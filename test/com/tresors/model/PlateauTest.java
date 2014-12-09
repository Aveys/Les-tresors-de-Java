package com.tresors.model;

import org.junit.*;

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
        this.pl = new Plateau(list);

    }

    @Test
    public void getTypeCaseTest(){
        Assert.assertEquals("Type de case incorrect",'P',pl.getTypeCase(1,1));
    }
    @Test
    public void repaireAleatoireTest(){
        Assert.assertNull( pl.repaireAleatoire());

    }
}
