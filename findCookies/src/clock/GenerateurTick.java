package clock;

import utile.observateur.Sujet;

/**
 * GenerateurTick génère les ticks permettant de cadencer le jeu, et déterminer le délai entre deux actions.
 * Il se charge de la fréquence à laquelle la partie métier recoit les notifications de la vue (comme les actions claviers).
 * Ces ticks servent par exemple a la boucle temporelle du jeu
 * Un tick est ici de 16ms, afin que le jeu soit rafraichis à 60Hz
 * @see BoucleTemporelle
 */
public class GenerateurTick extends Sujet implements Runnable {

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
     * Il lance en interne un nouveau thread (threadInterne), permettant de mettre en place les ticks
     * @see GenerateurTick#threadInterne
     */
    public GenerateurTick() {
        this.threadInterne = new Thread(this);
        threadInterne.start();
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
                Thread.sleep(16); // on veut un jeu a 60Hz, on permet un check des events toutes les 1/60 de secondes
                super.notifier(); // on notifie qu'un tick de 16ms est passé
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public boolean interrompreGenerateur() {
        if(threadInterne != null) {
            threadInterne.interrupt();
            return true;
        }
        return false;
    }

    public void reprendreGenerateur() {
        // on s'assure que le generateur est bien interrompu
        interrompreGenerateur();
        // on recréé un nouveau thread
        threadInterne = new Thread(this);
        threadInterne.start();
    }
}
