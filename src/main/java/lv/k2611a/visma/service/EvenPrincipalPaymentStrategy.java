package lv.k2611a.visma.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lv.k2611a.visma.domain.LoanPaymentPlan;
import lv.k2611a.visma.domain.LoanPaymentPlanEntry;

public class EvenPrincipalPaymentStrategy implements PaymentStrategy {

    @Override
    public LoanPaymentPlan calculatePaymentPlan(
            BigDecimal loanAmount,
            long loanPeriodInMonths,
            LocalDate paymentStartDate,
            BigDecimal yearlyInterestRate
    ) {
        BigDecimal precalculatedMonthlyPayment = loanAmount.divide(
                new BigDecimal(loanPeriodInMonths),
                2,
                RoundingMode.UP
        );
        List<LoanPaymentPlanEntry> result = new ArrayList<>();

        int monthsPassed = 0;
        while (loanAmount.compareTo(BigDecimal.ZERO) > 0) {
            LocalDate paymentDate = paymentStartDate.plusMonths(monthsPassed);
            BigDecimal principalPaymentAmount = precalculatedMonthlyPayment.min(loanAmount);
            BigDecimal interestPaymentAmount = loanAmount
                    .multiply(yearlyInterestRate)
                    .divide(new BigDecimal(12), 2, RoundingMode.UP);

            loanAmount = loanAmount.subtract(principalPaymentAmount);

            LoanPaymentPlanEntry entry = new LoanPaymentPlanEntry(
                    paymentDate,
                    principalPaymentAmount,
                    interestPaymentAmount,
                    loanAmount
            );

            result.add(entry);

            monthsPassed++;

        }

        return new LoanPaymentPlan(result);
    }

}
