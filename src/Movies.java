/**
 * This class represents a collection of movies
 */
class Movies {

    private String title;
    private String year;
    private String rating;
    private String runtime;
    private String actors;

    // Adding Colors for read ability
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String CYAN_BOLD = "\033[1;36m";   // Bold CYAN
    public static final String RED_BOLD = "\033[1;31m";    // Bold RED

    public Movies(String title, String year, String rating, String runtime, String actors) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.runtime = runtime;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
}