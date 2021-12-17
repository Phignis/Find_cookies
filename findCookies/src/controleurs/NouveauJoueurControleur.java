package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import metier.Joueur;
import utile.Vue;

import java.net.URL;
import java.util.ResourceBundle;

public class NouveauJoueurControleur implements Initializable {
    @FXML
    TextField vPseudo;
    private SimpleStringProperty pseudo = new SimpleStringProperty();
    public final StringProperty pseudoProperty(){
        return pseudo;
    }
    public final String getPseudo() {
        return pseudo.get();
    }

    @FXML
    Button vBtnValidation;

    private Vue vue = new Vue();
    private JoueurControleur joueurC = new JoueurControleur();

    private Stage monStage;

    public NouveauJoueurControleur(Stage monStage){
        this.monStage = monStage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vPseudo.textProperty().bindBidirectional(pseudoProperty());
        vPseudo.setText("Pseudo1");
        vBtnValidation.disableProperty().bind(vPseudo.textProperty().isEmpty());
    }

    public void clickAjouterJoueur() {
        try{
            if(joueurC.ajouterJoueur(pseudo.get())){
                vue.changeScene(monStage, "Niveau");
            }else{
                vue.changeScene(monStage, "NouveauJoueur");
            }
        }
        catch (Exception e){
            System.out.println("Pb ajout nouveau joueur");
            System.out.println(e.getMessage());
        }
        //test="test";
        //int test;
        // test=Integer.parseInt(vPseudo.getText());

     //   System.out.println(pseudoProperty().get());

      //  Joueur j = new Joueur(pseudoProperty().get(), mdpProperty().get(), 0);
     //   generalC.vue.changeScene("Niveau.fxml");
    }


}
