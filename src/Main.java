public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book(
                "Allan B. Downey", "Think Java", "978149207250", 400);
        Book book2 = new Book(
                "Rachel Cusk", "Omrids", "9788763851664", 250);
        Book book3 = new Book(
                "Yuval Noah Harari", "Sapiens", "9780062316097", 500);

        Movie movie = new Movie(
                "Disney", "Hercules", "5701234567890", "Ron Clements", 81);

        AudioBook audioBook = new AudioBook(
                "J.K. Rowling", "Harry Potter", "9783161484100", 600);

        VideoGame videoGame = new VideoGame(
                "Nintendo", "The Legend of Zelda", "5709876543210",
                "Nintendo Switch");

        Member member1 = new Member("Thorkild Hansen", 111);
        Member member2 = new Member("Lise Andersen", 222);
        Member member3 = new Member("Peter Larsen", 333);

        library.addMember(member1);
        library.addMember(member2);
        library.addMember(member3);

        library.addResource(book1);
        library.addResource(book2);
        library.addResource(book3);
        library.addResource(movie);
        library.addResource(audioBook);
        library.addResource(videoGame);

        ConsoleUI consoleUI = new ConsoleUI(library);
        consoleUI.run();
    }
}