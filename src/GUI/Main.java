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
    public void start(Stage primaryStage) throws Exception{
        javafx.scene.image.Image selecting = new Image("Resources/Pictures/selecting_hand.png");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(new Scene(root, 1264, 897));
        root.setCursor(new ImageCursor(selecting));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
