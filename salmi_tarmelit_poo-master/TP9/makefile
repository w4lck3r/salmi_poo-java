.PHONY:all clean


all: classes goosegame goosegameTest doc game
#rentalTest agency

#Compilation des classes :
goosegame : src/goosegame/*.java src/goosegame/cells/*.java  src/goosegame/boards/*.java classes 
	javac -cp classes src/goosegame/*.java src/goosegame/cells/*.java  src/goosegame/boards/*.java -d classes

#Compilation des classes de test :
goosegameTest: test/goosegame/*.java test/goosegame/cells/*.java test/goosegame/boards/*.java goosegame
	javac -cp test-1.7.jar:classes test/goosegame/*.java test/goosegame/cells/*.java test/goosegame/boards/*.java -d classes

#Création du répertoire recevant les classes compilées :
classes: 
	mkdir -p classes

#Création de la documentation :
doc : src/goosegame/*.java 
	javadoc -d docs -author -sourcepath src -subpackages goosegame 

#Création d'un jar éxécutable :
game: doc goosegame MANIFEST.MF goosegameTest
	jar cvfm oie.jar MANIFEST.MF docs/ test/ -C classes/ goosegame

#Commandes d'éxecution :
#Pour la classe principale :
GooseMain: goosegame
	java -cp classes goosegame.GooseMain classical frodon sam

#Pour les test :
playerTest: goosegameTest
	java -jar test-1.7.jar -cp classes goosegame.PlayerTest

startCellTest: goosegameTest
	java -jar test-1.7.jar -cp classes goosegame.cells.StartCellTest

basicCellTest: goosegameTest
	java -jar test-1.7.jar -cp classes goosegame.cells.BasicCellTest

gooseCellTest: goosegameTest
	java -jar test-1.7.jar -cp classes goosegame.cells.GooseCellTest

trapCellTest: goosegameTest
	java -jar test-1.7.jar -cp classes goosegame.cells.TrapCellTest

jumpCellTest: goosegameTest
	java -jar test-1.7.jar -cp classes goosegame.cells.JumpCellTest

waitCellTest: goosegameTest
	java -jar test-1.7.jar -cp classes goosegame.cells.WaitCellTest

classicalBoardTest: goosegameTest
	java -jar test-1.7.jar -cp classes goosegame.boards.ClassicalBoardTest

onlyBasicBoardTest: goosegameTest
	java -jar test-1.7.jar -cp classes goosegame.boards.OnlyBasicBoardTest

gameTest: goosegameTest
	java -jar test-1.7.jar -cp classes goosegame.GameTest

#Affiche les tests un par un à chaque fermeture d'une fenêtre Junit :
displayTest: playerTest startCellTest basicCellTest gooseCellTest trapCellTest jumpCellTest waitCellTest classicalBoardTest onlyBasicBoardTest gameTest

#Commande de nettoyage :
clean:
	rm -rf classes docs oie.jar

