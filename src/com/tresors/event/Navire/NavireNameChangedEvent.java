package com.tresors.event.Navire;

import javax.swing.event.ChangeEvent;

/**
 * Created by Paul on 11/12/2014.
 */
public class NavireNameChangedEvent extends ChangeEvent{
    private String name;
    /**
     * Constructs a ChangeEvent object.
     *
     * @param source the Object that is the source of the event
     *               (typically <code>this</code>)
     */
    public NavireNameChangedEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
