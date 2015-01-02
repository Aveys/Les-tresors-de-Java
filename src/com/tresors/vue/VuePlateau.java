package com.tresors.vue;

import com.tresors.controller.Controller;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Nicolas Sagon on 25/11/2014.
 */
public class VuePlateau extends JPanel {
    private JPanel mainPanel;
    private JPanel panelScore;
    private JLabel labelJoueur1;
    private HexGame plateauPanel;
    private BateauPanel bateauPanel;
    private JButton attackButton;
    private JButton repairButton;
    private JButton moveButton;
    private JLabel labelAction;
    private JButton buttonPassTour;
    private Controller controller = null;


    public VuePlateau(Controller controllerPlateau) {

        this.controller = controllerPlateau;
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        //Panel score
        panelScore = new JPanel();
        labelJoueur1 = new JLabel("C'est le tour de : " + controller.getModel().getListJoueurs().get(controllerPlateau.getCurrentPlayer()).getCapitaine());
        panelScore.add(labelJoueur1);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;

        mainPanel.add(panelScore, gbc);

        //Panel Plateau
        plateauPanel = new HexGame(getController().getModel().getPlateau(), 100, getController().getModel().getListJoueurs());
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 900;
        gbc.ipady = 600;
        gbc.anchor = GridBagConstraints.LINE_START;
        plateauPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getClickedCase(e.getX(),e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        mainPanel.add(plateauPanel, gbc);


        //Panel Action
        labelAction = new JLabel("Etape 1");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 124;
        gbc.ipady = 5;
        gbc.insets = new Insets(0, 10, 0, 10);
        gbc.gridwidth = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.PAGE_START;
        mainPanel.add(labelAction, gbc);

        attackButton = new JButton("Attaquer");
        gbc.insets.top = 30;
        mainPanel.add(attackButton, gbc);


        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                getController().doStartAttaquer();

            }
        });


        repairButton = new JButton("Réparer");
        gbc.insets.top = 60;
        repairButton.setEnabled(false);
        repairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                getController().doStartRepair();

            }
        });
        mainPanel.add(repairButton, gbc);

        moveButton = new JButton("Se deplacer");
        gbc.insets.top = 90;
        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //getController().notifyPlayerMoved(x,y);
            }
        });
        mainPanel.add(moveButton, gbc);

        buttonPassTour = new JButton("Passer le tour");
        gbc.insets.top = 120;
        buttonPassTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().nextStage();
                updateCurrentPlayerName();
                updateStageLabel();
                updateAllowedActions();

                bateauPanel.changeCouleur(getController().getModel().getListJoueurs().get(getController().getCurrentPlayer()).getColor());

               /* switch (getController().getCurrentPlayer()) {
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
                }*/
            }
        });
        mainPanel.add(buttonPassTour, gbc);

        bateauPanel = new BateauPanel(this.getController().getModel().getListJoueurs().get(this.getController().getCurrentPlayer()));
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.top = 160;
        mainPanel.add(bateauPanel, gbc);

        //add to JFrame
        this.add(mainPanel);
    }

    private void updateStageLabel() {
        labelAction.setText("Etape " + Integer.valueOf(controller.getCurrentPlayerStage()).toString());
    }

    private void updateCurrentPlayerName() {
        labelJoueur1.setText("C'est le tour de : " + controller.getModel().getListJoueurs().get(controller.getCurrentPlayer()).getCapitaine());
    }

    public void updateAllowedActions(){
        if (getController().getCurrentPlayerStage() == 1){
            repairButton.setEnabled(false);
            moveButton.setEnabled(true);
        }
        else if (getController().getCurrentPlayerStage() == 2){
            repairButton.setEnabled(true);
            moveButton.setEnabled(false);
        }
    }

    private int getIndexCurrentPlayer() {
        return getController().getCurrentPlayer();
    }

    public final Controller getController(){
        return controller;
    }

    public void getClickedCase(int x, int y){
        System.out.println(HexMech.pxtoHex(x, y).toString());   // Récupération de l'hexagone cliqué et convertir en Case
    }
}
