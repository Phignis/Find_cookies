package utile.observateur;

import java.util.ArrayList;
import java.util.List;

/**
 * Sujet a pour but de se faire observer par un Observateur abonné.
 * Un exemple de Sujet peut etre la classe BoucleTemporelle
 * Il est la couche d'abstraction Sujet (Subject), avec Observateur (Observer) du patron de conception comportemental "Observateur"
 * @see Observateur
 * @see clock.BoucleTemporelle
 * @see <a href="http://goprod.bouhours.net/?page=pattern&pat_id=16">Patron Observateur</a>
 */
public abstract class SujetObservableUneFois implements Sujet {

    /**
     * liste des observateurs abonnés au Sujet observés, l'unicité des instances dans la liste est garantit
     * @see SujetObservableUneFois#attacher(Observateur)
     * @see SujetObservableUneFois#detacher(Observateur)
     */
    private List<Observateur> observateurs;

    /**
     * Constructeur de Sujet, créé la liste des observateurs abonnées (à vide)
     */
    public SujetObservableUneFois() {
        this.observateurs = new ArrayList<>();
    }

    /**
     * Abonne un Observateur à cette instance de Sujet, pour qu'il reçoit les notifications, si l'instance n'est pas déjà présente
     * @see SujetObservableUneFois#notifier()
     * @param o observateur a abonner au Sujet, pour qu'il recoive les notifications
     * @return true si l'observateur a bien été abonné, false sinon (si null, ou si l'instance est déjà abonnée)
     */
    public boolean attacher(Observateur o) {

        if(o == null) return false;

        for (Observateur dejaAbonne : observateurs) {
            if(o == dejaAbonne) return false;
        }
        return observateurs.add(o);
    }

    /**
     * Désabonne un Observateur à cette instance de Sujet, pour qu'il ne reçoit plus les notifications
     * @see SujetObservableUneFois#notifier()
     * @param o observateur a abonner au Sujet, pour qu'il recoive les notifications
     * @return true si l'observateur a bien été abonné, false sinon
     */
    public boolean detacher(Observateur o) {
        return observateurs.remove(o);
    }

    /**
     * Notifie, via la méthode update de Observateur, tout les Observateurs abonnés a cette instance, via la méthode attacher
     * @see Observateur#update(Class)
     * @see SujetObservableUneFois#attacher(Observateur)
     */
    public void notifier() {
        for (Observateur o : observateurs) {
            o.update(getClass());
        }
    }
}
