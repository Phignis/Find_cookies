# Explications du diagramme de classes

Le diagramme de classe se trouve (ici)[./diagrammeClasses.mdj].


# controleurs et navigation
> Chaque visuel est au moins en partie déclaré dans un fichier FXML, auquel est lié un controleur du package controleur.
> Ce controleur possède toutes les méthodes d'évènements des éléments du fxml (clickAccueil).
> Chacun de ces controleurs, pour changer de vue (souvent par un évènement de bouton), passe par la classe NavigateurVue, qui change la scène courante pour celle demandée en paramètre de changerScene.
> Cependant, ListeNiveauxControleur ne passe pas par NavigateurVue pour changer de vue, et le fait de lui meme, pour pouvoir instancier un NiveauControleur avec un constructeur possédant des arguments.
> Le deplaceurControlleur gestionne tant qu'a lui toute requete de mouvement, en déléguant a d'autres classes la responsabilitée de vérifier si le déplacement est possible, et de déplacer.
>


# observateurs
>
> Ce package contient toutes les couches d'abstractions du patron (Observateur)[http://goprod.bouhours.net/?page=pattern&pat_id=16].
> Observateur et Sujet sont des interfaces. Pour sujet, il a été préféré une interface aussi, bien que du code soit factorisable a ce niveau, car certains objets en héritant,
> tel Interrupteur (cf le package objet/metier), dérive déjà d'une classe abstraite. Comme l'extension multiple n'existe pas en Java, Sujet devient une interface,
> afin de promettre a toute implémentation la définition des méthodes de Sujet.
>
> SujetObservableUneFois est une implémentation abstraite de Sujet. Outre le fait de définir les méthodes, et d'ajouter une liste d'observables abonnés, cette 
> couche abstraite a pour effet de garentir l'unicité des instances des Observateurs observant une de ses implémentations, sans passer par un set, qui forcerait
> tout observateurs a ne pas redéfinir le equals et garder celui de Object (comparaison de l'adresse mémoire), trop restreignant.
> 
> SujetRelaisUniqueObservation a pour but d'avoir le meme comportement que SujetObservableUneFois, a ceci près qu'il est pensé pour être possédé en attribut, plutot
> que par extension. Cette classe est nottament utilisée pour Interrupteur, qui étends déjà d'une autre classe. Interrupteur possède donc en attribut un SujetRelaisUniqueObservation,
> qui abonne, désabonne et notifie sous l'instance de Interrupteur.


# temps
>
> Ce package contient toutes les classes relatives aux ticks de l'application. GenerateurTick génère les ticks servant a observer à intervalle régulières 
> et update le visuel.
>
> BoucleTemporelle permet de définir la boucle temporelle. Elle se base sur un certain nombre de ticks de GenerateurTick, en l'observant via le patron Observateur,
> et notifie à la fin de la boucle tout les objets devant se remettre dans l'état de début de boucle, car est aussi un Sujet.
>

# objets
>
>
>
> #### metiers
> > 
>
> #### actions/portes
> >
> > Ce package référence toutes les actions possibles pour une Porte, sur une notification d'un sujet (méthode update de Porte). Le soucis était que l'on ne
> > peut prévoir à l'avance qui notifiera précisément Porte (BoucleTemporelle ou Interrupteur). Pour ce faire, chaque instance auquel s'abonne Porte est enregistré,
> > avec une instance dérivant de ActionPorte.
> > Ainsi, l'action est connue. Cela permet de plus de ne pas faire la même action pour une meme classe de Sujet, même si cela n'est pas exploité ici.
> > Une chaine de responsabilitée aurait pu etre mise en place en remplacement, mais cela aurait obligé de passer plusieurs instances de gestion de l'update,
> > si jamais la gestion gérant la classe ou instance notifiante n'est pas en début de la chaine.
> >
> > ActionPorte est une interface, déclarant une méthode doAction, qui correspond à l'action d'update à faire.
> > Chaque implémentation de ActionPorte devrait connaitre la porte sur laquelle faire l'action.
> > 
> > RemiseMementoPorte permet de remettre la porte au memento, plus précisément a un état enregistré au préalable. Il arrive surtout normalement lorsque la boucle temporelle
> > est terminée.
> >
> > SynchroPorteMemento a pour attribut un Interrupteur, en plus de la Porte. Le but de son action (appelé lorsqu'un Interrupteur notifie), est de synchroniser l'état
> > de la porte sur celui de l'interrupteur.
>
