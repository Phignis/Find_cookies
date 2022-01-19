package observateurs;

import temps.GenerateurTick;

import java.util.ArrayList;
import java.util.List;

/**
 * SujetObservableUneFois est une implémentation de Sujet. Il réalise donc la promesse de Sujet, et garentit en plus l'unicité des
 * Observateurs, c'est à dire qu'un Observateur ne peut observer qu'une seule fois cette instance de SujetObservableUneFois
 * Une classe fille typique est GenerateurTick
 * @see Sujet
 * @see Observateur
 * @see GenerateurTick
 */
public abstract class SujetObservableUneFois implements Sujet {

    /**
     * liste des observateurs abonnés au Sujet observé, l'unicité des instances dans la liste est garantit
     * @see SujetObservableUneFois#attacher(Observateur)
     * @see SujetObservableUneFois#detacher(Observateur)
     */
    private List<Observateur> observateurs;

    /**
     * Constructeur de SujetObservableUneFois, créé la liste des observateurs abonnées (à vide)
     */
    public SujetObservableUneFois() {
        this.observateurs = new ArrayList<>();
    }

    /**
     * Abonne un Observateur à cette instance de SujetObservableUneFois, pour qu'il reçoive les notifications,
     * si l'instance n'est pas déjà présente
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
     * Désabonne un Observateur à cette instance de SujetObservableUneFois, pour qu'il ne reçoive plus les notifications
     * @see SujetObservableUneFois#notifier()
     * @param o observateur a abonner au Sujet, pour qu'il recoive les notifications
     * @return true si l'observateur a bien été désabonné, false sinon (si l'observateur n'était déjà pas abonné)
     */
    public boolean detacher(Observateur o) {
        return observateurs.remove(o);
    }

    /**
     * Notifie, via la méthode update de Observateur, tout les Observateurs abonnés a cette instance, via la méthode attacher
     * @see Observateur#update(Sujet)
     * @see SujetObservableUneFois#attacher(Observateur)
     */
    public void notifier() {
        for (Observateur o : observateurs) {
            o.update(this);
        }
    }
}
