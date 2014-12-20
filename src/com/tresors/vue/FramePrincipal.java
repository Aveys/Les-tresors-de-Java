package com.tresors.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nicolas Sagon on 14/12/2014.
 */
public class FramePrincipal extends JFrame {
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem menuItemFileSave;
    private JMenuItem menuItemFileLoad;
    private JMenuItem menuItemFileExit;
    private JPanel panelTmp = null;

    public FramePrincipal() {
        super("Les trésors de Java");

        //Menu :

        menuBar = new JMenuBar();
        file = new JMenu("File");
        menuItemFileSave = new JMenuItem("Sauvegarder");
        menuItemFileLoad = new JMenuItem("Charger");
        menuItemFileExit = new JMenuItem("Quitter");

        file.add(menuItemFileSave);
        file.add(menuItemFileLoad);
        file.add(menuItemFileExit);

        menuItemFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        menuBar.add(file);
        this.setJMenuBar(menuBar);

        //Main panel
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(800,600));
        this.setVisible(true);

    }

    public void changeView(JPanel view){
        if (panelTmp != null)
            this.remove(panelTmp);
        panelTmp = view;
        this.add(view);
        this.setVisible(true);
    }

}
