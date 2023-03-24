public class MortgageCalculator {

    private final static int percent = 100;
    private final static int monthsInYears = 12;
    private final int principal;
    private final double annualInterestRate;
    private final int periodInYears;

    public MortgageCalculator(int principal, double annualInterestRate, int periodInYears) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.periodInYears = periodInYears;
    }

    private double getMonthlyInterestRate() {
        return annualInterestRate / percent / monthsInYears;
    }

    private int getNumberOfPayments() {
        return periodInYears * monthsInYears;
    }

    public double calculateMortgage() {
        double monthlyInterestRate = getMonthlyInterestRate();
        int numberOfPayments = getNumberOfPayments();

        return
                (principal
                        * (monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), numberOfPayments)))
                        / ((Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1)));
    }

    public double calculateBalance(int numberOfPaymentsMade) {
        double monthlyInterestRate = getMonthlyInterestRate();
        int numberOfPayments = getNumberOfPayments();

        return
                (principal
                        * (Math.pow(1 + monthlyInterestRate, numberOfPayments) - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                        / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
    }

    public double[] getRemainingBalance() {
        var balances = new double[getNumberOfPayments()];

        for (int month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }

        return balances;
    }
}
