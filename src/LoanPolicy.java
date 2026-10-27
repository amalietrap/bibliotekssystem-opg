import java.time.LocalDate;
import java.util.List;

public interface LoanPolicy {
    boolean canLoan(Resource resource, Member member, List<Loan> activeLoans);

    LocalDate calculateDueDate(Resource resource, LocalDate borrowedDate);
}