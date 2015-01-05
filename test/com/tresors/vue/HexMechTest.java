package com.tresors.vue;

import junit.framework.Assert;
import org.junit.Test;
import java.awt.Point;

import static org.junit.Assert.*;

public class HexMechTest {

    @Test
    public void testGetPaulCoordinate() throws Exception {
        Assert.assertEquals(new Point(3, 2), HexMech.getPaulCoordinate(4, 2));
        Assert.assertEquals(new Point(1, 6), HexMech.getPaulCoordinate(4, 6));
        Assert.assertEquals(new Point(4,8),HexMech.getPaulCoordinate(8,8));
    }
}