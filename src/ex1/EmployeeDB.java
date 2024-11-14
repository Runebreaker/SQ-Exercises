package ex1;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDB {
    private static EmployeeDB instance = new EmployeeDB();
    private final Map<Integer, EmployeeData> employees = new HashMap<>();
    // Implementation is not important for exercise, but why not

    public static EmployeeDB getInstance() {
        if (instance == null) instance = new EmployeeDB();
        return instance;
    }

    public void saveEmployee(EmployeeData data) {
        employees.put(data.id(), data);
    }

    public EmployeeData findByIdOrNull(int id) {
        return employees.get(id);
    }
}
