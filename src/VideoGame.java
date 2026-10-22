public class VideoGame extends Resource {
    private final String platform;

    public VideoGame(String studio, String title, String ean, String platform) {
        super(ean, title, studio);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }
}