package objets.actions.portes;

import objets.niveaux.metiers.Porte;
import observateurs.Sujet;

/**
 * Cette interface a pour but d'effectuer une action sur Porte
 * @see Porte
 */
public interface ActionPorte {
    /**
     * algorithme a effectuer sur la Porte
     * @see observateurs.Observateur#update(Sujet)
     */
    void doAction();
}
