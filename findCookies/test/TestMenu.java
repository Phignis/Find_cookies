import javafx.application.Application;
import javafx.stage.Stage;
import utile.NavigateurVue;

public class TestMenu extends Application {
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
        NavigateurVue navigateurVue = new NavigateurVue();
        try {
            navigateurVue.changeScene(stage, "Test");
        } catch(Exception e) {
            System.err.println("La scène demandée n'existe pas!");
            System.exit(1);
        }
    }

}
