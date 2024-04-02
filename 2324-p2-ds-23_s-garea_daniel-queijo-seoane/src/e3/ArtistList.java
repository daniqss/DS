package e3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArtistList {
    private List<Artist> artists;

    public ArtistList(List<Artist> artists) {
        this.artists = artists;
    }

    // Orden natural
    public void sort() {
        Collections.sort(artists);
    }

    // Ordenación con un comparador personalizado
    public void sort(Comparator<Artist> comparator) {
        if (comparator != null) {
            artists.sort(comparator);
        } else {
            throw new IllegalArgumentException("Comparator cannot be null");
        }

    }
}

