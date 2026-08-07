package BASE.INTERACAO;

import BASE.OUTROS.*;
import BASE.PERSONAGEM.*;
import java.util.Scanner;

public class Verficar_A_Mochila {
    Scanner scL = new Scanner (System.in);
    
    public void Verficar_A_Mochila (INVENTARIO I, Jogador J, Mensagens MSM) throws InterruptedException {
        I.MostrarInventarios();
            MSM.Menu_Dentro_Da_Mochila();
                int OP = Entrada.lerInt(scL);
                
            switch (OP) {
                case 1 -> { // USAR ITEM
                    System.out.println("\nInforme a Posição do Item");
                    OP = Entrada.lerInt(scL);
                    I.UsarItemMochila(OP, J);
                    break;
                }
                case 2 -> { // DESCATAR UM ITEM
                    System.out.println("\nInforme a Posição do Item");
                    OP = Entrada.lerInt(scL);
                    I.RemoverItemMochila(OP);
                    break;
                }
            }
    }
    
}
