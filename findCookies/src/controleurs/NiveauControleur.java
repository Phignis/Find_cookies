package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import utile.NavigateurVue;

public class NiveauControleur {
    private Stage monStage;
    private NavigateurVue vue = new NavigateurVue();

    @FXML
    public Canvas CanvasJoueur;

    @FXML
    private void clickAccueil(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene(monStage, "Menu");
    }
}
