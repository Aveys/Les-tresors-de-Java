package repair.model;

import javax.swing.event.ChangeEvent;

/**
 * A class that extends ChangeEvent and allows an event to modify the model
 * Created by Paul on 30/11/2014.
 * @author Paul Ribierre
 * @see javax.swing.event.ChangeEvent
 */

public class RepairChangeNbPirateEvent extends ChangeEvent {
    private int newNbPirates;

    public RepairChangeNbPirateEvent(Object source, int newNbPirates){
        super(source);
        this.newNbPirates = newNbPirates;
    }

    public int getNewNbPirates() {
        return newNbPirates;
    }
}
