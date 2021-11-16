package PartB;

public class DailyEvent extends Event{
    /**
     * Constructor
     *
     * @param description - description of the event
     */
    public DailyEvent(String description) {
        super(description, 0, 0, 0 );

    }

    @Override
    public String toString() {
        String retString = getDescription() + "(Daily) (id: " + getId() + ")";
        return retString;
    }

    @Override
    public boolean occursOn(int year, int month, int day) {
        year = 0;
        month = 0;
        day = day;
        return true;
    }

    @Override
    public String toFileString() {
        String retStr = "Daily " + getDescription();
        return retStr;
    }
}
