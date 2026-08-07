package BASE.COMBATE;

/*==============================================================================
    As Armas que vão ter são
    PISTOLA, DESERT EAGLE, ESPINGARDA, FACA, SOCO
==============================================================================*/

public class DanoArmas {
    private int Bala;
    private int BalaMaxima;
    private int DurabilidadeFaca;   

    public DanoArmas() {}
    
    public DanoArmas(int Bala, int BalaMaxima, int DurabilidadeFaca) {
        this.Bala = Bala;
        this.BalaMaxima = BalaMaxima;
        this.DurabilidadeFaca = DurabilidadeFaca;
    }

// BALA
    public int getBala() {
        if (Bala < 0) {
            Bala = 0;
        }
        return Bala;
    }
    public void setBala(int Bala) {
        this.Bala = Bala;
    }
    
// Bala Máxima
    public int getBalaMaxima() {
        return BalaMaxima;
    }
    public void setBalaMaxima(int BalaMaxima) {
        this.BalaMaxima = BalaMaxima;
    }

// Durabilidade da Faca
    public int getDurabilidadeFaca() {
        if (DurabilidadeFaca < 0) {
            DurabilidadeFaca = 0;
        }
        return DurabilidadeFaca;
    }
    public void setDurabilidadeFaca(int DurabilidadeFaca) {
        this.DurabilidadeFaca = DurabilidadeFaca;
    }

    
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// Pistola
    public int DanoPistola () {
        int dano = 10;
        return dano;
    }
    
// Desert Eagle
    public int DanoDesert () {
        int dano = 20;
        return dano;
    }
    
// Espingarda
    public int DanoEspingarda () {
        int dano = 35;
        return dano;
    }
    
// Faca
    public int DanoFaca () {
        int dano = 10;
        return dano;
    }
     
// Soco
    public int DanoSoco () {
        int dano = 5;
        return dano;
    }
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
   
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// Definir as balas
    public void recarregarArma (String TipoArma) {
        
        switch (TipoArma) {
            case "Pistola" -> {
                Bala = 10;
                BalaMaxima = 10;
                break;
            }
            case "Desert" -> {
                Bala = 6;
                BalaMaxima = 6;
                break;
            }
            case "Espingarda" -> {
                Bala = 2;
                BalaMaxima = 2;
                break;
            }
            case "Faca" -> {
                DurabilidadeFaca = 100;
                break;
            }
            default -> {
                System.out.println("Algo deu errado");
                break;
            }
        }
    }
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// Uma gabiara uqe vai pegar a arma e ver qual bala ela usa e se tiver bala ele
// consegue dar o tiro
    public boolean TemBala (String Arma) {
        boolean Convimardor = false;
        
        switch (Arma) {
            case "Pistola" -> {
                if (getBala() > 0 ) {
                    Convimardor = true;
                }
                break;
            }
            case "Desert" -> {
                if (getBala() > 0) {
                    Convimardor = true;
                }
                break;
            }
            case "Espingarda" -> {
                if (getBala() > 0) {
                    Convimardor = true;
                }
                break;
            }
            case "Faca" -> {
                Convimardor = true;
                break;
            }
            case "Soco" -> {
                Convimardor = true;
                break;
            }
            default -> {
                System.out.println("Erro");
                Convimardor = false;
                break;
            }
        }
        
        return Convimardor;
    }
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// Aqui vai diminuir as balas a cada tiro
    public void MininuirBala () {
        setBala(getBala() - 1);
    }        


   
}