package utile.observateur;

/**
 * Observateur a pour but d'observer un Sujet en particulier.
 * Il est la couche d'abstraction Observateur (Observer), avec Sujet (Subject) du patron de conception comportemental "Observateur"
 * @see SujetObservableUneFois
 * @see <a href="http://goprod.bouhours.net/?page=pattern&pat_id=16">Patron Observateur</a>
 */
public interface Observateur {

    /**
     * a pour but d'effectuer une action précise, lorsque la notification du ou d'un des Sujets auquel l'instance est abonné est envoyé.
     * @see SujetObservableUneFois#attacher(Observateur)
     * @see SujetObservableUneFois#notifier()
     */
    public abstract void update(Class c);
}
