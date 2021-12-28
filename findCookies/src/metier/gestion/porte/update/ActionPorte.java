package metier.gestion.porte.update;

import utile.observateur.Sujet;

/**
 * Cette interface a pour but d'effectuer une action sur Porte
 * @see metier.Porte
 */
public interface ActionPorte {
    /**
     * algorithme a effectuer sur la Porte
     * @see utile.observateur.Observateur#update(Sujet)
     */
    void doAction();
}