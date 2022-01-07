package utile;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * NavigateurVue permet de changer la scene courante affichée par celle dont le nom est passé en paramètre
 */
public class NavigateurVue {

    /**
     * Permet de changer la scène courante affichée pour celle dont le nom est donné en paramètre
     * @param monStage stage a changer
     * @param nomScene nom de la scène a afficher
     * @throws Exception si jamais le nom de scene n'existe pas
     */
    public void changeScene(Stage monStage, String nomScene) throws Exception {
        nomScene = "/VuesAppli/" + nomScene + ".fxml";
        Parent p = new FXMLLoader(getClass().getResource(nomScene)).load();
        monStage.setScene(new javafx.scene.Scene(p));
        monStage.show();

      //  if (Debugger.isEnabled())
         //   Debugger.log("Scene actuelle : " + nomScene);
        System.out.println("Scene actuelle : " + nomScene);
    }
}
