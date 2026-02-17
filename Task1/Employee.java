package Task1;
public abstract class Employee {
	    protected String name;
	    protected double baseSalary;
	    protected int attendanceDays;
	    protected int performanceRating;
	    protected static final double PF_PERCENTAGE = 0.12;
		public Employee
		(String name, double baseSalary, int attendanceDays, int performanceRating) {
	        this.name = name;
	        this.baseSalary = baseSalary;
	        this.attendanceDays = attendanceDays;
	        this.performanceRating = performanceRating;
	    }
	    public abstract double calculateGrossSalary();
	    public double calculateAttendanceDeduction() {
	        double dailySalary = baseSalary / 30;
	        int absentDays = 30 - attendanceDays;
	        return absentDays * dailySalary;
	    }
	    public double calculateBonus(double grossSalary) {
	        double bonusPercent = 0;
	        switch (performanceRating) {
	            case 5: bonusPercent = 0.20; break;
	            case 4: bonusPercent = 0.15; break;
	            case 3: bonusPercent = 0.10; break;
	            case 2: bonusPercent = 0.05; break;
	            default: bonusPercent = 0; break;
	        }
	        return grossSalary * bonusPercent;
		}
	    public double calculatePF() {
	        return baseSalary * PF_PERCENTAGE;
	    }
	    public double calculateTax(double grossSalary, double bonus) {
	        double taxableIncome = grossSalary + bonus;
	        double taxRate;
	        if (taxableIncome <= 50000) taxRate = 0.05;
	        else if (taxableIncome <= 100000) taxRate = 0.10;
	        else if (taxableIncome <= 150000) taxRate = 0.15;
	        else taxRate = 0.20;
			return taxableIncome * taxRate;
	    }
	    public double calculateNetSalary() {
	        double gross = calculateGrossSalary();
	        double bonus = calculateBonus(gross);
	        double pf = calculatePF();
	        double attendanceDeduction = calculateAttendanceDeduction();
	        double tax = calculateTax(gross, bonus);
	        return gross + bonus - pf - tax - attendanceDeduction;
	    }
	    public void printSalarySlip() {
	        double gross = calculateGrossSalary();
	        double bonus = calculateBonus(gross);
	        double pf = calculatePF();
	        double attendanceDeduction = calculateAttendanceDeduction();
	        double tax = calculateTax(gross, bonus);
	        double netSalary = calculateNetSalary();
			System.out.println("Salary Slip for " + name);
	        System.out.println("-------");
	        System.out.println("Gross Salary: " + gross);
	        System.out.println("Bonus: " + bonus);
	        System.out.println("PF Deduction: " + pf);
	        System.out.println("Attendance Deduction: " + attendanceDeduction);
	        System.out.println("Tax: " + tax);
	        System.out.println("Net Salary: " + netSalary);
	        System.out.println();
	    }
	}




