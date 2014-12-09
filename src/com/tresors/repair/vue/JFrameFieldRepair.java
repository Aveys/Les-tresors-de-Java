package com.tresors.repair.vue;

/**
 * Created by Paul on 30/11/2014.
 */

import com.tresors.repair.controller.RepairController;
import com.tresors.repair.model.RepairChangeNbCanonEvent;
import com.tresors.repair.model.RepairChangeNbPirateEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameFieldRepair extends RepairView {

    //Objets awt IHM
    private JFrame frame = null;
    private JPanel contentPane = null;

    private JButton addPirate = null;
    private JButton addCanon = null;
    private JButton delPirate = null;
    private JButton delCanon = null;

    private JLabel pirates = null;
    private JLabel canons = null;

    public JFrameFieldRepair(RepairController controller) {
        this(controller, 3, 3);
    }

    public JFrameFieldRepair(RepairController controller, int nbCanons, int nbPirates){
        super(controller);

        buildFrame(nbCanons, nbPirates);
    }

    private void buildFrame(int nbCanons, int nbPirates) {
        frame = new JFrame();

        contentPane = new JPanel();

        canons = new JLabel(Integer.toString(nbCanons));
        pirates = new JLabel(Integer.toString(nbPirates));

        contentPane.add(canons);
        contentPane.add(pirates);

        addCanon = new JButton("Ajouter un Canon");
        addPirate = new JButton("Ajouter un Pirate");
        delCanon = new JButton("Supprimer un Canon");
        delPirate = new JButton("Supprimer un Pirate");

        ActionListener listenerAddCanon = new ActionListener() {
            public void actionPerformed(ActionEvent e) {getController().notifyCanonsIncreased(Integer.valueOf(canons.getText()) + 1);}
        };
        addCanon.addActionListener(listenerAddCanon);

        ActionListener listenerAddPirate = new ActionListener() {
            public void actionPerformed(ActionEvent e) {getController().notifyPiratesIncreased(Integer.valueOf(pirates.getText()) + 1);}
        };
        addPirate.addActionListener(listenerAddPirate);

        ActionListener listenerDelCanon = new ActionListener() {
            public void actionPerformed(ActionEvent e) {getController().notifyCanonsDecreased(Integer.valueOf(canons.getText()) - 1);}
        };
        delCanon.addActionListener(listenerDelCanon);

        ActionListener listenerDelPirate = new ActionListener() {
            public void actionPerformed(ActionEvent e) {getController().notifyPiratesDecreased(Integer.valueOf(pirates.getText()) - 1);}
        };
        delPirate.addActionListener(listenerDelPirate);

        contentPane.add(addCanon);
        contentPane.add(addPirate);
        contentPane.add(delCanon);
        contentPane.add(delPirate);

        frame.setContentPane(contentPane);
        frame.setTitle("Reparation");
        frame.pack();
    }

    @Override
    public void close() {
        frame.dispose();
    }

    @Override
    public void display() {
        frame.setVisible(true);
    }
    @Override
    public void canonsChanged(RepairChangeNbCanonEvent event) {

    }

    @Override
    public void canonsDecreased(RepairChangeNbCanonEvent event) {
        this.canons.setText(String.valueOf(Integer.valueOf(canons.getText()) - 1));
    }

    @Override
    public void canonsIncreased(RepairChangeNbCanonEvent event) {
        this.canons.setText(String.valueOf(Integer.valueOf(canons.getText()) + 1));
    }

    @Override
    public void piratesChanged(RepairChangeNbPirateEvent event) {

    }

    @Override
    public void piratesDecreased(RepairChangeNbPirateEvent event) {
        this.pirates.setText(String.valueOf(Integer.valueOf(pirates.getText()) - 1));
    }

    @Override
    public void piratesIncreased(RepairChangeNbPirateEvent event) {
        this.pirates.setText(String.valueOf(Integer.valueOf(pirates.getText()) + 1));
    }
}