package controleurs;

import javafx.scene.Scene;
import utile.Vecteur2D;
import objets.niveaux.graphiques.ObjetGraphiqueDeplacable;

public class DeplaceurControleur {
    private final ObjetGraphiqueDeplacable ogd;
    private final Scene scene;
    private int newPosX = 0;
    private int newPosY = 0;

    public DeplaceurControleur(ObjetGraphiqueDeplacable ogd, Scene scene){
        if(ogd == null) throw new IllegalArgumentException("L'objet graphique déplaçable ne peut pas être nul.");
        if(scene == null) throw new IllegalArgumentException("La scene ne peut pas être nulle.");

        this.ogd = ogd;
        this.scene = scene;

        initListeners();
    }

    private void deplacementX(int deplacementX) {
        newPosX = Math.max(-1, Math.min(1, newPosX + deplacementX));
    }
    private void deplacementY(int deplacementY) {
        newPosY = Math.max(-1, Math.min(1, newPosY + deplacementY));
    }

    private void deplacement(Vecteur2D vecteurFinal, ObjetGraphiqueDeplacable ogd){
        if(ogd == null) throw new IllegalArgumentException("L'objet graphique déplaçable ne peut pas être nul.");
        if(vecteurFinal == null) throw new IllegalArgumentException("La scene ne peut pas être nulle.");

        //s'il n'y a pas de collision :
       // if(Collisionneur.isEnCollision(ogd, )){

        // }

        //normaliser la direction
        Vecteur2D vecteurNormalise = vecteurFinal.normaliser();

        //calculer le mouvement
        Vecteur2D mouvement = vecteurNormalise.multiplier(ogd.getObjetMetier().getVitesse());

        //calculer la nouvelle position
        Vecteur2D posActuelle = new Vecteur2D(ogd.getPosX(), ogd.getPosY());
        Vecteur2D nouvellePos = posActuelle.additionner(mouvement);

        //appliquer le mouvement
        ogd.setPosX(vecteurFinal.getX());
        ogd.setPosY(vecteurFinal.getY());
    }

    private void initListeners() {
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case Q -> deplacementX(-1);
                case D -> deplacementX(1);

                case Z -> deplacementY(-1);
                case S -> deplacementY(1);
            }
        });

        scene.setOnKeyReleased(e -> {
            switch (e.getCode()) {
                case Q -> deplacementX(1);
                case D -> deplacementX(-1);

                case Z -> deplacementY(1);
                case S -> deplacementY(-1);
            }
        });
    }

    public void lireEntrees() {
        if(newPosX != 0 || newPosY != 0) {
            //entityMover.move(player, new Vector2(posX, posY));
            deplacement(new Vecteur2D(newPosX, newPosY), ogd);
        }
    }
}
