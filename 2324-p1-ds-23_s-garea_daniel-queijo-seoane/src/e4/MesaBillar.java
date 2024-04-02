package e4;

import java.util.ArrayList;
import java.util.Arrays;

public class MesaBillar {
    private final ArrayList<BolaBillar> bolasCajetin;
    private final ArrayList<BolaBillar> bolasMesa;
    private boolean estadoPartida;

    public MesaBillar() {
        bolasMesa = new ArrayList<>();
        bolasCajetin = new ArrayList<>();
        estadoPartida = false;

    }

    public void iniciarPartida () {
        estadoPartida = true;
        if (!bolasCajetin.isEmpty() )
            bolasCajetin.clear();
        if (!bolasMesa.isEmpty())
            bolasMesa.clear();
        bolasMesa.addAll(Arrays.asList(BolaBillar.values()));
    }

    public boolean esPartidaIniciada () { return estadoPartida; }

    public void meterBola(BolaBillar bola) {
        if (estadoPartida) {
            if (!bolasCajetin.contains(bola)) {
                if (bola.getNumero() == 0)
                    throw new IllegalStateException("La bola blanco volverá a la mesa");
                else if (bola.getNumero() == 8)
                    finalizarPartida();
                else {
                    bolasMesa.remove(bola);
                    bolasCajetin.add(bola);
                }
            }
            else {
                throw new IllegalStateException("La bola ya se ha metido");
            }
        }
        else throw new IllegalStateException("La partida no ha sido iniciada");
    }

    public String bolasEnMesa() {
        StringBuilder aux = new StringBuilder();
        for (BolaBillar bola : bolasMesa) {
            aux.append("BOLA ").append(bola.getNumero()).append(" ").append(bola.getColor()).append(" ").append(bola.getTipo()).append("\n");
        }
        return aux.toString();
    }

    public String bolasEnCajetin() {
        StringBuilder aux = new StringBuilder();
        for (BolaBillar bola : bolasCajetin) {
            aux.append("BOLA ").append(bola.getNumero()).append(" ").append(bola.getColor()).append(" ").append(bola.getTipo()).append("\n");
        }
       return aux.toString();
    }

    public String obtenerGanador () {
        int lisas = 0, rayadas = 0;

        if (bolasCajetin.isEmpty())
            throw new IllegalStateException("No se puede determinar ganador");
        else {
            for (BolaBillar bola : bolasCajetin) {
                if ("LISA".equals(bola.getTipo()))
                    lisas++;
                else rayadas++;
            }
            if (lisas > rayadas)
                return "Ha ganado el jugador de las bolas lisas";
            else if (rayadas > lisas)
                return "Ha ganado el jugador de las bolas rayadas";
            else
                return "Se ha producido un empate";
        }
    }

    public void finalizarPartida () {
        if (!bolasCajetin.isEmpty())
            bolasCajetin.clear();
        if (!bolasMesa.isEmpty())
            bolasMesa.clear();
        estadoPartida = false;
    }
}

