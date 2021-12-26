package metier;

import utile.observateur.Observateur;
import utile.observateur.Sujet;
import utile.observateur.SujetRelaisUniqueObservation;

/**
 * Interrupteur a pour but de pouvoir s'activer ou se désactiver (on/off), et notifier tout Observateur abonné à lui.
 * @see Sujet
 * @see SujetRelaisUniqueObservation
 */
public class Interrupteur extends Objet implements Sujet {

    /**
     * représente l'activation ou non de cette instance d'Interrupteur
     */
    private boolean estActive;

    /**
     * permet de gérer tout l'aspect Sujet de l'interrupteur (abonnement, désabonnement et notification des abonnés)
     * la gestion est donc totalement délégué à cet attribut
     * @see SujetRelaisUniqueObservation
     */
    private SujetRelaisUniqueObservation gestionSujet;

    ////////////////////////////////
    // CONSTRUCTEUR
    ////////////////////////////////

    /**
     *
     * @param image
     * @param posX
     * @param posY
     */
    public Interrupteur(String image, int posX, int posY) {
        super(image, posX, posY);
        estActive = false;
        gestionSujet = new SujetRelaisUniqueObservation();
    }


    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    /**
     * permet de savoir si l'instance d'Interrupteur est actif (on) ou non
     * @return true si l'interrupteur est sur on, donc actif, false sinon
     */
    public boolean isEstActive() {
        return estActive;
    }


    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    /**
     * Abonne un Observateur à cette instance de Interrupteur, pour qu'il reçoive les notifications,
     * si jamais il n'est pas déjà présent
     * @param o Observateur a abonner, pour qu'il recoive les notifications
     * @return true si l'observateur a bien été abonné, false sinon (si null, ou si l'instance est déjà abonnée)
     */
    public boolean attacher(Observateur o) {
        return gestionSujet.attacher(o);
    }

    /**
     * Désabonne un Observateur à cette instance de Interrupteur, pour qu'il ne reçoive plus les notifications
     * @see Interrupteur#notifier()
     * @param o observateur a abonner au Sujet, pour qu'il recoive les notifications
     * @return true si l'observateur a bien été abonné, false sinon
     */
    public boolean detacher(Observateur o) {
        return gestionSujet.detacher(o);
    }

    public void notifier() {
        gestionSujet.notifier();
    }
}
