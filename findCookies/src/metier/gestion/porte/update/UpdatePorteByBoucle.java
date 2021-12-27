package metier.gestion.porte.update;

import clock.BoucleTemporelle;
import metier.Porte;
import utile.observateur.Sujet;

/**
 * UpdatePorteByBoucle est un des types de maillon de la structure de donnée.
 * Son but est de déterminer et de générer l'action d'update de Porte déclanché par BoucleTemporelle,
 * avec la méthode gererUpdatePorte(Class)
 * @see GestionnaireUpdatePorte
 * @see Porte
 * @see clock.BoucleTemporelle
 * @see <a href="http://goprod.bouhours.net/?page=pattern&pat_id=5">Patron Chaine de responsabilitée</a>
 */
public class UpdatePorteByBoucle extends GestionnaireUpdatePorte {

    /**
     * Constructeur de UpdatePorteByBoucle, générant une instance avec le successeur a null (fin de la liste)
     *
     * @param porteAGerer porte sur laquelle on effectue l'action d'update
     * @see GestionnaireUpdatePorte#gererUpdatePorte(Class)
     */
    public UpdatePorteByBoucle(Porte porteAGerer) {
        super(porteAGerer);
    }

    /**
     * permet de générer l'action d'update de la porte a gérer, si jamais c'est une BoucleTemporelle qui a notifié, ou délègue
     * la responsabilitée de générer cette action a son successeur si possible et si le notificateur n'est pas une BoucleTemporelle.
     * @param c classe du sujet ayant notifié la porte à gérer, dont dépend l'action à effectuer
     * @see GestionnaireUpdatePorte#porteAGerer
     * @see clock.BoucleTemporelle#notifier()
     */
    @Override
    public void gererUpdatePorte(Class<? extends Sujet> c) {
        // action par une BoucleTemporelle
        if(c.getName() == BoucleTemporelle.class.getName()) {
            // on fait alors l'action
            porteAGerer.setEstOuverte(false);
            // dans le futur, memento est a faire

        } else if(successeur != null) { // sinon on délègue au prochain la responsabilitée
            successeur.gererUpdatePorte(c);
        }
        // sinon on ne fait rien
    }
}
