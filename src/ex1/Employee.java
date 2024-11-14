package ex1;

/// This is essentially a facade class that delegates responsibilities to other classes
public class Employee {
    // Dedicated instances of classes for each responsibility
    private static final EmployeeDB employeeDB = EmployeeDB.getInstance();
    private static final PayManager payManager = PayManager.getInstance();
    private static final Summarizer summarizer = Summarizer.getInstance();

    // Data of the employee
    private final EmployeeData employeeData;

    public Employee(EmployeeData employeeData) {
        this.employeeData = employeeData;
    }

    // region DB
    public void saveToDB() {
        employeeDB.saveEmployee(employeeData);
    }

    public EmployeeData findByIdOrNull(int id) {
        return employeeDB.findByIdOrNull(id);
    }
    // endregion

    // region Pay
    public void calculatePay() {
        payManager.calculatePay(employeeData);
    }

    public void calculateDeduction() {
        payManager.calculateDeduction(employeeData);
    }
    // endregion

    //region Summary
    public String describe() {
        return summarizer.describeEmployee(employeeData);
    }

    public String summarizeHoursWorked() {
        return summarizer.summarizeHoursWorked(employeeData);
    }
    // endregion
}
