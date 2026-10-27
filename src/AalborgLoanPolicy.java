import java.time.LocalDate;
import java.util.List;

public class AalborgLoanPolicy implements LoanPolicy {

    @Override
    public boolean canLoan(Resource resource, Member member, List<Loan>activeLoans) {
        boolean isMovieOrGame = resource instanceof Movie || resource instanceof VideoGame;
        if (!isMovieOrGame) {
            return true;
        }

        int movieAndGameCount = 0;

        for (Loan loan : activeLoans) {
            boolean sameMember = loan.getMember().getMemberId() == member.getMemberId();
            boolean isMovieOrGameLoan = loan.getResource() instanceof Movie || loan.getResource() instanceof VideoGame;

            if (sameMember && isMovieOrGameLoan) {
                movieAndGameCount++;
            }
        }

        return movieAndGameCount < 3;
    }

    @Override
    public LocalDate calculateDueDate(Resource resource, LocalDate borrowedDate) {
        return borrowedDate.plusDays(30);
    }
}
