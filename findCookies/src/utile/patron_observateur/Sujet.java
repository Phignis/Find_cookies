package utile.patron_observateur;

import java.util.LinkedList;

/**
 * Subject
 */
public abstract class Sujet {
    private LinkedList<Observateur> observateurs;

    public Sujet() {
        this.observateurs = new LinkedList<>();
    }

    public boolean attacher(Observateur o) {
        return observateurs.add(o);
    }

    public boolean detacher(Observateur o) {
        return observateurs.remove(o);
    }

    public void notifier() {
        for (Observateur o : observateurs) {
            o.update();
        }
    }
}
