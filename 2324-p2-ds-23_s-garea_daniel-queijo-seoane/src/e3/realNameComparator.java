package e3;

import java.util.Comparator;

// Comparador para el nombre real del artista
public class realNameComparator implements Comparator<Artist> {
    @Override
    public int compare(Artist artist1, Artist artist2) {
        return artist1.getRealName().compareToIgnoreCase(artist2.getRealName());
    }
}
