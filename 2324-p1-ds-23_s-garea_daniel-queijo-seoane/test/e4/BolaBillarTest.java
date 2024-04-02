package e4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BolaBillarTest {
    @Test
    void testConstructorBolaBillar() {
        BolaBillar[] bolas = {
                BolaBillar.BLANCA, BolaBillar.BOLA1, BolaBillar.BOLA2,
                BolaBillar.BOLA3, BolaBillar.BOLA4, BolaBillar.BOLA5,
                BolaBillar.BOLA6, BolaBillar.BOLA7, BolaBillar.BOLA8,
                BolaBillar.BOLA9, BolaBillar.BOLA10, BolaBillar.BOLA11,
                BolaBillar.BOLA12, BolaBillar.BOLA13, BolaBillar.BOLA14,
                BolaBillar.BOLA15
        };

        String[] colores = {
                "BLANCA", "AMARILLA", "AZUL", "ROJA", "VIOLETA",
                "NARANJA", "VERDE", "GRANATE", "NEGRA",
                "AMARILLA", "AZUL", "ROJA", "VIOLETA",
                "NARANJA", "VERDE", "GRANATE"
        };

        String[] tipos = {"LISA", "RAYADA"};
        int tipoIndex = 0;

        for (int i = 0; i <= 15; i++) {
            assertEquals(i, bolas[i].getNumero());
            assertEquals(colores[i], bolas[i].getColor());
            assertEquals(tipos[tipoIndex], bolas[i].getTipo());

            if (i == 8)
                tipoIndex++;
        }
    }
}