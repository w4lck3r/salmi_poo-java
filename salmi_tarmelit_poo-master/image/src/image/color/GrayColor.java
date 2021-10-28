package image.color;

import java.util.Objects;

public class GrayColor {
    //instance variable of GrayColor classe

    public static final GrayColor WHITE = new GrayColor(255);
    public static final GrayColor BLACK = new GrayColor(0);

    private int grayLevel ;
    private double alpha ;

    //consruction of GrayColor
    public GrayColor(int Level){
        this.grayLevel = Level ;
        //alpha is always 1
        this.alpha = 1 ;
    }

    //getters of Alpha && GrayLevel
    public int getGrayLevel(){
        return this.grayLevel ;
    }
    public double getAlpha(){
        return this.alpha ;
    }

    //setter of alpha
    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    //equals method
    public boolean equals(Object color){
        if(color instanceof GrayColor){
            GrayColor grayColor = (GrayColor) color;
            if(grayColor.alpha == this.alpha && grayColor.grayLevel == this.grayLevel){
                return true;
            } else return false;
        } else return false;
    }

}
