package com.tresors.event.Navire;

import java.util.EventListener;

/**
 * Created by Paul on 11/12/2014.
 */
public interface INavireNameListener extends EventListener{
    public void nameChanged(NavireNameChangedEvent event);
}
