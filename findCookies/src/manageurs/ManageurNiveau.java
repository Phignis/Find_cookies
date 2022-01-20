package manageurs;

import controleurs.DeplaceurControleur;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class ManageurNiveau {
    private Canvas canvas;
    public Canvas getCanvas(){ return canvas; }

    private Image image;
    public Image getImage(){ return image; }

    private DeplaceurControleur deplaceur;
    public DeplaceurControleur getDeplaceur(){ return deplaceur; }

    public ManageurNiveau(Canvas canvas, Image img, DeplaceurControleur deplaceur){
        this.canvas = canvas;
        image = img;
        this.deplaceur = deplaceur;
    }


}
