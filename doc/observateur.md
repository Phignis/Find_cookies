# Implémentation observateur
> 
> Soucis: un observateur possible est la porte. Elle observe a la fois la boucle temporelle, et un interrupteur.
> Avec le patron classique, on ne peut savoir le type du sujet qui nous a notifié. Or, nous ne voulons pas effectuer la même action selon
> si c'est une notification de la boucle ou de l'interrupteur.
> 
> On souhaite donc connaitre le type de celui nous notifiant.
> 

# Propositions:

>
> update() pourrait prendre en paramètre une variable, pour déterminer le type. Dans Interrupteur, on redéfinirait notifier, pour informer que l'on
> est un Interrupteur. Reste a déterminer comment faire le choix dans update (stratégie?)
>
