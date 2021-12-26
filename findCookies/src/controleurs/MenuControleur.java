package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import utile.NavigateurVue;

public class MenuControleur {
    private Stage monStage;
    private NavigateurVue vue = new NavigateurVue();

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
