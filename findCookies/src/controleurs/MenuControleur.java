package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import utile.Vue;

import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;

public class MenuControleur {
    private Stage monStage;
    private Vue vue = new Vue();

    @FXML
    private void clickJouer(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene(monStage, "Lobbie");
    }

    @FXML
    private void clickOptions(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene(monStage, "Options");
    }

    @FXML
    private void clickCredits(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene(monStage, "Credits");
    }
}
