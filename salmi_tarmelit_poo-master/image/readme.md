**TP6**
*IMAGE*

## Auteurs

* SALMI Badr-eddine
* TARMELIT Lydia

## CompÃ©tences visÃ©es :
* ÃŠtre capable de rÃ©aliser une classe de tests, pour une classe cible.
* Savoir crÃ©e un paquetage java.
* Savoir crÃ©e un exÃ©cutable java de type .jar.

## Objectifs rÃ©alisÃ©s :
### Objectif 1 : Executer des nouveaux types de classe avec le fichier image.jar .
de meme principe pour la l'execution des tests de Junit .
Pour executer directement le fichier image il faut taper la commande 
<code> java -jar image.jar</code>  
On peut aussi passer des paramétre a l'execution de ce fichier selon les choix qu'on a dans le dossier images . sous la commande :
<code>java -jar image.jar /images/storm.pgm 5 16 </code>

### Objectif 2 : Consturction des Classes en respectant les packetages :
####Coder les classes en utilisant l'implementation 
Coder les classes en respectent l'UML :
le paquetage src.image contient : 
* Une classe GrayColor.java : D'objet GrayColor , qui contient les getters , setters , equals et qui est definit par un entier graylevel .
* Une classe Pixel.java : D'objet pixels avec d'instances de type GrayColor et contient : getColor , SetColor , equals et une méthode colorLevelDifference ; on a utilise une methode statique de ka classe java.lang.Math <code>abs(...);</code>
* Une classe Image.java : D'objet image qui implement la classe ImageInterface et contient : les fonctions de la classe ImageInterface bien evidament plus changeColorPixel et filleRectangle .
    l'ajoute d'une methode edges : qui fait l'extraction de contours d'une image .
    et la methode decreaseNbGrayLevels : qui recopier l'image initiale avec un nombre de niveaux de gris limite .
* ###### une classe test <ImageTest.java> : Dans le dossier tests qui fait les tests suivants :
verifier si weight et height matches les entrees .
verifier si tous les pixels sont blancs a la creation .
verifier si le rectangle a tous ces pixels sont blancs .
verifier si la methode changer la couleur marche bien .
pour compiler la classe ImageTest.java taper la commande <code>javac -classpath test4poo.jar tests/*.java </code>
pour executer la classe ImageTest.java taper la commande <code> java -jar test4poo.jar ImageTest </code>

### Objectif 3 : Compiler et Executer la classe Main :
* Compiler toutes les classes avec la commande <code> javac image/*.java -d ../classes</code> , <code> javac image/util/*.java -d ../classes</code> et <code> javac image/color/*.java -d ../classes</code> .
* Executer la classe ImageExampleMain avec la commande <code>java -classpath classes image.ImageExampleMain /images/casablanca.pgm 7 15</code>
 
### Objectif 4 : Construire La classe ImageMain :
* Contient les methodes de la classe ImageExampleMain et des nouveaux methodes qu'on a coder comme edges et decreaseNbGrayLevels .
* Pour executer : <code> java -classpath classes image.ImageExampleMain /images/casablanca.pgm 7 15 </code> 

### Objectif 5 : Creer un archive pour executer le Main du projet :
* <code>cd classes </code>
* <code>jar cvf ../image.jar image images</code>
* <code>cd ..</code>
* <code>java -classpath image.jar image.ImageMain /images/frog.pgm 2 6 &</code>
* <code>cd classes</code>
* <code>jar cvfm ../imageExec.jar ../manifest-image images image</code>
* <code>cd ..</code>
* <code>java -jar imageExec.jar /images/storm.pgm 12 5 &</code>




 