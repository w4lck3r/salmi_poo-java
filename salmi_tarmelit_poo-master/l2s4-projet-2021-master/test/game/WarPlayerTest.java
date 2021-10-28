package game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WarPlayerTest {

  private WarPlayer joueur;
  private WarPlayer other;
  private PlainCell plain;
  private MontainCell montain;
  private DesertCell desert;
  private Army a1;
  private Army a2;
  private Army a3;
  private Board b;

	/* méthode exécutée avant l'exécution de chacune des méthodes de test */
	@Before
	public void before() {
		 // initialisation des attributs pour chacun des tests
     this.joueur = new WarPlayer("player");
     this.other = new WarPlayer("other");
     this.plain = new PlainCell(1,1);
     this.montain = new MontainCell(0,1);
     this.desert = new DesertCell(1,0);
     this.b = new Board(3);
     this.a1 = new Army(this.plain,1, this.joueur);
     this.a2 = new Army(this.montain,1, this.joueur);
     this.a3 = new Army(this.desert,1, this.joueur);
	}

	@Test
	public void addArmyTest() {
		// Précondition : joueur ne contient pas d'armée'
		assertEquals(0,this.joueur.allArmy().size());
		// Execution de la mèthode testée
		this.joueur.addArmy(this.a1);
		// Résultat : le joueur possede bien une armée
    assertEquals(1,this.joueur.allArmy().size());
	}

  @Test
	public void decrementSoldiersTest() {
		// Précondition : joueur possede 35 soldats
		assertEquals(35,this.joueur.getSoldiers());
		// Execution de la mèthode testée
		this.joueur.decrementSoldiers(10);
		// Résultat : le joueur possede a present 25 soldats
    assertEquals(25,this.joueur.getSoldiers());
	}

  @Test
	public void addFoodTest() {
		// Précondition : joueur possede 10 de nourritures
		assertEquals(10,this.joueur.getFood());
		// Execution de la mèthode testée
		this.joueur.addFood(15);
		// Résultat : le joueur possede a present 25 de nourritures
    assertEquals(25,this.joueur.getFood());
	}

  @Test
	public void deployTest() {
		// Précondition : joueur et la case ne possede pas d'armée
    assertEquals(0,this.joueur.allArmy().size());
		assertEquals(null,this.plain.getArmy());
		// Execution de la mèthode testée
		this.joueur.deploy(2, this.plain, this.b, this.other);
		// Résultat : joueur et la case possede une armée
    assertEquals(1,this.joueur.allArmy().size());
		assertTrue(this.plain.getArmy() != null);
	}

  // La methode affecte4Cells appele seulement des methodes
  // qui sont deja tester, il est donc inutile de tester cette methode

  @Test
	public void feedTest() {
		// Précondition : joueur possede une armée en plain
    this.joueur.addArmy(this.a1);
    assertEquals(10,this.joueur.getFood());
		// Execution de la mèthode testée
		this.joueur.feed();
		// Résultat : -1 de nourritures
    assertEquals(9,this.joueur.getFood());
    // Précondition : joueur possede une armée en montain
    this.joueur.lostArmy(this.a1);
    this.joueur.addArmy(this.a2);
    assertEquals(9,this.joueur.getFood());
		// Execution de la mèthode testée
		this.joueur.feed();
		// Résultat : -3 de nourritures
    assertEquals(8,this.joueur.getFood());
    // Précondition : joueur possede une armée en desert
    this.joueur.lostArmy(this.a2);
    this.joueur.addArmy(this.a3);
    assertEquals(8,this.joueur.getFood());
		// Execution de la mèthode testée
		this.joueur.feed();
		// Résultat : -2 de nourritures
    assertEquals(6,this.joueur.getFood());
    // Précondition : joueur n'a plus de nourritures
    this.joueur.feed();
    this.joueur.feed();
    this.joueur.feed();
    assertEquals(0,this.joueur.getFood());
		// Execution de la mèthode testée
		this.joueur.feed();
		// Résultat : le joueur perd son armée
    assertEquals(0,this.joueur.allArmy().size());
	}

  @Test
	public void lostArmyTest() {
		// Précondition : joueur a une armée
    this.joueur.addArmy(this.a1);
    assertEquals(1,this.joueur.allArmy().size());
		// Execution de la mèthode testée
		this.joueur.lostArmy(this.a1);
		// Résultat : joueur n'a plus d'armée
    assertEquals(0,this.joueur.allArmy().size());
	}

  @Test
	public void changeRessourceTest() {
		// Précondition : possede des ressources et 10 de nourritures
    this.joueur.addRessource(Ressource.ROCHE, 1);
    this.joueur.addRessource(Ressource.BLE, 2);
    this.joueur.addRessource(Ressource.SABLE, 3);
    this.joueur.addRessource(Ressource.BOIS, 4);
    assertEquals(10,this.joueur.getFood());
		// Execution de la mèthode testée
		this.joueur.changeRessource();
		// Résultat : le joueur n'a plus de ressources et a gagner de la nourritures
    assertEquals(0,this.joueur.getRessource(Ressource.ROCHE));
    assertEquals(0,this.joueur.getRessource(Ressource.BLE));
    assertEquals(0,this.joueur.getRessource(Ressource.SABLE));
    assertEquals(0,this.joueur.getRessource(Ressource.BOIS));
    assertTrue(this.joueur.getFood()>10);
	}

  @Test
	public void harvestTest() {
		// Précondition : joueur a des armées et n'a pas de ressource
    this.joueur.addArmy(this.a1);
    this.joueur.addArmy(this.a2);
    this.joueur.addArmy(this.a3);
    assertEquals(3,this.joueur.allArmy().size());
    assertEquals(0,this.joueur.getRessource(Ressource.ROCHE));
    assertEquals(0,this.joueur.getRessource(Ressource.BLE));
    assertEquals(0,this.joueur.getRessource(Ressource.SABLE));
		// Execution de la mèthode testée
		this.joueur.harvest();
		// Résultat : joueur possede des ressources
    assertTrue(this.joueur.getRessource(Ressource.ROCHE)>0);
    assertTrue(this.joueur.getRessource(Ressource.BLE)>0);
    assertTrue(this.joueur.getRessource(Ressource.SABLE)>0);
	}

	// ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(game.WarPlayerTest.class);
	}
}
