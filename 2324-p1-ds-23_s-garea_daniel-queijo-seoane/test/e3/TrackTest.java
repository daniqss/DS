package e3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {

    /* Tracks. */

    // SFF/PL original double A-Side.
    private static Track beatlesSFFPennyLane01;
    private static Track beatlesSFFPennyLane02;

    // PL promotional release.
    private static Track beatlesPennyLanePromo01;
    private static Track beatlesPennyLanePromo02;

    // SFF digital one-track version.
    private static Track beatlesSFFDigital01;

    @BeforeAll
    static void setUp() {
        /* Recordings. */
        String recBeatlesSFF = "6f5f27e2-fe6d-4c98-be0b-1e58d569909c";
        String recBeatlesPennyLane = "5a6becfb-07e3-4286-8de0-5b4fa826f3f2";

        /* Tracks.
         * Note that some are credited to "Beatles" and some to "The Beatles".
         * Lengths may also vary slightly. */

        // https://musicbrainz.org/release/eadb40cc-9394-3787-80c3-644ed4a167c0
        beatlesSFFPennyLane01 = new Track("A", recBeatlesSFF, "The Beatles","Strawberry Fields Forever", 251);
        beatlesSFFPennyLane02 = new Track("AA", recBeatlesPennyLane,"The Beatles","Penny Lane", 178);

        // https://musicbrainz.org/release/0173d355-016f-4d28-8c57-cdb0b6fd30a0
        beatlesPennyLanePromo01 = new Track("A", recBeatlesPennyLane, "Beatles", "Penny Lane", 180);
        beatlesPennyLanePromo02 = new Track("B", recBeatlesSFF, "Beatles","Strawberry Fields Forever", 245);

        // https://musicbrainz.org/release/af20e7d5-8ab2-4967-8608-c508213b821d
        beatlesSFFDigital01 = new Track("1", recBeatlesSFF,"The Beatles","Strawberry Fields Forever (Remastered 2009)", 238);
    }

    @Test
    void testEquals() {
        assertEquals(beatlesSFFPennyLane01, beatlesPennyLanePromo02);
        assertEquals(beatlesSFFPennyLane02, beatlesPennyLanePromo01);
        assertEquals(beatlesSFFPennyLane01, beatlesSFFDigital01);
        assertEquals(beatlesSFFPennyLane01, beatlesSFFPennyLane01); //Same release
    }

    @Test
    void testNotEquals() {
        assertNotEquals(beatlesSFFPennyLane01, beatlesPennyLanePromo01); // Completely different songs.
        assertNotEquals(beatlesSFFPennyLane01, new Object()); //Not instance of release
    }

    @Test
    void testHashCode() {
        assertEquals(beatlesSFFPennyLane01.hashCode(), beatlesPennyLanePromo02.hashCode());
        assertEquals(beatlesSFFPennyLane01.hashCode(), beatlesSFFDigital01.hashCode());
    }
    @Test
    void testEqualTracks() {
        // Prueba de igualdad entre dos versiones diferentes de la misma canción.
        assertEquals(beatlesSFFPennyLane01, beatlesPennyLanePromo02);

        // Prueba de igualdad entre dos versiones diferentes de la misma canción.
        assertEquals(beatlesSFFPennyLane02, beatlesPennyLanePromo01);

        // Prueba de igualdad entre dos versiones de la misma canción con diferente grabación.
        assertEquals(beatlesSFFPennyLane01, beatlesSFFDigital01);
    }
    @Test
    void testNotEqualTracks() {
        // Prueba de desigualdad entre dos canciones completamente diferentes.
        assertNotEquals(beatlesSFFPennyLane01, beatlesPennyLanePromo01);
    }

    @Test
    void testTrackHashCode() {
        // Prueba del hash code de dos versiones diferentes de la misma canción.
        assertEquals(beatlesSFFPennyLane01.hashCode(), beatlesPennyLanePromo02.hashCode());

        // Prueba del hash code de dos versiones de la misma canción con diferente grabación.
        assertEquals(beatlesSFFPennyLane01.hashCode(), beatlesSFFDigital01.hashCode());
    }
    @Test
    void testGetters() {
        // Crear una instancia de Track para pruebas.
        Track testTrack = new Track("A", "recordingId1", "artist1", "title1", 200);

        // Verificar que los getters devuelvan los valores esperados.
        assertEquals("A", testTrack.getPosition());
        assertEquals("title1", testTrack.getDuration());
        assertEquals("artist1", testTrack.getTitle());
        assertEquals(200, testTrack.getId());
    }

}
