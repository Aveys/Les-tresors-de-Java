package com.tresors.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nicolas Sagon on 25/11/2014.
 */
public class BateauPanel extends JPanel {

    private Image bgImage;

    public enum Couleur {
        Bleu,
        Orange,
        Violet,
        Jaune,
        Rouge,
        Blanc
    }

    public String getUrlImage(Couleur c){

        String url = "";

        switch (c){
           case Bleu :
               url = "res/images/bateauBleu.png";
                break;

            case Orange :
                url = "res/images/bateauOrange.png";
                break;

            case Violet :
                url = "res/images/bateauViolet.png";
                break;

            case Jaune :
                url = "res/images/bateauJaune.png";
                break;

            case Rouge :
                url = "res/images/bateauRouge.png";
                break;

            case Blanc :
                url = "res/images/bateauBlanc.png";
                break;

        }

        return url;
    }

    public BateauPanel(Couleur c) {

        super();
        setSize(220, 428);
        File ficImg = new File(this.getUrlImage(c));
        try {
            bgImage = ImageIO.read(ficImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeCouleur(Couleur c) {

        File ficImg = new File(this.getUrlImage(c));
        try {
            bgImage = ImageIO.read(ficImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
    }
}
