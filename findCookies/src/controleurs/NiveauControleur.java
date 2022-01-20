package controleurs;

import javafx.application.Platform;
import manageurs.ManageurJeu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import navigation.NavigateurVue;
import objets.niveaux.graphiques.PersonnageGraphique;
import objets.niveaux.metiers.deplacables.Personnage;
import utile.Dessinateur;

import java.net.URL;
import java.util.ResourceBundle;

public class NiveauControleur {
    private Stage monStage;
    private NavigateurVue vue = new NavigateurVue();

    @FXML
    private Canvas canvas;

    private ManageurJeu manageurJeu;
    private Integer numeroNiveau;

    public NiveauControleur(Integer numeroNiveau) {
        this.numeroNiveau = numeroNiveau;
    }

    @FXML
    private void initialize() {
        canvas.setHeight(new NavigateurVue().getHAUTEUR_MAX() - 200);
        canvas.setWidth(new NavigateurVue().getLARGEUR_MAX());

        try {
            manageurJeu = new ManageurJeu(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickValidation(ActionEvent event) throws Exception{
        manageurJeu.chargerNiveau(numeroNiveau);
    }
}
