package com.tresors.vue;

import com.tresors.model.ENavireColor;

import javax.swing.*;

/**
 * Created by Nicolas Sagon on 02/01/2015.
 */
public class BateauAffichagePanel extends JPanel {

    public BateauAffichagePanel(ENavireColor color){

        this.setSize(10,10);
        this.setBackground(color.getCouleur());
        this.repaint();
    }

}



