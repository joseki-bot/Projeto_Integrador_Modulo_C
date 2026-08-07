
package BASE.COMBATE;

import BASE.COMBATE.DanoArmas;

/*------------------------------------------------------------------------------
    Aqui vai definir a arma e vai puxar o dano de cada uma
------------------------------------------------------------------------------*/

public class EscolhaArma {
    private String Arma;

     public EscolhaArma(){}
    
    public EscolhaArma(String Arma) {
        this.Arma = Arma;
    }
    
    public String getArma() {
        return Arma;
    }
    public void setArma(String Arma) {
        this.Arma = Arma;
    }
    
    
/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    Vai definir a arma e mudar ela no contructor, para poder ser usada em outras
classes
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    public void PISTOLA () {
        setArma("Pistola");
    }
    
    public void DESERT () {
        setArma("Desert");
    }
    
    public void ESPINGARDA () {
        setArma("Espingarda");
    }
    
    public void FACA () {
        setArma("Faca");
    }
    
    public void SOCO () {
        setArma("Soco");
    }
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -    



/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    Esse método vai pegar o ano de cada arma na classe DanoArmas e vai retonar o
dano de cada uma
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
public int ATAQUE () {
    String NomeArma = getArma();
    
    DanoArmas Dano = new DanoArmas(0, 0, 0);
    int DanoArma = 0;
    
    if (NomeArma.equals("Pistola")) {
        DanoArma = Dano.DanoPistola();
    }
    else if (NomeArma.equals("Desert")) {
        DanoArma = Dano.DanoDesert();
    }
    else if (NomeArma.equals("Espingarda")) {
        DanoArma = Dano.DanoEspingarda();
    }
    else if (NomeArma.equals("Faca")) {
        DanoArma = Dano.DanoFaca();
    }
    else if (NomeArma.equals("Soco")) {
        DanoArma = Dano.DanoSoco();
    }
    else {
        System.out.println("ERRO");
    }
    
    return DanoArma;
}
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -    
    
   
    
}
