import java.util.ArrayList;
import java.util.Scanner;

public class MovieManager {
    ArrayList<Movie> movies = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void addMovie() {
        System.out.println("Enter movie name:");
        String title = scanner.nextLine();

        if (movies.size() >= 100) {
            System.out.println("Movies limit reached.");
            return;
        }

        System.out.println("Enter rating:");
        double rating = Double.parseDouble(scanner.nextLine());

        if (rating < 0 || rating > 10) {
            System.out.println("Invalid rating.");
            return;
        }

        System.out.println("Enter director name:");
        String director = scanner.nextLine();

        Movie movie = new Movie(title, director, rating);
        movies.add(movie);

        System.out.println("Movie added successfully!");

    }
    public void displayAllMovies(){
        if(movies.isEmpty()){
            System.out.println("No movies are available");
            return;
        } else{
            for(Movie movie : movies){
                System.out.println("Name: " + movie.title + ",rating: " + movie.rating + ",director: " + movie.director);
            }
        }

    }

    public void displayMovieRating(String title) {
        System.out.println("Enter movie name:");
        String movie_title = scanner.nextLine();
        for (Movie movie : movies) {
            if (movie.title.equalsIgnoreCase(movie_title)) {
                System.out.println("Rating for" + movie.title + " : " + movie.rating);
                return;

            }
        }
        System.out.println("Movie not found with name " + movie_title);
    }


    public void findBestDirector() {
        if(movies.isEmpty()){
            System.out.println("No movies are available.");
        } else {String[] directors_unique = new String[movies.size()];
            int[] count_each_director = new int[movies.size()];
            int size = 0;


            String director = "some director name";

            boolean found = false;
            for (int i = 0; i < size; i++) {
                if (directors_unique[i].equals(director)) {
                    count_each_director[i]++;
                    found = true;
                    break;
                }
            }


            if (!found) {
                directors_unique[size] = director;
                count_each_director[size] = 1;
                size++;
            }


            String bestDirector = "";
            int maxCount = 0;

            for (int i = 0; i < size; i++) {
                if (count_each_director[i] > maxCount) {
                    maxCount = count_each_director[i];
                    bestDirector = directors_unique[i];
                }
            }
            int best_movie_sum = 0;
            int best_movie_num = 0;
            for(Movie movie : movies) {

                if (movie.director == bestDirector) {
                    best_movie_num++;
                    best_movie_sum += movie.rating;
                }
            }
            int best_avg = best_movie_sum / best_movie_num;
            System.out.println("Best director: " + bestDirector + "with an average rating of" + best_avg);
            }


        }

    }
}
