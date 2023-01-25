package lv.k2611a.visma.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lv.k2611a.visma.domain.LoanPaymentPlan;
import lv.k2611a.visma.domain.LoanPaymentPlanEntry;
import lv.k2611a.visma.domain.LoanType;


class LoanServiceTest {

    private LoanService loanService = new LoanService();

    @Test
    public void emptyLoan() {
        Assertions.assertEquals(
                LoanPaymentPlan.EMPTY,
                loanService.calculatePaymentPlay(
                        LoanType.HOUSING,
                        BigDecimal.ZERO,
                        30,
                        LocalDate.of(2023, 5, 10)
                )
        );
    }

    @Test
    public void oneYearPaymentPlan() {
        Assertions.assertEquals(
                new LoanPaymentPlan(
                        List.of(
                                entry(2023, 1, 1, 10_000, 350, 110_000),
                                entry(2023, 2, 1, 10_000, 320.84, 100_000),
                                entry(2023, 3, 1, 10_000, 291.67, 90_000),
                                entry(2023, 4, 1, 10_000, 262.50, 80_000),

                                entry(2023, 5, 1, 10_000, 233.34, 70_000),
                                entry(2023, 6, 1, 10_000, 204.17, 60_000),
                                entry(2023, 7, 1, 10_000, 175.00, 50_000),
                                entry(2023, 8, 1, 10_000, 145.84, 40_000),

                                entry(2023, 9, 1, 10_000, 116.67, 30_000),
                                entry(2023, 10, 1, 10_000, 87.50, 20_000),
                                entry(2023, 11, 1, 10_000, 58.34, 10_000),
                                entry(2023, 12, 1, 10_000, 29.17, 0))
                ),
                loanService.calculatePaymentPlay(
                        LoanType.HOUSING,
                        new BigDecimal(120_000),
                        1,
                        LocalDate.of(2023, 1, 1)
                )
        );
    }

    private static LoanPaymentPlanEntry entry(
            int year,
            int month,
            int day,
            int principalValue,
            double interestValue,
            int amountLeft
    ) {
        return new LoanPaymentPlanEntry(
                LocalDate.of(year, month, day),
                new BigDecimal(principalValue).setScale(2, RoundingMode.UP),
                BigDecimal.valueOf(interestValue).setScale(2, RoundingMode.UP),
                new BigDecimal(amountLeft).setScale(2, RoundingMode.UP)
        );
    }


}