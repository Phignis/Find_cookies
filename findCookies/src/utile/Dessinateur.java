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
        //taille de 50x50par image
        hauteurElement = (float) canvas.getHeight()/ 14; //700/14 = 50
        largeurElement = (float) canvas.getWidth() / 20; //1000/20 = 50

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

        float largeurImage = (float) og.getImage().getWidth();
        float hauteurImage = (float) og.getImage().getHeight();

        graphiqueContext.drawImage(og.getImage(), og.getPosX(), og.getPosY(), largeurImage, hauteurImage);

        //graphiqueContext.drawImage(og.getImage(), og.getPosX() * largeurElement, og.getPosY() * hauteurElement, largeurElement, hauteurElement);
    }

}
