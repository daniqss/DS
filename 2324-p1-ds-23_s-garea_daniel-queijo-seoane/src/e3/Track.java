package e3;

public record Track(String position, String recording, String title, String duration, int id) {
    //Métodos Getter
    public String getPosition() {
        return position;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Posición del Track: " + position + "\n Duración: " + duration + " segundos \n ID de la grabación: " + id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof Track track))
            return false;
        return recording.equals(track.recording);
    }
    @Override
    public int hashCode() {
        return recording.hashCode();
    }

}