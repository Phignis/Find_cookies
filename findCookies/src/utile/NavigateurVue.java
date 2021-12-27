package utile;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;


public class NavigateurVue {
    private Stage monStage;

    public void changeScene(Stage monStage, String nomScene) throws Exception {
        nomScene = "/testVues/" + nomScene + ".fxml";
        Parent p = new FXMLLoader(getClass().getResource(nomScene)).load();
        monStage.setScene(new javafx.scene.Scene(p));
        monStage.show();

        System.out.println(nomScene);
    }
}