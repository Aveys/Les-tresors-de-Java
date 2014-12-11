package com.tresors.event;

import java.util.EventListener;

/**
 * Created by Paul on 11/12/2014.
 */
public interface IPositionChangedListener extends EventListener {
    public void positionChanged(ChargePositionChangedEvent event);
}
