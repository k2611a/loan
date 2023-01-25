package lv.k2611a.visma.domain;

import java.util.Collections;
import java.util.List;

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
    public String toString() {
        return "LoanPaymentPlan{" +
                "planEntryList=" + planEntryList +
                '}';
    }
}
