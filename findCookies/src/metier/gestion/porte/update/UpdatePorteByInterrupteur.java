package metier.gestion.porte.update;

import metier.Interrupteur;
import metier.Porte;
import utile.observateur.Sujet;

/**
 * UpdatePorteByInterrupteur est un des types de maillon de la structure de donnée.
 * Son but est de déterminer et de générer l'action d'update de Porte déclanché par Interrupteur,
 * avec la méthode gererUpdatePorte(Class)
 * @see GestionnaireUpdatePorte
 * @see Porte
 * @see Interrupteur
 * @see <a href="http://goprod.bouhours.net/?page=pattern&pat_id=5">Patron Chaine de responsabilitée</a>
 */
public class UpdatePorteByInterrupteur extends GestionnaireUpdatePorte {

    /**
     * Constructeur de UpdatePorteByInterrupteur, générant une instance avec le successeur a null (fin de la liste)
     * @param porteAGerer porte sur laquelle on effectue l'action d'update
     * @see GestionnaireUpdatePorte#gererUpdatePorte(Class)
     */
    public UpdatePorteByInterrupteur(Porte porteAGerer) {
        super(porteAGerer);
    }


    /**
     * permet de générer l'action d'update de la porte a gérer, si jamais c'est un Interrupteur qui a notifié, ou délègue
     * la responsabilitée de générer cette action a son successeur si possible et si le notificateur n'est pas un Interrupteur.
     * @param c classe du sujet ayant notifié la porte à gérer, dont dépend l'action à effectuer
     * @see GestionnaireUpdatePorte#porteAGerer
     * @see Interrupteur#notifier()
     */
    @Override
    public void gererUpdatePorte(Class<? extends Sujet> c) {
        // action par un interrupteur
        Interrupteur actionneurPorte;
        if(c.getName() == Interrupteur.class.getName() && (actionneurPorte = porteAGerer.getActionneur()) != null) {
            // on fait alors l'action, car on a bien un actionneurPorte
            porteAGerer.setEstOuverte(actionneurPorte.isEstActive());
        } else if(successeur != null && c.getName() != Interrupteur.class.getName()) {
            // sinon on délègue au prochain la responsabilitée
            successeur.gererUpdatePorte(c);
        }
        // sinon on ne fait rien
    }
}
