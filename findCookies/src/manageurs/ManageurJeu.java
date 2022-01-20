package manageurs;

import javafx.scene.canvas.Canvas;
import objets.niveaux.graphiques.ObjetGraphique;
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

    private  Canvas canvas;
    private ObjetGraphique personnage;

    public ManageurJeu(Canvas canvas) throws Exception {
       this.canvas = canvas;

        generateurTick = new GenerateurTick();
       // generateurMouvement = new GenerateurMouvement(canvas);
       //// generateurTick.attacher(generateurMouvement);
    }

    public boolean chargerNiveau(int numNiveau){
        try {
            manageurNiveau = new ManageurNiveau(numNiveau);

            personnage = new PersonnageGraphique(8,3, new Personnage());

            manageurDessinateur = new ManageurDessinateur(canvas, personnage, manageurNiveau.getNiveau());
            generateurTick.attacher(manageurDessinateur);

            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
}
