public class GuessGame {
    public static void main(String[] args) {
        RandomMovie rm = new RandomMovie();
        String randomMovie = rm.getRandomMovie();
        System.out.println(randomMovie);
    }
}
