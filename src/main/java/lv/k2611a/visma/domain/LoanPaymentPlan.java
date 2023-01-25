package lv.k2611a.visma.domain;

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
