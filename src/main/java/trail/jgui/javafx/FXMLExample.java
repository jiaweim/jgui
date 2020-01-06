// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package trail.jgui.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.12.04, 10:01 PM
 */
public class FXMLExample extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage stage) throws IOException
    {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLExample.class.getClassLoader().getResource("fxml/fxml_example.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root, 300, 275);

        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
    }

}
