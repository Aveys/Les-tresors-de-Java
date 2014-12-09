package com.tresors.controller;

import com.tresors.model.Case;
import org.junit.*;

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


}
