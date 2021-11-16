package PartB;

import java.awt.*;

public class OnetimeEvent extends Event{


    /**
     * Constructor
     *
     * @param description - description of the event
     * @param year        - year of the event
     * @param month       - month of the event
     * @param day         - day of the event
     */
    public OnetimeEvent(String description, int year, int month, int day) {
        super(description, year, month, day);
    }

    @Override
    public String toString() {
        String retString = getDescription() + "(One time) (id: " + getId() + ")";
        return retString;
    }

    @Override
    public String toFileString() {
        String retStr = "One time " + this.getYear() + this.getMonth() + this.getDay() + this.getDescription();
        return retStr;
    }
}
