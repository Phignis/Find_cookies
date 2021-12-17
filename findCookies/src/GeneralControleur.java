import controleurs.JoueurControleur;
import controleurs.NouveauJoueurControleur;
import javafx.fxml.FXML;
import utile.Vue;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import metier.Joueur;

public class GeneralControleur {
    private Stage monStage;
    private Vue vue = new Vue();

    @FXML
    private void clickJouer(ActionEvent event) throws Exception {
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //Récupérer la scene actuelle
        vue.changeScene(monStage, "Lobbie");
    }

    @FXML
    private void clickAccueil(ActionEvent event) throws Exception {
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene(monStage, "Menu");
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

    @FXML
    private void clickNouvJoueur(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene(monStage, "NouveauJoueur");
    }

    @FXML
    private void clickAjouterJoueur(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        NouveauJoueurControleur njc = new NouveauJoueurControleur(monStage);
        njc.clickAjouterJoueur();
    }
}
