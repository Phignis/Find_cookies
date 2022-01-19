package controleurs;

public class ListeNiveauxControleur {
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
