package controleurs;

import manageurs.ManageurJoueur;
import objets.niveaux.Joueur;
import validation.VerifierJoueur;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JoueurControleur {

    private static Joueur joueurCourant;
    /**
     * Permet de connaitre l'instance du joueur courant
     * @return retourne l'instance du joueur courant
     */
    public Joueur getJoueurCourant() {
        return joueurCourant;
    }
    public void setJoueurCourant(Joueur joueur){ joueurCourant=joueur; }

    private ManageurJoueur manageurJ = new ManageurJoueur();
    private VerifierJoueur verifierJ = new VerifierJoueur();

    /**
     * Liste des joueurs de l'application
     */
    private List<Joueur> listeJoueurs = new ArrayList<>();

    /**
     * Ajoute un joueur dans la liste des joueurs
     * @param pseudo Pseudo du joueur à ajouter
     * @return vrai si l'insertion a bien eut lieu ; faux sinon
     */
    public boolean ajouterJoueur(String pseudo) throws IOException {
        boolean verif = verifierJ.verifierPseudo(pseudo, listeJoueurs);
        if(!verif){
            return false;
        }

        Joueur j = new Joueur(pseudo, 1);

      /*
        DataOutputStream fichier = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("/ressources/sauvegardes/joueurs/listeJoueurs.bin")));
 */
        if(!manageurJ.ajouterJoueur(j, listeJoueurs)){
            return false;
        }

      //  fichier.close();

        joueurCourant = j;
        return true;
    }

    /**
     * Supprime de la liste des joueurs le joueur dont le pseudo est passé en paramètre
     * @param pseudo Pseudo du joueur à supprimer
     * @return vrai si la suppression a bien eut lieu ; faux sinon
     */
    public boolean supprimerJoueur(String pseudo) {
        Joueur joueur = manageurJ.getJoueur(pseudo, listeJoueurs);
        if(joueur == null){
            return false;
        }

        if(!manageurJ.supprimerJoueur(joueur, listeJoueurs)){
            return false;
        }

        joueurCourant = null;
        return true;
    }

    /**
     * Charge la colection des joueurs à partir d'un fichier binaire
     */
    /*
    private void chargerListeJoueurs(){
        DataInputStream fichier;
        int nbJoueurs;

        try {
            fichier = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream("/ressources/sauvegardes/joueurs/listeJoueurs.bin")));

            nbJoueurs = fichier.readInt();
            for(int i=0; i<nbJoueurs; i++){
                String pseudo = fichier.readUTF();
                int numeroAtteint = fichier.readInt();
                Joueur joueur = new Joueur(pseudo, numeroAtteint);
                listeJoueurs.add(joueur);
            }

            fichier.close();
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
     */

}
