package e3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;


public class Release { //Creamos una clase para los lanzamientos
    private final String recording;
    private String title;
    private String artist;
    private final List<Track> listTrack;


    // Función auxiliar para verificar cadenas nulas o vacías
    private static void validateString(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(value + "' no puede ser nulo o vacío.");
        }
    }
    //Constructor de la clase
    public Release(String recording) {
        validateString(recording);
        this.recording = recording;
        this.listTrack = new ArrayList<>();
    }

    public void setTitle(String title) {
        validateString(title);
        this.title = title;
    }

    public void setArtist(String artist) {
        validateString(artist);
        this.artist = artist;
    }


    public void addTrack(Track track) {
        if (track == null) {
            throw new NullPointerException("La pista no puede ser nula.");
        }
        if (listTrack.contains(track)) {
            throw new IllegalArgumentException("Esta pista ya existe en la lista.");
        }
        listTrack.add(track);
    }



    //Métodos getter para obtener los valores de los campos del objeto
    public String getRecording() {
        return recording;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public List<Track> getTracklist() {
        return listTrack;
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder(); //Hacemos un strBuilder y le añadimos todos los campos del release
        strb.append("Grabación: ").append(recording).append("\n");
        strb.append("Titulo: ").append(title).append("\n");
        strb.append("Artista: ").append(artist).append("\n");
        strb.append("Track-list:\n");

        for (Track track : listTrack) {
            strb.append("\t").append(track.toString()).append("\n");
        }

        return strb.toString();
    }
    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof Release release))
            return false;

        // Compara las listas de pistas
        return listTrack.size() == release.listTrack.size() && new HashSet<>(listTrack).containsAll(release.listTrack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(new HashSet<>(listTrack));
    }
}

