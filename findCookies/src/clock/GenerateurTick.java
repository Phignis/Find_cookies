package clock;

import utile.observateur.SujetObservableUneFois;

/**
 * GenerateurTick génère les ticks permettant de cadencer le jeu, et déterminer le délai entre deux actions.
 * Il se charge de la fréquence à laquelle la partie métier recoit les notifications de la vue (comme les actions claviers).
 * Ces ticks servent par exemple a la boucle temporelle du jeu
 * @see BoucleTemporelle
 */
public class GenerateurTick extends SujetObservableUneFois implements Runnable {

    /**
     * Représente l'intervalle entre deux ticks généré par l'instance de la classe. Cette valeur est en micro secondes
     * @see GenerateurTick#GenerateurTick(int)
     * @see GenerateurTick#getIntervalleEntreTicks()
     */
    private int intervalleEntreTicks;

    /**
     * thread interne, servant d'effectuer, en parallèle du reste du jeu, la mise en place des ticks de 16ms
     * @see GenerateurTick#run()
     */
    private Thread threadInterne;


    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    /**
     * Constructeur de GenerateurTick.
     * Il lance en interne un nouveau thread (threadInterne), permettant de mettre en place les ticks, générés à intervalle régulière
     * Par défaut, la valeur de l'intervalle entre chaque ticks est de 16ms, pour un jeu à 60Hz
     * @see GenerateurTick#threadInterne
     * @see GenerateurTick#intervalleEntreTicks
     */
    public GenerateurTick() {
        this.intervalleEntreTicks = 16;
        this.threadInterne = new Thread(this);
        threadInterne.start();
    }

    /**
     * Constructeur de GenerateurTick.
     * Il lance en interne un nouveau thread (threadInterne), permettant de mettre en place les ticks, générés à intervalle régulière
     * @param intervalleEntreTicks intervalle entre deux ticks générés par l'instance. Cette valeur est en micro-secondes (ms)
     * @see GenerateurTick#threadInterne
     * @see GenerateurTick#intervalleEntreTicks
     *
     */
    public GenerateurTick(int intervalleEntreTicks) {
        this.intervalleEntreTicks = intervalleEntreTicks;
        this.threadInterne = new Thread(this);
        threadInterne.start();
    }


    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    /**
     * Permet de récupérer l'intervalle entre chaque ticks générés
     * @return un int, représentant l'intervalle en micro-seconde
     * @see GenerateurTick#intervalleEntreTicks
     */
    public int getIntervalleEntreTicks() {
        return intervalleEntreTicks;
    }


    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    /**
     * Fonction effectuée par le thread interne à la classe permettant la mise en place du décompte de tick de 16ms
     * Il est nottament utilisé pour la boucle temporelle
     * @see GenerateurTick#threadInterne
     */
    @Override
    public void run() {
        // boucle du thread
        while (true) {
            try {
                Thread.sleep(intervalleEntreTicks); // on veut un jeu a 60Hz, on permet un check des events toutes les 1/60 de secondes
                super.notifier(); // on notifie qu'un tick de 16ms est passé
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    /**
     * Permet d'interrompre le thread interne générant les ticks, via la méthode interrupt
     * Cette méthode ne devrait jamais renvoyer false.
     * La fonction réciproque est reprendreGenerateur
     * @return true si jamais il a été possible d'interrompre le thread interne, false sinon, normalement car le thread interne est initialisé à null
     * @see Thread#interrupt()
     * @see GenerateurTick#threadInterne
     * @see GenerateurTick#reprendreGenerateur()
     */
    public boolean interrompreGenerateur() {
        if(threadInterne != null) {
            threadInterne.interrupt();
            return true;
        }
        return false;
    }

    /**
     * Permet de relancer la génération des ticks. On ne relance pas vraiment le thread interne, mais on lui réattribue un nouveau thread, que l'on relance.
     * Il interrompt d'abord le thread interne avec interrompreGenerateur(), afin d'éviter que le thread n'ayant plus de référence soit toujours actif.
     * @see GenerateurTick#threadInterne
     * @see GenerateurTick#interrompreGenerateur()
     */
    public void reprendreGenerateur() {
        // on s'assure que le generateur est bien interrompu
        interrompreGenerateur();
        // on recréé un nouveau thread
        threadInterne = new Thread(this);
        threadInterne.start();
    }
}
