package com.tresors.controller;

import com.tresors.model.Plateau;
import com.tresors.vue.FramePrincipal;
import com.tresors.vue.HexGame;
import com.tresors.vue.HexMech;
import com.tresors.vue.VueMenu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nicolas Sagon on 14/12/2014.
 */
public class ControllerHexGame extends Controller {

    private Plateau model;
    private FramePrincipal framePrincipal;
    private JPanel view;
    private ControllerPrincipal controllerPrincipal;

    public ControllerHexGame(Plateau model, FramePrincipal f, ControllerPrincipal controllerPrincipal) {
        this.model = model;
        this.framePrincipal = f;
        this.controllerPrincipal = controllerPrincipal;
        HexMech.setHeight(100);
        HexMech.setBorders(5);
        view = new HexGame(model.getPlateau());
        framePrincipal.changeView(view);
    }
}
