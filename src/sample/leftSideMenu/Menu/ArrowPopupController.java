package sample.leftSideMenu.Menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Directions;
import sample.Ship;
import sample.ShipElement;
import sample.tiles.Tile;

import java.io.IOException;
import static sample.BoardController.*;
import static sample.GameManager.exitDirectionSelection;
import static sample.GameManager.exitShipMoveMenu;

public class ArrowPopupController {
    Stage stage;
    ShipElement shipDir;
    Tile tile;

    public void setTileDir(Tile t){
        this.tile = t;
    }
    public void setShipElement(ShipElement s){
        this.shipDir = s;
    }

    public void back(ActionEvent event) throws IOException {
        exitShipMoveMenu();
        Parent root = FXMLLoader.load(getClass().getResource("ShipActionView.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void ne(ActionEvent event){
        System.out.println("Clicked North East");
        shipDir.setDirection(Directions.NE);
        switchPlayers();
        /*Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();*/
        exitDirectionSelection();
    }

    public void n(ActionEvent event){
        System.out.println("Clicked North");
        shipDir.setDirection(Directions.N);
        switchPlayers();
//        try {
//            tile.highlightMoves(shipDir, false);
////            arrow.move(event);
//        }catch(NullPointerException e){
//            System.out.println(e.toString());
//        }
        /*Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();*/
        exitDirectionSelection();
    }

    public void nw(ActionEvent event){
        System.out.println("Clicked North West");
        shipDir.setDirection(Directions.NW);
        switchPlayers();
        /*Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();*/
        exitDirectionSelection();
    }

    public void w(ActionEvent event){
        System.out.println("Clicked West");
        shipDir.setDirection(Directions.W);
        switchPlayers();
        /*Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();*/
        exitDirectionSelection();
    }

    public void sw(ActionEvent event){
        System.out.println("Clicked South West");
        shipDir.setDirection(Directions.SW);
        switchPlayers();
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.close();
        exitDirectionSelection();
    }

    public void s(ActionEvent event){
        System.out.println("Clicked South");
        shipDir.setDirection(Directions.S);
        switchPlayers();
        /*Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();*/
        exitDirectionSelection();
    }

    public void se(ActionEvent event){
        System.out.println("Clicked South East");
        shipDir.setDirection(Directions.SE);
        switchPlayers();
       /* Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();*/
        exitDirectionSelection();
    }

    public void e(ActionEvent event){
        System.out.println("Clicked East");
        shipDir.setDirection(Directions.E);
        switchPlayers();
        /*Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();*/
        exitDirectionSelection();
    }
}