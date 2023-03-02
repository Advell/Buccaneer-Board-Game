package sample.startupMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayerNameViewController {

    public TextField player1textField;
    public TextField player2textField;
    public TextField player3textField;
    public TextField player4textField;
    public Button startGameButton;

    @FXML
    private Label feedbackLabel;

    public void onStartGame(ActionEvent event) throws IOException {

        String player1name = player1textField.getText();
        String player2name = player2textField.getText();
        String player3name = player3textField.getText();
        String player4name = player4textField.getText();
        String[] playerNames = {player1name, player2name, player3name, player4name};

        for (String name : playerNames) {//name validity checks
            if (name.length() > 16) {
                feedbackLabel.setText("Usernames must be under 16 characters!");
                return;
            } else if (!name.matches("[a-zA-Z]+")) {
                feedbackLabel.setText("Usernames must be made up of only alphabetical characters!");
                return;
            }
        }

        if (player2name.equals(player1name) || player3name.equals(player1name) || player4name.equals(player1name)) {
            feedbackLabel.setText("Usernames must be unique!");
            return;
        } else if (player3name.equals(player2name) || player4name.equals(player2name)) {
            feedbackLabel.setText("Usernames must be unique!");
            return;
        } else if (player4name.equals(player3name)) {
            feedbackLabel.setText("Usernames must be unique!");
            return;
        }

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.getScene().getWindow().setUserData(playerNames);
        stage.close();
    }
}
