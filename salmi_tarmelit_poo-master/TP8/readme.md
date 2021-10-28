# TP8

## Auteurs

* TARMELIT LYDIA
* SALMI BADR-EDDINE

## Compétences visées :

* Utiliser la notion d'héritage.
* Réaliser un paquetage de classes et des classes de tests pour un paquetage comportant des héritages.

## Objectifs réalisés :

### Objectif 1 : Completer les classes donner avec les fichiers  : 
Nous avons réalisé les classes :
* RentalAgency qui permet de créer des instances d'agences de locations et qui comporte les fonctions définies.
* AndFilter qui permet de créer une intersection entre différents filtres utilisables par une agence.
* RentalAgencyTest qui comporte les tests de la classe RentalAgency en utilisant la spécificité @Before.

### Objectif 2 : Réaliser les classes principale qui vérifiant le bon fonctionnement : 
MainAgency qui sert à expérimenter le bon fonctionnement des classes :
* Vehicle pour les véhicules.
* Client pour les clients.
* BrandFilter, MaxPriceFilter et AndFilter pour les filtres.
* RentalAgency pour les agences.

Dans MainAgency nous avons ; 
* Fait louer et rendre des véhicules par des clients.
* Utilisé les différentes fonctions proposées par la classe RentalAgency, en provoquant des cas de réussite et des cas engendrant des exceptions notamment pour : UnknownVehicleException.
* Affiché le résultat de selections par des filtres.

### Objectif 3 : Utilisation de la méthode twoClientObjectsWithSameNameCorrespondsToSameClien : 
1) Notre code n'a pas passé ce test avec succès.  
La raison est que nous avons pas défini de méthode hashCode pour les clients, ainsi 2 instances différentes d'un même client sont considéré comme différent car le hashCode par défaut compare les emplacement mémoire et évidemment ces 2 instances n'occupent pas le même espace mémoire.  
2) Les corrections nécessaires ont été apportées (réalisation d'une méthode hashCode au sein de la classe Client) 

### Objectif 4 : Réaliser une classe Car héritant de la classe Vehicle :
Nous avons réalisé la classe Car qui hérite de la classe Vehicle.  
Une voiture a comme propriété additionnelle le nombre de passagers qu’elle peut accueillir.  

### Objectif 5 : Réaliser une classe MotorBike héritant de la classe Vehicle :
Nous avons réalisé la classe Motorbike qui hérite de la classe Vehicle.  
Une moto a comme propriété additionnelle la cylindrée  

### Objectif 6 : Modifier La classe MainAgency pour  vérifier le bon fonctionnement des héritages de Vehicle :
* Car pour les voitures.
* Motorbike pour les motos.
En liens avec les classes précédement expérimentées  

Nous avons : 

* Fait louer et rendre des véhicules (vehicules, voitures et motos) par des clients.
* Utilisé les différentes fonctions proposées par la classe RentalAgency, en provoquant des cas de réussite et des cas engendrant des exceptions notamment pour : UnknownVehicleException.
* Affiché le résultat de selections par des filtres sur les prix.

### Objectif 7 : Réaliser une classe SuspiciousRentalAgency héritant de la classe RentalAgency :
Nous avons réalisé la classe SuspiciousRentalAgency qui hérite de RentalAgency et qui applique un surcoût de 10% sur le prix de location pour les conducteurs dont l’âge est inférieur à 25.  
 
 
### Objectif 8 : La classe SecondMainAgency pour  vérifier le bon fonctionnement de l'API et des héritages :

* Fait louer et rendre des véhicules (vehicules, voitures et motos) par des clients avec une partie permettant de voir les 10% supplémentaire appliquées sur le tarif journalier pour les conducteurs dont l'âge est inférieur a 25 ans.
* Utilisé les différentes fonctions proposées par les classes RentalAgency et SuspiciousRentalAgency, en provoquant des cas de réussite et des cas engendrant des exceptions notamment pour : UnknownVehicleException.
* Affiché le résultat de selections par des filtres sur les prix.

## Résumé des commandes : 

Veuillez ouvrir un terminal de commande dans le dossier TP8 .  


 

