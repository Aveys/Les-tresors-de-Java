package com.tresors.event.Navire;

import java.util.EventListener;

/**
 * Created by Paul on 11/12/2014.
 */
public interface INavireChargeListener extends EventListener{
    public void chargeAdded(NavireChargeAddedEvent event);
    public void chargeRemoved(NavireChargeRemovedEvent event);
}
