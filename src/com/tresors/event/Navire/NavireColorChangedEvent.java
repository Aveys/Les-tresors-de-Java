package com.tresors.event.Navire;

import com.tresors.model.ENavireColor;

import javax.swing.event.ChangeEvent;

/**
 * Created by Paul on 11/12/2014.
 */
public class NavireColorChangedEvent extends ChangeEvent{
    private ENavireColor color;
    /**
     * Constructs a ChangeEvent object.
     *
     * @param source the Object that is the source of the event
     *               (typically <code>this</code>)
     */
    public NavireColorChangedEvent(Object source, ENavireColor color) {
        super(source);
        this.color = color;
    }

    public ENavireColor getColor() {
        return color;
    }
}
