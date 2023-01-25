package lv.k2611a.visma.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import lv.k2611a.visma.domain.LoanPaymentPlan;

public interface PaymentStrategy {

    LoanPaymentPlan calculatePaymentPlan(
            BigDecimal loanAmount,
            long loanPeriodInYears,
            LocalDate paymentStartDate,
            BigDecimal yearlyInterestRate
    );
}
