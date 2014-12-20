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
    private int nbTour = 0;
    private Controller controller = null;

    public VuePlateau(Controller controllerPlateau) {

        this.controller = controllerPlateau;
        mainPanel.setBackground(Color.green);
        //Panel score
        panelScore = new JPanel();

        panelScore.setLayout(new FlowLayout());
        panelScore.setBackground(Color.cyan);
        labelJoueur1 = new JLabel(controllerPlateau.getModel().getListJoueurs().get(controllerPlateau.getCurrentPlayer()).toString());
        panelScore.add(labelJoueur1);

        GridBagConstraints constraintsPanelScore = new GridBagConstraints();
        constraintsPanelScore.fill = GridBagConstraints.HORIZONTAL;
        constraintsPanelScore.weighty = 1;
        constraintsPanelScore.weightx = 1;
        constraintsPanelScore.gridx = 0;
        constraintsPanelScore.gridy = 0;
        constraintsPanelScore.anchor = GridBagConstraints.PAGE_START;

        mainPanel.add(panelScore, constraintsPanelScore);

        //Panel Plateau
        plateauPanel = new HexGame(getController().getModel().getPlateau(), 100);
        GridBagConstraints constraintsPanelPlateau = new GridBagConstraints();
        constraintsPanelPlateau.fill = GridBagConstraints.BOTH;
        constraintsPanelPlateau.weighty = 30;
        constraintsPanelPlateau.weightx = 1;
        constraintsPanelPlateau.ipadx = 920;
        constraintsPanelPlateau.ipady = 620;
        constraintsPanelPlateau.gridx = 0;
        constraintsPanelPlateau.gridy = 1;
        constraintsPanelPlateau.anchor = GridBagConstraints.PAGE_START;
        plateauPanel.setBackground(Color.red);
        plateauPanel.setSize(500,800);
        mainPanel.add(plateauPanel, constraintsPanelPlateau);


        //Panel Action
        labelAction = new JLabel("1");
        GridBagConstraints constraintsLabelAction = new GridBagConstraints();
        constraintsLabelAction.weighty = 20;
        constraintsLabelAction.weightx = 0.3;
        constraintsLabelAction.gridx = 1;
        constraintsLabelAction.gridy = 1;
        constraintsLabelAction.insets = new Insets(0, 0, 0, 0);
        constraintsLabelAction.anchor = GridBagConstraints.PAGE_START;

        buttonAction1 = new JButton("Attaquer");
        GridBagConstraints constraintsButtonAction1 = new GridBagConstraints();
        constraintsButtonAction1.fill = GridBagConstraints.HORIZONTAL;
        constraintsButtonAction1.weighty = 20;
        constraintsButtonAction1.weightx = 0.3;
        constraintsButtonAction1.gridx = 1;
        constraintsButtonAction1.gridy = 1;
        constraintsButtonAction1.insets = new Insets(30, 0, 0, 0);
        constraintsButtonAction1.anchor = GridBagConstraints.PAGE_START;

        buttonAction2 = new JButton("Réparer");
        GridBagConstraints constraintsButtonAction2 = new GridBagConstraints();
        constraintsButtonAction2.fill = GridBagConstraints.HORIZONTAL;
        constraintsButtonAction2.weighty = 20;
        constraintsButtonAction2.weightx = 0.3;
        constraintsButtonAction2.gridx = 1;
        constraintsButtonAction2.gridy = 1;
        constraintsButtonAction2.insets = new Insets(60, 0, 0, 0);
        constraintsButtonAction2.anchor = GridBagConstraints.PAGE_START;

        buttonAction3 = new JButton("Se deplacer");
        GridBagConstraints constraintsButtonAction3= new GridBagConstraints();
        constraintsButtonAction3.fill = GridBagConstraints.HORIZONTAL;
        constraintsButtonAction3.weighty = 20;
        constraintsButtonAction3.weightx = 0.3;
        constraintsButtonAction3.gridx = 1;
        constraintsButtonAction3.gridy = 1;
        constraintsButtonAction3.insets = new Insets(90, 0, 0, 0);
        constraintsButtonAction3.anchor = GridBagConstraints.PAGE_START;

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
                nbTour = (nbTour + 1) % getController().getModel().getListJoueurs().size();
                switch (nbTour) {
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

        bateauPanel = new BateauPanel(ENavireColor.Bleu);
        GridBagConstraints constraintsBateauPanel = new GridBagConstraints();
        constraintsBateauPanel.fill = GridBagConstraints.BOTH;
        constraintsBateauPanel.weighty = 20;
        constraintsBateauPanel.weightx = 2;
        constraintsBateauPanel.gridx = 2;
        constraintsBateauPanel.gridy = 1;
        constraintsBateauPanel.insets = new Insets(120, 75, 0, 0);
        constraintsBateauPanel.anchor = GridBagConstraints.PAGE_START;

        mainPanel.add(labelAction, constraintsLabelAction);
        mainPanel.add(buttonAction1, constraintsButtonAction1);
        mainPanel.add(buttonAction2, constraintsButtonAction2);
        mainPanel.add(buttonAction3, constraintsButtonAction3);
        mainPanel.add(buttonPassTour, constraintsButtonPassTour);
        mainPanel.add(bateauPanel, constraintsBateauPanel);

        //add to JFrame
        this.add(mainPanel);

        //Draw joueur :
        Toolkit tk = Toolkit.getDefaultToolkit();
        setSize((int) tk.getScreenSize().getWidth(), (int) tk.getScreenSize().getHeight());
        this.setVisible(true);

    }

    public final Controller getController(){
        return controller;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
