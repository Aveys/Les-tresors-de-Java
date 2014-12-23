package com.tresors.vue;

import com.tresors.model.ENavireColor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nicolas Sagon on 21/12/2014.
 */
public class VueAttaquer extends JPanel{

    private BateauPanel bateau1;
    private BateauPanel bateau2;

    public VueAttaquer() {

        bateau1 = new BateauPanel(ENavireColor.Blanc);
        bateau2 = new BateauPanel(ENavireColor.Bleu);

        this.setLayout(new BorderLayout());

        JPanel contentBateau = new JPanel();
        contentBateau.setLayout(new FlowLayout());

        contentBateau.add(bateau1);
        contentBateau.add(bateau2);

        this.add(contentBateau, BorderLayout.CENTER);

        this.setVisible(true);
        this.repaint();

    }



}
