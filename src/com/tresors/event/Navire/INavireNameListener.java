package com.tresors.event.navire;

import java.util.EventListener;

/**
 * Created by Paul on 11/12/2014.
 */
public interface INavireNameListener extends EventListener{
    public void nameChanged(NavireNameChangedEvent event);
}
