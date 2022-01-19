package controleurs;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import vueNiveau.InstanciationNiveau;
import vueNiveau.Niveau;

import java.io.File;
import java.io.FileFilter;
import java.util.*;

/**
 * Controleur associé à ListeNiveaux.fxml, permet d'afficher tout les niveaux disponibles
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
            int numberFile;
            try{
                numberFile = Integer.parseInt(f.getName().substring(0, f.getName().lastIndexOf('.')));
            } catch (NumberFormatException c) {
                continue; // impossible que cela arrive avec le filtre
            }
            try {
                System.out.println(numberFile);
                aRendre.add(new InstanciationNiveau(numberFile).getNiveau());
            } catch (Exception e) {
                // impossible que cela arrive avec trouverListeNiveaux avant
                e.printStackTrace();
            }
        }

        return aRendre;
    }

    private void genererListeNumNiveaux(FileFilter f) {
        for (File file : trouverListeNiveaux(f)) {
            try{
                addNumNiveau(Integer.parseInt(file.getName().substring(0, file.getName().lastIndexOf('.'))));
            } catch (NumberFormatException c) {
                continue; // impossible que cela arrive avec le filtre
            }
        }
    }

    @FXML
    public void initialize() {
        listeNumNiveauxAAfficher.itemsProperty().bind(listeNiveauxProperty());
        listeNumNiveauxAAfficher.setCellFactory(__ -> new ListCell<Integer>() {
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




    /*
    private InstanciationNiveau instanceNiv; //Récupérer le niveau cliqué

    private List<Niveau> listeNiveaux;
    //trouver comment instancier une liste du nombre de fichiers du répertoire qui contient les mondes à charger

    @FXML
    private ListView vueListes;
    ObservableList ListeObservable = FXCollections.observableArrayList();

    public ListeNiveauxControleur() {
        try {
            listeNiveaux = chargerListeNiveaux();
            if(listeNiveaux != null){
                for (Niveau n : listeNiveaux) {
                    System.out.println(n);
                }
            }


     */
            //https://webdevdesigner.com/q/customize-listview-in-javafx-with-fxml-103337/
          //  ListeObservable.setAll(listeNiveaux);
           // vueListes.setItems(ListeObservable);
            /*
            vueListes.setCellFactory(new Callback<ListView<String>, ListCell<String>>()
            {
                @Override
                public ListCell<String> call(ListView<String> vueListes)
                {
                    return new vueListesCell();
                }
            });
             */
    /*
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private ArrayList<Niveau> chargerListeNiveaux() throws Exception {
        ArrayList<Niveau> listeNiveaux = new ArrayList<Niveau>();

        String separateur = File.separator;

        File repertoire = new File("\\\\fichiers" + separateur );
        if(!repertoire.exists() || !repertoire.isDirectory()){
            throw new Exception("Le dossier n'est pas accessible");
        }

        System.out.println(repertoire.getPath());

        var liste = repertoire.list();


     */
        /*
        URI nomFichier = getClass().getResource("/fichiers/" + numNiveau + ".txt").toURI();
        if(nomFichier == null){
            throw new Exception("Le fichier n'est pas accéssible");
        }
         */
/*
        if (liste != null) {
            for (int i = 0; i < liste.length; i++) {
                System.out.println(liste[i]);
                Niveau n = new Niveau(i);
                listeNiveaux.add(n);
            }
        } else {
            System.err.println("Nom de repertoire invalide");
        }

        return listeNiveaux;
    }

    //verifierNumero.verifierNumeroNiveau(

      ///////////////////////////

 */
}
