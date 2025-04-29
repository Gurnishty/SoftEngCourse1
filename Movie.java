/**
 * Represents a movie with a title, director, and rating.
 */
public class Movie {
    /** Title of the movie. */
    String title;

    /** Director of the movie. */
    String director;

    /** Rating of the movie. */
    double rating;

    /**
     * Constructs a new Movie with the given title, director, and rating.
     *
     * @param title the name of the movie
     * @param director the name of the director
     * @param rating the movie's rating
     */
    public Movie(String title, String director, double rating) {
        this.title = title;
        this.director = director;
        this.rating = rating;
    }
}
