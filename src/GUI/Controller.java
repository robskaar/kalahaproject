package GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private Canvas cup2_1;

    @FXML
    private Canvas cup2_2;

    @FXML
    private Canvas cup2_3;

    @FXML
    private Canvas cup2_4;

    @FXML
    private Canvas cup2_5;

    @FXML
    private Canvas cup2_6;

    @FXML
    private Canvas cup1_1;

    @FXML
    private Canvas cup1_2;

    @FXML
    private Canvas cup1_3;

    @FXML
    private Canvas cup1_4;

    @FXML
    private Canvas cup1_5;

    @FXML
    private Canvas cup1_6;

    @FXML
    private Canvas mancala_1;

    @FXML
    private Canvas mancala_2;


    private int cup1_1Count = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void newCup() {

        // for (TilePane t : player_1_cups) {

        // for (int i = 0; i < 4; i++) {
        Image image = new Image("Resources/Pictures/marble_3.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(10);
        imageView.setFitHeight(10);
        GraphicsContext graphicsContext = cup1_1.getGraphicsContext2D();
        graphicsContext.setGlobalAlpha(1);
        graphicsContext.drawImage(image, 0, 0,20,20);
    }
    //  }
    // }


}

