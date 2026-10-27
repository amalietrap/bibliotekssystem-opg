import java.util.List;
public class ConsoleUI {
    private Library library;

    public ConsoleUI(Library library) {
        this.library = library;
    }

    public void run() {
        boolean running = true;

        while (running) {
            showMenu();

            int choice = Integer.parseInt(IO.readln("Indtast dit valg: "));

            switch (choice) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> showLoans();
                case 4 -> running = false;
                default -> IO.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    private void showMenu() {
        IO.println();
        IO.println("1. Lån");
        IO.println("2. Aflever");
        IO.println("3. Vis alle lån");
        IO.println("4. Afslut");
        IO.println();
    }

    private void borrowBook() {
            String identifier = IO.readln("Indtast ISBN eller EAN: ");
            int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));

            LoanResult result = library.loanResource(identifier, memberId);

            switch (result) {
                case SUCCESS -> IO.println("Lån registreret.");
                case MEMBER_NOT_FOUND -> IO.println("Medlemmet findes ikke.");
                case RESOURCE_NOT_FOUND -> IO.println("Materialet findes ikke.");
                case RESOURCE_ALREADY_LOANED -> IO.println("Materialet er allerede udlånt.");
                case NOT_PERMITTED -> IO.println("Lånet er ikke tilladt.");
        }
    }
    private void returnBook() {
        String identifier = IO.readln("Indtast ISBN eller EAN: ");
        int memberId = Integer.parseInt(
                IO.readln("Indtast medlemsnummer: ")
        );

        if (library.returnResource(identifier, memberId)) {
            IO.println("Materialet er afleveret.");
        } else {
            IO.println("Materialet kunne ikke afleveres. Kontrollér ISBN/EAN og medlemsnummer.");
        }
    }

    private void showLoans() {
        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));

        List<Loan> loans = library.findLoansByMemberId(memberId);

        if (loans.isEmpty()) {
            IO.println("Medlemmet har ingen lån.");
        } else {
            IO.println("Medlemmets lån:");

            for (Loan loan : loans) {
                IO.println(loan);
            }
        }
    }
}
