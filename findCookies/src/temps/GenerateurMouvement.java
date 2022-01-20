package temps;

import controleurs.DeplaceurControleur;
import javafx.scene.canvas.Canvas;
import objets.niveaux.graphiques.PersonnageGraphique;
import objets.niveaux.metiers.Porte;
import objets.niveaux.metiers.deplacables.Personnage;
import utile.Dessinateur;
import observateurs.Observateur;
import observateurs.Sujet;
import observateurs.SujetObservableUneFois;
import objets.niveaux.graphiques.ObjetGraphique;
import objets.niveaux.graphiques.PorteGraphique;

public class GenerateurMouvement extends SujetObservableUneFois implements Observateur {
    private Dessinateur dessinateur;
    private ObjetGraphique og;

    private int a = 0;
    private int b = 0;

    private DeplaceurControleur dc;
    private PersonnageGraphique pg;

    public GenerateurMouvement(Canvas canvas) throws Exception {
        if(canvas == null){ throw new IllegalArgumentException("Le canvas ne peut pas être nul."); }
        pg = new PersonnageGraphique(a, b, new Personnage());
        dc = new DeplaceurControleur(pg, canvas.getScene());

        dessinateur = new Dessinateur(canvas);
        dessinateur.dessinerSurUneCase(new PorteGraphique(5, 5, new Porte()));
        this.dessinateur = dessinateur;
    }

    @Override
    public void update(Sujet notificateur) {
        if(notificateur instanceof GenerateurTick) {
           // System.out.println(a);
            //if( instanceof ObjetGraphiqueDeplacable) {
            try {
                dc.lireEntrees();
             //   System.out.println(pg.getPosX());
            } catch (Exception e) {
                e.printStackTrace();
            }
            //  }
            /*
            if(dessinateur.getObjetGraphique() instanceof ObjetGraphiqueDeplacable) {
                notifier();
                ((ObjetGraphiqueDeplacable) dessinateur.getObjetGraphique()).setPosX(a);
                ((ObjetGraphiqueDeplacable) dessinateur.getObjetGraphique()).setPosY(b);
                dessinateur.dessiner(((ObjetGraphiqueDeplacable) dessinateur.getObjetGraphique()));
                a++;
                b++;
                System.out.println(a);
            }

             */
            a++;
            b++;
          //  System.out.println(a);
        }

    }
}
