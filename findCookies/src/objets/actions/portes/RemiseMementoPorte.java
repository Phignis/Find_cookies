package objets.actions.portes;

import objets.niveaux.metiers.Porte;

/**
 * Cette classe a pour but que l'état d'une porte se remette a celui d'un memento précedent
 * @see ActionPorte
 * @see Porte
 * @see clock.BoucleTemporelle
 */
public class RemiseMementoPorte implements ActionPorte {

    /**
     * porte à remettre au memento, utile nottament pour la boycle temporelle
     */
    private Porte porteARemettreAuMemento;

    /**
     * Instancie un RemiseMementoPorte, avec une porte à remettre a un memento, avec doAction()
     * @param porteARemettreAuMemento porte a remettre au memento
     * @see SynchroPorteInterrupteur#doAction()
     */
    public RemiseMementoPorte(Porte porteARemettreAuMemento) {
        this.porteARemettreAuMemento = porteARemettreAuMemento;
    }

    /**
     * A pour effet de remettre la porte sur l'état d'un mémento
     */
    @Override
    public void doAction() {
        porteARemettreAuMemento.setEstOuverte(false);
    }
}
