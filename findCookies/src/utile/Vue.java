package utile;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class Vue {
    Stage monStage = new Stage();

    public void changeScene(String nomScene) throws Exception {
        nomScene = "testVues/" + nomScene;
        Parent p = FXMLLoader.load(getClass().getResource(nomScene));
        monStage.setScene(new javafx.scene.Scene(p));
        monStage.show();
    }
}
