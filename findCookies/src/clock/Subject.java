package clock;

import java.util.LinkedList;

public abstract class Subject {
    private LinkedList<Observateur> observateurs;

    public Subject() {
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
