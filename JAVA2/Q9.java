import java.util.*;

class Event {
    String title, time, desc;
    Event(String title, String time, String desc) {
        this.title = title;
        this.time = time;
        this.desc = desc;
    }
    public String toString() {
        return time + " - " + title + ": " + desc;
    }
}

public class EventCalendar {
    public static void main(String[] args) {
        TreeMap<String, ArrayList<Event>> calendar = new TreeMap<>();

        calendar.put("2025-05-14", new ArrayList<>());
        calendar.get("2025-05-14").add(new Event("Meeting", "10:00", "Team status update"));

        calendar.put("2025-05-15", new ArrayList<>());
        calendar.get("2025-05-15").add(new Event("Exam", "9:00", "Final exam"));

        for (String date : calendar.keySet()) {
            System.out.println(date + ":");
            for (Event e : calendar.get(date)) {
                System.out.println("  " + e);
            }
        }
    }
}
