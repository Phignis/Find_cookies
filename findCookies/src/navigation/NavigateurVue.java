package navigation;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * NavigateurVue permet de changer la scene courante affichée par celle dont le nom est passé en paramètre
 */
public class NavigateurVue {

    /**
     * Hauteur de la fenêtre
     */
    private static float HAUTEUR_MAX = 700;
    public float getHAUTEUR_MAX() { return HAUTEUR_MAX; }

    /**
     * Largeur de la fenêtre
     */
    private static float LARGEUR_MAX = 1000;
    public float getLARGEUR_MAX() { return LARGEUR_MAX; }

    public NavigateurVue(){
        new NavigateurVue(HAUTEUR_MAX, LARGEUR_MAX);
    }

    public NavigateurVue(float hauteur, float largeur){
        HAUTEUR_MAX = hauteur;
        LARGEUR_MAX = largeur;
    }

    /**
     * Permet de changer la scène courante affichée pour celle dont le nom est donné en paramètre
     * @param monStage stage a changer
     * @param nomScene nom de la scène a afficher
     * @throws Exception si le nom de scene est incorrect
     */
    public void changeScene(Stage monStage, String nomScene) throws Exception {
        changeScene(monStage, nomScene, HAUTEUR_MAX, LARGEUR_MAX);
    }

    /**
     * Permet de changer la scène courante affichée pour celle dont le nom est donné en paramètre
     * @param monStage stage a changer
     * @param nomScene nom de la scène a afficher
     * @param hauteur hauteur de la scène à afficher
     * @param largeur largeur de la scène à afficher
     * @throws Exception si le nom de scene est incorrect
     */
    public void changeScene(Stage monStage, String nomScene, float hauteur, float largeur) throws Exception {
        nomScene = "/vuesAppli/" + nomScene + ".fxml";
        HAUTEUR_MAX = hauteur;
        LARGEUR_MAX = largeur;

        Parent p = new FXMLLoader(getClass().getResource(nomScene)).load();
        monStage.setTitle("Find cookies");
        monStage.setScene(new javafx.scene.Scene(p));
        monStage.setHeight(HAUTEUR_MAX);
        monStage.setWidth(LARGEUR_MAX);
        monStage.setResizable(false);
        monStage.show();

      //  if (Debugger.isEnabled())
         //   Debugger.log("Scene actuelle : " + nomScene);
        System.out.println("Scene actuelle : " + nomScene);
    }
}
