/*
 * Copyright 2017 JiaweiMao jiaweiM_philo@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jgui.javafx.event;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 09 Apr 2018, 3:20 PM
 */
public class DraggablePanelsExample extends Application
{

    private final BooleanProperty dragModeActiveProperty = new SimpleBooleanProperty(this, "dragModeActive", true);

    public static void main(String[] args)
    {
        launch(args);
    }

    private static Node createLoginPanel()
    {
        final ToggleGroup toggleGroup = new ToggleGroup();

        final TextField textField = new TextField();
        textField.setPrefColumnCount(10);
        textField.setPromptText("Your name");

        final PasswordField passwordField = new PasswordField();
        passwordField.setPrefColumnCount(10);
        passwordField.setPromptText("Your password");

        final ChoiceBox<String> choiceBox = new ChoiceBox<>(
                FXCollections.observableArrayList(
                        "English", "\u0420\u0443\u0441\u0441\u043a\u0438\u0439",
                        "Fran\u00E7ais"));
        choiceBox.setTooltip(new Tooltip("Your language"));
        choiceBox.getSelectionModel().select(0);

        final HBox panel = createHBox(6,
                createVBox(2, createRadioButton("High", toggleGroup, true),
                        createRadioButton("Medium", toggleGroup, false),
                        createRadioButton("Low", toggleGroup, false)),
                createVBox(2, textField, passwordField),
                choiceBox);
        panel.setAlignment(Pos.BOTTOM_LEFT);
        configureBorder(panel);

        return panel;
    }

    private static Node createConfirmationPanel()
    {
        final Label acceptanceLabel = new Label("Not Available");

        final Button acceptButton = new Button("Accept");
        acceptButton.setOnAction(
                new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(final ActionEvent event)
                    {
                        acceptanceLabel.setText("Accepted");
                    }
                });

        final Button declineButton = new Button("Decline");
        declineButton.setOnAction(
                new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(final ActionEvent event)
                    {
                        acceptanceLabel.setText("Declined");
                    }
                });

        final HBox panel = createHBox(6, acceptButton,
                declineButton,
                acceptanceLabel);
        panel.setAlignment(Pos.CENTER_LEFT);
        configureBorder(panel);

        return panel;
    }

    private static Node createProgressPanel()
    {
        final Slider slider = new Slider();

        final ProgressIndicator progressIndicator = new ProgressIndicator(0);
        progressIndicator.progressProperty().bind(
                Bindings.divide(slider.valueProperty(),
                        slider.maxProperty()));

        final HBox panel = createHBox(6, new Label("Progress:"),
                slider,
                progressIndicator);
        configureBorder(panel);

        return panel;
    }

    private static void configureBorder(final Region region)
    {
        region.setStyle("-fx-background-color: white;"
                + "-fx-border-color: black;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 6;"
                + "-fx-padding: 6;");
    }

    private static RadioButton createRadioButton(final String text,
            final ToggleGroup toggleGroup,
            final boolean selected)
    {
        final RadioButton radioButton = new RadioButton(text);
        radioButton.setToggleGroup(toggleGroup);
        radioButton.setSelected(selected);

        return radioButton;
    }

    private static HBox createHBox(final double spacing,
            final Node... children)
    {
        final HBox hbox = new HBox(spacing);
        hbox.getChildren().addAll(children);
        return hbox;
    }

    private static VBox createVBox(final double spacing, final Node... children)
    {
        final VBox vbox = new VBox(spacing);
        vbox.getChildren().addAll(children);
        return vbox;
    }

    @Override
    public void start(Stage stage)
    {
        final Node loginPanel = makeDraggable(createLoginPanel());
        final Node confirmationPanel = makeDraggable(createConfirmationPanel());
        final Node progressPanel = makeDraggable(createProgressPanel());

        loginPanel.relocate(0, 0);
        confirmationPanel.relocate(0, 67);
        progressPanel.relocate(0, 106);

        final Pane panelsPane = new Pane();
        panelsPane.getChildren().addAll(loginPanel, confirmationPanel, progressPanel);

        final BorderPane sceneRoot = new BorderPane();

        BorderPane.setAlignment(panelsPane, Pos.TOP_LEFT);
        sceneRoot.setCenter(panelsPane);

        final CheckBox dragModeCheckbox = new CheckBox("Drag mode");
        BorderPane.setMargin(dragModeCheckbox, new Insets(6));
        sceneRoot.setBottom(dragModeCheckbox);

        dragModeActiveProperty.bind(dragModeCheckbox.selectedProperty());

        final Scene scene = new Scene(sceneRoot, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Draggable Panels Example");
        stage.show();
    }

    private Node makeDraggable(final Node node)
    {
        final DragContext dragContext = new DragContext();
        final Group wrapGroup = new Group(node);

        wrapGroup.addEventFilter(
                MouseEvent.ANY,
                new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(final MouseEvent mouseEvent)
                    {
                        if (dragModeActiveProperty.get()) {
                            // disable mouse events for all children
                            mouseEvent.consume();
                        }
                    }
                });

        wrapGroup.addEventFilter(
                MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(final MouseEvent mouseEvent)
                    {
                        if (dragModeActiveProperty.get()) {
                            // remember initial mouse cursor coordinates
                            // and node position
                            dragContext.mouseAnchorX = mouseEvent.getX();
                            dragContext.mouseAnchorY = mouseEvent.getY();
                            dragContext.initialTranslateX =
                                    node.getTranslateX();
                            dragContext.initialTranslateY =
                                    node.getTranslateY();
                        }
                    }
                });

        wrapGroup.addEventFilter(
                MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(final MouseEvent mouseEvent)
                    {
                        if (dragModeActiveProperty.get()) {
                            // shift node from its initial position by delta
                            // calculated from mouse cursor movement
                            node.setTranslateX(
                                    dragContext.initialTranslateX
                                            + mouseEvent.getX()
                                            - dragContext.mouseAnchorX);
                            node.setTranslateY(
                                    dragContext.initialTranslateY
                                            + mouseEvent.getY()
                                            - dragContext.mouseAnchorY);
                        }
                    }
                });

        return wrapGroup;
    }

    private static final class DragContext
    {
        public double mouseAnchorX;
        public double mouseAnchorY;
        public double initialTranslateX;
        public double initialTranslateY;
    }
}
