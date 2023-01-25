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

    @Test
    public void oneYearPaymentPlanCar() {
        Assertions.assertEquals(
                new LoanPaymentPlan(
                        List.of(
                                entry(2023, 1, 1, 83.34, 5.84, 916.66),
                                entry(2023, 2, 1, 83.34, 5.35, 833.32),
                                entry(2023, 3, 1, 83.34, 4.87, 749.98),
                                entry(2023, 4, 1, 83.34, 4.38, 666.64),

                                entry(2023, 5, 1, 83.34, 3.89, 583.30),
                                entry(2023, 6, 1, 83.34, 3.41, 499.96),
                                entry(2023, 7, 1, 83.34, 2.92, 416.62),
                                entry(2023, 8, 1, 83.34, 2.44, 333.28),

                                entry(2023, 9, 1, 83.34, 1.95, 249.94),
                                entry(2023, 10, 1, 83.34, 1.46, 166.60),
                                entry(2023, 11, 1, 83.34, 0.98, 83.26),
                                entry(2023, 12, 1, 83.26, 0.49, 0))
                ),
                loanService.calculatePaymentPlay(
                        LoanType.CAR,
                        new BigDecimal(1000),
                        1,
                        LocalDate.of(2023, 1, 1)
                )
        );
    }

    @Test
    public void twoYearPlan() {
        Assertions.assertEquals(
                new LoanPaymentPlan(
                        List.of(
                                entry(2023, 1, 1, 41.67, 2.92, 958.33),
                                entry(2023, 2, 1, 41.67, 2.80, 916.66),
                                entry(2023, 3, 1, 41.67, 2.68, 874.99),
                                entry(2023, 4, 1, 41.67, 2.56, 833.32),

                                entry(2023, 5, 1, 41.67, 2.44, 791.65),
                                entry(2023, 6, 1, 41.67, 2.31, 749.98),
                                entry(2023, 7, 1, 41.67, 2.19, 708.31),
                                entry(2023, 8, 1, 41.67, 2.07, 666.64),

                                entry(2023, 9, 1, 41.67, 1.95, 624.97),
                                entry(2023, 10, 1, 41.67, 1.83, 583.30),
                                entry(2023, 11, 1, 41.67, 1.71, 541.63),
                                entry(2023, 12, 1, 41.67, 1.58, 499.96),

                                entry(2024, 1, 1, 41.67, 1.46, 458.29),
                                entry(2024, 2, 1, 41.67, 1.34, 416.62),
                                entry(2024, 3, 1, 41.67, 1.22, 374.95),
                                entry(2024, 4, 1, 41.67, 1.10, 333.28),

                                entry(2024, 5, 1, 41.67, 0.98, 291.61),
                                entry(2024, 6, 1, 41.67, 0.86, 249.94),
                                entry(2024, 7, 1, 41.67, 0.73, 208.27),
                                entry(2024, 8, 1, 41.67, 0.61, 166.60),

                                entry(2024, 9, 1, 41.67, 0.49, 124.93),
                                entry(2024, 10, 1, 41.67, 0.37, 83.26),
                                entry(2024, 11, 1, 41.67, 0.25, 41.59),
                                entry(2024, 12, 1, 41.59, 0.13, 0.0))


                ),
                loanService.calculatePaymentPlay(
                        LoanType.HOUSING,
                        new BigDecimal(1000),
                        2,
                        LocalDate.of(2023, 1, 1)
                )
        );
    }

    private static LoanPaymentPlanEntry entry(
            int year,
            int month,
            int day,
            double principalValue,
            double interestValue,
            double amountLeft
    ) {
        return new LoanPaymentPlanEntry(
                LocalDate.of(year, month, day),
                BigDecimal.valueOf(principalValue).setScale(2, RoundingMode.DOWN),
                BigDecimal.valueOf(interestValue).setScale(2, RoundingMode.DOWN),
                BigDecimal.valueOf(amountLeft).setScale(2, RoundingMode.DOWN)
        );
    }


}