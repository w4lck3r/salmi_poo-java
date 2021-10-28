.PHONY:all clean


all: classes io shifumi doc shifumiTest rpsGame

#Compilation des classes :
shifumi : src/shifumi/*.java src/shifumi/util/*.java io classes
	javac -cp classes src/shifumi/*.java src/shifumi/util/*.java -d classes

io : src/io/*.java classes
	javac src/io/*.java -d classes

#Compilation des classes de test :
shifumiTest: test/shifumi/*.java test/shifumi/util/*.java shifumi
	javac -cp test-1.7.jar:classes test/shifumi/*.java test/shifumi/util/*.java -d classes

#Création du répertoire recevant les classes compilées :
classes: 
	mkdir -p classes

#Création de la documentation :
doc : src/shifumi/util/*.java src/shifumi/*.java
	javadoc -d docs -author -sourcepath src -subpackages shifumi

#Création d'un jar éxécutable :
rpsGame: doc shifumiTest shifumi MANIFEST.MF
	jar cvfm rps.jar MANIFEST.MF docs/ test/ classes/io -C classes/ shifumi

#Commandes d'éxecution :
#Pour les test :
gametest: shifumiTest
	java -jar test-1.7.jar -cp classes shifumi.GameTest

playertest: shifumiTest
	java -jar test-1.7.jar -cp classes shifumi.PlayerTest

shapetest: shifumiTest
	java -jar test-1.7.jar -cp classes shifumi.ShapeTest

strategytest: shifumiTest
	java -jar test-1.7.jar -cp classes shifumi.util.StrategyTest

papertest: shifumiTest
	java -jar test-1.7.jar -cp classes shifumi.util.PaperStrategyTest

rockpapertest: shifumiTest
	java -jar test-1.7.jar -cp classes shifumi.util.RockPaperStrategyTest

randomtest: shifumiTest
	java -jar test-1.7.jar -cp classes shifumi.util.RandomStrategyTest

#Affiche les tests un par un à chaque fermeture d'une fenêtre Junit:
displaytest : gametest playertest shapetest strategytest papertest rockpapertest randomtest

#Commande de nettoyage :
clean:
	rm -rf classes docs rps.jar
