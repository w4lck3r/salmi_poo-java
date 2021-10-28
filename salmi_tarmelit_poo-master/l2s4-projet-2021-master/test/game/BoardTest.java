package game ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private static int nbCells=3;
    private Board board;

    /* méthode exécutée avant l'exécution de chacune des méthodes de test */
    @Before
    public void Before() {
      // initialisation des attributs pour chacun des tests
      this.board = new Board(nbCells);
    }

    @Test
    public void randomCellTest(){
      // Précondition : une case de type ocean
      Cell c = this.board.getCell(0, 0);
      assertTrue(c instanceof OceanCell);
      // Execution de la mèthode testée
      this.board.randomCell(0, 0);
      c = this.board.getCell(0, 0);
      // Résultat : la case n'est plus de type ocean mais d'un type alèatoire
      assertTrue((c instanceof DesertCell)||(c instanceof MontainCell)||(c instanceof PlainCell)||(c instanceof ForestCell));
    }

    @Test
    public void checkCellAroundTest(){
      // Précondition : une case qui n'q que des cases ocean autour
      assertFalse(this.board.checkCellAround(1, 1));
      // Ajout d'une case qui n'est pas de type ocean
      this.board.randomCell(1, 0);
      // Résultat : le predicat reconnais qu'ue case autour n'est plus de type ocean
      assertTrue(this.board.checkCellAround(1, 1));
    }

    @Test
    public void earthCellLessTest(){
      // Précondition : la variable earthCell vaut 1/3 du nombre de case
      assertEquals(this.board.getEarthCell(),3);
      // Execution de la mèthode testée
      this.board.earthCellLess();
      // Résultat : la variable earthCell a diminuer de 1
      assertEquals(this.board.getEarthCell(),2);
      // Execution de la mèthode testée
      this.board.earthCellLess();
      this.board.earthCellLess();
      this.board.earthCellLess();
      this.board.earthCellLess();
      this.board.earthCellLess();
      // Résultat : la variable earthCell ne peut pas aller en dessous de 0
      assertEquals(this.board.getEarthCell(),0);
    }

    @Test
    public void initBoardTest(){
      // Précondition : toutes les cases sont de types ocean
      for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
          assertTrue(this.board.getCell(i,j) instanceof OceanCell);
        }
      }
      // Execution de la mèthode testée
      this.board.initBoard();
      // Résultat : 1/3 des cases sont pas de type ocean
      int ocean = 0;
      int pas_ocean = 0;
      for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
          if(this.board.getCell(i,j) instanceof OceanCell){
            ocean++;
          }
          else{
            pas_ocean++;
          }
        }
      }
      assertEquals(ocean,6);
      assertEquals(pas_ocean,3);
    }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(game.BoardTest.class);
    }
}
