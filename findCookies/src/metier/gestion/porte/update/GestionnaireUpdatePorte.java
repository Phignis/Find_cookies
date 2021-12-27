package metier.gestion.porte.update;

import metier.Porte;
import utile.observateur.Observateur;
import utile.observateur.Sujet;
import utile.observateur.SujetObservableUneFois;

/**
 * GestionnaireUpdatePorte est la couche d'abstraction du patron comportemental "Chaine de responsabilitée", appliqué ici à Porte.
 * Il permet de mettre en place une structure de donnée s'apparentant à une liste simplement chainée, chaque GestionnaireUpdatePorte
 * connaissant son successeur.
 * Son but est de déterminer et de générer une action de Porte selon un contexte, avec la méthode gererUpdatePorte(Class)
 * @see Porte
 * @see <a href="http://goprod.bouhours.net/?page=pattern&pat_id=5">Patron Chaine de responsabilitée</a>
 */
public abstract class GestionnaireUpdatePorte {

    /**
     * la Porte sur laquelle on effectue l'action d'update
     * @see GestionnaireUpdatePorte#gererUpdatePorte(Class)
     */
    protected Porte porteAGerer;

    /**
     * Successeur, servant a générer une autre action d'update
     */
    protected GestionnaireUpdatePorte successeur;

    /**
     * Constructeur de GestionnaireUpdatePorte, générant une instance avec le successeur a null (fin de la liste)
     * @param porteAGerer porte sur laquelle on effectue l'action d'update
     * @see GestionnaireUpdatePorte#gererUpdatePorte(Class)
     */
    public GestionnaireUpdatePorte(Porte porteAGerer) {
        this.porteAGerer = porteAGerer;
        this.successeur = null;
    }

    public GestionnaireUpdatePorte getSuccesseur() {
        return successeur;
    }

    public void setSuccesseur(GestionnaireUpdatePorte successeur) {
        this.successeur = successeur;
    }

    public boolean isTypeGestionnairePresent(Class c) {
        if(getClass().getName() == c.getName()) {
            // dans ce cas, le type est présent, on renvoie true
            return true;
        } else if(successeur != null) {
            return successeur.isTypeGestionnairePresent(c);
        }

        return false;
    }

    /**
     * permet de générer l'action d'update de la porte a gérer, dépendant du type contenu dérivant de Observateur dans la Class.
     * @param c classe du sujet ayant notifié la porte à gérer, dont dépend l'action à effectuer
     * @see Observateur
     * @see GestionnaireUpdatePorte#porteAGerer
     */
    public abstract void gererUpdatePorte(Class<? extends Sujet> c);
}
