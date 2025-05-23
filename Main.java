import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main class for the Movies Management System
 * Handles reading input from a file and managing test runs
 */
public class Main {

    /**Creates manager to pass to manage func*/
    public static void manageMovies(){
        System.out.println("Welcome to the Movies Management System!.");
        MovieManager manager = new MovieManager(scanner);
        manage(manager);
    }

    /**
     * Handles user interaction for managing movies
     * @param manager The MovieManager used to manage the movie collection
     */

    public static void manage(MovieManager manager) {
        String choice;
        while(true) {
            System.out.println("1. Add a new movie");
            System.out.println("2. Display all movies");
            System.out.println("3. Display movie rating");
            System.out.println("4. Find the best director");
            System.out.println("5. Exit");
            System.out.println("Please enter your choice:");
            //////////
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    manager.addMovie();
                    break;
                case "2":
                    manager.displayAllMovies();
                    break;
                case "3":
                    manager.displayMovieRating();
                    break;
                case "4":
                    manager.findBestDirector();
                    break;
                case "5":
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
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
