# TP9

## Auteurs

* SALMI Badr-eddine
* TARMELIT Lydia

## Compétences visées :

* Utiliser la notion d'héritage avec les classes abstraites.
* Réaliser un paquetage de classes et un ensemble de classes de tests pour un paquetage comportant des classes abstraites.

## Objectifs réalisés :

### Objectif 1 : Réaliser des classes de cellules pour un plateau de jeu de l'oie : 
Nous avons réalisé la classe abstraite Cell qui permet de représenter des cellules d'un plateau de jeu de l'oie.  
A l'aide de cette classe nous avons réalisé les classes suivante du sous-paquetage cells :
* StartCell qui permet de créer une cellule de départ du jeu, le joueur peut toujours la quitter et son action est de renvoyer l'index 0.
* BasicCell qui permet de créer des cellules basique, le joueur peut toujours les quitter et leur action est de renvoyer leur index.  

Et à l'aide de la classe BasicCell nous avons réalisé les classes :  
* GooseCell qui permet de créer des cellules d'oie, le joueur peut toujours les quitter et leur action est de doubler le score au dés du joueur.
* JumpCell qui permet de créer des cellules de téléportation vers une autre case, le joueur peut toujours les quitter et leur action est de téléporter le joueur vers une autre cellule.
* WaitCell qui permet de créer des cellules d'attente, le joueur doit attendre un certain nombre de tours avant de les quitter et leur action est de renvoyer leur index.
* TrapCell qui permet de créer des cellules piègées, le joueur ne peut les quitter que si un autre joueur tombe sur la meme cellule et leur action est de renvoyer leur index.  

### Objectif 2 : Réaliser des classes de plateau de jeu : 
Nous avons réaliser la classe abstraite Board, cette classe permet de representer des plateaux de jeu de l'oie à l'aide des cellules.  
Grâce à Board nous avons réaliser 2 classes dans le sous-paquetage boards :  
* ClassicalBoard qui permet de créer des plateau de jeu de l'oie standard.
* OnlyBasicBoard qui permet de créer des plateau de jeu de l'oie qui ne contiennent que des cellules basiques.  

### Objectif 3 : Réaliser le jeu de l'oie : 
Nous avons ensuite réaliser les classes permettant de jouer au jeu de l'oie :  
* La classe Player qui permet de representer un joueur.
* La classe Game qui permet de creer et de faire jouer des joueur sur un plateau de jeu.
* La classe InvalidNumberPlayerException qui permet de créer une exception spécifique au sein d'une partie du jeu de l'oie si aucun joueur n'est dans le jeu.

### Objectif 4 : Réaliser une classe principale permettant de jouer au jeu de l'oie :
La classe GooseMain permet de lancer une partie de jeu de l'oie en prenant sur l'entrée standard du terminal de commande des arguments.  

### Information complémentaire :
Les classes de tests des différentes classe ont été réalisées, hormis pour les classes abstraite, la classe d'exception et la classe GooseMain.  
Et un éxécutable oie.jar est réalisable avec une commande indiquée plus bas.  

## Résumé des commandes : 
Veuillez ouvrir un terminal de commande dans le dossier TP8 s'il vous plait.  

Afin de compiler toutes les classes, générer la documentation et un exécutable jar directement vous pouvez y saisir la commande :  
<code>make</code>  

#### Comment générer la documentation ?
Si vous n'avez pas effectué la commande <code>make</code>, saisissez la commande :  
<code>make doc</code>  

Dans les 2 cas, vous pourrez retrouver la documentation compilée dans le dossiers docs du répertoire racine TP8.  
Veuillez cliquer sur le fichier index.html de ce dossier afin de pouvoir la consulter au sein d'un navigateur internet.  

#### Comment compiler les classes du projet ?
Si vous n'avez pas effectué la commande <code>make</code>, pour compiler saisissez la commande :  
<code>make goosegame</code>  
Vous pourrez retrouver les classes compilées dans le dossier classes du répertoire racine TP8.  

#### Comment compiler puis exécuter les tests ?
Si vous n'avez pas effectué la commande <code>make</code>, pour compiler saisissez la commande :  
<code>make goosegameTest</code>  

Pour éxécuter tous les test d'un coup (1 test apparait à chaque fenêtre Junit fermée) saisissez la commande :  
<code>make displayTest</code>  

Sinon pour éxécuter les tests un par un vous pouvez saisir les commandes :  
<code>make playerTest</code>  
<code>make startCellTest</code>  
<code>make basicCellTest</code>  
<code>make gooseCellTest</code>  
<code>make trapCellTest</code>  
<code>make jumpCellTest</code>  
<code>make waitCellTest</code>  
<code>make classicalBoardTest</code>  
<code>make onlyBasicBoardTest</code>  
<code>make gameTest</code>  

Vous retrouverez également les classes de tests dans le dossier classes du répertoire racine TP8.

#### Comment réaliser un exécutable jar du projet ?
Si vous n'avez pas effectué la commande <code>make</code>, saisissez la commande :  
<code>make game</code>  
Afin de créer un jar exécutable.  

#### Comment tester l'exécution du programme ?
Pour éxécuter le programme saisissez la commande :  
<code>make GooseMain</code>  
/!\ UNE PARTIE INFINIE PEUT SE PRODUIRE /!\  

Ou vous pouvez utiliser l'exécutable oie.jar spécialement conçu à cet effet avec la commande :  
<code>java -jar oie.jar classical frodon sam</code>  
/!\ UNE PARTIE INFINIE PEUT SE PRODUIRE /!\  

La commande suivante vous montrera les arguments acceptés sur la ligne de commande :  
<code>java -jar oie.jar</code>  

#### Comment nettoyer le répertoire ?
Vous pouvez revenir au contenu initial du dossier TP8 en saisissant la commande :  
<code>make clean</code>  

