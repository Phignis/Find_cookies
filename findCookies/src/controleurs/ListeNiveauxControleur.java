package controleurs;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import objets.niveaux.Niveau;
import utile.InstanciateurNiveau;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.*;

/**
 * Controleur associé à ListeNiveaux.fxml, permet d'afficher tous les niveaux disponibles
 */
public class ListeNiveauxControleur {
    private ObservableList<Integer> listeNumNiveauxObservables = FXCollections.observableArrayList();
    private ListProperty<Integer> listeNiveauxP = new SimpleListProperty<>(listeNumNiveauxObservables);
        public ObservableList<Integer> getListeNiveauxP() { return listeNiveauxP.get(); }
        public void setListeNiveauxP(ObservableList<Integer> value) { listeNiveauxP.set(value); }
        public ListProperty<Integer> listeNiveauxProperty() { return listeNiveauxP; }

    public void addNumNiveau(Integer ajout) { listeNumNiveauxObservables.add(ajout); }

    @FXML
    private ListView<Integer> listeNumNiveauxAAfficher;

    @FXML
    private Button buttonSelectionNiveau;

    public ListeNiveauxControleur() {
        genererListeNumNiveaux(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().matches("^[0-9]+\\.txt$") && pathname.isFile();
            }
        });
    }

    private List<File> trouverListeNiveaux(FileFilter f) {
        File[] listeFile = new File("ressources/fichiers").listFiles(f);
        LinkedList<File> aRendre = new LinkedList<>();
        assert listeFile != null;
        Collections.addAll(aRendre, listeFile);

        return aRendre;
    }

    private List<Niveau> creerNiveaux(List<File> fichierNiveaux) {
        List<Niveau> aRendre = new ArrayList<>();
        for (File f : fichierNiveaux) {
            int numeroFichier;
            try{
                numeroFichier = Integer.parseInt(f.getName().substring(0, f.getName().lastIndexOf('.')));
            } catch (NumberFormatException c) {
                continue; // impossible que cela arrive avec le filtre
            }
            try {
                Niveau niveau = new InstanciateurNiveau().creerNiveau(numeroFichier);
                aRendre.add(niveau);
            } catch (Exception e) {
                // impossible que cela arrive avec trouverListeNiveaux avant
                e.printStackTrace();
            }
        }

        return aRendre;
    }

    private void genererListeNumNiveaux(FileFilter f) {
        for (File file : trouverListeNiveaux(f)) {
            try {
                addNumNiveau(Integer.parseInt(file.getName().substring(0, file.getName().lastIndexOf('.'))));
            } catch (NumberFormatException c) {
                continue; // impossible que cela arrive avec le filtre
            }
        }
    }

    @FXML
    private void initialize() {
        listeNumNiveauxAAfficher.itemsProperty().bind(listeNiveauxProperty());
        listeNumNiveauxAAfficher.setCellFactory(__ -> new ListCell<>() {
            @Override
            protected void updateItem(Integer integer, boolean empty) {
                super.updateItem(integer, empty);
                if(empty) {
                    textProperty().unbind();
                    setText("Niveau pas encore disponible");
                } else {
                    textProperty().bind(Bindings.format("%d", integer));
                }
            }
        });

    }

    @FXML
    private void niveauTempSelect() {
        if(buttonSelectionNiveau.disableProperty().get()) buttonSelectionNiveau.setDisable(false);
    }

    @FXML
    private void selectionnerNiveau() {
        // on récupère le niveau sélectionné
        Integer i = listeNumNiveauxAAfficher.getSelectionModel().getSelectedItem();
        if(i != null) {
            // on est sur qu'il ne soit pas null, car le boutton est disable avant, mais on verifie par propreté
            // on change la scene pour le niveau
            try {
                FXMLLoader f = new FXMLLoader(getClass().getResource("/VuesAppli/Niveau.fxml"));
                f.setController(new NiveauControleur(i));
                Parent p = f.load();
                Stage monStage = (Stage) buttonSelectionNiveau.getScene().getWindow(); // je recupère le stage courant avec mon bouton
                monStage.setScene(new javafx.scene.Scene(p));
                monStage.show();

                System.out.println("Scene actuelle : " + "/VuesAppli/Niveau.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
