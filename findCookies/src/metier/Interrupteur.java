package metier;

import utile.observateur.Observateur;
import utile.observateur.Sujet;

import java.util.ArrayList;
import java.util.List;

public class Interrupteur extends Objet implements Sujet {

    private boolean estActive;
    private List<Observateur> observateurs;


    ////////////////////////////////
    // CONSTRUCTEUR
    ////////////////////////////////

    public Interrupteur(String image, int posX, int posY) {
        super(image, posX, posY);
        estActive = false;
        observateurs = new ArrayList<>();
    }


    ////////////////////////////////
    // GETTERS
    ////////////////////////////////

    public boolean isEstActive() {
        return estActive;
    }


    ////////////////////////////////
    // METHODES
    ////////////////////////////////

    @Override
    public boolean attacher(Observateur o) {
        if(o == null) return false;

        for (Observateur dejaAbonne : observateurs) {
            if(o == dejaAbonne) return false;
        }

        return observateurs.add(o);
    }

    @Override
    public boolean detacher(Observateur o) {
        return observateurs.remove(o);
    }

    @Override
    public void notifier() {
        for (Observateur o : observateurs) {
            o.update(getClass());
        }
    }
}
