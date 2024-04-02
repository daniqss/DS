package e3;

import java.util.Comparator;

// Comparador para la puntuación media del artista (decreciente)
public class AverageRatingComparator implements Comparator<Artist> {
    @Override
    public int compare(Artist artist1, Artist artist2) {
        return Double.compare(artist2.getAverageRating(), artist1.getAverageRating());
    }
}
