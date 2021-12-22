package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import utile.Vue;

/**
 * \brief Controleur associé à la vue "Credits.fxml"
 */
public class CreditsControleur {
    private Stage monStage;
    private Vue vue = new Vue();

    /**
     * \brief Redirige l'utilisateur vers la page principale "Menu.fxml"
     * @param event Action associée au déclenchement de la méthode
     * @throws Exception
     */
    @FXML
    private void clickAccueil(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene(monStage, "Menu");
    }
}
