package sample.leftSideMenu.Menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.ShipElement;
import sample.tiles.Tile;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.BoardController.BOARD;
import static sample.GameManager.currentPlayer;
import static sample.GameManager.launchDirectionSelection;

public class ShipActionController implements Initializable {

    @FXML
    private Label playerName;
    Tile tile;
    ShipElement shipElement;
    Parent root;
    Stage stage;
    Scene scene;

    @FXML
    Button changeDirection;

    @FXML
    Button makeMove;

    public void setShipElement(ShipElement s){
        this.shipElement = s;
        this.tile = BOARD[shipElement.getBoardX()][shipElement.getBoardY()];
    }

    public void change(ActionEvent event) throws IOException {/*
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/leftSideMenu/Menu/ArrowPopup.fxml"));
        root = fxmlLoader.load();
        ArrowPopupController controller = fxmlLoader.<ArrowPopupController>getController();
        controller.setTileDir(tile);
        controller.setShipElement(shipElement);*/
        makeMove.setVisible(false);
        launchDirectionSelection();
/*
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/
    }

    public void move(ActionEvent event) {
        changeDirection.setVisible(false);
        try {
            tile.highlightMoves(shipElement, false);
        }catch(NullPointerException e){
            System.out.println(e.toString());
        }
        /*
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();*/
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playerName.setText(currentPlayer.getNickName());
    }
}