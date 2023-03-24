public class Main {
    public static void main(String[] args) {

        System.out.println("Mortgage Calculator\n");

        int principal = (int) Console.readNumber("Enter The Principle : ", 1_000, 1_000_000);
        double annualInterestRate = Console.readNumber("Enter The Annual Interest Rate : ", 1, 30);
        int periodInYears = (int) Console.readNumber("Enter The Period in Years : ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterestRate, periodInYears);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}