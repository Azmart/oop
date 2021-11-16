package PartB;

public class MonthlyEvent extends Event{
    /**
     * Constructor
     *
     * @param description - description of the event
     * @param day         - day of the event
     */
    public MonthlyEvent(String description, int day) {
        super(description,0, 0, day);
    }

    @Override
    public String toString() {
        String retString = getDescription() + "(Monthly) (id: " + getId() + ")";
        return retString;
    }

    @Override
    public boolean occursOn(int year, int month, int day) {
        year = 0;
        month = 0;
        return getDay() == day;
    }

    @Override
    public String toFileString() {
        String retStr = "Monthly " + getDay() + getDescription();
        return retStr;
    }
}
