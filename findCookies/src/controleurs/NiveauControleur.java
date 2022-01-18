package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import manageurs.ManageurNiveau;
import metier.objets.Interrupteur;
import utile.NavigateurVue;
import vueNiveau.InstanciationNiveau;
import vueNiveau.Niveau;
import vueNiveau.objets.InterrupteurGraphique;

import java.net.URL;
import java.util.List;

public class NiveauControleur {
    private Stage monStage;
    private NavigateurVue vue = new NavigateurVue();

    @FXML
    public Canvas canvasJoueur;

    public NiveauControleur(){
        /*
        try {
            InstanciationNiveau in = new InstanciationNiveau(1); */
            /*
            var listeCouches = in.getNiveau().getListeCouches();
            if(listeCouches == null) {
                System.out.println("Aucune couche au niveau");
            }
            */
            /*
            URL ressource = getClass().getResource("/image/objet_skin/default_skin.png");
            ManageurNiveau manNiveau = new ManageurNiveau(canvasJoueur, new Image(ressource.toExternalForm()), new DeplaceurControleur(new InterrupteurGraphique(0, 5, new Interrupteur()), canvasJoueur);

             */
        /*
        } catch (Exception e) {
            e.printStackTrace();
        }
        */


    }

    @FXML
    private void clickAccueil(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene(monStage, "Menu");
    }
}
