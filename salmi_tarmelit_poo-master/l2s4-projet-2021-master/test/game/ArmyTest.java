package game ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArmyTest {

    private Player player;
    private Army army;
    private Army other;
    private PlainCell c1;
    private MontainCell c2;

    /* méthode exécutée avant l'exécution de chacune des méthodes de test */
    @Before
    public void Before() {
      // initialisation des attributs pour chacun des tests
      this.player = new Player("player");
      this.c1 = new PlainCell(0,0);
      this.c2 = new MontainCell(1,1);
      this.army = new Army(this.c1, 3, this.player);
      this.other = new Army(this.c2, 3, this.player);
    }

    @Test
    public void incrementLengthTest(){
      // Précondition : l'armée a une taille de 3 guerriers
      assertEquals(this.army.getLength(),3);
      // Execution de la mèthode testée
      this.army.incrementLength();
      // Résultat : l'armée a une taille de 4 guerriers
      assertEquals(this.army.getLength(),4);
      // Précondition : l'armée a une taille max(5)
      this.army.incrementLength();
      assertEquals(this.army.getLength(),5);
      // Execution de la mèthode testée
      this.army.incrementLength();
      // Résultat : l'armée a toujours la taille max
      assertEquals(this.army.getLength(),5);
    }

    @Test
    public void verifLengthTest(){
      // Execution de la mèthode testée pour une armée sur une case plain
      assertEquals(this.army.getMaxLength(),5);
      // Execution de la mèthode testée pour une armée sur une case montain
      assertEquals(this.other.getMaxLength(),3);
    }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(game.ArmyTest.class);
    }

}
