package metier.gestion.porte.update;

import metier.Interrupteur;
import metier.Porte;

import java.time.temporal.Temporal;

/**
 * Cette classe a pour but que l'état d'une porte se synchronise avec celle d'un Interrupteur
 * @see ActionPorte
 * @see Porte
 */
public class SynchroPorteInterrupteur implements ActionPorte {

    /**
     * porte à synchroniser avec l'interrupteur
     * @see SynchroPorteInterrupteur#interrupteurActionneur
     */
    private Porte porteASynchroniser;

    /**
     * interrupteur servant à synchroniser la porte sur son état
     */
    private Interrupteur interrupteurActionneur;

    /**
     * Instancie un SynchroPorteInterrupteur, avec une porte à synchroniser, avec doAction(), sur un interrupteur
     * @param porteASynchroniser porte à synchroniser sur l'interrupteur en second paramètre
     * @param interrupteurActionneur interrupteur servant à synchroniser la porte sur son état
     * @see SynchroPorteInterrupteur#doAction()
     */
    public SynchroPorteInterrupteur(Porte porteASynchroniser, Interrupteur interrupteurActionneur) {
        this.porteASynchroniser = porteASynchroniser;
        this.interrupteurActionneur = interrupteurActionneur;
    }

    /**
     * A pour effet de synchroniser la porte sur l'état de l'interrupteur.
     * Si l'interrupteur est actif (on), la porte est ouverte;
     * si l'interrupteur est inactif, la porte est fermée
     */
    @Override
    public void doAction() {
        porteASynchroniser.setEstOuverte(interrupteurActionneur.isEstActive());
    }
}
