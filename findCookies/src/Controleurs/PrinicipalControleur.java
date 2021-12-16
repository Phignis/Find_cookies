package Controleurs;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class PrinicipalControleur {
    private Vue vue = new Vue();
    private Joueur joueurC = new JoueurControleur();

    public void clickJouer(ActionEvent event) throws Exception {
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //Récupérer la scene actuelle
        vue.changeScene("testVues/Lobbie.fxml");
    }
}
