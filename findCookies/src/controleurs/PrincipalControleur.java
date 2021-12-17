package controleurs;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import metier.Joueur;
import utile.Vue;

public class PrincipalControleur {
    private Vue vue = new Vue();
    private Joueur joueurC = new Joueur();

    public void clickJouer(ActionEvent event) throws Exception {
        Stage monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //Récupérer la scene actuelle
        vue.changeScene("testVues/Lobbie.fxml");
    }
}
