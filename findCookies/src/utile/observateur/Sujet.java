package utile.observateur;

import java.util.LinkedList;

/**
 * Sujet a pour but de se faire observer par un Observateur abonné.
 * Un exemple de Sujet peut etre la classe BoucleTemporelle
 * Il est la couche d'abstraction Sujet (Subject), avec Observateur (Observer) du patron de conception comportemental "Observateur"
 * @see Observateur
 * @see clock.BoucleTemporelle
 * @see <a href="http://goprod.bouhours.net/?page=pattern&pat_id=16">Patron Observateur</a>
 */
public abstract class Sujet {

    /**
     * liste des observateurs abonnés au Sujet observés
     * @see Sujet#attacher(Observateur)
     * @see Sujet#detacher(Observateur)
     */
    private LinkedList<Observateur> observateurs;

    /**
     * Constructeur de Sujet, créé la liste des observateurs abonnées (à vide)
     */
    public Sujet() {
        this.observateurs = new LinkedList<>();
    }

    /**
     * Abonne un Observateur à cette instance de Sujet, pour qu'il reçoit les notifications
     * @see Sujet#notifier()
     * @param o observateur a abonner au Sujet, pour qu'il recoive les notifications
     * @return true si l'observateur a bien été abonné, false sinon
     */
    public boolean attacher(Observateur o) {
        return observateurs.add(o);
    }

    /**
     * Désabonne un Observateur à cette instance de Sujet, pour qu'il ne reçoit plus les notifications
     * @see Sujet#notifier()
     * @param o observateur a abonner au Sujet, pour qu'il recoive les notifications
     * @return true si l'observateur a bien été abonné, false sinon
     */
    public boolean detacher(Observateur o) {
        return observateurs.remove(o);
    }

    /**
     * Notifie, via la méthode update de Observateur, tout les Observateurs abonnés a cette instance, via la méthode attacher
     * @see Observateur#update() 
     * @see Sujet#attacher(Observateur)
     */
    public void notifier() {
        for (Observateur o : observateurs) {
            o.update();
        }
    }
}
