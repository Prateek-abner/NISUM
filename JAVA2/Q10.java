import java.util.*;

class Movie {
    String title, director, genre;
    int year;
    double rating;

    Movie(String t, String d, String g, int y, double r) {
        title = t; director = d; genre = g; year = y; rating = r;
    }

    public String toString() {
        return title + " | " + director + " | " + genre + " | " + year + " | " + rating;
    }
}

public class MovieManager {
    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Inception", "Nolan", "Sci-Fi", 2010, 8.8));
        movies.add(new Movie("Titanic", "Cameron", "Romance", 1997, 7.9));
        movies.add(new Movie("Avatar", "Cameron", "Sci-Fi", 2009, 7.8));

        System.out.println("All Movies:");
        for (Movie m : movies) System.out.println(m);

        System.out.println("\nFiltered (Director = Cameron):");
        for (Movie m : movies) {
            if (m.director.equals("Cameron"))
                System.out.println(m);
        }

        System.out.println("\nSorted by rating:");
        movies.sort(Comparator.comparingDouble(m -> -m.rating));  // Descending
        for (Movie m : movies) System.out.println(m);
    }
}
