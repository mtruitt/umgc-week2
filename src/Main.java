/**
 *
 * Author: Mark Truitt
 * Class: CMIS 242 - Week 2
 * Date: 2023/01/21
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // create a scanner object for user input
        Scanner sc = new Scanner(System.in);

        // attributes
        String title;
        String year;
        String rating;
        String runtime;
        String actors;
        boolean isCorrect;

        // loop until user enters correct information
        do {
            // loop until user enters a non-blank title
            do {
                System.out.print("Enter movie title: ");
                title = sc.nextLine();
                if (title.isBlank()) {
                    System.out.println("Title cannot be blank. Please enter a valid title.");
                }
            } while (title.isBlank());

            // get the rest of the information from the user
            System.out.print("Enter year: ");
            year = sc.nextLine();
            System.out.print("Enter rating: ");
            rating = sc.nextLine();
            System.out.print("Enter runtime (minutes): ");
            runtime = sc.nextLine();
            System.out.print("Enter actors: ");
            actors = sc.nextLine();

            // create a new movie object
            Movies movie = new Movies("", "", "", "", "");
            movie.setTitle(title);
            movie.setYear(year);
            movie.setRating(rating);
            movie.setRuntime(runtime);
            movie.setActors(actors);

            // print the information entered by the user
            System.out.println("You entered:");
            System.out.println(Movies.CYAN_BOLD + "Title: " + Movies.RESET + movie.getTitle());
            System.out.println(Movies.CYAN_BOLD + "Year: " + Movies.RESET + movie.getYear());
            System.out.println(Movies.CYAN_BOLD + "Rating: " + Movies.RESET + movie.getRating());
            System.out.println(Movies.CYAN_BOLD + "Runtime: " + Movies.RESET + movie.getRuntime());
            System.out.println(Movies.CYAN_BOLD + "Actors: " + Movies.RESET + movie.getActors());
            System.out.print(Movies.RED_BOLD + "Is this information correct? (y/n) " + Movies.RESET );
            String confirm = sc.nextLine();
            isCorrect = confirm.equalsIgnoreCase("y");
        } while (!isCorrect);
        // close scanner
        sc.close();

        // Write to CSV
        FileWriter csvWriter = new FileWriter("movies.csv", true);
        csvWriter.append(title);
        csvWriter.append(",");
        csvWriter.append(year);
        csvWriter.append(",");
        csvWriter.append(rating);
        csvWriter.append(",");
        csvWriter.append(runtime);
        csvWriter.append(",");
        csvWriter.append(actors);
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();

        // Read from CSV
        BufferedReader csvReader = new BufferedReader(new FileReader("movies.csv"));
        String row;
        System.out.printf("\033[1;34m%-20s %-10s %-10s %-10s %-30s\033[m\n", "Title", "Year", "Rating", "Runtime", "Actors");
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",", -1);
            System.out.printf("%-20s %-10s %-10s %-10s %-30s\n", data[0], data[1], data[2], data[3], data[4]);
            System.out.println("---------------------------------------------------------------");
        }
        csvReader.close();
    }
}