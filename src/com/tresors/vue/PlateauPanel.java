package com.tresors.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nicolas Sagon on 25/11/2014.
 */
public class PlateauPanel extends JPanel{

    Image bgImage;

    public PlateauPanel() {

        super();
        setSize(1037, 641);
        File ficImg = new File("res/images/plateauFull.png");
        try {
            bgImage = ImageIO.read(ficImg);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
    }
}
