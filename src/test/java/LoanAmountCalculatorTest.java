import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoanAmountCalculatorTest {

    private LoanAmountCalculator loanAmountCalculator = new LoanAmountCalculator();

    @Test
    public void doesCalculatorWork() {
        assertThat(loanAmountCalculator.calculateLoanAmount(400, 5, 1))
                .isEqualTo("The amount you will be able to borrow is £4571. The interest you will pay is £228.55." +
                        " The total amount you will pay is £4799.55.");
    }

    @Test
    public void noInterestRate() {
        assertThat(loanAmountCalculator.calculateLoanAmount(500,0,5))
                .isEqualTo("The amount you will be able to borrow is £30000. The interest you will pay is £0." +
                        " The total amount you will pay is £30000.");
    }

    @Test
    public void hundredPercentInterestRate() {
        assertThat(loanAmountCalculator.calculateLoanAmount(100,100,1))
                .isEqualTo("The amount you will be able to borrow is £600. The interest you will pay is £600." +
                        " The total amount you will pay is £1200.");
    }

    @Test
    public void noYears() {
        assertThat(loanAmountCalculator.calculateLoanAmount(500,5,0))
        .isEqualTo("The amount you will be able to borrow is £0. The interest you will pay is £0." +
                " The total amount you will pay is £0.");
    }
}