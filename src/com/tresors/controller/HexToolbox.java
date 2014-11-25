package com.tresors.controller;

import com.tresors.model.Case;
import com.tresors.model.Mer;
import com.tresors.model.Repaire;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by arthurveys on 25/11/14.
 */
public class HexToolbox {


    public static repaireAleatoir
    /**
     * Donne les coordonnées des cases voisines
     * @param source Les coordonnées de départ
     * @return Un tableau de point avec les coordonnées des voisins
     */
    public static ArrayList<Point> detecteVoisins(Point source){
        ArrayList<Point> res = new ArrayList<Point>();
         int neighbors[][]={{+1,  0},{+1, -1},{ 0, -1},{-1,  0},{-1, +1},{ 0, +1}};
        for (int[] calc : neighbors){
            res.add(new Point(source.x+calc[0],source.y+calc[1]));
        }
        return res;
    }

    /**
     *
     * @param hex1
     * @param hex2
     * @return
     */
    public static int distanceHex(Point hex1, Point hex2){
        return ((Math.abs(hex1.y-hex2.x)+ Math.abs(hex1.y-hex2.y))+Math.abs(hex1.x+hex1.y-hex2.x-hex2.y))/2;
    }

    public static boolean estNaviguable(Case[][] plateau, Point p) {
        Case c = plateau[p.x][p.y];
        return !(c instanceof Repaire) && c != null;

    }

}
