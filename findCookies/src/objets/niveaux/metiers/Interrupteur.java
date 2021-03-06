package objets.niveaux.metiers;

import observateurs.Observateur;
import observateurs.Sujet;
import observateurs.SujetRelaisUniqueObservation;

/**
 * Interrupteur a pour but de pouvoir s'activer ou se désactiver (on/off), et notifier tout Observateur abonné à lui.
 * @see Sujet
 * @see SujetRelaisUniqueObservation
 */
public class Interrupteur extends ObjetMetier implements Sujet {

    /**
     * représente l'activation ou non de cette instance d'Interrupteur
     */
    private boolean estActive;

    /**
     * permet de savoir si l'instance d'Interrupteur est actif (on) ou non
     * @return true si l'interrupteur est sur on, donc actif, false sinon
     */
    public boolean isEstActive() {
        return estActive;
    }

    /**
     * permet de gérer tout l'aspect Sujet de l'interrupteur (abonnement, désabonnement et notification des abonnés)
     * la gestion est donc totalement déléguée à cet attribut
     * @see SujetRelaisUniqueObservation
     */
    private SujetRelaisUniqueObservation gestionSujet;

    ////////////////////////////////
    // CONSTRUCTEUR
    ////////////////////////////////

    /**
     * Créé un interrupteur
     */
    public Interrupteur() {
        estActive = false;
        gestionSujet = new SujetRelaisUniqueObservation();

        super.collision = true;
    }

    /**
     * Créé un interrupteur par copie profonde
     */
    public Interrupteur(Interrupteur i) {
        this.estActive = i.estActive;
        this.gestionSujet = new SujetRelaisUniqueObservation(i.gestionSujet);
    }

    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    /**
     * Action d'activer l'instance d'Interrupteur. Inverse le booléen estActive représentant on et off, et notifie les
     * Observateurs abonnés de ce changement.
     * @see Interrupteur#estActive
     * @see Interrupteur#notifier()
     */
    public void actionnerInterrupteur() {
        estActive = !estActive;
        notifier();
    }

    /**
     * Abonne un Observateur à cette instance de Interrupteur, pour qu'il reçoive les notifications,
     * si jamais il n'est pas déjà présent
     * @param o Observateur a abonner, pour qu'il recoive les notifications
     * @return true si l'observateur a bien été abonné, false sinon (si null, ou si l'instance est déjà abonnée)
     */
    @Override
    public boolean attacher(Observateur o) {
        return gestionSujet.attacher(o);
    }

    /**
     * Désabonne un Observateur à cette instance de Interrupteur, pour qu'il ne reçoive plus les notifications
     * @see Interrupteur#notifier()
     * @param o observateur a abonner au Sujet, pour qu'il recoive les notifications
     * @return true si l'observateur a bien été abonné, false sinon
     */
    @Override
    public boolean detacher(Observateur o) {
        return gestionSujet.detacher(o);
    }

    /**
     * permet de notifier tout les Observateurs abonné à cet interrupteur (en réalité abonné à gestionSujet)
     * @see Interrupteur#gestionSujet
     * @see Observateur#mettreAJour(Sujet)
     */
    @Override
    public void notifier() {
        gestionSujet.notifier(this);
    }
}
