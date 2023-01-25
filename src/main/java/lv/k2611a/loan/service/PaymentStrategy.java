package lv.k2611a.loan.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import lv.k2611a.loan.domain.LoanPaymentPlan;

public interface PaymentStrategy {

    LoanPaymentPlan calculatePaymentPlan(
            BigDecimal loanAmount,
            long loanPeriodInYears,
            LocalDate paymentStartDate,
            BigDecimal yearlyInterestRate
    );
}
