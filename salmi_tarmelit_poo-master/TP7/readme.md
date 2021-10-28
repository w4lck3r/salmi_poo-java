# TP7 RPS

## Auteurs

* SALMI Badr-Eddine
* TARMELIT Lydia

## Compétences visées :

* Réaliser une interface.
* Réaliser un paquetage de classes et un ensemble de classes de tests pour un paquetage implantant une interface.

## Objectifs réalisés :

### Objectif 1 : Réaliser une classe de formes : 
Nous avons réalisé la classe Shape qui indique la forme jouée.  
Elle peut être définit selon 3 états : ROCK (pierre) , PAPER (papier) et SCISSORS (ciseaux).  

### Objectif 2 : Réaliser une interface permettant d'avoir différentes stratégies de jeu : 
Nous avons réaliser la classe Strategy qui est une interface permettant d'obtenir la forme jouée par le joueur en fonction d'une stratégie.  
Pour chaque stratégie une classe lui est associé, ainsi nous avons réaliser les classes :
* PaperStrategy, permettant au joueur de toujours jouer la forme PAPER.
* RandomStrategy, permettant au joueur de jouer une forme aléatoirement parmi celles proposées.
* RockPaperStrategy,permettant au joueur de jouer ROCK puis PAPER alternativement.
* InteractiveStrategy, permettant au joueur de jouer la forme qu'il souhaite en saisissant son nom sur l'entrée standard.

### Objectif 3 : Réaliser une classe permettant de représenter un joueur : 
Nous avons réalisé la classe Player qui représente un joueur.  
Un joueur possède :  
* Un nom défini à sa création.
* Une stratégie de jeu parmi celles citées plus haut.
* Un joueur peut jouer une forme en fonction de sa stratégie.
* Un joueur peut gagner des points en fonction de ses résultats dans la partie.

### Objectif 4 : Réaliser une classe permettant de jouer une partie pierre-feuille-ciseaux : 
Nous avons réalisé la classe Game qui permet de jouer une partie de game.  
Le constructeur de cette classe prend 2 joueurs et un nombre n de tours afin de les faire jouer n manches, de plus cette classe permet d'afficher des messages à l'utilisateur en fonction des actions des joueurs ou de l'ordinateur.

### Objectif 5 : Réaliser une classe qui prépare une partie et qui fait jouer un utilisateur : 
Nous avons réalisé la classe GameMain pour notre exécutable rps.jar qui crée une partie de game de 10 manches.  
Où les joueurs sont :  
* L'utilisateur ayant pour stratégie celle où il saisi la forme à jouer (intéractive).
* L'ordinateur ayant pour stratégie celle passée en argument de rps.jar par l'utilisateur.  
NB: Les arguments acceptés sont indiqués plus bas dans la rubrique "Comment tester l'exécution du programme ?".  

## Résumé des commandes : 
Veuillez ouvrir un terminal de commande dans le dossier TP7 s'il vous plait.  

Afin de compiler toutes les classes, générer la documentation et un exécutable jar directement vous pouvez y saisir la commande :  
<code>make</code>  

#### Comment générer la documentation ?
Si vous n'avez pas effectué la commande <code>make</code>, saisissez la commande :  
<code>make doc</code>  

Dans les 2 cas, vous pourrez retrouver la documentation compilée dans le dossiers docs du répertoire racine TP7.  
Veuillez cliquer sur le fichier index.html de ce dossier afin de pouvoir la consulter au sein d'un navigateur internet.  

#### Comment compiler les classes du projet ?
Si vous n'avez pas effectué la commande <code>make</code>, pour compiler saisissez la commande :  
<code>make shifumi</code>  

Vous pourrez retrouver les classes compilées dans le dossier classes du répertoire racine TP7.  

#### Comment compiler puis exécuter les tests ?
Si vous n'avez pas effectué la commande <code>make</code>, pour compiler saisissez la commande :  
<code>make gametest</code>  

Pour éxécuter tous les test d'un coup (1 test apparait à chaque fenêtre Junit fermée) saisissez la commande :  
<code>make displaytest</code>  

Sinon pour éxécuter les tests un par un vous pouvez saisir les commandes :  
<code>make gametest</code>  
<code>make playertest</code>  
<code>make shapetest</code>  
<code>make strategytest</code>  
<code>make papertest</code>  
<code>make rockpapertest</code>  
<code>make randomtest</code>  

Vous retrouverez également les classes de tests dans le dossier classes du répertoire racine TP7.

#### Comment réaliser un exécutable jar du projet ?
Si vous n'avez pas effectué la commande <code>make</code>, saisissez la commande :  
<code>make rpsGame</code>  
Afin de créer un jar exécutable.  

#### Comment tester l'exécution du programme ?
L'éxécutable rps.jar est nécessaire pour exécuter le programme.  
Cet exécutable prend un nombre entier comme argument, indiquant la stratégie jouée par l'ordinateur, voici les stratégies et leur numéro associé :  

* 0 pour la stratégie "L'ordinateur joue une forme aléatoire".
* 1 pour la stratégie "L'ordinateur joue toujours papier".
* 2 pour la stratégie "L'ordinateur joue rock puis papier en alternance".
* 3 pour la stratégie "L'ordinateur joue intéractivement" Conseillé s'il y a 2 joueurs sur le même ordinateur.

Ainsi vous pouvez saisir dans le terminal les commandes suivantes :  
* <code>java -jar rps.jar</code> Pour afficher à l'utilisateur qu'un argument est nécessaire.
* <code>java -jar rps.jar help</code> Pour afficher l'aide à l'utilisateur et un rappel des stratégies. 
* <code>java -jar rps.jar 0</code> Pour jouer une partie de 10 manches où l'ordinateur joue une forme aléatoire.
* <code>java -jar rps.jar 1</code> Pour jouer une partie de 10 manches où l'ordinateur joue toujours papier.
* <code>java -jar rps.jar 2</code> Pour jouer une partie de 10 manches où l'ordinateur joue rock puis papier en alternance.
* <code>java -jar rps.jar 3</code> Pour jouer une partie de 10 manches où l'ordinateur joue intéractivement (Mode 2 joueurs).
* <code>java -jar rps.jar 5</code> Pour afficher un message indiquant que cette stratégie n'est pas définie.
* <code>java -jar rps.jar a</code> Pour afficher un message indiquant qu'une stratégie doit être un entier positif.

#### Comment nettoyer le répertoire ?
Vous pouvez revenir au contenu initial du dossier TP6 en saisissant la commande :  
<code>make clean</code>  

