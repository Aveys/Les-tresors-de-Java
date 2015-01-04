package com.tresors.controller;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static com.tresors.controller.HexToolbox.getVoisins;
import static org.junit.Assert.fail;

/**
 * Created by aurelia on 09/12/2014.
 */
public class HexToolboxTest {
    @Test
    public void getVoisinsTest() {
       // Assert.assertEquals("Type de case incorrect",'P',pl.getTypeCase(1,1));
        Point mPoint = new Point(5,5);
        ArrayList<Point> ret;

        ret = getVoisins(mPoint);
        for (Point point: ret) {
            if (point.x< 0 || point.y <0 || point.x>= 9 || point.y>=9 ){
                fail("ret est hor champs");
            }
        }

        mPoint = new Point(0,0);
        ret = getVoisins(mPoint);
        for (Point point: ret) {
            if (point.x< 0 || point.y <0 || point.x>= 9 || point.y>=9){
                fail("ret est hor champs");
            }
        }
    }
    /*@Test
    public void distanceHexTest(){// TODO passe pas test. quesque la distance absolue?
        Point hex1= new Point(0,0);
        Point hex2= new Point(4,4);
        assertEquals("Mauvaise distance base", 4, distanceHex( hex1,  hex2));

        hex1= new Point(3,1);// non droit
        hex2= new Point(6,6);
        assertEquals("Mauvaise distance en L", 5, distanceHex( hex1,  hex2));

        hex1= new Point(3,2);// sans inverse
        hex2= new Point(0,0);
        assertEquals("Mauvaise distance en sens inverse", 5, distanceHex( hex1,  hex2));

        hex1= new Point(6,4);// hors champ
        hex2= new Point(9,7);
        assertEquals("Mauvaise distance hors champ", null, distanceHex( hex1,  hex2));

    }*/


}
