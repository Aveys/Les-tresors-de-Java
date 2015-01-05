package com.tresors.controller;

import com.tresors.model.Plateau;
import com.tresors.vue.FramePrincipal;
import com.tresors.vue.VueReparer;

/**
 * Created by aurelia on 04/01/2015.
 */
public class ControllerInitNavire extends ControllerReparer {

    //dostartgame
    public ControllerInitNavire(Plateau model, FramePrincipal f, ControllerPrincipal controllerPrincipal) {

                super(model,f,controllerPrincipal, false, 0);

    }


    @Override
    public void doStartPlateau() {//appeler par quitter de la vue maintenance, nous commencons le plateau que qd tt  les bt st init
        if(currentPlayer==(model.getListJoueurs().size()-1)){
            this.controllerPrincipal.doStartPlateau(0,1);
        }
        else{
            currentPlayer ++;
            view = new VueReparer(this);
            framePrincipal.changeView(view);
            addListenersToModel();
        }


    }
}

