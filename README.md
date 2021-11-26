# JavaFX-2AP1

## Contexte du projet
>
> Projet de JavaFX de la seconde période du premier semestre de 2eme année de DUT.
> Projet de création d'un jeu avec une fonctionnalité visible par l'utilisateur en rapport avec une clock

## Présentation Commerciale du projet
>
> Aidez Chpatata!
> Cette pauvre petite patate douce a fait tomber sa jarre de cookies, qui se sont empréssé de s'enfuir aux quatres coins de la maison!
> Chpatata a très faim, et doit se dépêcher de récupérer le cookie qu'elle voit au loin, avant d'alerter la personne habitant de la maison avec vos bruits!
> Finissez vite le niveau, résolvez les énigmes diverses vous séparant du tant convoité cookie!
> Craignez la lumière, qui augmente d'intensité au fur et à mesure que la personne est alertée, et se rapproche de votre pièce.
> Heureusement, ce n'est pas encore l'heure du repas, et la personne se contentera de vous replacer à votre place d'origine avant de repartir.

## Présentation technique du projet
>
> Le projet sera donc un jeu de logique, avec des niveaux vue du dessus.
> Chaque niveau vous mettra dans la peau de Chpatata, le personnage controlé, qui devra traverser le niveau, surmonter toutes les énigmes diverses pour atteindre le cookie.
> Les épreuves à surmonter seront diverses et variées (*pas forcément intégré dans le jeu actuellement*):
> *   amener un faisceau lumineux vers un interrupteur pour enlever l'obstacle
> *   labyrinthe de téléporteurs
> *   contrôle d'un petit robot a distance limitée
> *   pousser des blocs dans un espace vide, afin de pouvoir passer
> *   un système de glace entrainant Chpatata jusqu'à rencontrer un bloc normal ou bien un obstacle
>
> Le jeu sera composé de 3 niveaux de couches (layout) d'objets, représenté par une AnchorPanel.
> 1.  La couche 0 représente le background, les éléments visibles, mais n'ayant aucune intéraction avec votre personnage
> 2.  La couche 1 représente les objets statiques, ils ont une influence sur votre personnage (comme la glace), mais ne peuvent bouger dans le nivceau.
> 3.  La couche 2 représente les objets dynamiques et les objets avec collision.
>     Les bords du niveau, un poteau en plein milieu du niveau sont des exemples d'objets de collision.
>     Votre personnage ou d'autres objets de collision ne peuvent les traverser.
>
>     Les objets dynamiques sont les objets pouvant être amené, au cours du niveau, à être changer d'état (interrupteur, bloc à déplacer...).
>     Les objets dynamiques peuvent être des objets avec collision, comme par exemple les portes (qui peuvent etre ouverte, mais fermée, non traversable par votre personnage).
>

## Membres du projet
> 
> FOUCRAS Baptiste
>
> L'HOSTIS Loriane
>

## Technologies utilisées
>
> Java 16, JavaFX 16 (avec FXML)
>

## Période du projet
>
> 19 novembre 2021 au 16 janvier 2022 (2 mois)
>
