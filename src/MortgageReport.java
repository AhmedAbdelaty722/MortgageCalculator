import java.text.NumberFormat;

public class MortgageReport {

    private final MortgageCalculator calculator;
    private final NumberFormat currency;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();

        String mortgageFormatted = currency.format(mortgage);

        System.out.println("\nMortgage");
        System.out.println("----------------------------------------------");
        System.out.println("Your Monthly Payments are " + mortgageFormatted);
    }

    public void printPaymentSchedule() {
        System.out.println("\nPayments Schedule");
        System.out.println("----------------------------------------------");

        int month = 1;

        for (double balance : calculator.getRemainingBalance()) {
            String formattedBalance = currency.format(balance);
            System.out.println("In Month No. " + month + " Your Balance will be " + formattedBalance);
            month++;
        }
    }
}
