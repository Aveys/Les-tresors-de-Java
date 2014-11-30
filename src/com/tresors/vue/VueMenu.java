package com.tresors.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Paul on 30/11/2014.
 */
public class VueMenu extends JFrame {
    //Déclaration des objets de la Frame
    private JPanel mainPanel;
    private JPanel panelNewGame;
    //
    private JMenuBar menuBar;

    private JMenu file;

    private JMenuItem menuItemFileExit;
    private JMenuItem menuItemFileLoad;

    private JButton buttonAddPlayer;
    private JButton buttonRemovePlayer;
    private JButton buttonStart;

    /**
     * Constructeur
     */
    public VueMenu(){
        super("Les trésors de Java");

        //Menu :

        menuBar = new JMenuBar();
        file = new JMenu("File");
        menuItemFileLoad = new JMenuItem("Charger une partie");
        menuItemFileExit = new JMenuItem("Quitter");

        file.add(menuItemFileLoad);
        file.add(menuItemFileExit);

        menuItemFileLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO Ajouter routine de chargement d'une partie
            }
        });

        menuItemFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        menuBar.add(file);
        this.setJMenuBar(menuBar);

        mainPanel.setLayout(new GridBagLayout());
        //Panel score
        panelNewGame = new JPanel();
        panelNewGame.setLayout(new FlowLayout());

        GridBagConstraints constraintsPanelScore = new GridBagConstraints();
        constraintsPanelScore.fill = GridBagConstraints.HORIZONTAL;
        constraintsPanelScore.weighty = 1;
        constraintsPanelScore.weightx = 1;
        constraintsPanelScore.gridx = 0;
        constraintsPanelScore.gridy = 0;
        constraintsPanelScore.anchor = GridBagConstraints.PAGE_START;

        mainPanel.add(panelNewGame, constraintsPanelScore);

        //Panel Plateau
        GridBagConstraints constraintsPanelPlateau = new GridBagConstraints();
        constraintsPanelPlateau.fill = GridBagConstraints.BOTH;
        constraintsPanelPlateau.weighty = 30;
        constraintsPanelPlateau.weightx = 1;
        constraintsPanelPlateau.ipadx = 920;
        constraintsPanelPlateau.gridx = 0;
        constraintsPanelPlateau.gridy = 1;
        constraintsPanelPlateau.anchor = GridBagConstraints.PAGE_START;

        //add to JFrame
        this.add(mainPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit tk = Toolkit.getDefaultToolkit();
        setSize((int) tk.getScreenSize().getWidth(), (int) tk.getScreenSize().getHeight());
        this.setVisible(true);
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenu getFile() {
        return file;
    }

    public void setFile(JMenu file) {
        this.file = file;
    }

    public JMenuItem getMenuItemFileLoad() {
        return menuItemFileLoad;
    }

    public void setMenuItemFileLoad(JMenuItem menuItemFileLoad) {
        this.menuItemFileLoad = menuItemFileLoad;
    }

    public JMenuItem getMenuItemFileExit() {
        return menuItemFileExit;
    }

    public void setMenuItemFileExit(JMenuItem menuItemFileExit) {
        this.menuItemFileExit = menuItemFileExit;
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