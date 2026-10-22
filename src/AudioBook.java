public class AudioBook extends Resource {
    private final int lengthInMinutes;

    public AudioBook(String author, String title, String isbn,
                     int lengthInMinutes) {
        super(isbn, title, author);
        this.lengthInMinutes = lengthInMinutes;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }
}