package PartB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

//write comments for your class and methods

public class ScheduleBook {

    private List<Event> aList;

    public ScheduleBook() {

        aList = new ArrayList<>();
    }

    public static void main(String[] args) throws Exception {
        new ScheduleBook().runApp();

    }

    public void runApp() throws Exception {
        Scanner in = new Scanner(System.in);
        int option = 0;
        int year = 0, month = 0, day = 0;
        do {
            System.out.println("1: Load events from file");
            System.out.println("2: Save events to file");
            System.out.println("3: Show events");
            System.out.println("4: Add events");
            System.out.println("5: Remove event");
            System.out.println("6: Quit");
            System.out.print("\n");
            System.out.print("Option: ");
            String choice = in.next();
            option = Integer.parseInt(choice);

            switch (option) {
                case 1: System.out.print("Enter input filename: ");
                        String filename = in.next();
                        loadEvents(filename);break;

                case 2: System.out.println("Enter output filename: ");
                        String outFilename = in.nextLine();
                        saveEvents(outFilename); break;

                case 3: System.out.print("Enter the date(YYYY MM DD): ");
                        String yearIs = in.next();
                        String monthIs = in.next();
                        String dayIs = in.next();
                        year = Integer.parseInt(yearIs);
                        month = Integer.parseInt(monthIs);
                        day = Integer.parseInt(dayIs);
                        printEventsOn(year, month, day); break;

                case 4: addEvent(in); break;

                case 5: System.out.println("Enter event id");
                        String id = in.next();
                        removeEvent(Integer.parseInt(id)); break;

                case 6: break;
            }
        } while (option != 6);
        System.out.println("Bye ~");
    }

    public void saveEvents(String filename) throws Exception {
        FileWriter myWrite = new FileWriter(filename);
        myWrite.write(toFileString());
        myWrite.close();

    }

    private String toFileString() {
        return "B";
    }

    public int loadEvents(String filename) throws Exception {
        int count  = 0;
        String description = null, eventType;
        int year = 0, month = 0, day = 0;
        try {
            File objectMy = new File(filename);
            Scanner myRead = new Scanner(objectMy);
            while (myRead.hasNextLine()) {
                String fileData = myRead.nextLine();
                String[] token = fileData.split("\\s+");

                eventType = token[0] ;
                description = token[token.length-2] + " " + token[token.length-1] ;

                if (token.length == 4){
                    day = Integer.parseInt(token[1]) ;
                }
                if(token.length ==6){
                    year = Integer.parseInt(token[1]);
                    month = Integer.parseInt(token[2]);
                    day = Integer.parseInt(token[3]);
                }

                switch (token.length) {
                    case 3: Event toLoad1 = new Event(description, 0, 0, 0);
                            aList.add(toLoad1); break;
                    case 4: Event toLoad2 = new Event(description, 0, 0, day);
                            aList.add(toLoad2); break;
                    case 6: Event toLoad3 = new Event(description, year, month, day);
                            aList.add(toLoad3); break;
                }

                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(count + " event(s) successfully read.");
        return count;
    }

    public void addEvent(Scanner in) {
        System.out.println("Event type (onetime, daily or monthly) : ");
        String eventType = in.next();

        int year = 0;
        int month = 0;
        int day = 0;

        if (eventType.equals("onetime")) {
            System.out.println("Enter the data(YYYY MM DD): ");
            String[] descrip = in.next().split("\\s+");
            for (int i = 0; i <descrip.length; i++) {
                if (i == 0){
                    year = Integer.parseInt(descrip[i]) ;
                }
                if (i == 1){
                    month = Integer.parseInt(descrip[i]) ;
                }
                if (i == 2){
                    day = Integer.parseInt(descrip[i]) ;
                }

            }
        }
        else if(eventType.equals("monthly")) {
            System.out.println("Enter day of the month: ");
            String dayOfMonth = in.next();
            month = Integer.parseInt(dayOfMonth);
        }

        System.out.println("Enter description: ");
        String descrip = in.next();

        Event addNewEvent = new Event(descrip, year, month, day);
        aList.add(addNewEvent);

    }

    public void removeEvent(int id) {
        aList.remove(id);

    }


    /**
     *  You are not allowed to modify this method
     *  Print all events occur on the given date
     * @param year - year of the event
     * @param month - month of the event
     * @param day - day of the event
     */
    public void printEventsOn(int year, int month, int day) {
        for (Event a : aList) {
            if (a.occursOn(year, month, day)) {
                System.out.println(a);
            }
        }
    }

}
