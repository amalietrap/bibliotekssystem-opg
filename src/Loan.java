import java.time.LocalDate;

public class Loan {
    private final Resource resource;
    private final Member member;
    private final LocalDate borrowedDate;

    public Loan(Resource resource, Member member, LocalDate borrowedDate) {
        this.resource = resource;
        this.member = member;
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public Resource getResource() {
        return resource;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getDueDate() {
        return borrowedDate.plusDays(14);
    }

    public boolean isOverdue() {
        LocalDate today = LocalDate.now();
        return today.isAfter(getDueDate());
    }

    @Override
    public String toString() {
        return resource + "\n" + member + "\n" + "afleveringsfrist " + getDueDate();
    }
}
