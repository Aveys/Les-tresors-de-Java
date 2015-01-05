package com.tresors.vue;

import com.tresors.model.ENavireColor;
import com.tresors.model.Navire;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nicolas Sagon on 25/11/2014.
 */
public class BateauPanel extends JPanel {

    private Image bgImage;
    private ChargePanel[] tabCharge = new ChargePanel[6];
    private ArrayList<Point> locationList = new ArrayList<Point>();


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

    public BateauPanel(Navire n) {
        super();
        ENavireColor c = n.getColor();
        //setSize(220, 428); Test de mise en place dans la vue générale
        File ficImg = new File(c.getUrlImage());
        try {
            bgImage = ImageIO.read(ficImg);
        } catch (IOException e) {
            e.printStackTrace();
        }




        locationList.add(new Point(60,60));
        locationList.add(new Point(125,60));
        locationList.add(new Point(37,140));
        locationList.add(new Point(92,140));
        locationList.add(new Point(149,140));
        locationList.add(new Point(95,320));
         Point pointTemp;
        String type;
        for (int i = 0; i < 6; i++) {

            type = n.getTypeCharge(i);
            if (type == "Pirate") {

                pointTemp = locationList.get(i);
                tabCharge[i] = new ChargePanel(ChargePanel.Type.pirate);
                tabCharge[i].setSize(33, 71);
                tabCharge[i].setLocation(pointTemp.x, pointTemp.y);

            } else if (type == "Canon") {
                pointTemp = locationList.get(i);
                tabCharge[i] = new ChargePanel(ChargePanel.Type.canon);
                tabCharge[i].setSize(33, 71);
                tabCharge[i].setLocation(pointTemp.x, pointTemp.y);

            } else {tabCharge[i]=null;}
        }




        this.setLayout(null);
        for (int i = 0; i < 6; i++) {
            if(tabCharge[i]!= null)
            {

                this.add(tabCharge[i]);
            }
        }
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

    public void addPirate(int position) {
     // System.out.println("lol");
        Point pointTemp = locationList.get(position);
        tabCharge[position] = new ChargePanel(ChargePanel.Type.pirate);
        tabCharge[position].setSize(33, 71);
        tabCharge[position].setLocation(pointTemp.x, pointTemp.y);

        this.add(tabCharge[position]);
        this.repaint();

    }

    public void addCanon(int position) {

        Point pointTemp = locationList.get(position);
        tabCharge[position] = new ChargePanel(ChargePanel.Type.canon);
        tabCharge[position].setSize(33, 71);
        tabCharge[position].setLocation(pointTemp.x, pointTemp.y);

        this.add(tabCharge[position]);
        this.repaint();
    }

    public void removeCharge(int posChargeRemoved) {
        this.remove(tabCharge[posChargeRemoved]);
        this.repaint();
    }
}
