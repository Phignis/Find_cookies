package utile;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import objets.niveaux.graphiques.ObjetGraphique;

import java.net.URL;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Dessinateur {
    private Canvas canvas;
    public Canvas getCanvas(){ return canvas; }

    private float hauteurElement; //700/(5+2)
    private float largeurElement; //1000/(10+2);

    private GraphicsContext graphiqueContext;

    public Dessinateur(Canvas canvas){
        this.canvas = canvas;
        hauteurElement = (float) canvas.getHeight()/ 5;
        largeurElement = (float) canvas.getWidth() / 10;

        graphiqueContext = canvas.getGraphicsContext2D();
    }

    /**
     * Dessine, sur un canvas, l'image d'un objet métier aux positions qui lui sont attribuées.
     */
    public void dessinerSurUneCase(ObjetGraphique og){
        graphiqueContext.drawImage(og.getImage(), og.getPosX() * largeurElement, og.getPosY() * hauteurElement, largeurElement, hauteurElement);
    }

    /**
     * Dessine un objet graphique de la taille attribuée
     * @param og Objet graphique à dessiner
     */
    public void dessinerLibre(ObjetGraphique og){
        if(og == null) { return; }

        //graphiqueContext.clearRect(0,0,canvas.getWidth(), canvas.getHeight());
        //graphiqueContext.drawImage(og.getImage(), og.getPosX(), og.getPosY(), largeurImage, hauteurImage);

        graphiqueContext.drawImage(og.getImage(), og.getPosX() * largeurElement, og.getPosY() * hauteurElement, largeurElement, hauteurElement);
    }

    /**
     * Dessine un objet sur une case et remplace son ancienne position par l'image d'un autre objet graphique
     * @param anciennePosX Ancienne position du coin supérieur gauche sur l'axe des X
     * @param anciennePosY Ancienne position du coin supérieur gauche sur l'axe des Y
     * @param objAjouter Objet graphique à instancier à sa position
     * @param imgRemplacer Objet graphique par quoi remplacer objAjouter si sa position est modifiée
     */
    public void dessinerAvecSuppression(float anciennePosX, float anciennePosY, ObjetGraphique objAjouter, Image imgRemplacer ) throws Exception {
        //  creationNiveau.getDeplacement().readInputAndMovePlayer();
        if(imgRemplacer == null){
            URL ressource = getClass().getResource("/images/objet_skin/skin_par_defaut.png");
            if(ressource == null){ throw new Exception("/images/objet_skin/skin_par_defaut.png n'existe pas"); }

            imgRemplacer = new Image(ressource.toExternalForm());
        }

        graphiqueContext.clearRect(anciennePosX * largeurElement, anciennePosY * hauteurElement, largeurElement, hauteurElement); //canvas.getWidth(), canvas.getHeight());
        graphiqueContext.drawImage(imgRemplacer, anciennePosX * largeurElement, anciennePosY * hauteurElement, largeurElement, hauteurElement);
        graphiqueContext.drawImage(objAjouter.getImage(), objAjouter.getPosX() * largeurElement, objAjouter.getPosY() * hauteurElement, largeurElement, hauteurElement);
    }

}
