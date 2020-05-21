package trail.jgui.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.GlyphFont;
import org.controlsfx.glyphfont.GlyphFontRegistry;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 May 2020, 8:00 PM
 */
public class FontAwesomeDemo extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        StackPane root = new StackPane();
        ListView<Button> listView = new ListView<>();
        GlyphFont fontAwesome = GlyphFontRegistry.font("FontAwesome");
        for (FontAwesome.Glyph glyph : FontAwesome.Glyph.values()) {
            Button button = new Button();
            button.setText(glyph.name());
            button.setGraphic(fontAwesome.create(glyph));
            listView.getItems().add(button);
        }
        root.getChildren().add(listView);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
