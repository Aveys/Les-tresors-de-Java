package com.tresors.model;

import java.awt.*;

/**
 * Created by arthurveys on 21/11/14.
 * Projet java ${PROJECT}
 */
public abstract class Case {

    private Point coord= new Point();

    public Case(Point point) {
        this.coord = point;
    }
    public Case(int x, int y) {
        this.coord = new Point(x,y);
    }
}
