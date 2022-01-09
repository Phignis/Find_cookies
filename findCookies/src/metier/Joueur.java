package metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vueNiveau.Niveau;

public class Joueur{ // implements Initializable {
    private StringProperty pseudo = new SimpleStringProperty();
    public final StringProperty pseudoProperty(){
        return pseudo;
    }

    private Niveau niveauAtteint;

    ////////////////////////////////
    // CONSTRUCTEUR
    ////////////////////////////////

    public Joueur(String pseudo, int niveauAtteint) {
        // this.pseudo = pseudo;
        this.pseudo.setValue(pseudo);
        this.niveauAtteint = new Niveau(niveauAtteint);
    }

    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    public final String getPseudo() {
        return pseudo.get();
    }

    public Niveau getNiveauAtteint() {
        return niveauAtteint;
    }

    ////////////////////////////////
    // SETTERS
    ////////////////////////////////

    public final void setPseudo(String pseudo) {
        this.pseudo.setValue(pseudo);
    }

    public void setNiveauAtteint(Niveau niveauAtteint) {
        this.niveauAtteint = niveauAtteint;
    }

    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    private String hashMdp(String mdp) {
        return mdp;
    }

    @Override
    public String toString() {
        return pseudo + "\t: " + niveauAtteint.getNumeroNiveau();
    }
}

