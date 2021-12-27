package utile.observateur;

/**
 * Observateur a pour but d'observer un Sujet en particulier.
 * Il est la couche d'abstraction Observateur (Observer), avec Sujet (Subject) du patron de conception comportemental "Observateur"
 * @see SujetObservableUneFois
 * @see <a href="http://goprod.bouhours.net/?page=pattern&pat_id=16">Patron Observateur</a>
 */
public interface Observateur {

    /**
     * a pour but d'effectuer une action précise, lorsque la notification du ou d'un des Sujets auquel l'instance est abonné
     * est envoyé. L'action d'update peut changé en fonction du type de Class passé en paramètre
     * @param c Class qui est initiatrice de la mise en place de cette méthode
     * @see SujetObservableUneFois#attacher(Observateur)
     * @see SujetObservableUneFois#notifier()
     */
    void update(Class<? extends Sujet> c);
}
