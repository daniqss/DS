package e4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MesaBillarTest {


    public static MesaBillar mesaBillar = new MesaBillar();

    @Test
    void testConstructorMesaBillar() {

    }


    @Test
    void iniciarPartidaTest() {
        mesaBillar.iniciarPartida();
        assertTrue(mesaBillar.esPartidaIniciada());
    }

    @Test
    void finalizarPartidaTest() {
        mesaBillar.iniciarPartida();
        mesaBillar.meterBola(BolaBillar.BOLA5);
        mesaBillar.finalizarPartida();
        assertFalse(mesaBillar.esPartidaIniciada());
    }

    @Test
    void bolasEnMesaTest() {
        String text = """
                BOLA 0 BLANCA LISA
                BOLA 1 AMARILLA LISA
                BOLA 2 AZUL LISA
                BOLA 3 ROJA LISA
                BOLA 4 VIOLETA LISA
                BOLA 5 NARANJA LISA
                BOLA 6 VERDE LISA
                BOLA 7 GRANATE LISA
                BOLA 8 NEGRA LISA
                BOLA 9 AMARILLA RAYADA
                BOLA 10 AZUL RAYADA
                BOLA 11 ROJA RAYADA
                BOLA 12 VIOLETA RAYADA
                BOLA 13 NARANJA RAYADA
                BOLA 14 VERDE RAYADA
                BOLA 15 GRANATE RAYADA
                """;
        mesaBillar.iniciarPartida();
        assertEquals(text, mesaBillar.bolasEnMesa());
    }

    @Test
    void meterTodasBolasTest() {
        String text = """
                BOLA 1 AMARILLA LISA
                BOLA 2 AZUL LISA
                BOLA 3 ROJA LISA
                BOLA 4 VIOLETA LISA
                BOLA 5 NARANJA LISA
                BOLA 6 VERDE LISA
                BOLA 7 GRANATE LISA
                BOLA 9 AMARILLA RAYADA
                BOLA 10 AZUL RAYADA
                BOLA 11 ROJA RAYADA
                BOLA 12 VIOLETA RAYADA
                BOLA 13 NARANJA RAYADA
                BOLA 14 VERDE RAYADA
                BOLA 15 GRANATE RAYADA
                """;
        mesaBillar.iniciarPartida();
        for (BolaBillar bola : BolaBillar.values()) {
            if (bola != BolaBillar.BOLA8 && bola != BolaBillar.BLANCA) {
                mesaBillar.meterBola(bola);
            }
        }
        assertEquals(text, mesaBillar.bolasEnCajetin());
    }


    @Test
    void meterBolaException1() {
        assertThrows(IllegalStateException.class,
                    () -> mesaBillar.meterBola(BolaBillar.BLANCA));
    }

    @Test
    void meterBolaException2() {
        mesaBillar.iniciarPartida();
        mesaBillar.meterBola(BolaBillar.BOLA3);
        assertThrows(IllegalStateException.class,
                () -> mesaBillar.meterBola(BolaBillar.BOLA3));
    }

    @Test
    void obtenerGanadorTest () {
        mesaBillar.iniciarPartida();
        mesaBillar.meterBola(BolaBillar.BOLA1);
        mesaBillar.meterBola(BolaBillar.BOLA9);
        mesaBillar.meterBola(BolaBillar.BOLA10);
        mesaBillar.meterBola(BolaBillar.BOLA11);

        assertEquals("Ha ganado el jugador de las bolas rayadas", mesaBillar.obtenerGanador());
    }

    @Test
    void obtenerGanadorException () {
        mesaBillar.iniciarPartida();
        assertThrows(IllegalStateException.class, () -> mesaBillar.obtenerGanador());
    }
}