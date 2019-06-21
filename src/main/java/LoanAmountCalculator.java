import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class LoanAmountCalculator {

    public String calculateAffordableLoanAmountUsingMonthlyPayment(double monthlyRepayment, double interestRate, int yearsToBorrow) {
        double maximumLoanAmountWithInterest = monthlyRepayment * yearsToBorrow * 12;
        double loanAmountWithInterest = 0;
        int loanAmount = 0;

        while (loanAmountWithInterest < maximumLoanAmountWithInterest){
            loanAmountWithInterest = loanAmount + (interestRate / 100 * loanAmount);
            loanAmount = getLoanAmount(maximumLoanAmountWithInterest, loanAmountWithInterest, loanAmount);
        }
        loanAmountWithInterest = loanAmount + (interestRate / 100 * loanAmount);

//        extract ifs above and add loanAmountWithInterest line to each

        String loan = "The amount you will be able to borrow is " + NumberFormat.getCurrencyInstance(Locale.UK).format(loanAmount)
                + ". The interest you will pay is " + NumberFormat.getCurrencyInstance(Locale.UK).format(loanAmountWithInterest-loanAmount)
                + ". The total amount you will pay is " + NumberFormat.getCurrencyInstance(Locale.UK).format(loanAmountWithInterest)
                + ".";
        System.out.println(loan);
        return String.format(loan, "#");
    }

    private int getLoanAmount(double maximumLoanAmountWithInterest, double loanAmountWithInterest, int loanAmount) {
        if (loanAmountWithInterest<maximumLoanAmountWithInterest){
            loanAmount++;
        }
        if (loanAmountWithInterest>maximumLoanAmountWithInterest){
            loanAmount--;
        }
        return loanAmount;
    }

    public static void main(String[] args) {
        System.out.println("Loan Calculator!");
        System.out.println("Would you like to work out how much your loan will be based on affordability or a fixed loan amount?"
                + "Please answer 1 for affordability or 2 for the total cost");
        Scanner input = new Scanner(System.in);
        try {
        int affordOrAmount = input.nextInt();

        if (affordOrAmount==1){
        System.out.println("How much money can you afford to borrow? Let's work it out.");
        System.out.println("");
        System.out.println("How much can you afford to repay each month?");

            double monthlyRepayment = input.nextDouble();
            System.out.println("What's the interest rate percent?");
            double interestRate = input.nextDouble();
            System.out.println("How many years do you want to borrow for?");
            int yearsToBorrow = input.nextInt();
            LoanAmountCalculator loanAmountCalculator = new LoanAmountCalculator();
            loanAmountCalculator.calculateAffordableLoanAmountUsingMonthlyPayment(monthlyRepayment, interestRate, yearsToBorrow);
        }else{
            System.out.println("How much money would you like to borrow? Let's work it out.");
            System.out.println("");
            System.out.println("How much would you like to borrow?");
            double loanValue = input.nextDouble();
            System.out.println("How many years do you want to borrow for?");
            int yearsToBorrow = input.nextInt();
            System.out.println("What's the interest rate percent?");
            double interestRate = input.nextDouble();
            LoanAmountCalculator loanAmountCalculator = new LoanAmountCalculator();
            loanAmountCalculator.calculateTotalLoanAmountIncludingInterest(loanValue, interestRate, yearsToBorrow);
        }
        } finally {
            input.close();
        }
    }

    public String calculateTotalLoanAmountIncludingInterest(double loanValue, double interestRate, int yearsToBorrow) {
        double totalInterest = (interestRate/100*loanValue) * yearsToBorrow;
        double totalLoanCost = totalInterest + loanValue;
        System.out.println("To borrow £" + new DecimalFormat("##.##").format(loanValue) + ", over "  + yearsToBorrow
                + " years at " + new DecimalFormat("##.##").format(interestRate) + "% APR, you will need to pay £"
                + new DecimalFormat("##.##").format(totalLoanCost) + " in total.");
        return "" + new DecimalFormat("##.##").format(totalLoanCost);
    }
}
