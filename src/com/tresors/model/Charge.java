package com.tresors.model;

/**
 * Created by arthurveys on 21/11/14.
 * Projet java ${PROJECT}
 */
public abstract class Charge {
    int position;

    public Charge(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
