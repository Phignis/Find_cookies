package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import utile.Vue;

public class LobbieControleur {
    private Stage monStage;
    private Vue vue = new Vue();

    @FXML
    private void clickAccueil(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene(monStage, "Menu");
    }

    @FXML
    private void clickNouvJoueur(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene(monStage, "NouveauJoueur");
    }
}
