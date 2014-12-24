package com.tresors.event.navire;

import javax.swing.event.ChangeEvent;

/**
 * Created by Paul on 11/12/2014.
 */
public class NavireScoreChangedEvent extends ChangeEvent {
    private int score;
    /**
     * Constructs a ChangeEvent object.
     *
     * @param source the Object that is the source of the event
     *               (typically <code>this</code>)
     */
    public NavireScoreChangedEvent(Object source, int score) {
        super(source);
        this.score = score;
    }

    public int getScore(){
        return score;
    }
}
