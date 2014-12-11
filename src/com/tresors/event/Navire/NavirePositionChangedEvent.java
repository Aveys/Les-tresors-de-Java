package com.tresors.event.navire;

import javax.swing.event.ChangeEvent;
import java.awt.*;

/**
 * Created by Paul on 11/12/2014.
 */
public class NavirePositionChangedEvent extends ChangeEvent{
    private Point position;

    public NavirePositionChangedEvent(Object source, Point newPosition){
        super(source);
        this.position = newPosition;
    }

    public Point getPosition() {
        return position;
    }
}
