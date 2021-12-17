package utile.observateur;

/**
 * Observateur a pour but d'observer un Sujet en particulier.
 * Il est la couche d'abstraction Observateur (Observer), avec Sujet (Subject) du patron de conception comportemental "Observateur"
 * @see Sujet
 * @see <a href="http://goprod.bouhours.net/?page=pattern&pat_id=16">Patron Observateur</a>
 */
public abstract class Observateur {

    /**
     * a pour but d'effectuer une action précise, lorsque la notification du ou d'un des Sujets auquel l'instance est abonné est envoyé.
     * @see Sujet#attacher(Observateur)
     * @see Sujet#notifier()
     */
    public abstract void update();
}
