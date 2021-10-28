**TP5**

## Auteurs

* SALMI badr eddine
* TARMELIT lydia

## Compétences visées :
* Être capable de réaliser une classe de tests, pour une classe cible.
* Savoir crée un paquetage java.
* Savoir crée un exécutable java de type .jar.

## Objectifs réalisés :

### Objectif 1 : Résumé des achèvements de l'exercice 1: 
Q1) Mise en oeuvre de paquetages.  
La mise en oeuvre des paquetages a été éffectué.
 
Q2) Compilation :  
La variable $CLASSPATH n'etait pas définie.
En ouvrant un terminal de commande dans le dossier src et en exécutant la commande :  
<code>javac example/Robot.java -d ../classes</code>  
Le résultat de la compilation a pu être déposé dans le dossier classes.  

Q3) Génération de la documentation :  
La documentation du paquetage example et de tous ses sous-paquetages a été généré l'aide de la commande (Toujours depuis le dossier src) :  
<code>javadoc -d ../docs -subpackages factory</code>  
Et la javadoc de la classe Box.java a été complété.

Q4) Tests :  
Nous avons regardé les tests fournis et en ouvrant un terminal de commande au sein du dossier racine du projet (dossier TP5), nous les avons éxécutés à l'aide des commandes :  
<code>javac -classpath test4poo.jar test/BoxTest.java</code>  
<code>java -jar test4poo.jar BoxTest</code>  
Ils ont tous été passés avec succès  

Nous avons crée une classe afin de tester les méthodes de la classe Robot.java.  
Elle se nomme RobotTest.java et se situe dans le dossier test.  
Vous pouvez vérifier que tout les tests ont été passé avec succès à l'aide des commandes :  
<code>javac -classpath test4poo.jar test/RobotTest.java</code>  
<code>java -jar test4poo.jar RobotTest</code>  

Q5) Execution du programme :  
La fonction main fournie a été implémenté dans le fichier Robot.java.  
Vous pouvez verifier son exécution en ouvrant un terminal dans le dossier classes et en tapant la commande :  
<code>java factory.Robot</code>  
Sinon depuis le dossier racine TP5 :
<code>java -classpath classes factory.Robot</code>  

Q6) Réalisation d'un exécutable .jar :  
Depuis un terminal de commande ouvert dans le dossier classes, la commande :  
<code>jar cvf ../factory.jar factory</code>  
Nous a permit de crée une archive .jar.  

Pour voir son contenu nous avons saisi la commande (depuis le dossier TP5):  
<code>jar tvf factory.jar</code>  
La commande nous indique que l'archive contient :  
Le dossier example, qui contient lui même :
* Le fichier Robot.class.
* Le dossier util qui contient lui même les classes Box.class et ConveyerBelt.class.  
Un dossier suppleméntaire :  
* META-INF qui contient un fichier MANIFEST.MF.  

Depuis un terminal dans le dossier tmp, nous avons saisi la commande :  
<code>java -classpath factory.jar factory.Robot</code>  
Afin d'exécuter le code présent au sein de l'archive factory.jar.  

Puis toujours dans ce dossier nous avons effectué l'extraction de l'archive grâce à la commande :  
<code>jar xvf factory.jar</code>

Afin de rendre appli.jar éxécutable, nous avons modifié le fichier MANIFEST.MF en mettant à jour l'archive grâce à la commande (depuis le dossier tmp) :  
<code>jar cvfm ../factory.jar ../manifest-factory factory</code>  

En ouvrant un terminal dans le dossier racine TP4, l'exécutable crée s'exécute à l'aide de la commande :  
<code>java -jar factory.jar</code>  

Q7) Ajouter des ressources :  
Enfin d'avoir une archive complète, nous avons pu insérer dans notre exécutable, la documentation et les test des classes grâce à la commande :  
<code>jar cvfm factory.jar manifest-factory docs test -C classes factory</code>  
A l'aide d'un terminal ouvert dans le dossier TP5.  

### Objectif 2 : Réalisation du paquetage date vu en TD : 
Dans le dossier src vous pourrez retrouver le paquetage date qui a été réalisé, il contient :  
* Une classe Date.java qui est la classe d'objets Date.
* Une classe DateMain.java qui contient le programme principal du paquetage.
* Un dossier util qui contient une classe de type énuméré Month qui représentent les mois des dates.

Et dans le dossier racine vous pouvez retrouver l'éxécutable appliDate.jar qui a été produit à l'aide de ce paquetage.  

Pour compiler les classes de ce paquetage veuillez ouvrir un terminal de commande dans le dossier src et y taper la commande :  
<code>javac date/DateMain.java -d ../classes</code>

Toujours depuis le dossier src vous pouvez générer la doc avec la commande :  
<code>javadoc -d ../docs -subpackages date</code>  

Puis ouvrez un terminal dans le dossier TP5 vous pouvez réaliser les tests du paquetage à l'aide des commandes :  
<code>javac -classpath test4poo.jar test/DateTest.java</code>  
<code>java -jar test4poo.jar DateTest</code>  

<code>javac -classpath test4poo.jar test/MonthTest.java</code>  
<code>java -jar test4poo.jar MonthTest</code>  

Enfin avec le terminal de commande ouvert dans le dossier TP5, vous pouvez exécuter le programme en saisissant la commande :  
<code>java -classpath classes date.DateMain</code>  

Ou vous pouvez saisir la commande d'éxécution de l'exécutable appliDate.jar crée pour ce paquetage :  
<code>java -jar appliDate.jar</code>  

### Résumé des commandes : 

#### Comment générer la documentation ?
Ouvrez un terminal de commande dans le répertoire src s'il vous plait.
Saisissez les commandes :  
Pour le paquetage factory :  
<code>javadoc -d ../docs -subpackages factory</code>  
Pour le paquetage date :  
<code>javadoc -d ../docsDate -subpackages date</code>  

Vous pourrez retrouver les documentations compilées dans les dossiers docs et docsDate du répertoire racine TP5.  
Veuillez cliquer sur le fichier index.html afin de pouvoir la consulter au sein d'un navigateur internet.

#### Comment compiler les classes du projet ?
Ouvrez un terminal de commande dans le répetoire src s'il vous plait.
Saisissez les commandes :  
Pour le paquetage example :  
<code>javac factory/Robot.java -d ../classes</code>  
Pour le paquetage date :  
<code>javac date/DateMain.java -d ../classes</code>  

Vous pourrez retrouver les classes compilées dans le dossier classes du répertoire racine TP5.
#### Comment compiler puis exécuter les tests ?
Depuis terminal de commande ouvert dans le dossier TP4 vous pouvez réaliser les tests à l'aide des commandes :  
Pour le paquetage example :  
<code>javac -classpath test4poo.jar test/RobotTest.java</code>  
<code>java -jar test4poo.jar RobotTest</code>  
<code>javac -classpath test4poo.jar test/BoxTest.java</code>  
<code>java -jar test4poo.jar BoxTest</code>  
Pour le paquetage date :  
<code>javac -classpath test4poo.jar test/DateTest.java</code>  
<code>java -jar test4poo.jar DateTest</code>  
Et:  
<code>javac -classpath test4poo.jar test/MonthTest.java</code>  
<code>java -jar test4poo.jar MonthTest</code>  

Vous pouvez retrouver les classes de tests dans le dossier test du répertoire racine TP5.

#### Comment tester l'exécution du programme ?
Toujours depuis un terminal de commande ouvert dans le dossier TP5 vous pouvez réaliser les exécution manuelles des programmes à l'aide des commandes :  
Pour le paquetage example :  
<code>java -classpath classes factory.Robot</code>  
Pour le paquetage date :  
<code>java -classpath classes date.DateMain</code>  

Où exécuter directement les exécutables .jar produit :  
Pour le paquetage example :  
<code>java -jar factory.jar</code>  
Pour le paquetage date :  
<code>java -jar appliDate.jar</code>  

Remarque : Vous pouvez consulter le contenu des exécutables .jar à l'aide des commandes :
Pour le paquetage example :  
<code>jar tvf factory.jar</code>  
Pour le paquetage date :  
<code>jar tvf appliDate.jar</code>  
