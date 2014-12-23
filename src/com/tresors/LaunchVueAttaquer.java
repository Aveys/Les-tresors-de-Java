package com.tresors;

import com.tresors.vue.VueAttaquer;

import java.awt.*;

/**
 * Created by Nicolas Sagon on 21/12/2014.
 */
public class LaunchVueAttaquer {

    public static void main(String args[]){

        Frame test = new Frame();
        test.add(new VueAttaquer());
        test.setVisible(true);
        test.pack();

    }

}
