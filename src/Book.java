public class Book extends Resource {
    private final int pageCount;

    public Book(String author, String title, String isbn, int pageCount) {
        super(isbn, title, author);
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }
}