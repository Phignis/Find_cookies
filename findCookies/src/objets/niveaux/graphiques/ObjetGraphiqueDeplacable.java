package objets.niveaux.graphiques;

import objets.niveaux.metiers.ObjetMetier;
import objets.niveaux.metiers.deplacables.Deplacable;

public abstract class ObjetGraphiqueDeplacable extends ObjetGraphique {
    /**
     * Objet métier associé au graphique
     */
    private Deplacable deplacable;

    public ObjetGraphiqueDeplacable(String cheminImage, float posX, float posY, Deplacable deplacable) throws Exception {
        super(cheminImage, posX, posY);
        this.deplacable = deplacable;
    }

    /**
     * Modifier la position sur l'axe des abscisses
     * @param posX
     */
    public void setPosX(float posX){
        super.vecteur2D.setX(posX);
    }

    /**
     * Modifier la position sur l'axe des ordonnées
     * @param posY
     */
    public void setPosY(float posY){
        super.vecteur2D.setY(posY);
    }

    /**
     * Récupérer l'Objet métier sous-jacent
     * @return l'objet métier déplaçable associé
     */
    @Override
    public Deplacable getObjetMetier() {
        return deplacable;
    }
}
