public class Niveau {


    private int numeroNiveau;

    // scène possédée par le niveau
    private Scene scene;


    ////////////////////////////////
    // CONSTRUCTEURS
    ////////////////////////////////

    public Niveau(int numeroNiveau) {
        this.numeroNiveau = numeroNiveau;
        this.scene = null;
    }

    public Niveau(int numeroNiveau, Scene scene) {
        this.numeroNiveau = numeroNiveau;
        this.scene = scene;
    }


    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    public int getNumeroNiveau() {
        return numeroNiveau;
    }

    public Scene getScene() {
        return scene;
    }

    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public void setNumeroNiveau(int numeroNiveau) {
        this.numeroNiveau = numeroNiveau;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }


    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    @Override
    public String toString() {
        return "\nNiveau numero " + numeroNiveau +
                ", scene:\n" + scene +
                '\n';
    }
}
