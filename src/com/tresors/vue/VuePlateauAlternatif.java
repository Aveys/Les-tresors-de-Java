import com.tresors.controller.ControllerMenu;
import com.tresors.controller.ControllerPlateau;
import com.tresors.model.ENavireColor;
import com.tresors.vue.BateauPanel;
import com.tresors.vue.PlateauPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Paul on 11/12/2014.
 */
public class VuePlateauAlternatif extends JPanel {
    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem menuItemFileSave;
    private JMenuItem menuItemFileLoad;
    private JMenuItem menuItemFileExit;
    private JPanel panelScore;
    private JLabel labelJoueur1;
    private PlateauPanel plateauPanel;
    private BateauPanel bateauPanel;
    private JButton buttonAction1;
    private JButton buttonAction2;
    private JLabel labelAction;
    private JButton buttonPassTour;
    private int nbTour = 0;

    public VuePlateauAlternatif(ControllerPlateau controller) {

        this.setLayout(new GridBagLayout());

        //Panel score
        panelScore = new JPanel();
        panelScore.setLayout(new FlowLayout());
        labelJoueur1 = new JLabel("Joueur 1 : TEST1");
        panelScore.add(labelJoueur1);

        GridBagConstraints constraintsPanelScore = new GridBagConstraints();
        constraintsPanelScore.fill = GridBagConstraints.HORIZONTAL;
        constraintsPanelScore.weighty = 1;
        constraintsPanelScore.weightx = 1;
        constraintsPanelScore.gridx = 0;
        constraintsPanelScore.gridy = 0;
        constraintsPanelScore.anchor = GridBagConstraints.PAGE_START;

        this.add(panelScore, constraintsPanelScore);

        //Panel Plateau
        plateauPanel = new PlateauPanel();
        GridBagConstraints constraintsPanelPlateau = new GridBagConstraints();
        constraintsPanelPlateau.fill = GridBagConstraints.BOTH;
        constraintsPanelPlateau.weighty = 30;
        constraintsPanelPlateau.weightx = 1;
        constraintsPanelPlateau.ipadx = 920;
        constraintsPanelPlateau.gridx = 0;
        constraintsPanelPlateau.gridy = 1;
        constraintsPanelPlateau.anchor = GridBagConstraints.PAGE_START;

        this.add(plateauPanel, constraintsPanelPlateau);


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

        buttonPassTour = new JButton("Passer le tour");
        GridBagConstraints constraintsButtonPassTour = new GridBagConstraints();
        constraintsButtonPassTour.fill = GridBagConstraints.HORIZONTAL;
        constraintsButtonPassTour.weighty = 20;
        constraintsButtonPassTour.weightx = 0.3;
        constraintsButtonPassTour.gridx = 1;
        constraintsButtonPassTour.gridy = 1;
        constraintsButtonPassTour.insets = new Insets(90, 0, 0, 0);
        constraintsButtonPassTour.anchor = GridBagConstraints.PAGE_START;

        buttonPassTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nbTour = (nbTour + 1) % 6;
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
        constraintsBateauPanel.gridx = 1;
        constraintsBateauPanel.gridy = 1;
        constraintsBateauPanel.insets = new Insets(120, 75, 0, 0);
        constraintsBateauPanel.anchor = GridBagConstraints.PAGE_START;

        this.add(labelAction, constraintsLabelAction);
        this.add(buttonAction1, constraintsButtonAction1);
        this.add(buttonAction2, constraintsButtonAction2);
        this.add(buttonPassTour, constraintsButtonPassTour);
        this.add(bateauPanel, constraintsBateauPanel);

    }

    public JPanel getPanelScore() {
        return panelScore;
    }

    public void setPanelScore(JPanel panelScore) {
        this.panelScore = panelScore;
    }

    public JLabel getLabelJoueur1() {
        return labelJoueur1;
    }

    public void setLabelJoueur1(JLabel labelJoueur1) {
        this.labelJoueur1 = labelJoueur1;
    }

    public PlateauPanel getPlateauPanel() {
        return plateauPanel;
    }

    public void setPlateauPanel(PlateauPanel plateauPanel) {
        this.plateauPanel = plateauPanel;
    }

    public BateauPanel getBateauPanel() {
        return bateauPanel;
    }

    public void setBateauPanel(BateauPanel bateauPanel) {
        this.bateauPanel = bateauPanel;
    }

    public JButton getButtonAction1() {
        return buttonAction1;
    }

    public void setButtonAction1(JButton buttonAction1) {
        this.buttonAction1 = buttonAction1;
    }

    public JButton getButtonAction2() {
        return buttonAction2;
    }

    public void setButtonAction2(JButton buttonAction2) {
        this.buttonAction2 = buttonAction2;
    }

    public JLabel getLabelAction() {
        return labelAction;
    }

    public void setLabelAction(JLabel labelAction) {
        this.labelAction = labelAction;
    }

    public JButton getButtonPassTour() {
        return buttonPassTour;
    }

    public void setButtonPassTour(JButton buttonPassTour) {
        this.buttonPassTour = buttonPassTour;
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