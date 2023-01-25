package lv.k2611a.visma.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lv.k2611a.visma.domain.LoanPaymentPlan;
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
}