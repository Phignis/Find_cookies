package manageurs;

import controleurs.JoueurControleur;
import javafx.scene.canvas.Canvas;
import utile.Dessinateur;
import validation.VerifierNiveau;
import utile.InstanciateurNiveau;
import objets.niveaux.Niveau;
import objets.niveaux.graphiques.ObjetGraphique;

public class ManageurNiveau {

    private Canvas canvas;
    private int numNiveau;
    private VerifierNiveau verifierNiveau = new VerifierNiveau();

    private Dessinateur dessinateur;
    private InstanciateurNiveau instanciateurNiveau = new InstanciateurNiveau();

    public ManageurNiveau(Canvas canvas, int numNiveau) throws Exception {
        if(canvas == null){ throw new IllegalArgumentException("Le canvas ne peut pas être nul."); }

        if(! verifierNiveau.verifierNumeroNiveau(new JoueurControleur().getJoueurCourant(), numNiveau)){
            throw new IllegalArgumentException("Le numéro du niveau ne peut pas être plus petit que 0.");
        }

        this.canvas = canvas;
        dessinateur = new Dessinateur(canvas);

        this.numNiveau = numNiveau;
        creerNiveauGraphique(canvas, numNiveau);
    }

    /**
     * Dessine tous les objets graphiques d'un niveau
     * @param canvas Canvas pour lequel chaque couche dessine l'ensemble des objets graphiques à instancier
     * @param numNiveau numéro du niveau à charger
     * @throws Exception
     */
    private void creerNiveauGraphique(Canvas canvas, int numNiveau) throws Exception {
        Niveau niveau = instanciateurNiveau.creerNiveau(numNiveau);
        int i;

        if(niveau.getListeCouches().isEmpty()){
            throw new Exception("Le niveau n'a pas été correctement chargé");
        }

        for (i = 0; i<niveau.getListeCouches().size(); i++){ //pour chaque couche
            for (ObjetGraphique og : niveau.getListeCouches().get(i).getListeObjets() ) {
                //pour chaque objet graphique de la liste de chaque couche...
                dessinateur.dessiner(og); //...on le dessine
            }
        }
    }
}
