package com.tresors.vue;

import com.tresors.HexGame;
import com.tresors.controller.Controller;
import com.tresors.model.ENavireColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nicolas Sagon on 25/11/2014.
 */
public class VuePlateau extends JPanel {
    private JPanel mainPanel;
    private JPanel panelScore;
    private JLabel labelJoueur1;
    private JPanel plateauPanel;
    private BateauPanel bateauPanel;
    private JButton buttonAction1;
    private JButton buttonAction2;
    private JButton buttonAction3;
    private JLabel labelAction;
    private JButton buttonPassTour;
    private Controller controller = null;

    public VuePlateau(Controller controllerPlateau) {

        this.controller = controllerPlateau;
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.green);
        //Panel score
        panelScore = new JPanel();
        panelScore.setLayout(new FlowLayout());
        panelScore.setBackground(Color.cyan);
        labelJoueur1 = new JLabel(controller.getModel().getListJoueurs().get(controllerPlateau.getCurrentPlayer()).getCapitaine());
        panelScore.add(labelJoueur1);

        GridBagConstraints cPanelScore = new GridBagConstraints();
        cPanelScore.fill = GridBagConstraints.HORIZONTAL;
        cPanelScore.weighty = 1;
        cPanelScore.weightx = 1;
        cPanelScore.gridx = 0;
        cPanelScore.gridy = 0;
        cPanelScore.anchor = GridBagConstraints.PAGE_START;

        mainPanel.add(panelScore, cPanelScore);

        //Panel Plateau
        plateauPanel = new HexGame(getController().getModel().getPlateau(), 100);
        GridBagConstraints cPanelPlateau = new GridBagConstraints();
        cPanelPlateau.fill = GridBagConstraints.BOTH;
        cPanelPlateau.weighty = 30;
        cPanelPlateau.weightx = 1;
        cPanelPlateau.ipadx = 920;
        cPanelPlateau.ipady = 620;
        cPanelPlateau.gridx = 0;
        cPanelPlateau.gridy = 1;
        cPanelPlateau.anchor = GridBagConstraints.PAGE_START;
        plateauPanel.setBackground(Color.red);
        plateauPanel.setSize(500,800);
        mainPanel.add(plateauPanel, cPanelPlateau);


        //Panel Action
        labelAction = new JLabel("Etape 1");
        GridBagConstraints cLabelAction = new GridBagConstraints();
        cLabelAction.weighty = 20;
        cLabelAction.weightx = 0.3;
        cLabelAction.gridx = 1;
        cLabelAction.gridy = 1;
        cLabelAction.insets = new Insets(0, 0, 0, 0);
        cLabelAction.anchor = GridBagConstraints.PAGE_START;
        mainPanel.add(labelAction, cLabelAction);

        buttonAction1 = new JButton("Attaquer");
        GridBagConstraints cButtonAction1 = new GridBagConstraints();
        cButtonAction1.fill = GridBagConstraints.HORIZONTAL;
        cButtonAction1.weighty = 20;
        cButtonAction1.weightx = 0.3;
        cButtonAction1.gridx = 1;
        cButtonAction1.gridy = 1;
        cButtonAction1.insets = new Insets(30, 0, 0, 0);
        cButtonAction1.anchor = GridBagConstraints.PAGE_START;
        mainPanel.add(buttonAction1, cButtonAction1);

        buttonAction2 = new JButton("Réparer");
        GridBagConstraints constraintsButtonAction2 = new GridBagConstraints();
        constraintsButtonAction2.fill = GridBagConstraints.HORIZONTAL;
        constraintsButtonAction2.weighty = 20;
        constraintsButtonAction2.weightx = 0.3;
        constraintsButtonAction2.gridx = 1;
        constraintsButtonAction2.gridy = 1;
        constraintsButtonAction2.insets = new Insets(60, 0, 0, 0);
        constraintsButtonAction2.anchor = GridBagConstraints.PAGE_START;
        mainPanel.add(buttonAction2, constraintsButtonAction2);

        buttonAction3 = new JButton("Se deplacer");
        GridBagConstraints constraintsButtonAction3= new GridBagConstraints();
        constraintsButtonAction3.fill = GridBagConstraints.HORIZONTAL;
        constraintsButtonAction3.weighty = 20;
        constraintsButtonAction3.weightx = 0.3;
        constraintsButtonAction3.gridx = 1;
        constraintsButtonAction3.gridy = 1;
        constraintsButtonAction3.insets = new Insets(90, 0, 0, 0);
        constraintsButtonAction3.anchor = GridBagConstraints.PAGE_START;
        mainPanel.add(buttonAction3, constraintsButtonAction3);

        buttonPassTour = new JButton("Passer le tour");
        GridBagConstraints constraintsButtonPassTour = new GridBagConstraints();
        constraintsButtonPassTour.fill = GridBagConstraints.HORIZONTAL;
        constraintsButtonPassTour.weighty = 20;
        constraintsButtonPassTour.weightx = 0.3;
        constraintsButtonPassTour.gridx = 1;
        constraintsButtonPassTour.gridy = 1;
        constraintsButtonPassTour.insets = new Insets(120, 0, 0, 0);
        constraintsButtonPassTour.anchor = GridBagConstraints.PAGE_START;
        buttonPassTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().nextStage();
                updateCurrentPlayerName();
                updateStageLabel();
                switch (getController().getCurrentPlayer()) {
                    case 0:
                        bateauPanel.changeCouleur(ENavireColor.Bleu);
                        break;
                    case 1:
                        bateauPanel.changeCouleur(ENavireColor.Violet);
                        break;
                    case 2:
                        bateauPanel.changeCouleur(ENavireColor.Jaune);
                        break;
                    case 3:
                        bateauPanel.changeCouleur(ENavireColor.Orange);
                        break;
                    case 4:
                        bateauPanel.changeCouleur(ENavireColor.Rouge);
                        break;
                    case 5:
                        bateauPanel.changeCouleur(ENavireColor.Blanc);
                        break;
                }
            }
        });
        mainPanel.add(buttonPassTour, constraintsButtonPassTour);

        bateauPanel = new BateauPanel(ENavireColor.Bleu);
        GridBagConstraints constraintsBateauPanel = new GridBagConstraints();
        constraintsBateauPanel.fill = GridBagConstraints.BOTH;
        constraintsBateauPanel.weighty = 20;
        constraintsBateauPanel.weightx = 2;
        constraintsBateauPanel.gridx = 2;
        constraintsBateauPanel.gridy = 1;
        constraintsBateauPanel.insets = new Insets(120, 75, 0, 0);
        constraintsBateauPanel.anchor = GridBagConstraints.PAGE_START;
        mainPanel.add(bateauPanel, constraintsBateauPanel);

        //add to JFrame
        this.add(mainPanel);
    }

    private void updateStageLabel() {
        labelAction.setText("Etape " + Integer.valueOf(controller.getCurrentPlayerStage()).toString());
    }

    private void updateCurrentPlayerName() {
        labelJoueur1.setText(controller.getModel().getListJoueurs().get(controller.getCurrentPlayer()).getCapitaine());
    }

    private int getIndexCurrentPlayer() {
        return getController().getCurrentPlayer();
    }

    public final Controller getController(){
        return controller;
    }

}
