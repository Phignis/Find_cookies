package controleurs;

import utile.Vecteur2D;
import validation.Collisionneur;
import vueNiveau.objets.ObjetGraphiqueDeplacable;

public class DeplacementControleur {
    public DeplacementControleur(){

    }

    public void deplacement(Vecteur2D vecteurFinal, ObjetGraphiqueDeplacable ogd){
        if(ogd == null) throw new IllegalArgumentException("L'objet graphique déplaçable ne peut pas être nul");

        //s'il n'y a pas de collision :
       // if(Collisionneur.isEnCollision(ogd, )){

        // }

        //normaliser la direction
        Vecteur2D vecteurNormalise = vecteurFinal.normaliser();

        //calculer le mouvement
        Vecteur2D mouvement = vecteurNormalise.multiplier(ogd.getDeplacable().getVitesse());

        //calculer la nouvelle position
        Vecteur2D nouvellePos = ogd.getDeplacable().getPosition().additionner(mouvement);

        //appliquer le mouvement
        ogd.setPosX(vecteurFinal.getX());
        ogd.setPosY(vecteurFinal.getY());
    }
}
