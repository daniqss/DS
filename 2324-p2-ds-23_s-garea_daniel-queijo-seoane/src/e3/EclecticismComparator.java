package e3;

import java.util.Comparator;

// Comparador para el eclecticismo del artista (creciente)
public class EclecticismComparator implements Comparator<Artist> {
    @Override
    public int compare(Artist artist1, Artist artist2) {
        return Integer.compare(artist1.getGenres().size(), artist2.getGenres().size());
    }
} //Cuantos más géneros tenga un artista más ecléctico es.
