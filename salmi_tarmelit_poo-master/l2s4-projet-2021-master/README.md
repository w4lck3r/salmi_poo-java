# l2s4-projet-2021

Vous devez *forker* ce projet dans votre espace de travail Gitlab (bouton `Fork`) et vidéo sur le [portail](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)

Une fois cela réalisé supprimer ces premières lignes et remplissez les noms des membres de votre équipe.

# Equipe

- Téo VANDROEMME
- Tom SAGOT
- Lydia TARMELIT
- Badreddine SALMI

# Sujet

[Le sujet 2021](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)

# Livrables

## Livrable 1

Modélisation des personnages

### Atteinte des objectifs

Codes des personnages effectuer ainsi que leurs diagramme UML

### Difficultés restant à résoudre

Il manque quelques diagrammes ULM et les codes sont sont pas tous complets

## Livrable 2

Modélisation du plateau

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 3

Modélisation des actions

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 4

Modélisation complète

### Atteinte des objectifs

### Difficultés restant à résoudre

# Journal de bord

## Semaine 1

diagramme UML

## Semaine 2

Diagramme UML et code pour les classes Caracter, Army, Farmer, Player, Resource et Board.
Il manque quelques diagramme ULM et les codes sont sont pas tous complets.

## Semaine 3

Code de la classe Board et des classes Cells

## Semaine 4

code de la classe FarmingPlayer, fichier a_finir, et qlq modifications

## Semaine 5

ajout de quelques methodes d'actions , et modif de certaines methodes, modif fichier a finir

## Semaine 6

## Semaine 7

## Semaine 8

ajout de quelques methodes d'actions

## Semaine 9

Fin du code des methodes d'actions + debut code methodes game

## Semaine 10

Fin du code des methodes Game + documentation des methodes

## Semaine 11

Tests

## Semaine 12

Fin du projet + diagramme UML (par Lydia)

# Utilisation du programme

## Documantation :

Pour génerer la documentation du projet, il faut executer la
commande ci dessous dans un terminal en ce placant dans le
dossier src contenant les fichiers du packetage game.

```shell
javadoc -d ../docs -subpackages game
```

Cette commande va génerer un dossier docs contenant tout les
fichiers necessaires à la documantation.
Pour consulter la documentation il sufit de d'ouvrir le fichier index.html
situer dans le dossier docs.


## Compiler le projet :

Pour compiler le projet il faut executer la commande ci dessous
dans un terminal toujours en étant dans le dossier src contenant les fichers
du packetage game

```shell
javac game/*.java -d ../classes
```

Cette commande va génerer des fichiers .class dans le dossier classes situer
dans le dossier tp9_POO.


## Compiler et executer les tests :

Pour compiler les tests du packetage game il faut executer la
commande ci dessous dans un terminal en étant dans le dossier
contenant les dossier src, class .

```shell
javac -classpath test4poo.jar test/game/*.java
```

Cette commande va génerer des fichiers .class dans le dossier test/game

Pour executer les tests il faut executer les commandes ci dessous
dans un terminal toujours en étant dans le dossier contenant les dossier src, class.

Test le la classe Army :
```shell
java -jar test4poo.jar game.ArmyTest
```

Test le la classe Board :
```shell
java -jar test4poo.jar game.BoardTest
```

Test le la classe Caracter :
```shell
java -jar test4poo.jar game.CaracterTest
```

Test le la classe FarmingGame :
```shell
java -jar test4poo.jar game.FarmingGameTest
```

Test le la classe FarmingPlayer :
```shell
java -jar test4poo.jar game.FarmingPlayerTest
```

Test le la classe Player :
```shell
java -jar test4poo.jar game.PlayerTest
```

Test le la classe WarGame :
```shell
java -jar test4poo.jar game.WarGameTest
```

Test le la classe WarPlayer :
```shell
java -jar test4poo.jar game.WarPlayerTest
```

Ces commandes vont ouvrir une fenêtre, si il y a une barre verte cela veut
dire que tout les tests sont passés avec succés. Si cette barre est rouge,
alors certains tests ne sont pas passés avec succés.


## Execution du programme :

Pour executer la classe Main il faut executer la
commande ci dessous dans un terminal toujours en étant dans le dossier
contenant les dossier src, class.

```shell
java -classpath classes game.Main
```

Lors de l'execution de cette commande,
on peut y voir le deroulement d'une partie de developpement agricole, puis
le deroulement d'un partie de guerre.

Il est possible d'executer le programme avec des paramètres,
si le premier paramètre est 1 alors seul une partie de guerre se lance,
si le premier paramètre est 2 alors c'est une partie de developpement
agricole qui se lance
Le deuxieme et troisieme paramètres sont les noms des deux joueurs.

Pour une partie de Guerre:
```shell
java -classpath classes game.Main 1
```

Pour une partie de Developpement agricole:
```shell
java -classpath classes game.Main 2
```

Pour une partie de Guerre avec les joueurs timo et leon:
```shell
java -classpath classes game.Main 1 timo leon
```

Il existe une autre manière d'exécuter le programme, pour cela on utilise
un .jar exécutable, mais pour l'utiliser il faut d'abord le crée. Pour
cela il faut exécuter la commande ci dessous en étant dans le dossier
classes situer dans le dossier src.

```shell
jar cvfm ../game.jar ../manifest-game game
```

Maintenant nous avons un fichier .jar qui se
nomme game, c'est grace à celui-ci que nous allons pouvoir exécuter
le programme.

Il n'y a plus qu'a exécuter le programme avec cette commande en se
placant dans le dossier contenant les dossier src, class.

```shell
java -jar game.jar
```

Ici aussi il est possible d'executer le programme avec des paramètres

Pour une partie de Guerre:
```shell
java -jar game.jar 1
```

Pour une partie de Developpement agricole:
```shell
java -jar game.jar 2
```

Pour une partie de Guerre avec les joueurs timo et leon:
```shell
java -jar game.jar 1 timo leon
```
