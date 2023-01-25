package lv.k2611a.visma.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class LoanPaymentPlanEntry {

    private final LocalDate paymentDate;

    private final BigDecimal principalPaymentAmount;

    private final BigDecimal interestPaymentAmount;

    private final BigDecimal amountLeft;


    public LoanPaymentPlanEntry(
            LocalDate paymentDate,
            BigDecimal principalPaymentAmount,
            BigDecimal interestPaymentAmount,
            BigDecimal amountLeft
    ) {
        this.paymentDate = paymentDate;
        this.principalPaymentAmount = principalPaymentAmount;
        this.interestPaymentAmount = interestPaymentAmount;
        this.amountLeft = amountLeft;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public BigDecimal getPrincipalPaymentAmount() {
        return principalPaymentAmount;
    }

    public BigDecimal getInterestPaymentAmount() {
        return interestPaymentAmount;
    }

    public BigDecimal getAmountLeft() {
        return amountLeft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanPaymentPlanEntry that = (LoanPaymentPlanEntry) o;

        if (!Objects.equals(paymentDate, that.paymentDate)) return false;
        if (!Objects.equals(principalPaymentAmount, that.principalPaymentAmount))
            return false;
        if (!Objects.equals(interestPaymentAmount, that.interestPaymentAmount))
            return false;
        return Objects.equals(amountLeft, that.amountLeft);
    }

    @Override
    public int hashCode() {
        int result = paymentDate != null ? paymentDate.hashCode() : 0;
        result = 31 * result + (principalPaymentAmount != null ? principalPaymentAmount.hashCode() : 0);
        result = 31 * result + (interestPaymentAmount != null ? interestPaymentAmount.hashCode() : 0);
        result = 31 * result + (amountLeft != null ? amountLeft.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LoanPaymentPlanEntry{" +
                "paymentDate=" + paymentDate +
                ", principalPaymentAmount=" + principalPaymentAmount +
                ", interestPaymentAmount=" + interestPaymentAmount +
                ", amountLeft=" + amountLeft +
                '}';
    }
}
