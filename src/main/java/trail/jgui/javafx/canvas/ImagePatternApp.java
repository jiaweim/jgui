package trail.jgui.javafx.canvas;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;

/**
 * @author JiaweiMao 2017-05-07
 * @since 1.0-SNAPSHOT
 */
public class ImagePatternApp extends Application {

    private Image img;

    @Override
    public void init() throws Exception {
        // Create an Image object
        final String IMAGE_PATH = "picture/blue_rounded_rectangle.png";
        URL url = this.getClass().getClassLoader().getResource(IMAGE_PATH);
        if (url == null) {
            System.out.println(IMAGE_PATH + " file not found in CLASSPATH");
            Platform.exit();
            return;
        }
        img = new Image(url.toExternalForm());
    }

    @Override
    public void start(Stage stage) throws Exception {
        // An anchor rectangle at (0, 0) that is 25% wide and 25% tall
        // relative to the rectangle to be filled
        ImagePattern p1 = new ImagePattern(img, 0, 0, 0.25, 0.25, true);
        Rectangle r1 = new Rectangle(100, 50);
        r1.setFill(p1);

        // An anchor rectangle at (0, 0) that is 50% wide and 50% tall
        // relative to the rectangle to be filled
        ImagePattern p2 = new ImagePattern(img, 0, 0, 0.5, 0.5, true);
        Rectangle r2 = new Rectangle(100, 50);
        r2.setFill(p2);

        // Using absolute bounds for the anchor rectangle
        ImagePattern p3 = new ImagePattern(img, 40, 15, 20, 20, false);
        Rectangle r3 = new Rectangle(100, 50);
        r3.setFill(p3);

        // Fill a circle
        ImagePattern p4 = new ImagePattern(img, 0, 0, 0.1, 0.1, true);
        Circle c = new Circle(50, 50, 25);
        c.setFill(p4);

        HBox root = new HBox();
        root.getChildren().addAll(r1, r2, r3, c);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using Image Patterns");
        stage.show();
    }
}
