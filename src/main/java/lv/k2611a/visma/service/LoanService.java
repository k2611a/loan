package lv.k2611a.visma.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

import org.springframework.stereotype.Component;

import lv.k2611a.visma.domain.LoanPaymentPlan;
import lv.k2611a.visma.domain.LoanType;

@Component
public class LoanService {


    public LoanPaymentPlan calculatePaymentPlay(
            LoanType loanType,
            BigDecimal loanAmount,
            int loanPeriodInYears,
            LocalDate paymentStartDate
    ) {
        return new LoanPaymentPlan(Collections.emptyList());
    }


}
