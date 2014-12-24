package com.tresors.event.navire;

import java.util.EventListener;

/**
 * Created by Paul on 11/12/2014.
 */
public interface INavireColorListener extends EventListener{
    public void colorChanged(NavireColorChangedEvent event);
}
