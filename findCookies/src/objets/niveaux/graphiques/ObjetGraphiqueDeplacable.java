package objets.niveaux.graphiques;

import objets.niveaux.metiers.deplacables.Deplacable;
import observateurs.Observateur;
import observateurs.Sujet;
import observateurs.SujetRelaisUniqueObservation;

public abstract class ObjetGraphiqueDeplacable extends ObjetGraphique implements Sujet {
    /**
     * Objet métier associé au graphique
     */
    private Deplacable deplacable;

    /**
     * Gère les changements en tant que Sujet (abonnement, désabonnement et notification des abonnés)
     * @see SujetRelaisUniqueObservation
     */
    private SujetRelaisUniqueObservation gestionSujet = new SujetRelaisUniqueObservation();

    public ObjetGraphiqueDeplacable(String cheminImage, float posX, float posY, Deplacable deplacable) throws Exception {
        super(cheminImage, posX, posY);
        this.deplacable = deplacable;
    }

    /**
     * Modifier la position sur l'axe des abscisses
     * Observateurs abonnés de ce changement
     * @see ObjetGraphiqueDeplacable#notifier()
     * @param posX
     */
    public void setPosX(float posX){
        super.vecteur2D.setX(posX);
        notifier();
    }

    /**
     * Modifier la position sur l'axe des ordonnées
     * Observateurs abonnés de ce changement
     * @see ObjetGraphiqueDeplacable#notifier()
     * @param posY
     */
    public void setPosY(float posY){
        super.vecteur2D.setY(posY);
        notifier();
    }

    /**
     * Récupérer l'Objet métier sous-jacent
     * @return l'objet métier déplaçable associé
     */
    @Override
    public Deplacable getObjetMetier() {
        return deplacable;
    }

    /**
     * Abonne un Observateur à cette instance de ObjetGraphiqueDeplacable, pour qu'il reçoive les notifications,
     * si jamais il n'est pas déjà présent
     * @param o Observateur a abonner, pour qu'il recoive les notifications
     * @return vrai si l'observateur a bien été abonné ; faux sinon (si null, ou si l'instance est déjà abonnée)
     */
    public boolean attacher(Observateur o) {
        return gestionSujet.attacher(o);
    }

    /**
     * Désabonne un Observateur à cette instance de Interrupteur, pour qu'il ne reçoive plus les notifications
     * @see ObjetGraphiqueDeplacable#notifier()
     * @param o observateur a abonner au Sujet, pour qu'il recoive les notifications
     * @return vrai si l'observateur a bien été abonné ; faux sinon
     */
    public boolean detacher(Observateur o) {
        return gestionSujet.detacher(o);
    }

    /**
     * permet de notifier tous les objets graphiques
     * @see ObjetGraphiqueDeplacable#gestionSujet
     * @see Observateur#mettreAJour(Sujet)
     */
    public void notifier() {
        gestionSujet.notifier(this);
    }
}
