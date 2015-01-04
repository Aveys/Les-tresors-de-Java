package com.tresors.vue;

import com.tresors.model.ENavireColor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nicolas Sagon on 02/01/2015.
 */
public class BateauAffichagePanel extends JPanel {

    int x = 0;
    int y = 0;
    Boolean visible = false;


    public BateauAffichagePanel(ENavireColor color, Boolean visible){

        this.setSize(10, 10);
        this.setBackground(color.getCouleur());
        this.changeVisibility(visible);
        this.repaint();
    }

    public void changePosition(Point p){

        this.x = (int) p.getX();
        this.y = (int) p.getY();
        this.setLocation(p);
        this.repaint();

    }

    public void changeVisibility(Boolean visible){
        this.visible = visible;
        this.setVisible(this.visible);
    }

}



