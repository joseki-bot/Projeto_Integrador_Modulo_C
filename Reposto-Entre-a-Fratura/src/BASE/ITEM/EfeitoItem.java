
package BASE.ITEM;

import BASE.PERSONAGEM.Jogador;
import BASE.COMBATE.*;
import BASE.OUTROS.*;


public class EfeitoItem {
    DanoArmas DA = new DanoArmas(0, 0, 0);
    Mensagens MSM = new Mensagens();
    EscolhaArma EA = new EscolhaArma();
    
    public void Efeito(String item, Jogador jogador) { //"Bala", "Maçã", "Banana", "Poção", "Erva"
        switch (item) {
            case "Maçã", "maca" -> { // CURA
                jogador.RecuperarVida(8);
                break;
            }
            case "Banana", "banana" -> { // CURA
                jogador.RecuperarVida(10);
                break;
            }
            case "Poção", "pocao" -> { // CURA
                jogador.RecuperarVida(30);
                break;
            }
            case "Erva", "erva" -> { // DANO E RESISTENCIA
                jogador.LevarDano(20);
                jogador.ativarErva();
                break;
            }
            case "Bala", "bala" -> { // MUNIÇÃO
                if (DA.getBalaMaxima() > 0) {
                    DA.recarregarArma(EA.getArma());
                }
                break;
            }
        }
        
    }
}
