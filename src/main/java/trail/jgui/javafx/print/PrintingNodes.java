/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 JiaweiMao
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package trail.jgui.javafx.print;

import javafx.application.Application;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2017.01.11, 3:15 PM
 */
public class PrintingNodes extends Application{

    private Label jobStatus = new Label();

    @Override public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();

        Label textLbl = new Label("Text:");
        TextArea text = new TextArea();
        text.setPrefRowCount(10);
        text.setPrefColumnCount(20);
        text.setWrapText(true);

        // Button to print the TextArea node
        Button printTextBtn = new Button("Print Text");
        printTextBtn.setOnAction(e -> print(text));

        // Button to print the entire scene
        Button printSceneBtn = new Button("Print Scene");
        printSceneBtn.setOnAction(e -> print(root));

        HBox jobStatusBox = new HBox(5, new Label("Print Job Status."), jobStatus);
        HBox buttonBox = new HBox(5, printTextBtn, printSceneBtn);

        root.getChildren().addAll(textLbl, text, jobStatusBox, buttonBox);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Print Node");
        primaryStage.show();
    }

    private void print(Node node){
        jobStatus.textProperty().unbind();
        jobStatus.setText("Creating a printer job...");

        // Create a printer job for the default printer
        PrinterJob job = PrinterJob.createPrinterJob();
        if(job != null){
            // Show the printer job status
            jobStatus.textProperty().bind(job.jobStatusProperty().asString());

            boolean proceed = job.showPageSetupDialog(null);
            if(proceed){

            }

            // Print the node
            boolean printed = job.printPage(node);
            if(printed){
                // End the printer job
                job.endJob();
            }else{
                jobStatus.textProperty().unbind();
                jobStatus.setText("Printing failed.");
            }
        }else{
            jobStatus.setText("Could not create a printer job.");
        }
    }
}
