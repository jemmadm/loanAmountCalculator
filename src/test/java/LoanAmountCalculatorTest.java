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
}