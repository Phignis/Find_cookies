package controleurs;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
import javafx.util.converter.PercentageStringConverter;
import utile.Vue;

import javafx.fxml.FXML;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class OptionsControleur implements Initializable{
    private Stage monStage;
    private Vue vue = new Vue();

    @FXML Slider vSlider;
    @FXML Spinner<Integer> vCpt;

    private final int valeurInitiale = 50;
    private int valeurCourante;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Initialiser les valeurs
        SpinnerValueFactory<Integer> fabrique =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        fabrique.setValue(valeurInitiale);

        vCpt.setValueFactory(fabrique);
        vSlider.setValue(vCpt.getValue());

        //Le slider bindé au spinner
        vCpt.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
                valeurCourante = vCpt.getValue();
                vSlider.setValue(valeurCourante);
            }
        });

        //et l'inverse : le spinner bindé au slider
        vSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                valeurCourante = (int) vSlider.getValue();
                //vCpt.setPromptText(Integer.toString(valeurCourante));
                fabrique.setValue(valeurCourante);
                vCpt.setValueFactory(fabrique);
            }
        });

        //vSlider.valueProperty().bindBidirectional(new SimpleDoubleProperty(DoubleProperty));
        //   pseudoProperty().bindBidirectional(vCpt.valueProperty(), NumberFormat.getNumberInstance());
    }

    @FXML
    private void clickAccueil(ActionEvent event) throws Exception{
        monStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        vue.changeScene(monStage, "Menu");
    }
}
