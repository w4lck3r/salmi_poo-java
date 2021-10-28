package image;
// import Graycolor class
import image.color.GrayColor;

import static image.color.GrayColor.*;

//build of Image class which it's implement ImageInterface
public class Image implements ImageInterface{
    Pixel[][] pixels;
    int width;
    int height;

    //construct of image
    public Image(int x, int y){
        this.width = x;
        this.height = y;
        pixels = new Pixel[x][y];
        for (int column = 0; column < x; column++){
            for (int row = 0; row < y; row++){
                pixels[column][row] = new Pixel(WHITE);
            }
        }
    }
    /** returns Width of the image
     * @return Width of the image
     */
    public int getWidth(){
        return this.width;
    }

    /** returns height of the image
     * @return height of the image
     */
    public int getHeight(){
        return this.height;
    }

    /** get the pixel at coord (x,y) of this image. (0,0) is top left corner pixel.
     * @param x the horizontal coordinate
     * @param y the vertical coordinate
     * @return pixel at coord (x,y) of this image. (0,0) is top left corner pixel.
     * @exception UnknownPixelException if coord (x,y) is not valid for this image
     */
    public Pixel getPixel(int x, int y) throws UnknownPixelException{
        if(pixels[x][y] != null) {
            return pixels[x][y];
        } else throw new UnknownPixelException("unknown pixel at: ("+x+","+y+")!");
    }
    /** change color of pixel(x,y).
     * @param x
     * @param y
     */
    public void changeColorPixel(int x, int y, GrayColor color){
        this.getPixel(x, y).setColor(color);
    }

    /** fill a rectangle with pixels by a wanted color
     * @param x the horizontal coordinate
     * @param y the vertical coordinate
     * @param color the GrayColor
     * @param width
     * @param height
     */
    public void fillRectangle(int x, int y, int width, int height, GrayColor color) {
        for(int currentX = x; currentX < x+width; currentX++){
            for (int currentY = y; currentY < y+height; currentY++){
                pixels[currentX][currentY].setColor(color);
            }
        }
    }

    /** get an edges of our color if she got threshold
     * @param threshold
     * @return resultImage
     */
    public Image edges(int threshold){
        GrayColor black = new GrayColor(0);
        Image resultImage = new Image(this.width, this.height);

        for (int column = 0; column < this.width-1; column++){
            for (int row = 0; row < this.height-1; row++){
                if(this.pixels[column][row].colorLevelDifference(this.pixels[column+1][row]) > threshold
                        || this.pixels[column][row].colorLevelDifference(this.pixels[column][row+1]) > threshold){
                    resultImage.pixels[column][row].setColor(black);
                }
            }
        }
        return resultImage;
    }

    /** get a new version of our color with a nbGrayLevels .
     * @param nbGrayLevels
     * @return resultImage
     */
    public Image decreaseNbGrayLevels(int nbGrayLevels) {
        Image resultImage = new Image(this.width, this.height);
        int t = 256/nbGrayLevels;

        for (int column = 0; column < this.width; column++){
            for (int row = 0; row < this.height; row++){
                int k = Math.floorDiv(pixels[column][row].getColor().getGrayLevel(), t);
                resultImage.pixels[column][row].setColor(new GrayColor(k * t));
            }
        }

        return resultImage;
    }

}
