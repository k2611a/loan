package lv.k2611a.visma.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.k2611a.visma.domain.LoanType;
import lv.k2611a.visma.service.LoanService;

@Controller
public class LoanPageController {


    @Autowired
    private LoanService loanService;

    @GetMapping("/")
    public String loanFormPage(
    ) {
        return "loanFormPage";
    }

    @PostMapping("/calculateLoan")
    public String loanTablePage(
            Model model,
            @RequestParam(name = "years") int loanLengthYears,
            @RequestParam(value = "loanAmount", required = true) BigDecimal loanAmount
    ) {
        model.addAttribute(
                "loanEntries",
                loanService
                        .calculatePaymentPlay(
                                LoanType.HOUSING,
                                loanAmount,
                                loanLengthYears,
                                LocalDate.now()
                        )
                        .getPlanEntryList()
        );
        return "loanTablePage";
    }
}
