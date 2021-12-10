package clock;

/**
 * BoucleTemporelle représente la boucle temporelle présente dans les niveaux du jeu.
 * Il se charge de la fréquence à laquelle la partie métier recoit les notifications de la vue (comme les actions claviers),
 * mais aussi indiquer la fin de la limite de temps de jeu, a laquelle le personne est remis au début du niveau
 */
public class BoucleTemporelle extends Subject implements Runnable {
    // un tick = 16 ms
    /**
     * nombre de ticks que dure au total la boucle, avant d'indiquer la fin de la boucle temporelle du niveau.
     * @see BoucleTemporelle#BoucleTemporelle(long)
     * @see BoucleTemporelle#setTempsTotalBoucle(long)
     */
    private long nbTicksBoucle;

    /**
     * nombre de ticks écoulé depuis la dernière indication de fin de boucle temporelle
     * @see BoucleTemporelle#BoucleTemporelle(long)
     */
    private long nbTicksEcoule;

    /**
     * thread interne, servant d'effectuer, en parallèle du reste du jeu, la mise en place des ticks de 16ms
     * @see BoucleTemporelle#BoucleTemporelle(long)
     * @see BoucleTemporelle#run()
     */
    private final Thread threadInterne;


    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    /**
     * Constructeur de BoucleTemporelle, il lance en interne un nouveau thread (threadInterne), permettant de mettre en place les ticks
     * @see BoucleTemporelle#threadInterne
     * @param nbSecondesBoucle Le nombre de secondes que dure la boucle temporelle, avant que le niveau soit remis au début de la boucle
     */
    public BoucleTemporelle(long nbSecondesBoucle) {
        this.nbTicksBoucle = (nbSecondesBoucle * 1000 / 16); // conversion des secondes en tick de 16ms
        nbTicksEcoule = 0;
        threadInterne = new Thread(this);
        threadInterne.start();
    }

    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    /**
     * Met a jour le nombre de ticks que dure la boucle temporelle du niveau (conversion des secondes données en ticks de 16ms)
     * @see BoucleTemporelle#nbTicksBoucle
     * @param nbSecondesBoucle Le nouveau nombre de secondes que dure la boucle, avant que le niveau soit remis au début de la boucle
     */
    public void setTempsTotalBoucle(long nbSecondesBoucle) {
        this.nbTicksBoucle = (nbSecondesBoucle * 1000 / 16);
    }

    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    /**
     * Indique si la boucle temporelle est terminée, moment où le niveau sera réinitialisé au début du début de la boucle temporelle
     * @return true si jamais la boucle est bien terminé, false sinon
     */
    private boolean estBoucleTemporelleTermine() {
        return nbTicksBoucle == nbTicksEcoule;
    }

    /**
     * Effectue l'action prédéterminée (ici notifier les Observateurs abonnés a la Boucle, et remettre à zéro le nombre de ticks écoulés) si jamais la boucle temporelle est terminée.
     * Afin de vérifier cette fin, la fonction estBoucleTemporelleTermine() est utilisé.
     * @see BoucleTemporelle#nbTicksEcoule
     * @see BoucleTemporelle#estBoucleTemporelleTermine()
     */
    private void eventFinBoucleTemporelle() {
        if (estBoucleTemporelleTermine()) {
            super.notifier();
            nbTicksEcoule = 0;
        }
    }

    /**
     * Fonction effectuée par le thread interne à la classe permettant la mise en place du décompte de tick de 16ms, et lance l'event de fin de boucle temporelle
     * @see BoucleTemporelle#threadInterne
     * @see BoucleTemporelle#eventFinBoucleTemporelle()
     */
    @Override
    public void run() {
        // boucle du thread
        while (true) {
            try {
                Thread.sleep(16); // on veut un jeu a 60 fps, on permet un check des events toutes les 1/60 de secondes
                ++nbTicksEcoule;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            eventFinBoucleTemporelle();
        }
    }
}
