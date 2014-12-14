package com.tresors;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Paul on 14/12/2014.
 */
public class TestJpanels {
    private JFrame frame;
    private JPanel panel1;
    private JPanel panel2;
    private JButton button;

    public JFrame getFrame() {
        return frame;
    }

    public TestJpanels() {
        try{UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");}
        catch(Exception e){}

        final JFrame frame = new JFrame();
        final JPanel panel1 = new JPanel();
        final JPanel panel2 = new JPanel();
        final JPanel mainPanel = new JPanel();
        JButton button1 = null;
        JButton button2 = null;

        button1 = new JButton("Changer de vue");
        button2 = new JButton("Revenir a 1ere vue");

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(panel1);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(panel2);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        panel1.add(button1);
        panel2.add(button2);

        mainPanel.add(panel1);


        frame.add(mainPanel);

        frame.setVisible(true);
    }
}
