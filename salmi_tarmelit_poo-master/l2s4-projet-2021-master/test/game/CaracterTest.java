package game ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CaracterTest {

    private Player player;
    private Caracter carac;
    private PlainCell c1;
    private ForestCell c2;

    /* méthode exécutée avant l'exécution de chacune des méthodes de test */
    @Before
    public void Before() {
      // initialisation des attributs pour chacun des tests
      this.player = new Player("player");
      this.c1 = new PlainCell(0,0);
      this.c2 = new ForestCell(1,1);
      this.carac = new Caracter(this.c1, this.player);
    }

    @Test
    public void addGoldTest(){
      // Précondition : le personnage n'a pas d'or
      assertEquals(this.carac.getGold(),0);
      // Execution de la mèthode testée
      this.carac.addGold(17);
      // Résultat : le personnage a 17 d'or
      assertEquals(this.carac.getGold(),17);
    }

    @Test
    public void verifCellTest(){
      // Execution de la mèthode testée
      assertTrue(this.carac.verifCell(this.c1));
      // Ajout d'un joueur sur la case
      this.c1.setPlayer(this.player);
      // Execution de la mèthode testée, la case n'est plus libre
      assertFalse(this.carac.verifCell(this.c1));
    }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(game.CaracterTest.class);
    }

}
