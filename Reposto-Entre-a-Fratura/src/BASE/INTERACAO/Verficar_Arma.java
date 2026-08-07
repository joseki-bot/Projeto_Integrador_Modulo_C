package BASE.INTERACAO;

import BASE.COMBATE.*;
import BASE.HOTEL.*;
import BASE.ITEM.*;
import BASE.OUTROS.*;
import BASE.PERSONAGEM.*;
import BASE.INTERACAO.*;

public class Verficar_Arma {
    
    AnimacaoDaMensagem AM = new AnimacaoDaMensagem();
    
    public void Verficar_Arma(DanoArmas DA, EscolhaArma EA) throws InterruptedException {
        boolean Tem_Bala = DA.TemBala(EA.getArma());
            String Texto = "Você olha para a " +EA.getArma();
                AM.PalavraPorPalavra(Texto, 300);
            if (Tem_Bala == true) {
                Texto = "Após abrir ela, percebesse que já está carregada";
                    AM.PalavraPorPalavra(Texto, 300);
                System.out.println("\nQUANTIDADE DE BALA = " + DA.getBala());
            }
            else {
                Texto = "Após abrir ela, percebesse que está sem munição";
                    AM.PalavraPorPalavra(Texto, 250);
            }
    }
}
