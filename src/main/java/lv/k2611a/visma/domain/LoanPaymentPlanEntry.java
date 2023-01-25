package lv.k2611a.visma.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanPaymentPlanEntry {

    private final LocalDate paymentDate;

    private final BigDecimal paymentAmount;

    public LoanPaymentPlanEntry(LocalDate paymentDate, BigDecimal paymentAmount) {
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }


    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    @Override
    public String toString() {
        return "LoanPaymentPlanEntry{" +
                "paymentDate=" + paymentDate +
                ", paymentAmount=" + paymentAmount +
                '}';
    }
}
