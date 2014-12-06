package com.tresors.repair.model;
import java.util.EventListener;

public interface IRepairPirateListener extends EventListener {
    public void piratesChanged(RepairChangeNbPirateEvent event);
    public void piratesDecreased(RepairChangeNbPirateEvent event);
    public void piratesIncreased(RepairChangeNbPirateEvent event);
}