package game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FarmingGameTest {

	private FarmingGame game;
  private FarmingPlayer joueur1;
  private FarmingPlayer joueur2;

	/* méthode exécutée avant l'exécution de chacune des méthodes de test */
	@Before
	public void before() {
		 // initialisation des attributs pour chacun des tests
		 this.game = new FarmingGame(3);
     this.joueur1 = new FarmingPlayer("player1");
     this.joueur2 = new FarmingPlayer("player2");
	}

  // le test de la methode WhoWin de la classe Game n'est pas utile car
  // elle permet juste d'ecrire de texte dans la console

	@Test
	public void addPlayerTest() {
		// Précondition : game ne contient pas de joueurs
		assertEquals(null,this.game.getPlayer1());
    assertEquals(null,this.game.getPlayer2());
		// Execution de la mèthode testée
		this.game.addPlayer(this.joueur1, this.joueur2);
		// Résultat : game contient un joueur
		assertEquals(this.joueur1,this.game.getPlayer1());
    assertEquals(this.joueur2,this.game.getPlayer2());
	}

  @Test
	public void nextPlayerTest() {
		// Précondition : ajout des joueurs dans la partie
		this.game.addPlayer(this.joueur1, this.joueur2);
    // Execution de la mèthode testée
    FarmingPlayer next = this.game.nextPlayer(this.joueur1);
    // Résultat : next est le joueur2
    assertEquals(this.joueur2, next);
    // Execution de la mèthode testée
    next = this.game.nextPlayer(this.joueur2);
    // Résultat : next est le joueur1
    assertEquals(this.joueur1, next);
	}

  // La methode play1Round a un comportement alèatoire et appele seulement des methodes
  // qui sont deja tester, il est donc inutile de tester cette methode

  @Test
	public void comptagePointsTest() {
    // Précondition : ajout des joueurs dans la partie, initialisation du plateau
    this.game.addPlayer(this.joueur1, this.joueur2);
    this.game.getBoard().initBoard();
    // Les deux joueur 1 n'a pas de points
    assertEquals(this.joueur1.getScore(), 0);
    // Ajout d'un fermier avec de l'or pour gagner des points
    while(!(this.joueur1.deploy(this.game.getBoard().getCell((int)(Math.random()*3),(int)(Math.random()*3))))){
    }
    this.joueur1.getDeployedFarmers().get(0).addGold(5);
    // Execution de la mèthode testée
    this.game.comptagePoints(this.joueur1);
    // Résultat : le joueur1 a des points
    assertTrue(this.joueur1.getScore() != 0);
	}

	// La methode play appele seulement des methodes
  // qui sont deja tester, il est donc inutile de tester cette methode

	@Test
	public void canPlayTest() {
    // Précondition : ajout des joueurs dans la partie, initialisation du plateau
    this.game.addPlayer(this.joueur1, this.joueur2);
    this.game.getBoard().initBoard();
		// Execution de la mèthode testée, les cases sont libres donc on peut jouer
		assertTrue(this.game.canPlay());
		// Execution de la mèthode testée, mais deploiment d'un fermier tant que possible pour tester le predicat
		while(this.game.canPlay()){
			this.game.deployOrChangeOrNothing(this.joueur1);
		}
    // Résultat : on ne peut plus jouer
    assertFalse(this.game.canPlay());
	}

  @Test
	public void cellAleatoireTest() {
		// Précondition : le plateau est initialiser
		this.game.getBoard().initBoard();
    // Execution de la mèthode testée
    int[] armee = this.game.cellAleatoire();
    // Résultat : le premier et le second entier sont entre 0 et 3 (le nombre de case)
    assertTrue(armee[0]<3);
    assertTrue(armee[0]>=0);
    assertTrue(armee[1]<3);
    assertTrue(armee[1]>=0);
	}

  @Test
	public void deployOrChangeOrNothingTest() {
		// Précondition : le joueur1 n'a pas de fermier
    this.game.addPlayer(this.joueur1, this.joueur2);
    this.game.getBoard().initBoard();
		assertEquals(this.joueur1.getDeployedFarmers().size(), 0);
    // Execution de la mèthode testée
    while(this.joueur1.getDeployedFarmers().size() == 0){
      this.game.deployOrChangeOrNothing(this.joueur1);
    }
    // Résultat : le joueur 1 a un fermier
  	assertEquals(this.joueur1.getDeployedFarmers().size(), 1);
	}

	// ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(game.FarmingGameTest.class);
	}
}
