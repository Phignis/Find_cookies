package Controleurs;

import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

public class NouveauJoueurControleur {
    @FXML
    TextField vPseudo;
    private SimpleStringProperty pseudo = new SimpleStringProperty();
    public final StringProperty pseudoProperty(){
        return pseudo;
    }
    public final String getPseudo() {
        return pseudo.get();
    }
    public final void setMdp(String pseudo) {
        this.pseudo.setValue("test");
    }

    @FXML
    Button vBtnValidation;
    private PrincipalControleur principalC = new PrincipalControleur();
    private Vue vue = new Vue();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vPseudo.textProperty().bindBidirectional(pseudoProperty());
        vPseudo.setText("Pseudo1");
        vBtnValidation.disableProperty().bind(vPseudo.textProperty().isEmpty());
/*
        if(!vPassword.getText().isEmpty()){
            vBtnValidation.setDisable(false);
        }
        */

    }

    @FXML
    private void clickAccueil(ActionEvent event) throws Exception {
       // System.out.println("Menu");
      //  generalC.vue.changeScene("Menu.fxml");
    }

    @FXML
    private void clickValider(ActionEvent event) throws Exception {
        System.out.println("Valider");
        //test="test";
        //int test;
        // test=Integer.parseInt(vPseudo.getText());

     //   System.out.println(pseudoProperty().get());

      //  Joueur j = new Joueur(pseudoProperty().get(), mdpProperty().get(), 0);


     //   generalC.vue.changeScene("Niveau.fxml");
    }
}
