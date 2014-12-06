package com.tresors.repair.model;
import java.util.EventListener;

public interface IRepairCanonListener extends EventListener {
    public void canonsChanged(RepairChangeNbCanonEvent event);
    public void canonsDecreased(RepairChangeNbCanonEvent event);
    public void canonsIncreased(RepairChangeNbCanonEvent event);
}