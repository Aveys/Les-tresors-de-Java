package com.tresors.event.navire;

import java.util.EventListener;

/**
 * Created by Paul on 11/12/2014.
 */
public interface INavirePositionListener extends EventListener {
    public void positionChanged(NavirePositionChangedEvent event);
}
