package com.tresors;

import com.tresors.controller.HexToolbox;
import com.tresors.model.Case;
import com.tresors.model.Plateau;
import com.tresors.model.Repaire;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gael on 15/12/2014.
 */
public class TestDeplacement {


    public static void main(String[] args) {

        Plateau pl = new Plateau();
        Set<Point> s = new HashSet<Point>();
        s = pl.deplacementPossible(new Point(4, 3), 2);
        // les cases navigables a partir  de mon navire.
        for(Point p : s) System.out.println(p+" "+Case.getTypeCase(pl.getPlateau()[p.x][p.y]));
        Case[][] css= pl.getPlateau();
//les cases non navigable
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {

                Case c = css[i][j];
                if( (Case.getTypeCase(c)=='N') ||(Case.getTypeCase(c)=='R') ) System.out.println("[x="+i+",y="+j+"] "+Case.getTypeCase(c));
            }

        }

    }

}
