import java.util.LinkedList;

public abstract class Sujet {

        public LinkedList<Observateur> observateurs;


        ////////////////////////////////
        // CONSTRUCTEURS
        ////////////////////////////////

        public Sujet() {
                observateurs = new LinkedList<>(observateurs);
        }

        public Sujet(LinkedList<Observateur> observateurs) {
                this.observateurs = observateurs;
        }


        ////////////////////////////////
        // SETTERS
        ////////////////////////////////

        public boolean attacherObservateur(Observateur ajout) {
                return observateurs.add(ajout);
        }

        public boolean detacherObservateur(Observateur suppression) {
                return observateurs.remove(suppression);
        }

        public void notifier() {
                for (Observateur o: observateurs ) {
                        o.update();
                }
        }
}
