package ex1;

public class Summarizer {
    private static Summarizer instance;

    public static Summarizer getInstance() {
        if (instance == null) instance = new Summarizer();
        return instance;
    }

    public String describeEmployee(EmployeeData data) {
        /* implementation is not important for exercise */
        return null;
    }

    public String summarizeHoursWorked(EmployeeData data) {
        /* implementation is not important for exercise */
        return null;
    }
}
