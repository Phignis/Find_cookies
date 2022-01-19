package temps;

import javafx.scene.canvas.Canvas;
import objets.niveaux.metiers.Porte;
import utile.Dessinateur;
import observateurs.Observateur;
import observateurs.Sujet;
import observateurs.SujetObservableUneFois;
import objets.niveaux.graphiques.ObjetGraphique;
import objets.niveaux.graphiques.ObjetGraphiqueDeplacable;
import objets.niveaux.graphiques.PorteGraphique;

public class GenerateurMouvement extends SujetObservableUneFois implements Observateur {

    private Dessinateur dessinateur;
    private ObjetGraphique og;

    private int a = 0;
    private int b = 0;

    public GenerateurMouvement(Canvas canvas) throws Exception {
        dessinateur = new Dessinateur(canvas);
        dessinateur.dessiner(new PorteGraphique(5, 5, new Porte()));
        this.dessinateur = dessinateur;
    }

    /*
    public GenerateurMouvement(Dessinateur dessinateur, ObjetGraphique og){
        if(dessinateur == null){ throw new IllegalArgumentException("Le dessinateur ne peut pas être nul."); }
        if(og == null){ throw new IllegalArgumentException("L'objet graphique ne peut pas être nul."); }
        this.dessinateur = dessinateur;
        this.og = og;
    }
     */

    @Override
    public void update(Sujet notificateur) {
        // update par GenerateurTick
        /*
        if(notificateur instanceof GenerateurTick) {
            GraphicsContext gc = creationNiveau.getCanvas().getGraphicsContext2D();

            creationNiveau.getDeplacement().readInputAndMovePlayer();

            gc.clearRect(0, 0, creationNiveau.getCanvas().getWidth(), creationNiveau.getCanvas().getHeight());
            gc.drawImage(creationNiveau..playerImage,
                    gameManager.player.getPosition().getX(),
                    gameManager.player.getPosition().getY(),
                    50,
                    50);

        }*/

        /*
        if(notificateur instanceof GenerateurTick) {
           // System.out.println(a);
            if(dessinateur.getObjetGraphique() instanceof ObjetGraphiqueDeplacable) {
                notifier();
                ((ObjetGraphiqueDeplacable) dessinateur.getObjetGraphique()).setPosX(a);
                ((ObjetGraphiqueDeplacable) dessinateur.getObjetGraphique()).setPosY(b);
                dessinateur.dessiner(((ObjetGraphiqueDeplacable) dessinateur.getObjetGraphique()));
                a++;
                b++;
                System.out.println(a);
            }
        }

*/

    }
}
