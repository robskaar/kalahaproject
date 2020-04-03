package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        javafx.scene.image.Image cursor = new Image("Resources/Pictures/Cursor.png");

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(new Scene(root, 1920, 1080));
        root.setCursor(new ImageCursor(cursor));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
