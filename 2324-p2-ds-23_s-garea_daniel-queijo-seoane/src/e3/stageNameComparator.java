package e3;

import java.util.Comparator;

// Comparador para el nombre artístico del artista
public class stageNameComparator implements Comparator<Artist> {
    @Override
    public int compare(Artist artist1, Artist artist2) {
        return artist1.getStageName().compareToIgnoreCase(artist2.getStageName());
        //Comparar sin tener en cuenta mayúsculas o minúsculas
    }
}
