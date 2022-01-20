package observateurs;

/**
 * Sujet a pour but d'envoyer des notifications à divers Observateurs
 * Il fait partie de la couche d'abstraction avec Observateur (Observer) du patron de conception comportemental "Observateur"
 * Chaque implémentation de Sujet devrait définir une collection (au choix) d'Observateur abonné, a qui il envoit des notifications
 * @see SujetObservableUneFois
 * @see Observateur
 * @see <a href="http://goprod.bouhours.net/?page=pattern&pat_id=16">Patron Observateur</a>
 */
public interface Sujet {

    /**
     * A pour but d'abonner l'observateur passé en paramètre, en l'ajoutant à une collection d'abonnés, pour qu'il recoive les notifications
     * @see Sujet#notifier()
     * @param o Observateur a abonner, pour qu'il recoive les notifications
     * @return true si l'observateur a été abonné, false sinon
     */
    boolean attacher(Observateur o);

    /**
     * A pour but de désabonner l'observateur passé en paramètre, pour qu'il ne recoive plus les notifications.
     * Réciproque de attacher(Observateur)
     * @see Sujet#attacher(Observateur)
     * @param o Observateur à désabonner
     * @return true si o a bien été désabonné, false sinon
     */
    boolean detacher(Observateur o);

    /**
     * A pour but de notifier tout les Observateurs présent dans la collection d'observateurs abonnés
     */
    void notifier();
}
