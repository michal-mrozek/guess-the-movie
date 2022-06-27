import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Guess {

    private String getUnderscoredMovie(String movie) {
        String underscoredMovie = movie;

        underscoredMovie = underscoredMovie.replaceAll("[a-zA-Z]", "_");

        return underscoredMovie;
    }

    public String guessing() {
        boolean win = false;
        RandomMovie rm = new RandomMovie();
        Scanner scan = new Scanner(System.in);
        String randomMovie = rm.getRandomMovie();
        System.out.println(randomMovie);
        String underscoredMovie = getUnderscoredMovie(randomMovie);
        System.out.println(underscoredMovie);
        List<String> wrongLetters = new ArrayList<>() ;
        List<String> correctLetters = new ArrayList<>();
        int noWrongGuess = 10;
        while (noWrongGuess > 0){


            System.out.println("You are guessing: " + underscoredMovie + "\n" + noWrongGuess + " guesses left. Wrong letters: " + toString(wrongLetters));
            System.out.println("your next letter:");
            String letter = scan.nextLine();
            if (randomMovie.indexOf(letter) != -1){
                correctLetters.add(letter);
                underscoredMovie = randomMovie.replaceAll("[^" +toStringRegex(correctLetters) + " ]", "_");
                System.out.println(toStringRegex(correctLetters));

                if(underscoredMovie.equals(randomMovie)){
                    win = true;
                    break;
                }

            } else {
                wrongLetters.add(letter);
                noWrongGuess--;
            }
        }



        if (win)
            return "Congratulation! You won.";
        else
            return "sorry you lose!";
    }

    private String toStringRegex(List<String> correctLetters) {
        String letters= "";
        for (int i = 0; i < correctLetters.size(); i++) {
            letters+=correctLetters.get(i);
        }
        return letters;
    }

    private String toString(List<String> wrongLetters) {
        String wrongLettersString = "";
        for (int i = 0; i < wrongLetters.size(); i++) {
            wrongLettersString += wrongLetters.get(i) + ", ";
        }
        return wrongLettersString;
    }


}
