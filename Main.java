// Main.java
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner; // Note: Do not change this line.

    public static void manageMovies() {
        MovieManager manager = new MovieManager(scanner); // Pass the existing scanner
        System.out.println("Welcome to the Movies Management System!");

        while (true) {
            // Display menu options every time
            System.out.println("1. Add a new movie");
            System.out.println("2. Display all movies");
            System.out.println("3. Display movie rating");
            System.out.println("4. Find the best director");
            System.out.println("5. Exit");
            System.out.println("Please enter your choice");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    manager.addMovie();
                    break;
                case 2:
                    manager.displayAllMovies();
                    break;
                case 3:
                    manager.displayMovieRating();
                    break;
                case 4:
                    manager.findBestDirector();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
            }
        }
    }

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
