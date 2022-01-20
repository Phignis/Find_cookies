package observateurs;

import objets.niveaux.metiers.Interrupteur;

import java.util.ArrayList;
import java.util.List;

/**
 * SujetRelaisUniqueObservation est une implémentation de Sujet. Il réalise donc la promesse de Sujet,
 * et garentit en plus l'unicité des Observateurs, c'est à dire qu'un Observateur ne peut observer qu'une seule fois
 * cette instance de SujetRelaisUniqueObservation.
 * Il ressemble en cela à SujetObservableUneFois. Il a été pensé pour remplir ce rôle, en relayant les notifications d'un
 * Sujet ne pouvant étendre de la classe SujetObservableUneFois, et est possédé en attribut.
 * Une classe possédant un SujetRelaisUniqueObservation en attribut est Interrupteur
 * @see Sujet
 * @see Observateur
 * @see SujetObservableUneFois
 * @see Interrupteur
 */
public class SujetRelaisUniqueObservation implements Sujet {
    /**
     * liste des observateurs abonnés au SujetRelaisUniqueObservation observé,
     * l'unicité des instances dans la liste est garantit
     * @see SujetRelaisUniqueObservation#attacher(Observateur)
     * @see SujetRelaisUniqueObservation#detacher(Observateur)
     */
    private List<Observateur> observateurs;

    /**
     * Constructeur de SujetRelaisUniqueObservation. Instancie la collection des observateurs à vide
     * @see SujetRelaisUniqueObservation#observateurs
     */
    public SujetRelaisUniqueObservation() {
        this.observateurs = new ArrayList<>();
    }

    /**
     * Abonne un Observateur à cette instance de SujetRelaisUniqueObservation, pour qu'il reçoive les notifications,
     * si l'instance n'est pas déjà présente
     * @see SujetRelaisUniqueObservation#notifier()
     * @see SujetRelaisUniqueObservation#notifier(Sujet)
     * @param o observateur à abonner au SujetRelaisUniqueObservation, pour qu'il recoive les notifications
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
     * Désabonne un Observateur à cette instance de SujetRelaisUniqueObservation, pour qu'il ne reçoive plus les notifications
     * @see SujetRelaisUniqueObservation#notifier()
     * @param o observateur a abonner au Sujet, pour qu'il recoive les notifications
     * @return true si l'observateur a bien été abonné, false sinon
     */
    public boolean detacher(Observateur o) {
        return observateurs.remove(o);
    }

    /**
     * Notifie, via la méthode update de Observateur, tous les Observateurs abonnés a cette instance, via la méthode attacher.
     * Cette méthode notifie avec lui-même (l'instance), ici SujetRelaisUniqueObservation
     *
     * @deprecated Cette méthode ne devrait pas etre utilisé dans le concept original de cette classe, qui est de servir
     * de relais pour des classes ne pouvant étandre de SujetObservationUneFois, instance pensée pour etre possédée en attribut
     * Notifie, via la méthode update de Observateur, tout les Observateurs abonnés a cette instance, via la méthode attacher.
     * Cette méthode notifie avec la Class lié à cette instance, donc SujetRelaisUniqueObservation.
     * @see Observateur#update(Sujet)
     * @see SujetRelaisUniqueObservation#attacher(Observateur)
     */
    @Override
    public void notifier() {
        for (Observateur o : observateurs) {
            o.update(this);
        }
    }

    /**
     * Notifie, via la méthode update de Observateur, tous les Observateurs abonnés a cette instance, via la méthode attacher.
     * Cette méthode notifie avec l'instance passée en paramètre, typiquement l'instance qui possède la possède en attribut.
     * @param notificateur Instance sous laquelle vous souhaitez faire passer la notification
     * @see Observateur#update(Sujet)
     * @see SujetRelaisUniqueObservation#attacher(Observateur)
     * @see Object#getClass()
     * @see Interrupteur#notifier()
     */
    public void notifier(Sujet notificateur) {
        for (Observateur o : observateurs) {
            o.update(notificateur);
        }
    }
}