package clock;

public class Observateur {

    private String nomObservateur;

    public Observateur(String nomObservateur) {
        this.nomObservateur = nomObservateur;
    }

    public void update() {
        System.out.println(this + " : La boucle est terminée!");
    }

    @Override
    public String toString() {
        return "Observateur{" +
                "nomObservateur='" + nomObservateur + '\'' +
                '}';
    }
}
