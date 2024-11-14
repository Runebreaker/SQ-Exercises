package ex1;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    int id;
    float hourlyPay;
    String description;
    List<WorkTime> clockedWorkTimeByDay = new ArrayList<>();

    class WorkTime {
        int hours;
        int minutes;

        WorkTime(int hours, int minutes) {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    Employee(int id, float hourlyPay) {
        this.id = id;
        this.hourlyPay = hourlyPay;
        description = null;
    }

    public String describeEmployee() {
        return description != null ? description : "No description found.";
    }
    public String summarizeHoursWorked() {
        /* implementation is not important for exercise */
        return null;
    }
}
