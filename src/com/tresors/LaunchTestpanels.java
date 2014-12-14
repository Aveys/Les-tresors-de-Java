package com.tresors;

import javax.swing.*;

/**
 * Created by Paul on 14/12/2014.
 */
public class LaunchTestpanels {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        TestJpanels jpanels = new TestJpanels();
    }
}
