package com.tresors.vue;

import com.sun.xml.internal.ws.policy.AssertionSet;
import com.tresors.model.Plateau;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Test les hexagons (WIP)
 */
public class HexGameTest {

    @Before
    public void setUp() throws Exception {
        HexMech.setHeight(100);
        HexMech.setBorders(5);
        ArrayList<String> list = new ArrayList<String>();
        list.add("Edward Teach");
        list.add("Rackam");
        list.add("Davy Jones");
        Plateau pl = new Plateau();
        HexGame hg = new HexGame(pl.getPlateau(),100,null);
    }

    @Test
    public void testGetCasePaulCoordinate() throws Exception {
        Assert.assertTrue(true);
    }
}