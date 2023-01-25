package lv.k2611a.visma.domain;

import java.math.BigDecimal;

public enum LoanType {

    HOUSING(new BigDecimal("0.035")),
    CAR(new BigDecimal("0.07"));

    private BigDecimal yearlyInterestRate;

    LoanType(BigDecimal yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate;
    }

    public BigDecimal getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    }
