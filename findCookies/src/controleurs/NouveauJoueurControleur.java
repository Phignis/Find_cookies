package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import utile.Vue;

import java.net.URL;
import java.util.ResourceBundle;

public class NouveauJoueurControleur implements Initializable {
    @FXML Button vBtnValidation;
    @FXML TextField vPseudo;
    @FXML Label vTxtErreur;

    private Stage monStage;
    private Vue vue = new Vue();

    private JoueurControleur joueurC = new JoueurControleur();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialize");
        vBtnValidation.disableProperty().bind(vPseudo.textProperty().isEmpty());
    }

    @FXML
    private void clickAccueil(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene(monStage, "Menu");
    }

    @FXML
    private void clickAjouterJoueur(ActionEvent event) {
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        String pseudo = vPseudo.textProperty().get();

        try{
            if(joueurC.ajouterJoueur(pseudo)){
                vue.changeScene(monStage, "Niveau");
            }else{
              //  vue.changeScene(monStage, "NouveauJoueur");
                vTxtErreur.setText("Problème de pseudo - Veuillez en changer");
            }
        }
        catch (Exception e){
            vTxtErreur.setText("Problème d'ajout du nouveau joueur.");
            System.out.println(e.getMessage());
        }
    }


}
