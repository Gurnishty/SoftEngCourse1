import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public void f1(){}
    public void f2(){}
    public void f3(){}
    public void f4(){
        if(Movie.isEmpty()){
            System.out.println("No movies are available.");
        } else {
            System.out.println("Best director: <director> with an average" +
                    " rating of <averagr>");
        }
    }
    public void startup() {
        System.out.println("Welcome to the Movies Management System!");
        System.out.println("1. Add a new movie");
        System.out.println("2. Display all movies");
        System.out.println("3. Display movie rating");
        System.out.println("4. Find the best director");
        System.out.println("5. Exit");
        System.out.println("Please enter your choice");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                f1();
                break;
            case 2:
                f2();
                break;
            case 3:
                f3();
                break;
            case 4:
                f4();
                break;
            case 5:
                System.out.println("Exiting the program, Goodbye!");
                return;
            default:
                // Code to execute if all the cases don't match
                startup();
                return;
        }
        return;
    }
    public static Scanner scanner; // Note: Do not change this line.

    public static void manageMovies() {}

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
