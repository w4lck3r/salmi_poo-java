package image;

import image.util.*;
import image.color.*;

// a modifier

public class ImageMain {

    private static final String LAMP_IMAGE = "/images/lamp.pgm";
    private static final String CAT_IMAGE = "/images/chat.pgm";

    public static void main(String[] args) {

        // utilisation de ImageLoader pour créer des objets Image à partir d'un fichier au format PGM
        Image lampImg = ImageLoader.loadPGM(LAMP_IMAGE);
        Image catImg = ImageLoader.loadPGM(CAT_IMAGE);

        // création d'un objet qui permet d'afficher les images
        ImageDisplayer displayer = new ImageDisplayer();
        // affichages des deux images
        displayer.display(lampImg, "Lamp", 100, 100);
        displayer.display(catImg, "Chat", 450, 100);

        //création d'une image
        Image newImage = new Image(200, 150);
        //initialisation du GrayColor comme un couleur noir
        GrayColor blackColor = new GrayColor(0);
        //créer une image avec un couleur noir
        newImage.fillRectangle(20, 30, 30, 50, blackColor);

        GrayColor greyColor = new GrayColor(128);
        newImage.fillRectangle(50, 100, 40, 40, greyColor);

        GrayColor gayColor = new GrayColor(200);
        newImage.fillRectangle(90, 20, 70, 50, gayColor);

        // affichages de newImage
        displayer.display(newImage, "rectangles", 100, 100);
        // affichages de l'edges de catImage
        displayer.display(catImg.edges(20), "edges", 100, 100);

        // affichages de catImage avec deux nombre de GrayColor
        displayer.display(catImg.decreaseNbGrayLevels(2), "B&W", 100, 100);

        //prendre 'image par l'arg du main
        Image passedImage = ImageLoader.loadPGM(args[0]);
        //afficher l'image
        displayer.display(passedImage.edges(Integer.parseInt(args[1])).decreaseNbGrayLevels(Integer.parseInt(args[2])), "Image", 100, 100);

    }

}
