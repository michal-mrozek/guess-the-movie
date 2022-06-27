import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomMovie {
    private final String FILE_NAME = "movies.txt";
    File file = new File(FILE_NAME);

    public String getRandomMovie() {
        try (Scanner scan = new Scanner(file)) {

            List<String> listOfMovies = new ArrayList<>();

            while (scan.hasNextLine()) {
                listOfMovies.add(scan.nextLine());
            }
            Random random = new Random();
            int randomIndex = random.nextInt(listOfMovies.size());

            return listOfMovies.get(randomIndex);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
