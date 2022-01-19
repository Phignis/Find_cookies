package objets.niveaux;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import objets.niveaux.Niveau;

public class Joueur{ // implements Initializable {
    private StringProperty pseudo = new SimpleStringProperty();
    public final StringProperty pseudoProperty(){
        return pseudo;
    }

    public final String getPseudo() {
        return pseudo.get();
    }
    public final void setPseudo(String pseudo) {
        this.pseudo.setValue(pseudo);
    }

    private Niveau niveauAtteint;
    public Niveau getNiveauAtteint() {
        return niveauAtteint;
    }
    public void setNiveauAtteint(Niveau niveauAtteint) {
        this.niveauAtteint = niveauAtteint;
    }

    ////////////////////////////////
    // CONSTRUCTEUR
    ////////////////////////////////

    public Joueur(String pseudo, int niveauAtteint) {
        this.pseudo.setValue(pseudo);
        this.niveauAtteint = new Niveau(niveauAtteint);
    }

    @Override
    public String toString() {
        return pseudo + "\t: " + niveauAtteint.getNumeroNiveau();
    }
}

