package Task1;

public class SalaryCalc {
	public static void main(String[] args) {
        Employee dev = new Developer("Pratiksha", 20000, 20, 5, 10);
        Employee mgr = new Manager("Kashish", 120000, 30, 6, 5);
        Employee intern = new Intern("Gauri", 30000, 10, 4);

        dev.printSalarySlip();
        mgr.printSalarySlip();
        intern.printSalarySlip();
    }
}
