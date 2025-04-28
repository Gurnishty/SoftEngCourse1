import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void manageMovies() {
        MovieManager manager = new MovieManager();
        System.out.println("Welcome to the Movies Management System!");
        int choice = 0;
        while(choice < 1 || choice > 5) {
            System.out.println("1. Add a new movie");
            System.out.println("2. Display all movies");
            System.out.println("3. Display movie rating");
            System.out.println("4. Find the best director");
            System.out.println("5. Exit");
            System.out.println("Please enter your choice");
            choice = scanner.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        switch (choice) {
            case 1:
                manager.addMovie();
                break;
            case 2:
                manager.displayAllMovies();
                break;
            case 3:
                String movie_name = scanner.nextLine();
                manager.displayMovieRating(movie_name);
                break;
            case 4:
                manager.findBestDirector();
                break;
            case 5:
                System.out.println("Exiting the program. Goodbye!");
                return;
            default:
                // Code to execute if all the cases don't match
                manageMovies();
                return;
        }
        manageMovies();
        return;
    }
    public static Scanner scanner; // Note: Do not change this line.


    public static void main(String[] args) throws IOException {
        String path = args[0];

        scanner = new Scanner(new File(path));
        int numberOfTests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numberOfTests; i++) {
            System.out.println("Test number " + i + " starts.");
            try {
                manageMovies();
            } catch(Exception e){
                System.out.println("Exception " + e);
            }
            System.out.println("Test number " + i + " ended.");
            System.out.println("-----------------------------------------------");
        }
        System.out.println("All tests have ended.");
    }
}
