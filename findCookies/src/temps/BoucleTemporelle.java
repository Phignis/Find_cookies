package temps;

import observateurs.Observateur;
import observateurs.Sujet;
import observateurs.SujetObservableUneFois;

/**
 * BoucleTemporelle représente la boucle temporelle présente dans les niveaux du jeu.
 * Elle est chargée d'indiquer la fin de la limite de temps de jeu, a laquelle le personne est remise au début du niveau
 */
public class BoucleTemporelle extends SujetObservableUneFois implements Observateur {

    /**
     * nombre de ticks que dure au total la boucle, avant d'indiquer la fin de la boucle temporelle du niveau.
     * @see BoucleTemporelle#BoucleTemporelle(long)
     * @see BoucleTemporelle#setTempsTotalBoucle(long)
     */
    private long nbTicksBoucle;

    /**
     * Met a jour le nombre de ticks que dure la boucle temporelle du niveau (conversion des secondes données en ticks de 16ms)
     * @see BoucleTemporelle#nbTicksBoucle
     * @param nbTicksBoucle Le nouveau nombre de ticks que dure la boucle, avant que le niveau soit remis au début de la boucle
     */
    public void setTempsTotalBoucle(long nbTicksBoucle) {
        this.nbTicksBoucle = nbTicksBoucle;
    }

    /**
     * nombre de ticks écoulé depuis la dernière indication de fin de boucle temporelle
     * @see BoucleTemporelle#BoucleTemporelle(long)
     */
    private long nbTicksEcoule;

    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    /**
     * Constructeur de BoucleTemporelle
     * @param nbTicksBoucle Le nombre de ticks que dure la boucle temporelle, avant que le niveau soit remis au début de la boucle
     */
    public BoucleTemporelle(long nbTicksBoucle) {
        this.nbTicksBoucle = nbTicksBoucle;
        nbTicksEcoule = 0;
    }

    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    /**
     * Indique si la boucle temporelle est terminée, moment où le niveau sera réinitialisé au début du début de la boucle temporelle
     * @return true si jamais la boucle est bien terminée, false sinon
     */
    private boolean estBoucleTemporelleTerminee() {
        return nbTicksBoucle == nbTicksEcoule;
    }

    /**
     * Effectue l'action prédéterminée (ici notifier les Observateurs abonnés a la Boucle, et remettre à zéro le nombre de ticks écoulés) si jamais la boucle temporelle est terminée.
     * Afin de vérifier cette fin, la fonction estBoucleTemporelleTermine() est utilisé.
     * @see BoucleTemporelle#nbTicksEcoule
     * @see BoucleTemporelle#estBoucleTemporelleTerminee()
     */
    private void eventFinBoucleTemporelle() {
        if (estBoucleTemporelleTerminee()) {
            notifier();
            nbTicksEcoule = 0;
        }
    }

    /**
     * Implémentation de la méthode de Observateur. ici, a chaque notification, on incrémente le nombre de ticks écoulés depuis le début,
     * et si jamais on a atteint la fin du temps de la boucle, on effectue l'event de fin de boucle, qui notifie tout ce qui est abonné
     * à la boucle
     * @param notificateur notificateur à l'origine de l'update, le nombre de tick ecoulé ne s'incrémente que si ce dernier est un GenerateurTick
     * @see Observateur
     * @see BoucleTemporelle#setTempsTotalBoucle(long)
     * @see BoucleTemporelle#eventFinBoucleTemporelle()
     */
    @Override
    public void update(Sujet notificateur) {
        // update par GenerateurTick
        if(notificateur instanceof GenerateurTick) {
            ++nbTicksEcoule;
            eventFinBoucleTemporelle();
        }
    }
}
