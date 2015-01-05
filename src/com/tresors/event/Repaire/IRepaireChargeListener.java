package com.tresors.event.Repaire;

import java.util.EventListener;

/**
 * Created by aurelia on 05/01/2015.
 */
public interface IRepaireChargeListener extends EventListener {
    public void chargeAdded(RepaireChargeAddedEvent event);
    public void chargeRemoved(RepaireChargeRemoveEvent event);
}
