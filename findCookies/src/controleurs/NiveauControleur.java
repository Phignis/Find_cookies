package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import metier.Couche;
import utile.NavigateurVue;
import vueNiveau.InstanciationNiveau;
import vueNiveau.Niveau;
import vueNiveau.objets.ObjetGraphique;

import java.io.IOException;
import java.net.URISyntaxException;

public class NiveauControleur {
    private Stage monStage;
    private NavigateurVue vue = new NavigateurVue();

    public AnchorPane initialiserNiveau(int numeroNiveau) throws URISyntaxException, IOException {
        Niveau n = new InstanciationNiveau(numeroNiveau).getNiveau();
        AnchorPane a = new AnchorPane();
        for(Couche c : n.getListeCouches()) {
            GridPane g = new GridPane();
            for(ObjetGraphique o : c.getListeObjets()) {
                ImageView image = new ImageView(o.getImage());
                image.setFitHeight(32);
                image.setFitWidth(32);
                g.add(image, o.getPosX(), o.getPosY());
            }
            a.getChildren().addAll(g);
        }

        return a;
    }

    @FXML
    private void clickAccueil(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene(monStage, "Menu");
    }
}
