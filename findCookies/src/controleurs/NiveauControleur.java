package controleurs;

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

    private ManageurNiveau manageurNiveau;
    private GenerateurTick generateurTick;
    private GenerateurMouvement generateurMouvement;

    private final int HAUTEUR_MAX = 500; //700
    public int getHAUTEUR_MAX() { return HAUTEUR_MAX; }

    private final int LARGEUR_MAX = 1000; //1000
    public int getLARGEUR_MAX() { return LARGEUR_MAX; }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            canvas.setHeight(HAUTEUR_MAX);
            canvas.setWidth(LARGEUR_MAX);

            manageurNiveau = new ManageurNiveau(canvas, 1);

            Dessinateur dessinateur = new Dessinateur(canvas);
            generateurTick = new GenerateurTick();
            generateurMouvement = new GenerateurMouvement(canvas);
            generateurTick.attacher(generateurMouvement);

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
        dessinateur.dessinerAvecSuppression(8,5 , new PorteGraphique(8, 8, new Porte()),
                new Image(getClass().getResource("/images/objet_skin/sol_1.png").toExternalForm()));
    }
}
