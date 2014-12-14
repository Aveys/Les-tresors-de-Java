package com.tresors.vue;

import com.tresors.controller.ControllerMenu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nicolas Sagon on 14/12/2014.
 */
public class FramePrincipal extends JFrame {

    private JPanel panelTmp = null;

    public FramePrincipal() {

        super();
        Toolkit tk = Toolkit.getDefaultToolkit();
        this.setSize((int) tk.getScreenSize().getWidth(), (int) tk.getScreenSize().getHeight());
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
