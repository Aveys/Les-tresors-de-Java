package com.tresors.vue;

import com.tresors.model.ENavireColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nicolas Sagon on 21/12/2014.
 */
public class VueAttaquer extends JPanel{

    private BateauPanel bateau1;
    private BateauPanel bateau2;
    private JButton buttonAttaquer;

    public VueAttaquer() {
        super();
        bateau1 = new BateauPanel(ENavireColor.Blanc);
        bateau2 = new BateauPanel(ENavireColor.Bleu);
        buttonAttaquer = new JButton("Attaquer");
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        bateau1.setPreferredSize(new Dimension(224,448));
        bateau2.setPreferredSize(new Dimension(224,448));
        this.add(bateau1, gbc);
        this.add(bateau2, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 1;
        gbc.insets.left = 224;
        this.add(buttonAttaquer, gbc);

        buttonAttaquer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int de1 = (int) (1 + (Math.random() * (6 - 1)));
                JOptionPane.showMessageDialog(getPanel().getParent(),
                        "Résultat du dé :   " + nbRandom);
            }
        });
    }

    public JPanel getPanel(){
        return this;
    }



}
