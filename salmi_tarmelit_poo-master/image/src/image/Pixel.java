package image;

//import GrayColor class
import image.color.GrayColor;

//construct of Pixel
public class Pixel {
    private GrayColor color ;

    /** set color
     * @param color
     */
    public void setColor(GrayColor color) {
        this.color = color;
    }

    /** get Color
     * @return color
     */
    public GrayColor getColor() {
        return this.color;
    }

    //build a pixel with a color
    public Pixel(GrayColor Color){
        this.color = new GrayColor(color.getGrayLevel());
    }

    //equals method
    public boolean equals(Pixel pixel){
        if(pixel instanceof Pixel){
            Pixel newPixel = (Pixel) pixel;
            if(newPixel.getColor() == this.getColor()){
                return true;
            } else return false;
        } else return false;
    }

    /** get integer of a diff between our pixel and a param pixel
     * @param pixel
     * @return value
     */
    public int colorLevelDifference(Pixel pixel){
        return Math.abs(this.getColor().getGrayLevel()-pixel.getColor().getGrayLevel());
    }
}
