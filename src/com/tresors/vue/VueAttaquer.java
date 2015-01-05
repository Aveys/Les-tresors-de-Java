package com.tresors.vue;

import com.tresors.controller.Controller;
import com.tresors.controller.ControllerAttaquer;
import com.tresors.event.navire.INavireChargeListener;
import com.tresors.event.navire.NavireChargeAddedEvent;
import com.tresors.event.navire.NavireChargeRemovedEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Nicolas Sagon on 21/12/2014.
 */
public class VueAttaquer extends JPanel implements INavireChargeListener{

    private BateauPanel bateauAttaquant;
    private BateauPanel bateauAttacked;
    private JButton buttonAttaquer;
    private ControllerAttaquer controller = null;

    private static final int ATTAQUER = 0;
    private static final int RIPOSTER = 1;
    private static final int QUITTER = 2;


    public VueAttaquer(Controller controllerAttaquer) {

        super();
        this.controller=(ControllerAttaquer)controllerAttaquer;
        bateauAttaquant = new BateauPanel(controller.getModel().getListJoueurs().get(controller.getCurrentPlayer()));
        bateauAttacked = new BateauPanel(controller.getNavireSelectedAttack());
        buttonAttaquer = new JButton();
        switch (controller.getStateAttaque()){
            case 0:
                buttonAttaquer.setText("ATTAQUER");
                break;

            case 1:
                buttonAttaquer.setText("RIPOSTER");
                break;

            case 2:
                buttonAttaquer.setText("QUITTER");
                break;

        }
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        bateauAttaquant.setPreferredSize(new Dimension(224, 448));
        bateauAttacked.setPreferredSize(new Dimension(224, 448));
        this.add(bateauAttaquant, gbc);
        this.add(bateauAttacked, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 1;
        gbc.insets.left = 224;
        this.add(buttonAttaquer, gbc);

        buttonAttaquer.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                controller.notifyActionAttaquer();

            }
        });
    }

    public JPanel getPanel(){
        return this;
    }

    @Override
    public void chargeRemoved(NavireChargeRemovedEvent event) {
        switch (controller.getStateAttaque()){
            case 0:
                bateauAttaquant.removeCharge(event.getPosChargeRemoved());
                break;

            case 1:
                bateauAttacked.removeCharge(event.getPosChargeRemoved());
                break;

            default:
                System.out.println(" NavireChargeRemovedEvent non realisable par view");
                break;
        }


    }


    @Override
    public void chargeAdded(NavireChargeAddedEvent event) {

    }
}
