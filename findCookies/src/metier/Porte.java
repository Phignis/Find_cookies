package metier;

import metier.gestion.porte.update.GestionnaireUpdatePorte;
import metier.gestion.porte.update.UpdatePorteByInterrupteur;
import utile.observateur.Observateur;
import utile.observateur.Sujet;

/**
 * Porte a pour but de pouvoir s'ouvrir ou se fermer, selon qui notifie la Porte
 * @see Observateur
 */
public class Porte implements Observateur {

    /**
     * indique l'état de la porte (ouverte -> true, fermée -> false)
     */
    private boolean estOuverte;

    /**
     * actionneur est l'interrupteur qui commande la porte, observée donc par celle ci
     * @see Observateur
     */
    private Interrupteur actionneur;

    /**
     * permet de gérer l'action a faire en cas de notification, selon la classe du notificateur
     * @see Observateur#update(Class)
     */
    private GestionnaireUpdatePorte gestionUpdate;


    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    /**
     * Instancie une Porte, fermée de base, sans interrupteur pour la commander, ni de gestionUpdate
     */
    public Porte() {
        this.estOuverte = false;
    }


    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    /**
     * permet de savoir si la porte est ouverte ou non
     * @return true si elle est ouverte, false si elle est fermée
     */
    public boolean isEstOuverte() {
        return estOuverte;
    }

    public Interrupteur getActionneur() {
        return actionneur;
    }

    ////////////////////////////////
    // SETTERS
    ////////////////////////////////


    public void setEstOuverte(boolean estOuverte) {
        this.estOuverte = estOuverte;
    }

    /**
     * permet d'ajouter un interrupteur actionnant la porte, ainsi que la gestion pour update si jamais l'interrupteur actionne la porte
     * abonne cette instance a l'actionneur
     * @param actionneur Interrupteur commandant la porte
     */
    public void setActionneur(Interrupteur actionneur) {
        this.actionneur = actionneur;
        actionneur.attacher(this);

        GestionnaireUpdatePorte ajoutPossible = new UpdatePorteByInterrupteur(this);
        if(gestionUpdate != null && gestionUpdate.isTypeGestionnairePresent(ajoutPossible.getClass())) {
            ajouterGestionUpdate(ajoutPossible);
        }
        else if(gestionUpdate == null) {
            ajouterGestionUpdate(ajoutPossible);
        }
    }


    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    /**
     * Permet d'ajouter en tête de la structure de donnée un nouveau systeme d'update
     * @param ajout nouveau systeme d'update
     * @return true si l'insertion est réussie, false sinon, si jamais le systeme d'update est déjà présent dans nos systèmes
     * @see GestionnaireUpdatePorte
     */
    public boolean ajouterGestionUpdate(GestionnaireUpdatePorte ajout) {
        if(gestionUpdate != null && !gestionUpdate.isTypeGestionnairePresent(ajout.getClass())) {
            // dans ce cas, on peut insérer, le type n'est pas déjà présent, cas le plus courant
            ajout.setSuccesseur(gestionUpdate);
            gestionUpdate = ajout;
        } else if(gestionUpdate == null) {
            // on ajoute juste
            gestionUpdate = ajout;
        } else { // on a donc gestionUpdate non null, mais le type déjà présent
            return false;
        }

        return true;
    }

    @Override
    public void update(Class<? extends Sujet> c) {
        if(gestionUpdate != null) {
            gestionUpdate.gererUpdatePorte(c);
        }
    }
}
