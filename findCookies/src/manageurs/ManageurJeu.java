package manageurs;

import javafx.scene.canvas.Canvas;
import objets.niveaux.graphiques.ObjetGraphique;
import objets.niveaux.graphiques.ObjetGraphiqueDeplacable;
import objets.niveaux.graphiques.PersonnageGraphique;
import objets.niveaux.metiers.deplacables.Personnage;
import temps.GenerateurMouvement;
import temps.GenerateurTick;
import utile.Dessinateur;
import utile.InstanciateurNiveau;

public class ManageurJeu {
    private ManageurNiveau manageurNiveau;
    private GenerateurTick generateurTick;
   // private GenerateurMouvement generateurMouvement;
    private ManageurDessinateur manageurDessinateur;
    private ManagerDeplaceurJoueur managerDeplaceurJoueur;

    private  Canvas canvas;
    private PersonnageGraphique personnage;

    public ManageurJeu(Canvas canvas) throws Exception {
       this.canvas = canvas;

        generateurTick = new GenerateurTick(32);
       // generateurMouvement = new GenerateurMouvement(canvas);
       //// generateurTick.attacher(generateurMouvement);
    }

    public boolean chargerNiveau(int numNiveau){
        try {
            manageurNiveau = new ManageurNiveau(numNiveau);

            personnage = new PersonnageGraphique(8,3, new Personnage());
            managerDeplaceurJoueur = new ManagerDeplaceurJoueur(personnage, canvas.getScene());

            manageurDessinateur = new ManageurDessinateur(canvas, personnage, manageurNiveau.getNiveau());

            generateurTick.attacher(manageurDessinateur);
            generateurTick.attacher(managerDeplaceurJoueur);

            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
}
