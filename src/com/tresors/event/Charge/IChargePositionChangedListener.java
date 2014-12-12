package com.tresors.event.charge;

import java.util.EventListener;

/**
 * An Interface that contains the methods that should be implemented when an Event asks for a modification of the model
 * Created by Paul on 11/12/2014.
 * @author Paul Ribierre
 */
public interface IChargePositionChangedListener extends EventListener {
    public void positionChanged(ChargePositionChangedEvent event);
}
