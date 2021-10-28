package game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

  private Player joueur;

	/* méthode exécutée avant l'exécution de chacune des méthodes de test */
	@Before
	public void before() {
		 // initialisation des attributs pour chacun des tests
     this.joueur = new Player("player");
	}

	@Test
	public void addRessourceTest() {
		// Précondition : joueur ne contient pas de ressource
		assertEquals(0,this.joueur.getRessource(Ressource.ROCHE));
    assertEquals(0,this.joueur.getRessource(Ressource.BLE));
    assertEquals(0,this.joueur.getRessource(Ressource.SABLE));
    assertEquals(0,this.joueur.getRessource(Ressource.BOIS));
		// Execution de la mèthode testée
		this.joueur.addRessource(Ressource.ROCHE, 1);
    this.joueur.addRessource(Ressource.BLE, 2);
    this.joueur.addRessource(Ressource.SABLE, 3);
    this.joueur.addRessource(Ressource.BOIS, 4);
		// Résultat : le joueur possede bien les ressources qu'on lui a ajouté
    assertEquals(1,this.joueur.getRessource(Ressource.ROCHE));
    assertEquals(2,this.joueur.getRessource(Ressource.BLE));
    assertEquals(3,this.joueur.getRessource(Ressource.SABLE));
    assertEquals(4,this.joueur.getRessource(Ressource.BOIS));
	}

  @Test
	public void addPointsTest() {
		// Précondition : joueur ne possede pas de points
		assertEquals(0,this.joueur.getScore());
		// Execution de la mèthode testée
		this.joueur.addPoints(10);
		// Résultat : le joueur possede bien les points qu'on lui a ajouté
    assertEquals(10,this.joueur.getScore());
	}

  @Test
	public void addGoldTest() {
		// Précondition : joueur ne possede pas d'or
		assertEquals(0,this.joueur.getGold());
		// Execution de la mèthode testée
		this.joueur.addGold(15);
		// Résultat : le joueur possede bien l'or qu'on lui a ajouté
    assertEquals(15,this.joueur.getGold());
	}

  @Test
	public void removeGoldTest() {
		// Précondition : joueur ne possede de l'or
    this.joueur.addGold(10);
		assertEquals(10,this.joueur.getGold());
		// Execution de la mèthode testée
		this.joueur.removeGold(10);
		// Résultat : le joueur ne possede plus
    assertEquals(0,this.joueur.getGold());
	}

	// ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(game.PlayerTest.class);
	}
}
