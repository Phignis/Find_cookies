package utile;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import objets.niveaux.graphiques.ObjetGraphique;

import java.net.URL;

public class Dessinateur {
    private Canvas canvas;
    public Canvas getCanvas(){ return canvas; }

    private float hauteur; //700/(5+2)
    private float largeur; //1000/(10+2);

    private GraphicsContext graphiqueContext;

    public Dessinateur(Canvas canvas){
        this.canvas = canvas;
        hauteur = (float) canvas.getHeight()/ 5;
        largeur = (float) canvas.getWidth() / 10;

        graphiqueContext = canvas.getGraphicsContext2D();
    }

    /**
     * Dessine, sur un canvas, l'image d'un objet métier aux positions qui lui sont attribuées.
     */
    public void dessinerSurUneCase(ObjetGraphique og){
        graphiqueContext.drawImage(og.getImage(), (og.getPosX() ) * largeur, (og.getPosY() ) * hauteur, largeur, hauteur);
    }

    /**
     * Dessine un objet graphique de la taille attribuée
     * @param og
     */
    public void dessinerLibre(ObjetGraphique og){
        graphiqueContext.drawImage(og.getImage(), og.getPosX(), og.getPosY(), og.getImage().getWidth() / largeur, og.getImage().getHeight() / hauteur);
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

        graphiqueContext.clearRect(anciennePosX * largeur, anciennePosY * hauteur, largeur, hauteur); //canvas.getWidth(), canvas.getHeight());
        graphiqueContext.drawImage(imgRemplacer, anciennePosX * largeur, anciennePosY * hauteur, largeur, hauteur);
        graphiqueContext.drawImage(objAjouter.getImage(), objAjouter.getPosX() * largeur, objAjouter.getPosY() * hauteur, largeur, hauteur);
    }

}
