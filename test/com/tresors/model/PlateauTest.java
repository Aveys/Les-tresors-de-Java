package com.tresors.model;

import org.junit.*;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author arthur veys
 * Test pour la classe {@link Plateau}
 *
 */
public class PlateauTest {

    Plateau pl;
    @Before
    public void initialize(){
        TreeMap<String,String> list = new TreeMap<String, String>();
        list.put("Edward Teach","Noir");
        list.put("Rackam","Rouge");
        list.put("Davy Jones","Vert");
        this.pl = new Plateau();

    }

    @Test
    public void getTypeCaseTest(){
        Assert.assertEquals("Type de case incorrect",'P',pl.getTypeCase(1,1));
    }
    @Test
    public void repaireAleatoireTest(){
        Assert.assertNull(pl.repaireAleatoire());
    }
    @Test
    public void isNoTreasureStartTest(){
        Assert.assertFalse(pl.isNoTreasures());
    }
    @Test
    public void getNavireEmptyCaseTest(){
        Assert.assertEquals(new ArrayList<Navire>(), pl.getNavire(1, 1));
    }

}
