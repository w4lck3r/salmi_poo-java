package game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FarmingPlayerTest {

  private FarmingPlayer joueur;
  private PlainCell plain;
  private MontainCell montain;
  private DesertCell desert;
  private Farmer f1;
  private Farmer f2;
  private Farmer f3;

	/* méthode exécutée avant l'exécution de chacune des méthodes de test */
	@Before
	public void before() {
		 // initialisation des attributs pour chacun des tests
     this.joueur = new FarmingPlayer("player");
     this.plain = new PlainCell(1,1);
     this.montain = new MontainCell(0,1);
     this.desert = new DesertCell(1,0);
     this.f1 = new Farmer(this.plain, this.joueur);
     this.f2 = new Farmer(this.montain, this.joueur);
     this.f3 = new Farmer(this.desert, this.joueur);
	}

	@Test
	public void addFarmerTest() {
		// Précondition : joueur ne contient pas de fermier
		assertEquals(0,this.joueur.getDeployedFarmers().size());
		// Execution de la mèthode testée
		this.joueur.addFarmer(this.f1);
		// Résultat : le joueur possede bien un fermier
    assertEquals(1,this.joueur.getDeployedFarmers().size());
	}

  @Test
	public void doNothingTest() {
		// Précondition : joueur possede un fermier sur plain et possede 15 d'or
		this.joueur.addFarmer(this.f1);
    assertEquals(15,this.joueur.getGold());
		// Execution de la mèthode testée
		this.joueur.doNothing();
		// Résultat : le joueur possede a present 1 d'or en plus
    assertEquals(16,this.joueur.getGold());
    // Précondition : joueur possede un fermier sur desert
		this.joueur.addFarmer(this.f3);
    assertEquals(16,this.joueur.getGold());
		// Execution de la mèthode testée
		this.joueur.doNothing();
		// Résultat : le joueur possede a present 3 d'or en plus
    assertEquals(19,this.joueur.getGold());
	}

  @Test
	public void deployTest() {
		// Précondition : joueur et la case ne possede pas de fermier
    assertEquals(0,this.joueur.getDeployedFarmers().size());
		assertEquals(null,this.plain.getFarmer());
		// Execution de la mèthode testée
		this.joueur.deploy(this.plain);
		// Résultat : joueur et la case possede un fermier
    assertEquals(1,this.joueur.getDeployedFarmers().size());
		assertTrue(this.plain.getFarmer() != null);
	}

  @Test
	public void payTest() {
		// Précondition : joueur possede un fermier
    this.joueur.addFarmer(this.f1);
    assertEquals(15,this.joueur.getGold());
		// Execution de la mèthode testée
		this.joueur.pay();
		// Résultat : -1 d'or'
    assertEquals(14,this.joueur.getGold());
    // Précondition : joueur n'a plus d'or'
    this.joueur.removeGold(14);
    assertEquals(0,this.joueur.getGold());
		// Execution de la mèthode testée
		this.joueur.pay();
		// Résultat : le joueur perd son armée
    assertEquals(0,this.joueur.getDeployedFarmers().size());
	}

  @Test
	public void lostFarmerTest() {
		// Précondition : joueur a un fermier
    this.joueur.addFarmer(this.f1);
    assertEquals(1,this.joueur.getDeployedFarmers().size());
		// Execution de la mèthode testée
		this.joueur.lostFarmer(this.f1);
		// Résultat : joueur n'a plus de fermier
    assertEquals(0,this.joueur.getDeployedFarmers().size());
	}

  @Test
	public void changeRessourceTest() {
		// Précondition : possede des ressources et 15 d'or
    this.joueur.addRessource(Ressource.ROCHE, 1);
    this.joueur.addRessource(Ressource.BLE, 2);
    this.joueur.addRessource(Ressource.SABLE, 3);
    this.joueur.addRessource(Ressource.BOIS, 4);
    assertEquals(15,this.joueur.getGold());
		// Execution de la mèthode testée
		this.joueur.changeRessource();
		// Résultat : le joueur n'a plus de ressources et a gagner de l'or
    assertEquals(0,this.joueur.getRessource(Ressource.ROCHE));
    assertEquals(0,this.joueur.getRessource(Ressource.BLE));
    assertEquals(0,this.joueur.getRessource(Ressource.SABLE));
    assertEquals(0,this.joueur.getRessource(Ressource.BOIS));
    assertTrue(this.joueur.getGold()>15);
	}

  @Test
	public void harvestTest() {
		// Précondition : joueur a des fermiers et n'a pas de ressource
    this.joueur.addFarmer(this.f1);
    this.joueur.addFarmer(this.f2);
    this.joueur.addFarmer(this.f3);
    assertEquals(3,this.joueur.getDeployedFarmers().size());
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
		return new junit.framework.JUnit4TestAdapter(game.FarmingPlayerTest.class);
	}
}
