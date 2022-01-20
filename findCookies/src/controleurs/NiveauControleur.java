package controleurs;

import manageurs.ManageurJeu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import navigation.NavigateurVue;

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //tests
    @FXML
    private void clickAccueil(ActionEvent event) throws Exception{
       // monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       // vue.changeScene(monStage, "Menu");

        /*
        Canvas ancienCanvas = canvas;

        Dessinateur dessinateur = new Dessinateur(canvas);
        dessinateur.dessiner(new PorteGraphique(5, 5, new Porte()));
       // Dessinateur dessinateur2 = new Dessinateur(canvas, new PorteGraphique(9, 9, new Porte()));

        // Dessinateur dessinateur3 = new Dessinateur(canvas, new PorteGraphique(2, 2, new Porte()));
        PersonnageGraphique pg = new PersonnageGraphique(8, 8, new Personnage()); //new PorteGraphique(8, 8, new Porte())
        dessinateur.dessinerAvecSuppression(8,5 , new PorteGraphique(2, 2, new Porte()),
                new Image(getClass().getResource("/images/objet_skin/sol_1.png").toExternalForm()));
        */

        manageurJeu.chargerNiveau(1);
    }
}
