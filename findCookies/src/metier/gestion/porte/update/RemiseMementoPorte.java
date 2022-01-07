package metier.gestion.porte.update;

import metier.objets.Porte;

public class RemiseMementoPorte implements ActionPorte {

    private Porte porteARemettreAuMemento;

    public RemiseMementoPorte(Porte porteARemettreAuMemento) {
        this.porteARemettreAuMemento = porteARemettreAuMemento;
    }

    @Override
    public void doAction() {
        porteARemettreAuMemento.setEstOuverte(false);
    }
}
