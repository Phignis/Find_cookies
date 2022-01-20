package objets.niveaux.graphiques;

import objets.niveaux.metiers.ObjetMetier;
import objets.niveaux.metiers.Porte;

public class PorteGraphique extends ObjetGraphique {

    private Porte porte;

    public PorteGraphique(float posX, float posY, Porte metier) throws Exception {
        super("porte_face.svg", posX, posY);
        porte = metier;
    }

    public PorteGraphique(PorteGraphique p) throws Exception {
        super(p);
        porte = new Porte(p.porte);
    }


    @Override
    public ObjetMetier getObjetMetier() {
        return porte;
    }
}
