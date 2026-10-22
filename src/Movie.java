public class Movie extends Resource {
    private final String director;
    private final int lengthInMinutes;

    public Movie(String studio, String title, String ean,
                 String director, int lengthInMinutes) {
        super(ean, title, studio);
        this.director = director;
        this.lengthInMinutes = lengthInMinutes;
    }

    public String getDirector() {
        return director;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }
}