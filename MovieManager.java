import java.util.ArrayList;
import java.util.Scanner;

/** Allows adding movies, displaying them, checking ratings, and finding the best director */
public class MovieManager {
    ArrayList<Movie> movies = new ArrayList<>();
    Scanner scanner;

    /**
     * Constructs a MovieManager with the shared Scanner
     * @param scanner The shared Scanner
     */
    public MovieManager(Scanner scanner) {
        this.scanner = scanner;
    }


    /** Checkes for max movies and adds new movie to the collection if not full */

    public void addMovie() {
        System.out.println("Enter movie name:");
        String title = scanner.nextLine();

        if (movies.size() >= 100) {
            System.out.println("Movies limit reached.");
            return;
        }

        System.out.println("Enter rating:");
        double rating;
        rating = scanner.nextDouble();
        scanner.nextLine();
        if (rating < 0 || rating > 10) {
            System.out.println("Invalid rating");
            return;
        }

        /** Check if movie already exists */

        for (Movie movie : movies) {
            if (movie.getTitle(movie).equals(title)) {
                movie.setRating(rating);
                return;
            }
        }

        System.out.println("Enter director name:");
        String director = scanner.nextLine();
        Movie movie = new Movie(title, director, rating);
        movies.add(movie);
        System.out.println("Movie " + title + " added successfully!");
    }


    /** Displays all movies currently in the collection */

    public void displayAllMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies are available");
            return;
        } else {
            for (Movie movie : movies) {
                System.out.println("Name: " + movie.title + " rating: " +
                        movie.rating + " director: " + movie.director);
            }
        }
    }


    /** Displays the rating for a specific movie */
    public void displayMovieRating() {
        System.out.println("Enter movie name:");
        String movie_title = scanner.nextLine();

        for (Movie movie : movies) {
            if (movie.title.equalsIgnoreCase(movie_title)) {
                System.out.println("Rating for " + movie.title + ": " + movie.rating);
                return;
            }
        }
        System.out.println("No movie found with name " + movie_title);
    }


    /** Finds and displays the director with the highest average movie rating */

    public void findBestDirector() {
        if (movies.isEmpty()) {
            System.out.println("No movies are available.");
        } else {
            String[] directors = new String[movies.size()];
            double[] ratingSums = new double[movies.size()];
            int[] movieCounts = new int[movies.size()];
            int uniqueDirectorCount = 0;

            for (Movie movie : movies) {
                String director = movie.director;
                boolean found = false;

                for (int i = 0; i < uniqueDirectorCount; i++) {
                    if (directors[i].equals(director)) {
                        ratingSums[i] += movie.rating;
                        movieCounts[i]++;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    directors[uniqueDirectorCount] = director;
                    ratingSums[uniqueDirectorCount] = movie.rating;
                    movieCounts[uniqueDirectorCount] = 1;
                    uniqueDirectorCount++;
                }
            }

            String bestDirector = "";
            double highestAverage = -1.0;

            for (int i = 0; i < uniqueDirectorCount; i++) {
                double average = ratingSums[i] / movieCounts[i];
                if (average > highestAverage) {
                    highestAverage = average;
                    bestDirector = directors[i];
                }
            }

            System.out.printf("Best director: " + bestDirector +
                    " with an average rating of: %.2f%n", highestAverage);
        }
    }
}
