package utile;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class NavigateurVue {
    private Stage monStage;

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
