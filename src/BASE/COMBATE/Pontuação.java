package BASE.COMBATE;


public class Pontuação {
    private int pontos = 0;

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = Math.max(0, pontos);
    }

    /** +1 por cada ponto de dano causado */
    public void Ponto_Dano_Causado(int dano) {
        if (dano > 0) {
            pontos += dano;
        }
    }

    /** −1 por cada ponto de dano recebido (não fica negativo) */
    public void Dimuir_Pontos(int dano) {
        if (dano > 0) {
            pontos -= dano;
            if (pontos < 0) {
                pontos = 0;
            }
        }
    }

    /** Bônus ao derrotar o monstro */
    public void porMonstroDerrotado(String nomeMonstro) {
        int bonus = switch (nomeMonstro) {
            case "Zumbi"     -> 50;
            case "Esqueleto" -> 60;
            case "Goblin"    -> 30;
            case "Lobo"      -> 40;
            case "Aranha"    -> 45;
            default          -> 25;
        };
        pontos += bonus;
    }

    public void resetar() {
        pontos = 0;
    }
    
}
