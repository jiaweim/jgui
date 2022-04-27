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

package jgui.javafx.tableview.music;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 09 Jan 2018, 7:10 PM
 */
public class MusicTable extends Application
{
    //Sample Values
    final ObservableList<Integer> ratingSample = FXCollections.observableArrayList(1, 2, 3, 4, 5);
    ObservableList<String> artists = FXCollections.observableArrayList("Adele",
            "Unknown", "Beyounce", "Rihanna", "Avril", "Disturbia", "Kid Rock", "Jessi J", "Unknown", "Unknown");
    ObservableList<String> titles = FXCollections.observableArrayList("Running in the Deep",
            "Title 01", "Title 09", "What's my name", "What the Hell", "Disturbia", "Kid Rock", "Price Tag", "Title 2", "09");

    public static void main(String[] args)
    {
        launch(args);
    }

    /**
     * This function gives the full configured TableView
     *
     * @return TableView
     */
    public TableView getTableView()
    {
        TableView<Music> table = new TableView<>();
        table.setTableMenuButtonVisible(true);

        /*
         * Creating the TableColumn for the TableView
         * The property value Factory name must match with the
         * Generic Class's(Music's) property
         */
        TableColumn<Music, Album> albumArt = new TableColumn<Music, Album>("Album Art");
        albumArt.setCellValueFactory(new PropertyValueFactory("album"));
        albumArt.setPrefWidth(200);

        TableColumn<Music, String> title = new TableColumn<Music, String>("Title");
        title.setCellValueFactory(new PropertyValueFactory("title"));
        title.setPrefWidth(120);

        TableColumn<Music, String> artist = new TableColumn<Music, String>("Artist");
        artist.setCellValueFactory(new PropertyValueFactory("artist"));
        artist.setPrefWidth(120);

        TableColumn<Music, Integer> rating = new TableColumn<Music, Integer>("Rating");
        rating.setCellValueFactory(new PropertyValueFactory("rating"));
        rating.setPrefWidth(120);


        // SETTING THE CELL FACTORY FOR THE ALBUM ART
        albumArt.setCellFactory(param -> {
            TableCell<Music, Album> cell = new TableCell<Music, Album>()
            {
                @Override
                public void updateItem(Album item, boolean empty)
                {
                    if (item != null) {
                        HBox box = new HBox();
                        box.setSpacing(10);
                        VBox vbox = new VBox();
                        vbox.getChildren().add(new Label(item.getArtist()));
                        vbox.getChildren().add(new Label(item.getAlbum()));

                        ImageView imageview = new ImageView();
                        imageview.setFitHeight(50);
                        imageview.setFitWidth(50);
                        imageview.setImage(new Image(MusicTable.class.getResource("img").toString() + "/" + item.getFilename()));

                        box.getChildren().addAll(imageview, vbox);
                        //SETTING ALL THE GRAPHICS COMPONENT FOR CELL
                        setGraphic(box);
                    }
                }
            };
            System.out.println(cell.getIndex());
            return cell;
        });

        // SETTING THE CELL FACTORY FOR THE RATINGS COLUMN
        rating.setCellFactory(param -> new TableCell<Music, Integer>()
        {
            @Override
            public void updateItem(Integer item, boolean empty)
            {
                if (item != null) {

                    ChoiceBox choice = new ChoiceBox(ratingSample);
                    choice.getSelectionModel().select(ratingSample.indexOf(item));
                    //SETTING ALL THE GRAPHICS COMPONENT FOR CELL
                    setGraphic(choice);
                }
            }
        });


        //ADDING ALL THE COLUMNS TO TABLEVIEW
        table.getColumns().addAll(albumArt, title, artist, rating);

        //ADDING ROWS INTO TABLEVIEW
        ObservableList<Music> musics = FXCollections.observableArrayList();
        for (int i = 0; i < 10; i++) {
            Album al = new Album(i + 1 + ".jpg", artists.get(i), artists.get(i));
            Music m = new Music(artists.get(i), al, titles.get(i), i % 5);
            musics.add(m);
        }
        table.setItems(musics);

        return table;
    }


    /**
     * This function gives the fancy Background for the application
     */
    public Group getBackground()
    {
        Group group = new Group();
        group.setLayoutX(40);
        group.setLayoutY(40);

        Rectangle rect = new Rectangle();
        rect.setWidth(600);
        rect.setHeight(460);
        rect.setFill(Color.web("#f5f5f5"));
        //Some OuterGlow Effect
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.web("#969696"));
        dropShadow.setOffsetX(0);
        dropShadow.setOffsetY(0);
        dropShadow.setRadius(50);
        dropShadow.setSpread(0.2);

        rect.setEffect(dropShadow);

        group.getChildren().add(rect);

        return group;
    }


    @Override
    public void start(Stage stage) throws Exception
    {
        //Main Group of the Application
        Group group = getBackground();
        //VBox for the Text and Table
        VBox box = new VBox();
        box.setLayoutX(20);
        box.setLayoutY(5);
        box.setSpacing(15);

        //Text
        Text text = new Text("Music Library");
        text.setFont(new Font(20));

        //Table
        TableView table = getTableView();
        table.setLayoutX(20);
        table.setLayoutY(20);

        //adding all components
        box.getChildren().addAll(text, table);
        group.getChildren().add(box);

        Scene scene = new Scene(group, 680, 530, Color.web("#666666"));
        stage.setScene(scene);
        stage.show();
    }
}
