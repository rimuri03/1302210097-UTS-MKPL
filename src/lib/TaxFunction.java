package lib;

public class TaxFunction {

    private static final int STANDARD_DEDUCTIBLE = 54000000;
    private static final int PER_CHILD_DEDUCTION = 1500000;
    private static final int MAX_CHILDREN = 3;
    private static final double TAX_RATE = 0.05;

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible,
            boolean isMarried, int numberOfChildren) {
        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 months working per year");
            return 0;
        }
        numberOfChildren = Math.min(numberOfChildren, MAX_CHILDREN);

        int totalIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;

        int totalDeductible = deductible + STANDARD_DEDUCTIBLE + (numberOfChildren * PER_CHILD_DEDUCTION);
		
        if (!isMarried) {
            totalDeductible -= PER_CHILD_DEDUCTION;
        }
        int tax = (int) Math.round(TAX_RATE * (totalIncome - totalDeductible));

        return Math.max(tax, 0);
    }
}
