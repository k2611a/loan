package lv.k2611a.visma.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lv.k2611a.visma.domain.LoanPaymentPlan;
import lv.k2611a.visma.domain.LoanPaymentPlanEntry;
import lv.k2611a.visma.domain.LoanType;

@Component
public class LoanService {


    public LoanPaymentPlan calculatePaymentPlay(
            LoanType loanType,
            BigDecimal loanAmount,
            int loanPeriodInYears,
            LocalDate paymentStartDate
    ) {

        Period loanPeriod = Period.ofYears(loanPeriodInYears);
        long loanPeriodInMonth = loanPeriod.toTotalMonths();

        BigDecimal precalculatedMonthlyPayment = loanAmount.divide(
                new BigDecimal(loanPeriodInMonth),
                2,
                RoundingMode.UP
        );
        List<LoanPaymentPlanEntry> result = new ArrayList<>();

        int monthsPassed = 0;
        while (loanAmount.compareTo(BigDecimal.ZERO) > 0) {
            LocalDate paymentDate = paymentStartDate.plusMonths(monthsPassed);
            BigDecimal principalPaymentAmount = precalculatedMonthlyPayment.min(loanAmount);
            BigDecimal interestPaymentAmount = loanAmount
                    .multiply(loanType.getYearlyInterestRate())
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
