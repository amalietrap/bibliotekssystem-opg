import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private final ArrayList<Resource> resources = new ArrayList<>();
    private final ArrayList<Member> members = new ArrayList<>();
    private final ArrayList<Loan> loans = new ArrayList<>();

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public Resource getResource(String identifier) {
        for (Resource resource : resources) {
            if (resource.getIdentifier().equals(identifier)) {
                return resource;
            }
        }
        return null;
    }

    public Member getMember(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }

    public LoanResult loanResource(String identifier, int memberId) {
        Resource resource = getResource(identifier);
        if (resource == null) {
            return LoanResult.RESOURCE_NOT_FOUND;
        }

        Member member = getMember(memberId);
        if (member == null) {
            return LoanResult.MEMBER_NOT_FOUND;
        }

        for (Loan loan : loans) {
            if (loan.getResource().getIdentifier().equals(identifier)) {
                return LoanResult.RESOURCE_ALREADY_LOANED;
            }
        }

        loans.add(new Loan(resource, member, LocalDate.now()));
        return LoanResult.SUCCESS;
    }

    public boolean returnResource(String identifier, int memberId) {
        for (int i = 0; i < loans.size(); i++) {
            Loan loan = loans.get(i);

            boolean sameResource =
                    loan.getResource().getIdentifier().equals(identifier);
            boolean sameMember =
                    loan.getMember().getMemberId() == memberId;

            if (sameResource && sameMember) {
                loans.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Loan> findLoansByMemberId(int memberId) {
        ArrayList<Loan> memberLoans = new ArrayList<>();

        for (Loan loan : loans) {
            if (loan.getMember().getMemberId() == memberId) {
                memberLoans.add(loan);
            }
        }

        return memberLoans;
    }
}