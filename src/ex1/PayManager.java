package ex1;

public class PayManager {
    private static PayManager instance;

    public static PayManager getInstance() {
        if (instance == null) instance = new PayManager();
        return instance;
    }

    public void calculatePay(Employee employee) {
        /* implementation is not important for exercise */
    }
    public void calculateDeduction() {
        /* implementation is not important for exercise */
    }
}
