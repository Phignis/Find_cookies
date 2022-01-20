package objets.niveaux.metiers;

import objets.actions.portes.ActionPorte;
import objets.actions.portes.SynchroPorteInterrupteur;
import observateurs.Observateur;
import observateurs.Sujet;

import java.util.HashMap;
import java.util.Map;

/**
 * Porte a pour but de pouvoir s'ouvrir ou se fermer, selon qui notifie la Porte
 * @see Observateur
 */
public class Porte extends ObjetMetier implements Observateur {

    /**
     * indique l'état de la porte (ouverte -> true, fermée -> false)
     */
    private boolean estOuverte;

    /**
     * permet de savoir si la porte est ouverte ou non
     * @return true si elle est ouverte, false si elle est fermée
     */
    public boolean isEstOuverte() {
        return estOuverte;
    }

    public void setEstOuverte(boolean estOuverte) {
        super.collision = !estOuverte;
        this.estOuverte = estOuverte;
    }

    /**
     * map liant un Sujet notificateur à un ActionUpdatePorte, qui détermine l'algorithme de update à effectuer
     * @see Observateur#mettreAJour(Sujet)
     */
    private Map<Sujet, ActionPorte> listeUpdatePossible;

    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    /**
     * Instancie une Porte, fermée de base, sans interrupteur pour la commander, ni de gestionUpdate
     */
    public Porte() {
        this.estOuverte = false;
        listeUpdatePossible = new HashMap<Sujet, ActionPorte>();
    }

    /**
     * Instancie une Porte, par copie profonde
     */
    public Porte(Porte p) {
        this.estOuverte = p.estOuverte;
        this.listeUpdatePossible = new HashMap<>();
        listeUpdatePossible.putAll(p.listeUpdatePossible);
    }

    ////////////////////////////////
    // SETTEURS
    ////////////////////////////////

    /**
     * permet d'ajouter un interrupteur actionnant la porte, ainsi que la gestion pour update si jamais l'interrupteur actionne la porte
     * abonne cette instance a l'actionneur
     *
     * @deprecated Cette méthode fait exactement la même chose que
     * {@link Porte#ajouterActionUpdate(Sujet, ActionPorte)}, avec pour 1er attribut l'actionneur et en second un SynchroPorteInterrupteur
     * avec la Porte puis l'actionneur
     * @param actionneur Interrupteur commandant la porte
     */
    public void setActionneur(Interrupteur actionneur) {
        listeUpdatePossible.put(actionneur, new SynchroPorteInterrupteur(this, actionneur));
    }

    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    /**
     * Permet d'ajouter à la liste des algorithmes possibles de update une nouvelle entrée.
     * Chaque algorithme est spécifique a une instance de Sujet (donc pour deux instances de même classe, on peut avoir deux
     * algorithmes qui diffèrent).
     * Si jamais l'entrée pour l'instance notificateur existe déjà, alors l'action a effectuer est remplacée
     *
     * @param notificateur Sujet étant à l'origine de l'update, pour lequel on spécifie un algorithme
     * @param actionAEffectuer Algorithme a effectuer
     * @see ActionPorte
     * @see Porte#mettreAJour(Sujet)
     */
    public void ajouterActionUpdate(Sujet notificateur, ActionPorte actionAEffectuer) {
        listeUpdatePossible.put(notificateur, actionAEffectuer);
    }

    /**
     * Permet de supprimer de la liste des algorithmes possible l'entrée pour le notificateur spécifié
     * @param notificateur Sujet dont l'algorithme est à supprimer
     * @return true si la suppression est réussie, false sinon (si notificateur n'existait déjà pas dans la liste des algo)
     */
    public boolean supprimerActionUpdate(Sujet notificateur) {
        return listeUpdatePossible.remove(notificateur) != null;
    }

    /**
     * permet à la porte de s'update, selon l'instance de sujet passée en paramètre
     * @param notificateur Sujet qui est initiateur de l'éxecution de cette méthode
     */
    @Override
    public void mettreAJour(Sujet notificateur) {
        ActionPorte actionAEffectuer = listeUpdatePossible.get(notificateur);
        if(actionAEffectuer != null) {
            actionAEffectuer.doAction();
        }
    }
}
