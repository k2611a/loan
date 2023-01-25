package lv.k2611a.visma.domain;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LoanPaymentPlan {

    public final static LoanPaymentPlan EMPTY = new LoanPaymentPlan(Collections.emptyList());

    private final List<LoanPaymentPlanEntry> planEntryList;

    public LoanPaymentPlan(List<LoanPaymentPlanEntry> planEntryList) {
        this.planEntryList = planEntryList;
    }

    public List<LoanPaymentPlanEntry> getPlanEntryList() {
        return planEntryList;
    }

    public BigDecimal getPrincipalPaymentAmount() {
        BigDecimal result = BigDecimal.ZERO;
        for (LoanPaymentPlanEntry loanPaymentPlanEntry : planEntryList) {
            result = result.add(loanPaymentPlanEntry.getPrincipalPaymentAmount());
        }
        return result;
    }

    public BigDecimal getInterestPaymentAmount() {
        BigDecimal result = BigDecimal.ZERO;
        for (LoanPaymentPlanEntry loanPaymentPlanEntry : planEntryList) {
            result = result.add(loanPaymentPlanEntry.getInterestPaymentAmount());
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanPaymentPlan that = (LoanPaymentPlan) o;

        return Objects.equals(planEntryList, that.planEntryList);
    }

    @Override
    public int hashCode() {
        return planEntryList != null ? planEntryList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "LoanPaymentPlan{" +
                "planEntryList=" + planEntryList +
                '}';
    }
}
