package com.tresors.event;
import java.util.EventListener;

/**
 * An Interface that contains the methods that should be implemented when an Event asks for a modification of the model
 * Created by Paul on 06/12/2014.
 * @author Paul Ribierre
 */
public interface IRepairCanonListener extends EventListener {
    public void canonsChanged(RepairChangeNbCanonEvent event);
    public void canonsDecreased(RepairChangeNbCanonEvent event);
    public void canonsIncreased(RepairChangeNbCanonEvent event);
}