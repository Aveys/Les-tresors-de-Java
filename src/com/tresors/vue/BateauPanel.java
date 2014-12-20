package com.tresors.vue;

import com.tresors.model.ENavireColor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nicolas Sagon on 25/11/2014.
 */
public class BateauPanel extends JPanel {

    private Image bgImage;
    private ChargePanel[] tabCharge = new ChargePanel[6];



    public BateauPanel(ENavireColor c) {

        super();
        //setSize(220, 428); Test de mise en place dans la vue générale
        File ficImg = new File(c.getUrlImage());
        try {
            bgImage = ImageIO.read(ficImg);
        } catch (IOException e) {
            e.printStackTrace();
        }

        tabCharge[0] = new ChargePanel(ChargePanel.Type.pirate);
        tabCharge[0].setSize(33,71);
        tabCharge[0].setLocation(60,60);
        tabCharge[1] = new ChargePanel(ChargePanel.Type.canon);
        tabCharge[1].setSize(33, 71);
        tabCharge[1].setLocation(125, 60);
        tabCharge[2] = new ChargePanel(ChargePanel.Type.pirate);
        tabCharge[2].setSize(33, 71);
        tabCharge[2].setLocation(37, 140);
        tabCharge[3] = new ChargePanel(ChargePanel.Type.tresor3);
        tabCharge[3].setSize(33, 71);
        tabCharge[3].setLocation(92, 140);
        tabCharge[4] = new ChargePanel(ChargePanel.Type.tresor2);
        tabCharge[4].setSize(33, 71);
        tabCharge[4].setLocation(149, 140);
        tabCharge[5] = new ChargePanel(ChargePanel.Type.tresor1);
        tabCharge[5].setSize(33, 71);
        tabCharge[5].setLocation(95, 320);
        this.setLayout(null);
        this.add(tabCharge[0]);
        this.add(tabCharge[1]);
        this.add(tabCharge[2]);
        this.add(tabCharge[3]);
        this.add(tabCharge[4]);
        this.add(tabCharge[5]);
    }

    public void changeCouleur(ENavireColor c) {

        File ficImg = new File(c.getUrlImage());
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
