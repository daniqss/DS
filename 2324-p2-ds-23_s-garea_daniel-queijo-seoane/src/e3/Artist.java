package e3;

import java.util.List;

public class Artist implements Comparable<Artist> {
    private final String id;
    private String realName;  // Nombre real del artista
    private String stageName; // Nombre Artístico
    private double averageRating;
    private List<Genre> genres;

    public Artist(String id, String realName, String stageName, double averageRating, List<Genre> genres) {
        this.id = id;
        this.realName = realName;
        this.stageName = stageName;
        this.averageRating = averageRating;
        this.genres = genres;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getRealName() {
        return realName;
    }

    public String getStageName() {
        return stageName;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    // Setters
    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    // Implementación del método compareTo para ordenar por el atributo 'id'
    @Override
    public int compareTo(Artist o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return "Artist [id=" + id + ", realName=" + realName + ", stageName=" + stageName +
                ", averageRating=" + averageRating + ", genres=" + genres + "]";
    }
}
