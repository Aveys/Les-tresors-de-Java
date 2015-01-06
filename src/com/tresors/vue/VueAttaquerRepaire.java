package com.tresors.vue;

import com.tresors.controller.Controller;
import com.tresors.controller.ControllerAttaquerRepaire;
import com.tresors.event.Repaire.IRepaireChargeListener;
import com.tresors.event.Repaire.RepaireChargeAddedEvent;
import com.tresors.event.Repaire.RepaireChargeRemoveEvent;
import com.tresors.model.Canon;
import com.tresors.model.Charge;
import com.tresors.model.Pirate;
import com.tresors.model.Repaire;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

/**
 * Created by aurelia on 05/01/2015.
 */
public class VueAttaquerRepaire extends JPanel implements IRepaireChargeListener{

    private BateauPanel bateauAttaquant;
    private Repaire repaireAttaquer;
    private JLabel repairePirates;
    private JLabel repaireCannons;
    private JLabel repaireTresore;
    private JButton buttonAttaquer;
    private ControllerAttaquerRepaire controller = null;

    private static final int ATTAQUER = 0;
    private static final int RIPOSTER = 1;
    private static final int QUITTER = 2;


    public VueAttaquerRepaire(Controller controllerAttaquerRepaire) {

        super();
        this.controller=(ControllerAttaquerRepaire)controllerAttaquerRepaire;
        bateauAttaquant = new BateauPanel(controller.getModel().getListJoueurs().get(controller.getCurrentPlayer()));
        repaireAttaquer = controller.getRepaireSelectedAttack();
        buttonAttaquer = new JButton();
        repairePirates = new JLabel();
        repaireCannons = new JLabel();
        repaireTresore = new JLabel();
        repaireTresore.setText("Tresore : "+Integer.toString(controller.getRepaireSelectedAttack().getMontantTresors()));
        System.out.print(repaireAttaquer.getNbCanons());
        System.out.print(repaireAttaquer.getNbPirates());

        String  strTempPirate = "";
        String strTempCanons = "";
        for(Charge c :repaireAttaquer.getCharges()){
            if( c instanceof Pirate){
                strTempPirate = strTempPirate.concat(Integer.toString(c.getPosition())).concat("; ") ;
            }
            if( c instanceof Canon){
                strTempCanons = strTempCanons.concat(Integer.toString(c.getPosition())).concat("; ") ;
            }
        }
        repairePirates.setText("Positions Pirates : "+strTempPirate);
        repaireCannons.setText("Positions Canons : "+strTempCanons);
//INIT JLAB
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
        repairePirates.setPreferredSize(new Dimension(200,50));
        repaireCannons.setPreferredSize(new Dimension(200,50));
        repaireTresore.setPreferredSize(new Dimension(200,50));

        //gbc.insets.top = 30;
        this.add(bateauAttaquant, gbc);
        //gbc.insets.top = 50;
        this.add(repaireCannons, gbc);
        //gbc.insets.top = 120;
        this.add(repaireTresore, gbc);
        //gbc.insets.top = 220;
        this.add(repairePirates, gbc);
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
    public void chargeRemoved(com.tresors.event.Repaire.RepaireChargeRemoveEvent event) {
        switch (controller.getStateAttaque()){
            case 0:
                bateauAttaquant.removeCharge(event.getPosChargeRemoved());
                break;

            case 1://repaint ???

                //controller.getRepaireSelectedAttack().supprimerEmplacement(event.getPosChargeRemoved());

                repaireAttaquer = controller.getRepaireSelectedAttack();

                repairePirates = new JLabel();
                repairePirates.setText("Positions Pirates :");
                repaireCannons = new JLabel();
                repaireCannons.setText("Positions Cannon :");
                repaireTresore = new JLabel();
                repaireTresore.setText(Integer.toString(controller.getRepaireSelectedAttack().getMontantTresors()));

                for(Charge c :repaireAttaquer.getCharges()){
                    if( c instanceof Pirate){
                        repairePirates.setText(repairePirates.getText()+"; "+Integer.toString(c.getPosition()));
                    }
                    if( c instanceof Canon){
                        repaireCannons.setText(repairePirates.getText()+"; "+Integer.toString(c.getPosition()));
                    }
                }
                break;

            default:
                System.out.println(" NavireChargeRemovedEvent non realisable par view");
                break;
        }


    }


    @Override
    public void chargeAdded(com.tresors.event.Repaire.RepaireChargeAddedEvent event) {

    }
}
