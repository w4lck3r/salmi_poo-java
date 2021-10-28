import static org.junit.Assert.*;
import org.junit.Test;

import image.util.*;
import image.*;
import image.color.*;

public class ImageTest{

    /**
     * check that the weight and height both match the given params at creation 
     */
    @Test
	public void returnWidthTest() {
            Image image = new Image(420, 360);
            assertEquals(image.getWidth(), 420);
    }

    /**
     * check that height matchs the given params at creation 
     */
    @Test
	public void returnHeightTest() {
            Image image = new Image(420, 360);
            assertEquals(image.getHeight(), 360);
    }

    /**
     * check that pixels are all white at creation
     */
    @Test
	public void returnPixelColorTest() {
            Image image = new Image(420, 360);      
            for(int x = 0; x < 420; x++){
                for( int y = 0; y < 360; y++){
                    assertEquals(image.getPixel(x, y).getColor(), GrayColor.WHITE);
                }
            }
    }

    /**
     * check that fillRectangle fills with white color 
     */
    @Test
	public void fillRectangleTest() {
            Image image = new Image(420, 360);
            image.fillRectangle(5, 5, 50, 50, GrayColor.WHITE);
            for(int x = 5; x < 55; x++){
                for( int y = 5; y < 55; y++){
                    assertEquals(image.getPixel(x, y).getColor(), GrayColor.WHITE);
                }
            }
    }

    /**
     * check that changeColorPixel method is working
     */
    @Test
	public void changeColorPixelTest() {
            Image image = new Image(420, 360);
            image.getPixel(0, 0).setColor(GrayColor.BLACK);
            assertEquals(image.getPixel(0, 0).getColor(), GrayColor.BLACK);
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(ImageTest.class);
    }

}