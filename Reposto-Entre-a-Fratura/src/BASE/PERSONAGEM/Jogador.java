package BASE.PERSONAGEM;
/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    Esse classe no primeiro momento é só para ser a vida do jogador 
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
public class Jogador {
    private int vida;
    private int turnosErva = 0;

    
    public Jogador(int vida) {
        this.vida = vida;
    }


    public int getVida() {
        if (vida < 0) {   
            vida = 0;
        }
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    
    
    public int getTurnosErva() {
        return turnosErva;
    }
    public void setTurnosErva(int turnosErva) {
        this.turnosErva = turnosErva;
    }
    
    
/*------------------------------------------------------------------------------
        Esses métodos vão ser para manipular a vida do jogador, tanto recuperando
    quanti tirando a vida,
------------------------------------------------------------------------------*/
    public void RecuperarVida(int Cura) {
        this.vida += Cura;
    }   

    public void LevarDano (int Dano) {
        int danoFinal = Dano;

        if (turnosErva > 0) {
            danoFinal = (int) Math.round(Dano * 0.70);
        }

        this.vida -= danoFinal;
    }
//------------------------------------------------------------------------------


//------------------------------------------------------------------------------
    public void ativarErva() {
        this.turnosErva = 5;
    }

    public void passarTurnoErva() {
        if (turnosErva > 0) {
            turnosErva--;
        }
    }
//------------------------------------------------------------------------------
}