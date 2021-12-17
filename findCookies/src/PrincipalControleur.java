import utile.Vue;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import metier.Joueur;

public class PrincipalControleur {
    Stage monStage;
    private Vue vue = new Vue();
    private Joueur joueurC;

    public void clickJouer(ActionEvent event) throws Exception {
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //Récupérer la scene actuelle
        vue.changeScene("Lobbie.fxml");
    }

    public void clickAccueil(ActionEvent event) throws Exception {
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene("Menu.fxml");
    }

    public void clickOptions(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene("Options.fxml");
    }

    public void clickCredits(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene("Credits.fxml");
    }

    public void clickNouvJoueur(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene("NouveauJoueur.fxml");
    }

    public void clickValider(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene("Menu.fxml");
    }
}
