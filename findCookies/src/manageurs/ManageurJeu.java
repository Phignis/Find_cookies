package manageurs;

import javafx.scene.canvas.Canvas;
import objets.niveaux.graphiques.PersonnageGraphique;
import objets.niveaux.metiers.deplacables.Personnage;
import temps.GenerateurTick;

public class ManageurJeu {
    private ManageurNiveau manageurNiveau;
    private GenerateurTick generateurTick;
    private ManageurDessinateur manageurDessinateur;
    private ManagerDeplaceurJoueur managerDeplaceurJoueur;

    private Canvas canvas;
    private PersonnageGraphique personnage;

    public ManageurJeu(Canvas canvas) throws Exception {
        if(canvas == null){ throw new IllegalArgumentException("Le canvas ne peut pas être nul"); }
        this.canvas = canvas;

        generateurTick = new GenerateurTick(32);
    }

    /**
     * Permet de charger le niveau et d'en afficher son graphisme
     * @param numNiveau Index du niveau à charger parmi la liste des niveaux
     * @return vrai si le niveau a bien été chargé ; faux sinon
     */
    public boolean chargerNiveau(int numNiveau){
        try {
            manageurNiveau = new ManageurNiveau(numNiveau);

            personnage = new PersonnageGraphique(2,2, new Personnage());
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
