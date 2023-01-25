package lv.k2611a.loan.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

import lv.k2611a.loan.domain.LoanPaymentPlan;
import lv.k2611a.loan.domain.LoanType;

@Component
public class LoanService {


    public LoanPaymentPlan calculatePaymentPlan(
            LoanType loanType,
            BigDecimal loanAmount,
            int loanPeriodInYears,
            LocalDate paymentStartDate
    ) {
        PaymentStrategy paymentStrategy = selectPaymentStrategy(loanType);
        BigDecimal yearlyInterestRate = loanType.getYearlyInterestRate();
        Period loanPeriod = Period.ofYears(loanPeriodInYears);
        long loanPeriodInMonths = loanPeriod.toTotalMonths();

        return paymentStrategy.calculatePaymentPlan(
                loanAmount,
                loanPeriodInMonths,
                paymentStartDate,
                yearlyInterestRate
        );

    }

    private PaymentStrategy selectPaymentStrategy(LoanType loanType) {
        // new strategies can be added here
        return new EvenPrincipalPaymentStrategy();
    }


}
