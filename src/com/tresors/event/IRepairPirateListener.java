package com.tresors.event;
import java.util.EventListener;

/**
 * An Interface that contains the methods that should be implemented when an Event asks for a modification of the model
 * Created by Paul on 06/12/2014.
 * @author Paul Ribierre
 */
public interface IRepairPirateListener extends EventListener {
    public void piratesChanged(RepairChangeNbPirateEvent event);
    public void piratesDecreased(RepairChangeNbPirateEvent event);
    public void piratesIncreased(RepairChangeNbPirateEvent event);
}