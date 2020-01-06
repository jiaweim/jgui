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

package trail.jgui.javafx.tableview;

import javafx.application.Application;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import trail.javafx.tableview.music.Music;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 09 Jan 2018, 6:57 PM
 */
public class TableEx3 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        TableView<Music> table = new TableView<>();
        table.setTableMenuButtonVisible(true);

        TableColumn albumArt = new TableColumn("Album Art");
        albumArt.setCellValueFactory(new PropertyValueFactory("album"));
        albumArt.setPrefWidth(200);

        TableColumn title = new TableColumn("Title");
        title.setCellValueFactory(new PropertyValueFactory("title"));
        title.setPrefWidth(120);

        TableColumn artist = new TableColumn("Artist");
        artist.setCellValueFactory(new PropertyValueFactory("artist"));
        artist.setPrefWidth(120);

        TableColumn rating = new TableColumn("Rating");
        rating.setCellValueFactory(new PropertyValueFactory("rating"));
        rating.setPrefWidth(120);
    }
}
