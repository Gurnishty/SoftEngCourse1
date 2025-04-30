/** Represents a movie with a title, director, and rating */
public class Movie {
    String title;
    String director;
    double rating;

    /**
     * Constructs a new Movie with the given title, director, and rating.
     */
    public Movie(String title, String director, double rating) {
        this.title = title;
        this.director = director;
        this.rating = rating;
    }
    public String getTitle(Movie movie){
        return title;
    }
    public void setRating(double new_rating){
        this.rating = new_rating;
    }

}
