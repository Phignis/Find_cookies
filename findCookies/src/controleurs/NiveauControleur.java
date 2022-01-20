package controleurs;

import javafx.scene.Scene;
import manageurs.ManageurJeu;
import objets.niveaux.graphiques.ObjetGraphiqueDeplacable;
import objets.niveaux.graphiques.PersonnageGraphique;
import objets.niveaux.metiers.deplacables.Personnage;
import temps.GenerateurMouvement;
import temps.GenerateurTick;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import manageurs.ManageurNiveau;
import objets.niveaux.metiers.Porte;
import utile.Dessinateur;
import navigation.NavigateurVue;
import objets.niveaux.graphiques.PorteGraphique;

import java.net.URL;
import java.util.ResourceBundle;

public class NiveauControleur implements Initializable {
    private Stage monStage;
    private NavigateurVue vue = new NavigateurVue();

    @FXML
    private Canvas canvas;

    private ManageurJeu manageurJeu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            canvas.setHeight(new NavigateurVue().getHAUTEUR_MAX() - 200);
            canvas.setWidth(new NavigateurVue().getLARGEUR_MAX());

            manageurJeu = new ManageurJeu(canvas);

           // PersonnageGraphique pg = new PersonnageGraphique(5, 5, new Personnage());
        //    DeplaceurControleur dc = new DeplaceurControleur(pg, new NavigateurVue().getScene());

          //  System.out.println(pg.getPosX());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //tests
    @FXML
    private void clickAccueil(ActionEvent event) throws Exception{
       // monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       // vue.changeScene(monStage, "Menu");

        Canvas ancienCanvas = canvas;

        Dessinateur dessinateur = new Dessinateur(canvas);
        dessinateur.dessiner(new PorteGraphique(5, 5, new Porte()));
       // Dessinateur dessinateur2 = new Dessinateur(canvas, new PorteGraphique(9, 9, new Porte()));

        // Dessinateur dessinateur3 = new Dessinateur(canvas, new PorteGraphique(2, 2, new Porte()));
        PersonnageGraphique pg = new PersonnageGraphique(8, 8, new Personnage()); //new PorteGraphique(8, 8, new Porte())
        dessinateur.dessinerAvecSuppression(8,5 , new PorteGraphique(2, 2, new Porte()),
                new Image(getClass().getResource("/images/objet_skin/sol_1.png").toExternalForm()));

    }
}
