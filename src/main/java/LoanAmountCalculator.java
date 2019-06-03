import java.text.DecimalFormat;
import java.util.Scanner;

public class LoanAmountCalculator {

    public String calculateLoanAmount(double monthlyRepayment, double interestRate, double yearsToBorrow) {
        double maximumLoanAmountWithInterest = monthlyRepayment * yearsToBorrow * 12;
        double loanAmountWithInterest = 0;
        double outputLoanAmountWithInterest = 0;
        double outputLoan = 0;
        double outputInterest = 0;
        for (int loanAmount = 0; loanAmountWithInterest <= maximumLoanAmountWithInterest; loanAmount++) {
            loanAmountWithInterest = loanAmount + (interestRate / 100 * loanAmount);

            if (loanAmountWithInterest <= maximumLoanAmountWithInterest) {
                outputLoanAmountWithInterest = loanAmountWithInterest;
                outputLoan = loanAmount;
                outputInterest = loanAmountWithInterest - loanAmount;
            }
        }
        String loan = "The amount you will be able to borrow is £" + new DecimalFormat("##.##").format(outputLoan)
                + ". The interest you will pay is £" + new DecimalFormat("##.##").format(outputInterest) + ". The total amount you will pay is £" + new DecimalFormat("##.##").format(outputLoanAmountWithInterest) + ".";
        System.out.println(loan);
        return loan;
    }
    public static void main(String[] args) {
        System.out.println("Loan Calculator!");
        System.out.println("How much money can you afford to borrow? Let's work it out.");
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("How much can you afford to repay each month?");
        try {
            double monthlyRepayment = input.nextDouble();
            System.out.println("What's the interest rate percent?");
            double interestRate = input.nextDouble();
            System.out.println("How many years do you want to borrow for?");
            double yearsToBorrow = input.nextDouble();
            LoanAmountCalculator loanAmountCalculator = new LoanAmountCalculator();
            loanAmountCalculator.calculateLoanAmount(monthlyRepayment, interestRate, yearsToBorrow);
        } finally {
            input.close();
        }
    }
}
