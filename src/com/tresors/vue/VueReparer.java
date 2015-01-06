package com.tresors.vue;

/**
 * Created by Paul on 06/12/2014.
 */


import com.tresors.controller.Controller;
import com.tresors.event.navire.INavireChargeListener;
import com.tresors.event.navire.NavireChargeAddedEvent;
import com.tresors.event.navire.NavireChargeRemovedEvent;
import com.tresors.model.Canon;
import com.tresors.model.Pirate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Nicolas Sagon on 25/11/2014.
 */
public class VueReparer extends JPanel implements INavireChargeListener{
    private JPanel mainPanel;

    private JLabel labelJoueur1;
    private BateauPanel bateauPanel;
    private Controller controller = null;

    private JButton ajouterPirate;
    private JButton ajouterCanon;
    private JButton supprimerPirate;
    private JButton supprimerCanon;
    private JButton quitter;


    public VueReparer(Controller controllerReparer) {

        this.controller = controllerReparer;
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets.top = 100;
        gbc.ipadx = 600;
        gbc.ipady = 800;

        bateauPanel = new BateauPanel( controller.getModel().getListJoueurs().get(controller.getCurrentPlayer()));
        mainPanel.add(bateauPanel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.insets.top = 100;
        gbc.anchor= GridBagConstraints.PAGE_START;
        ajouterPirate = new JButton("Ajouter pirate");

        ajouterPirate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().ajouterPirateRepair();
            }

        });


        mainPanel.add(ajouterPirate, gbc);




        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.insets.top = 150;
        ajouterCanon = new JButton("Ajouter canon");
        ajouterCanon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                getController().ajouterCanonRepair();

            }
        });
        mainPanel.add(ajouterCanon, gbc);


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.insets.top = 200;
        supprimerPirate = new JButton("supprimer pirate");

        supprimerPirate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().supprimerPirateRepair();

            }
        });
        mainPanel.add(supprimerPirate, gbc);



        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.insets.top = 250;
        supprimerCanon = new JButton("supprimer canon");

        supprimerCanon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().supprimerCanonRepair();

            }
        });
        mainPanel.add(supprimerCanon, gbc);


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.insets.top = 300;
        quitter = new JButton("Quitter");

        quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().doStartPlateau();

            }
        });
        mainPanel.add(quitter, gbc);

        this.add(mainPanel);
    }
    public final Controller getController(){
        return controller;
    }

    @Override
    public void chargeAdded(NavireChargeAddedEvent event) {

        if(event.getChargeAdded() instanceof Pirate)
        {
          bateauPanel.addPirate(event.getChargeAdded().getPosition());
        }
        else
        {
            if (event.getChargeAdded() instanceof Canon){
            bateauPanel.addCanon(event.getChargeAdded().getPosition());

            }
            else{
            bateauPanel.addTresore(event.getChargeAdded().getPosition());
            }

        }

    }

    @Override
    public void chargeRemoved(NavireChargeRemovedEvent event) {

      bateauPanel.removeCharge(event.getPosChargeRemoved());
    }
}
