package com.tresors.vue;

import com.tresors.controller.Controller;
import com.tresors.model.ENavireColor;
import com.tresors.model.Navire;

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
    private Controller controller = null;

    public VueAttaquer(Controller controllerAttaquer) {

        super();
        this.controller=controllerAttaquer;
        bateau1 = new BateauPanel(controller.getModel().getListJoueurs().get(controller.getCurrentPlayer()));
        bateau2 = new BateauPanel(controller.getNavireSelectedAttack());
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
                Navire n =controller.getModel().getListJoueurs().get(controller.getCurrentPlayer());
                int nbCanons=n.getNbCanons();
                int[] tabDe = new int[nbCanons];
                for(int i = 0; i < nbCanons; i++){
                    tabDe[i] = (int) (1 + (Math.random() * (6 - 1)));
                }
                JOptionPane.showMessageDialog(getPanel().getParent(),
                        "Résultat du dé :   " + tabDe);
            }
        });
    }

    public JPanel getPanel(){
        return this;
    }



}
