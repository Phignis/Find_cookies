package clock;

public class BoucleTemporelle extends Subject implements Runnable {
    // un tick = 16 ms
    private long nbTicksBoucle;
    private long nbTicksEcoule;
    private final Thread threadInterne;


    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public BoucleTemporelle(long nbSecondesBoucle) {
        this.nbTicksBoucle = (nbSecondesBoucle * 1000 / 16); // conversion des secondes en tick de 16ms
        nbTicksEcoule = 0;
        threadInterne = new Thread(this);
        threadInterne.start();
    }

    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public void setTempsTotalBoucle(long nbSecondesBoucle) {
        this.nbTicksBoucle = (nbSecondesBoucle * 1000 / 16);
    }

    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    private boolean estBoucleTermine() {
        return nbTicksBoucle == nbTicksEcoule;
    }

    private void eventFinDeBoucle() {
        if (estBoucleTermine()) {
            super.notifier();
            nbTicksEcoule = 0;
        }
    }

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

            eventFinDeBoucle();
        }
    }
}
