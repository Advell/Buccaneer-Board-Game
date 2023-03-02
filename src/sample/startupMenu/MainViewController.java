package sample.startupMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Player;

import java.io.IOException;
import java.util.Objects;

public class MainViewController {
    public void quitGame(ActionEvent event) {
        System.exit(0);
    }

    public void loadGame(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Player p = new Player(); //placeholder to trigger loadSequence in gameManager
        stage.getScene().getWindow().setUserData(p);
        stage.close();
    }

    public void newGame(ActionEvent event) {
        try {
            switchWindow(event, "PlayerNameView.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void switchWindow(ActionEvent event, String filename) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(filename)));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
