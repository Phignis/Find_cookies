import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class testMenu extends Application {
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
        String nomScene = "vues/menu.fxml";
        Parent p = FXMLLoader.load(getClass().getResource(nomScene));
        stage.setScene(new javafx.scene.Scene(p));
        stage.show();
    }

    public void changeScene(String nomScene) throws Exception {
        Parent p = FXMLLoader.load(getClass().getResource(nomScene));
        Stage stage = new Stage();
        stage.setScene(new javafx.scene.Scene(p));
        stage.show();
    }

    @FXML
    private void clickJouer(ActionEvent event) throws Exception {
        System.out.println("Jouer");
        changeScene("vues/game.fxml");
    }
}
