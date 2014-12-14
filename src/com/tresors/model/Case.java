package com.tresors.model;

import java.awt.*;
import java.util.NoSuchElementException;

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
    public Case(){ }

    public String toString(){
        return getCoord().toString();
    }

    public void setCoord(Point coord) {
        this.coord = coord;
    }

    public Point getCoord() {
        return coord;
    }

    public static char getTypeCase(Case tmp){
        if (tmp ==null)
            return 'N';
        if(tmp instanceof Mer)
            return 'M';
        else if(tmp instanceof Port)
            return 'P';
        else if (tmp instanceof Repaire)
            return 'R';
        else
            throw new NoSuchElementException();
    }

}
