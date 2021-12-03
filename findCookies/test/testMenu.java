import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseDragEvent;
import javafx.stage.Stage;

public class testMenu extends Application {
    Stage monStage = new Stage();
    /*
    public void main(String args[]) {
        nomScene = "vues/menu.fxml";
    }
    */

    @Override
    public void start(Stage stage) throws Exception {
        /*
        FlowPane fp = new FlowPane();
        fp.getChildren().addAll(new Button("JOUER"),
                                new Button("OPTIONS"));

        javafx.scene.Scene niveau = new javafx.scene.Scene(fp);

        stage.setScene(niveau);
        stage.show();
        */
        changeScene("testVues/Menu.fxml");
        stage.close();
    }

    public void changeScene(String nomScene) throws Exception {
        //monStage.close();
        Parent p = FXMLLoader.load(getClass().getResource(nomScene));
        monStage.setScene(new javafx.scene.Scene(p));
        monStage.show();
    }

    @FXML
    private void clickJouer(ActionEvent event) throws Exception {
        System.out.println("Jouer");

        //text bJouer.text="patate";

        monStage.close();
        changeScene("testVues/Lobbie.fxml");
    }

    @FXML
    public void onMouseDragOver(MouseDragEvent mouseDragEvent) {
        System.out.println("onMouseDragOver");
    }

    @FXML
    private void clickOptions(ActionEvent event) throws Exception {
        System.out.println("Options");
        changeScene("testVues/Options.fxml");
    }

    @FXML
    private void clickAccueil(ActionEvent event) throws Exception {
        monStage.close();
        System.out.println("Menu");
        changeScene("testVues/Menu.fxml");
    }

    @FXML
    private void clickNouvJoueur(ActionEvent event) throws Exception {
        monStage.close();
        System.out.println("Nouveau joueur");
        changeScene("testVues/NouveauJoueur.fxml");
    }

    @FXML
    private void clickCredits(ActionEvent event) throws Exception {
        System.out.println("Nouveau joueur");
        changeScene("testVues/Credits.fxml");
    }
}
