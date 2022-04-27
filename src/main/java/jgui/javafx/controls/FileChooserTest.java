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

package jgui.javafx.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static javafx.stage.FileChooser.ExtensionFilter;

public class FileChooserTest extends Application
{
    private final FileChooser fileDialog = new FileChooser();
    private Stage primaryStage;
    private HTMLEditor resumeEditor;

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        primaryStage = stage; // Used in file dialogs later
        resumeEditor = new HTMLEditor();
        resumeEditor.setPrefSize(600, 300);

        // Filter only HTML files
        fileDialog.getExtensionFilters().add(new ExtensionFilter("HTML Files", "*.htm", "*.html"));

        Button openBtn = new Button("Open");
        Button saveBtn = new Button("Save");
        Button closeBtn = new Button("Close");

        openBtn.setOnAction(e -> openFile());
        saveBtn.setOnAction(e -> saveFile());
        closeBtn.setOnAction(e -> stage.close());

        HBox buttons = new HBox(20, openBtn, saveBtn, closeBtn);
        buttons.setAlignment(Pos.CENTER_RIGHT);

        VBox root = new VBox(resumeEditor, buttons);
        root.setSpacing(20);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Editing Resume in HTML Format");
        stage.show();
    }

    private void openFile()
    {
        fileDialog.setTitle("Open Resume");
        File file = fileDialog.showOpenDialog(primaryStage);
        if (file == null) {
            return;
        }
        try {
            // Read the file and populate the HTMLEditor
            byte[] resume = Files.readAllBytes(file.toPath());
            resumeEditor.setHtmlText(new String(resume));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFile()
    {
        fileDialog.setTitle("Save Resume");
        fileDialog.setInitialFileName("untitled.htm");
        File file = fileDialog.showSaveDialog(primaryStage);
        if (file == null) {
            return;
        }
        try {
            // Write the HTML contents to the file. Overwrite the existing file.
            String html = resumeEditor.getHtmlText();
            Files.write(file.toPath(), html.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}