package com.tresors.event.Navire;

import java.util.EventListener;

/**
 * Created by Paul on 11/12/2014.
 */
public interface INavireScoreListener extends EventListener {
    public void scoreChanged(NavireScoreChangedEvent event);
}
