package ex1;

import java.util.HashMap;
import java.util.Map;

public class EmployeeManager {
    private static EmployeeManager instance = new EmployeeManager();
    private final Map<Integer, Employee> employees = new HashMap<>();

    public static EmployeeManager getInstance() {
        if (instance == null) instance = new EmployeeManager();
        return instance;
    }
    public void saveEmployee(Employee employee) {
        employees.put(employee.id, employee);
    }
    public Employee findByIdOrNull(int id) {
        return employees.get(id);
    }
}
