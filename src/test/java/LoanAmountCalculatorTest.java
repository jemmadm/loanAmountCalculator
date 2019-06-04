import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoanAmountCalculatorTest {

    private LoanAmountCalculator loanAmountCalculator = new LoanAmountCalculator();

    @Test
    public void doesCalculatorWork() {
        assertThat(loanAmountCalculator.calculateAffordableLoanAmountUsingMonthlyPayment(400, 5, 1))
                .isEqualTo("The amount you will be able to borrow is £4571. The interest you will pay is £228.55." +
                        " The total amount you will pay is £4799.55.");
    }
    @Test
    public void noInterestRate() {
        assertThat(loanAmountCalculator.calculateAffordableLoanAmountUsingMonthlyPayment(500,0,5))
                .isEqualTo("The amount you will be able to borrow is £30000. The interest you will pay is £0." +
                        " The total amount you will pay is £30000.");
    }
    @Test
    public void hundredPercentInterestRate() {
        assertThat(loanAmountCalculator.calculateAffordableLoanAmountUsingMonthlyPayment(100,100,1))
                .isEqualTo("The amount you will be able to borrow is £600. The interest you will pay is £600." +
                        " The total amount you will pay is £1200.");
    }
    @Test
    public void noYears() {
        assertThat(loanAmountCalculator.calculateAffordableLoanAmountUsingMonthlyPayment(500,5,0))
        .isEqualTo("The amount you will be able to borrow is £0. The interest you will pay is £0." +
                " The total amount you will pay is £0.");
    }
    @Test
    public void monthlyRepaymentIncludesPence() {
        assertThat(loanAmountCalculator.calculateAffordableLoanAmountUsingMonthlyPayment(100.50,10,1))
        .isEqualTo("The amount you will be able to borrow is £1096. The interest you will pay is £109.6." +
                " The total amount you will pay is £1205.6.");
    }
    @Test
    public void calculateTotalLoanAmount(){
        assertThat(loanAmountCalculator.calculateTotalLoanAmountIncludingInterest(5000,5,1)).isEqualTo("5250");
    }
    @Test
    public void TotalLoanNoInterestRate() {
        assertThat(loanAmountCalculator.calculateTotalLoanAmountIncludingInterest(500,0,5))
                .isEqualTo("500");
    }
    @Test
    public void TotalLoanHundredPercentInterestRate() {
        assertThat(loanAmountCalculator.calculateTotalLoanAmountIncludingInterest(1000,100,1))
                .isEqualTo("2000");
    }
    @Test
    public void TotalLoanNoYears() {
        assertThat(loanAmountCalculator.calculateTotalLoanAmountIncludingInterest(500,5,0))
                .isEqualTo("500");
    }
}