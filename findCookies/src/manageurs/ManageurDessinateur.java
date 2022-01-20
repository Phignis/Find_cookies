package manageurs;

import javafx.scene.canvas.Canvas;
import objets.niveaux.Niveau;
import objets.niveaux.graphiques.ObjetGraphique;
import objets.niveaux.graphiques.ObjetGraphiqueDeplacable;
import objets.niveaux.metiers.deplacables.Caisse;
import objets.niveaux.metiers.deplacables.Personnage;
import observateurs.Observateur;
import observateurs.Sujet;
import utile.Dessinateur;

import java.util.*;


public class ManageurDessinateur implements Observateur {
    private Dessinateur dessinateur;

    private ObjetGraphique personnage;
    public void setPersonnage(ObjetGraphique personnage){
        this.personnage = personnage;
    }

    private Niveau niveau;
    public void setNiveau(Niveau niveau){
        this.niveau = niveau;
    }

    public ManageurDessinateur(Canvas canvas, ObjetGraphique personnage, Niveau niveau) throws IllegalArgumentException{
        if(canvas == null) { throw new IllegalArgumentException("Le canvas ne peut pas être nul."); }
        dessinateur = new Dessinateur(canvas);
        setPersonnage(personnage);
        setNiveau(niveau);
    }

    public void dessinerPersonnage(){
        if(personnage == null) { return; }
        dessinateur.dessiner(personnage);
    }

    public void dessinerNiveau(){
        if(niveau == null) { return; }
        int i;
        for (i = 0; i<niveau.getListeCouches().size(); i++){ //pour chaque couche
            for (ObjetGraphique og : niveau.getListeCouches().get(i).getListeObjets()) {
                //pour chaque objet graphique de la liste de chaque couche...
                dessinateur.dessiner(og); //...on le dessine
            }
        }
    }

    @Override
    public void update(Sujet notificateur) {
        dessinerNiveau();
        dessinerPersonnage();
    }
}
