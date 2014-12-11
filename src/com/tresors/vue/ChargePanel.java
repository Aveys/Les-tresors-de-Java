package com.tresors.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nicolas Sagon on 09/12/2014.
 */
public class ChargePanel extends JPanel {

    private Image bgImage;
    private File ficImg;

    public enum Type {
        pirate,
        canon,
        tresor1,
        tresor2,
        tresor3,
        blank
    }

    public ChargePanel(Type t) {

        ficImg = getImage(t);

        try {
            bgImage = ImageIO.read(ficImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setOpaque(false);
        this.repaint();

    }

    public File getImage(Type t){
        File img;
        switch (t) {
            case pirate :
                img = new File("res/images/pirate.png");
                break;
            case canon :
                img = new File("res/images/canon.png");
                break;
            case tresor1 :
                img = new File("res/images/tresor1.png");
                break;
            case tresor2 :
                img = new File("res/images/tresor2.png");
                break;
            case tresor3 :
                img = new File("res/images/tresor3.png");
                break;
            case blank :
                img = new File("res/image/blank.png");
                break;
            default:
                img = new File("res/image/blank.png");
                break;
        }
        return img;
    }


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
    }

    public void changePanelType(Type t) {

        ficImg = this.getImage(t);
        try {
            bgImage = ImageIO.read(ficImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.repaint();

    }


}
