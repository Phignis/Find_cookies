package manageurs;

import objets.niveaux.Joueur;

import java.util.List;

public class ManageurJoueur {

    /**
     * Ajoute un juoeur dans une liste de joueurs
     * @param j Joueur à ajouter
     * @param listeJoueurs Liste des joueurs
     * @return retourne vrai si l'insertion a bien été effective, faux sinon
     */
    public boolean ajouterJoueur(Joueur j, List<Joueur> listeJoueurs){
        return listeJoueurs.add(j);
    }

    /**
     * Supprime un joueur de la liste des joueurs
     * @param j Joueur à supprimer
     * @param listeJoueurs liste des joueurs de laquelle supprimer le joueur
     * @return retourne vrai si la suppression a bien été effective, faux sinon
     * @throws Exception
     */
    public boolean supprimerJoueur(Joueur j, List<Joueur> listeJoueurs){
        return listeJoueurs.remove(j);
    }

    /**
     * Récupère l'instance d'un joueur selon son unique pseudo
     * @param pseudo Pseudo du joueur pour lequel récupérer l'instance
     * @param listeJoueurs Liste des joueurs à parcourir
     * @return retourne l'instance du joueur trouvé si elle éxiste, null sinon
     */
    public Joueur getJoueur(String pseudo, List<Joueur> listeJoueurs){
        for(Joueur j : listeJoueurs){
            if(j.getPseudo().equals(pseudo)){
                return j;
            }
        }

        return null;
    }
}
