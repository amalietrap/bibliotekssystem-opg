import java.time.LocalDate;
import java.util.List;

public class StandardLoanPolicy implements LoanPolicy {

    @Override
    public boolean canLoan(Resource resource, Member member, List<Loan> activeLoans) {
        return true;
    }

    @Override
    public LocalDate calculateDueDate(Resource resource, LocalDate borrowedDate) {
        return borrowedDate.plusDays(30);
    }
}