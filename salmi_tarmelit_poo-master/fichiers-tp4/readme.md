# TP4

## Auteurs

* SALMI Badr-eddine
* TARMELIT Lydia

## Compétences visées :
* Être capable de générer une documentation JavaDoc.
* Savoir compiler et éxécuter une classe.
* Réaliser des test afin de verifier le bon fonctionnement d'un programme.
* Connaitre l'implémententation d'un programme principal (spécificité de la fonction main et de ses arguments).
* Être capable de créer et d'utiliser des dépendances (relations) entre classes.

# Objectif principal : Réaliser une classe simulant une station de vélos afin que les tests founis soient passé avec succès.

## Objectifs réalisés :

## 1)Prise en main:

### Objectif 1 : Q1.Q2.Q3 : Générer et analyser une documentation :
Une documentation se génère de la manière suivante :  
<code>javadoc *fichiercomportantlaclasse*.java -d docs</code>  
Où l'option -d docs permet de placer les fichiers généré dans un dossier docs.

Ainsi la documentation du fichier Bike.java peut être généré via un terminal en éxécutant la commande :  
<code>javadoc Bike.java -d docs</code>

### Objectif 2 : Q4 : Compilation d'une classe :
Pour compiler une classe il faut utiliser la commande:  
<code>javac *fichiercomportantlaclasse*.java</code>

Ainsi pour compiler la classe Bike on saisit dans un terminal de commande:  
<code>javac Bike.java</code>  

Question 4:  
BikeModel.java définit un type énuméré représentant le modèle de vélo.  
Nous avons le choix entre un vélo classique, un éléctrique ou un tandem.  
Le fichier a été compilé en même temps que Bike.java car il y a une relation de dépendance entre ces 2 classes.

### Objectif 3 : Q5.Q6.Q7 : Prise en main des tests :
Pour réaliser les tests, la présence du fichier test-1.7.jar contenant le gestionnaire de test est requise.  
Commande générale pour la compilation : <code>javac -classpath .:test-1.7.jar test/*nomdelaclasseTest*.java</code>  
Commande générale pour l'éxecution : <code>java -jar test-1.7.jar *nomdelaclasseTest*</code>  

Les tests ont été consulté et nous avons éxécuté ceux de BikeTest.  
Nous avons eu une barre verte, signifiant que les 4 tests ont été passé avec succès lors de l'éxécution des commandes :  
<code>javac -classpath .:test-1.7.jar test/BikeTest.java</code>  
<code>java -jar test-1.7.jar BikeTest</code>


### Objectif 4 : Q8 : Fixer un prix de location :
La bonne manière pour définir cette information est d'utiliser un attribut constant, soit un entier fixée et public.  
Afin:  
* D'être accessible depuis toutes les instances grâce à static.
* De ne pas devoir programmer un getter (accesseur) pour le prix en étant public.
* De ne pas pouvoir être modifié par l'utilisateur grâce à final.  
Ce qui nous donne :  
<code>public static final int PRICE=10;</code>  
Le code de Bike.java a été modifié.

### Objectif 5 : Q9 : Définition de la classe BikeMain :
Veuillez voir le fichier BikeMain.java s'il vous plait.

### Objectif 6 : Q10 : Compilation du fichier BikeStation.java :
Nous avons éxécuté les commandes suivantes :  
<code>javac -classpath .:test-1.7.jar test/BikeStationTest.java</code>  
<code>java -jar test-1.7.jar BikeStationTest</code>  
Nous avons obtenu une barre rouge signifiant qu'il y a des erreurs lors de l'éxécution du fichier BikeStation.

## 2)Obtenir une barre verte:

### Objectif 7 : Q11.Q12.Q13.Q14.Q15 : Réalisation de la classe BikeStation :
Dans un premier temps nous avons déterminé les signatures de méthode qui nous seront utiles.  
Puis nous avons réalisé la documentation JavaDoc de la classe.  
Enfin nous avons déterminé les attributs nécessaires.  
Les tests étant déja réalisé, nous avons implémenté le constructeur, les accesseurs et les méthodes en général.  
Enfin nous avons effectué les tests et avons obtenu la barre verte recherchée.

# Comment utiliser ce TP ?
En ouvrant un terminal de commande au sein du dossier TP3 vous pourrez éxécuter les différentes commandes qui suivront.

## Comment générer la documentation ?
La principale classe implémenté ici est BikeStation, vous pouvez générer sa documentation de la manière suivante:  
<code>javadoc BikeStation.java -d docs</code>  

Puis allez dans le dossier docs et ouvrez index.html dans un navigateur web pour voir la documentation.  
Les documentations des autres classes peuvent être réalisées de la même manière en remplacant BikeStation par le nom de la classe souhaité.


## Comment compiler les classes du projet ?
Pour compiler toutes les classes du projet veuillez éxécuter la commande :  
<code>javac BikeStationMain.java</code>  

L'avantage de cette commande est que la compilation de BikeStationMain engendre la compilation des autres classes du projet dont il dépend.  
La seule classe non compilé est BikeMain de la question 9, pour la compiler veuillez éxécuter la commande :  
<code>javac BikeMain.java</code>  


## Comment compiler puis exécuter les tests ?
Afin de vérifier le bon fonctionnement de la classe BikeStation vous pouvez lancer les tests en éxécutant les 2 commandes suivantes :  
<code>javac -classpath .:test-1.7.jar test/BikeStationTest.java</code>  
<code>java -jar test-1.7.jar BikeStationTest</code>  

La première commande est la commande de compilation, la seconde celle d'éxécution.


## Comment tester l'exécution du programme ?
Pour tester l'éxécution du programme, il faut utiliser une fonction main.
Elle est présente dans au moins une des classes du projet, cela permet d'envoyer des instructions aux autres classes et donc d'éxécuter le programme lorsque cette classe est compilé.

Dans ce TP, il y a 2 fonction main, une pour les vélos, une pour la station de vélo :

Pour la question 9 de la partie 1 : BikeMain :  
Vous pouvez éxécuter les commandes suivantes (Si les classes ont déja été compilé vous pouvez éxécuter que la seconde commande):  
<code>javac BikeMain.java</code>  
<code>java BikeMain</code>  
L'affichage obtenu a été produit en utilisant la classe Bike, par exemple, sur celui-ci vous pouvez voir des informations sur un objet Bike comme son prix.

Pour les questions de la partie 2 : BikeStationMain :  
Vous pouvez éxécuter les commandes suivantes (Si les classes ont déja été compilé vous pouvez passer la première commande):  
<code>javac BikeStationMain.java</code>  
<code>java BikeStationMain</code>  
<code>java BikeStationMain 3</code>  
<code>java BikeStationMain 1</code>  
<code>java BikeStationMain a</code>  


Explications des commandes :
* La seconde commande affichera un message vous indiquant de saisir un argument lors de l'appel du script.
* La 3ème commande imprimera à l'écran qu'il n'y pas de vélo a cet emplacement.
* La 4ème commande montrera l'id du vélo que vous avez eu ainsi que son prix.
* Enfin la dernière commande vous affichera qu'il faut saisir un nombre entier, car une exception du programme a été levé suite à un mauvais type d'argument.
