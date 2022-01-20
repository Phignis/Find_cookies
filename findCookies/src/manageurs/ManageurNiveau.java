package manageurs;

import controleurs.JoueurControleur;
import javafx.scene.canvas.Canvas;
import utile.Dessinateur;
import validation.VerifierNiveau;
import utile.InstanciateurNiveau;
import objets.niveaux.Niveau;

public class ManageurNiveau {
    private int numNiveau;
    private VerifierNiveau verifierNiveau = new VerifierNiveau();

    private Niveau niveau;
    public Niveau getNiveau(){ return niveau; }

    public ManageurNiveau(int numNiveau) throws Exception {
        if(! verifierNiveau.verifierNumeroNiveau(new JoueurControleur().getJoueurCourant(), numNiveau)){
            throw new IllegalArgumentException("Le numéro du niveau ne peut pas être plus petit que 0.");
        }

        this.numNiveau = numNiveau;
        chargerNiveau(numNiveau);
    }

    /**
     * Dessine tous les objets graphiques d'un niveau
     * @param numNiveau numéro du niveau à charger
     * @throws Exception
     */
    private void chargerNiveau(int numNiveau) throws Exception {
        niveau = new InstanciateurNiveau().creerNiveau(numNiveau);

        if(niveau.getListeCouches().isEmpty()){
            throw new Exception("Le niveau n'a pas été correctement chargé");
        }
    }
}
