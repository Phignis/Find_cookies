package manageurs;

import javafx.scene.Scene;
import objets.niveaux.graphiques.ObjetGraphiqueDeplacable;
import observateurs.Observateur;
import observateurs.Sujet;
import utile.Vecteur2D;

public class ManagerDeplaceurJoueur implements Observateur {
    private final ObjetGraphiqueDeplacable objetGraphiqueDeplacable;
    private final Scene scene;
    private float newPosX = 0;
    private float newPosY = 0;

    public ManagerDeplaceurJoueur(ObjetGraphiqueDeplacable objetGraphiqueDeplacable, Scene scene) throws IllegalArgumentException{
        if(objetGraphiqueDeplacable == null) throw new IllegalArgumentException("L'objet graphique déplaçable ne peut pas être nul.");
        if(scene == null) throw new IllegalArgumentException("La scene ne peut pas être nulle.");

        this.objetGraphiqueDeplacable = objetGraphiqueDeplacable;
        this.scene = scene;

        actionnerTouches();
    }

    /**
     * Calcule la nouvelle position sur l'axe des abscisses en fonction de la touche appuyée
     * @param deplacementX Ancienne position sur l'axe des abscisses calculée
     */
    private void deplacementX(float deplacementX) {
        newPosX = Math.max(-1, Math.min(1, newPosX + deplacementX));
    }

    /**
     * Calcule la nouvelle position sur l'axe des ordonnées en fonction de la touche appuyée
     * @param deplacementY Ancienne position sur l'axe des ordonnées calculée
     */
    private void deplacementY(float deplacementY) {
        newPosY = Math.max(-1, Math.min(1, newPosY + deplacementY));
    }

    /**
     * Constructeur permettant à l'objet graphique déplaçable de changer ses positions afin de le déplacer
     * @param vecteurFinal Positions finales sur les axes des ordonnées et des abscisses
     * @param objetGraphiqueDeplacable Objet graphique à déplacer
     */
    private void deplacement(Vecteur2D vecteurFinal, ObjetGraphiqueDeplacable objetGraphiqueDeplacable){
        if(objetGraphiqueDeplacable == null) throw new IllegalArgumentException("L'objet graphique déplaçable ne peut pas être nul.");
        if(vecteurFinal == null) throw new IllegalArgumentException("Le vecteur ne peut pas être nul.");

        //s'il n'y a pas de collision :
       // if(Collisionneur.isEnCollision(ogd, )){

        // }

        //normaliser la direction
        Vecteur2D vecteurNormalise = vecteurFinal.normaliser();

        //calculer le mouvement
        Vecteur2D mouvement = vecteurNormalise.multiplier(objetGraphiqueDeplacable.getObjetMetier().getVitesse());

        //calculer la nouvelle position
        Vecteur2D posActuelle = new Vecteur2D(objetGraphiqueDeplacable.getPosX(), objetGraphiqueDeplacable.getPosY());
        Vecteur2D nouvellePos = posActuelle.additionner(mouvement);

        //appliquer le mouvement
        objetGraphiqueDeplacable.setPosX(nouvellePos.getX()); // vecteurFinal.getX()
        objetGraphiqueDeplacable.setPosY(nouvellePos.getY()); //vecteurFinal.getY()
    }

    /**
     * Action de presser ou relâcher une touche (Z, Q, S, ou D) pour modifier la position de l'objet graphique à déplacer
     */
    private void actionnerTouches() {
        scene.setOnKeyPressed(e -> { //appuie
            switch (e.getCode()) {
                case Q -> deplacementX(-1);
                case D -> deplacementX(1);

                case Z -> deplacementY(-1);
                case S -> deplacementY(1);
            }
        });

        scene.setOnKeyReleased(e -> { //relâche
            switch (e.getCode()) {
                case Q -> deplacementX(1);
                case D -> deplacementX(-1);

                case Z -> deplacementY(1);
                case S -> deplacementY(-1);
            }
        });
    }

    /**
     * Déplace l'objet graphique si les positions ont changé
     */
    public void lireEntrees() {
        if(objetGraphiqueDeplacable == null) return;
        if(newPosX != 0 || newPosY != 0) {
            deplacement(new Vecteur2D(newPosX, newPosY), objetGraphiqueDeplacable);
        }
    }

    @Override
    public void mettreAJour(Sujet notificateur) {
        lireEntrees();
    }
}
