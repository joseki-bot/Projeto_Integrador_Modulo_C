package BASE.HOTEL;

import BASE.PERSONAGEM.INVENTARIO;
import BASE.ITEM.DefinindoItem;
import BASE.PERSONAGEM.Jogador;
import BASE.OUTROS.Mensagens;
import java.util.Random;

public class Quarto  {
    
//==============================================================================
/*
    Aqui eu vou colocar as classe para poder puxar os métodos de cada classe e os
Utilitario (sla se é esse o Nome)
*/
    DefinindoItem ITEM = new DefinindoItem(null);
    Mensagens msm =  new Mensagens();
//==============================================================================
    
    
//==============================================================================
/*      Aqui vão ser um método que vai ver se a mobilia que o jogador escolheu
    olha vai ser item ou não                                                  */
    
public static boolean TemItem() {
    Random ale = new Random();
    int Sorte = ale.nextInt(1, 5);
     
    boolean Sla = true;
    
    if (Sorte <= 3) {
        Sla = true;
    }
    else {
        Sla = false;
    }
    return Sla;
}
//==============================================================================

/*        Todos os métodos baixo vão bem dizer fazer a mesma coisa, você vai ter uma
    chance de achar um item aleátorio. O único que vai ser diferente vai ser o
    quadro, ele vai ter uma chance baixa de ter um cofre, ele vai ser aberto por
    uma senha e dentro dele vai ter uma nova arma */

//==============================================================================
public void Cama(boolean JaOlhou, INVENTARIO mochila, Jogador jogador) throws InterruptedException {
    if (JaOlhou == false) {
        System.out.println("Você decide olhar a cama");
        System.out.println("    Ela é bem velha, e parece que ninguém se deita nele a tempos");
        System.out.println("    mesemo assim você a revira, na esperança de achar algo");
        
        if (TemItem() == true) {
            String Obj = ITEM.SortarItem();
            System.out.println("\n- E você achou uma " +Obj+ " !!!");
            msm.OqueFazerComItem(Obj, mochila, jogador);
        }
        else {
            System.out.println("\n- Mesmo olhando cada canto, você não achou nada");
        }
    }
    else {
        System.out.println("Você já olhou a Cama");
    }
}
//==============================================================================


//==============================================================================
public void CriadoMudo(boolean JaOlhou, INVENTARIO mochila, Jogador jogador) throws InterruptedException {
    if (JaOlhou == false) {
        System.out.println("Você decide olhar o Criado-Mudo");
        System.out.println("    Ele está cabado, com muita poeira, machas e usa porta está caida");
        
        if (TemItem() == true) {
            String Obj = ITEM.SortarItem();
            System.out.println("\n- E você achou uma " +Obj+ " !!!");
            msm.OqueFazerComItem(Obj, mochila, jogador);
        }
        else {
            System.out.println("\n- Mesmo olhando cada canto, você não achou nada");
        }
    }
    else {
        System.out.println("Você já olhou o Criado-Mudo");
    }
}
//==============================================================================


//==============================================================================
public void GuardaRoupa(boolean JaOlhou, INVENTARIO mochila, Jogador jogador) throws InterruptedException {
    if (JaOlhou == false) {
        System.out.println("Você decide olhar o Guarda-Roupa");
        System.out.println("    Suas portas estão caidas e ele não tem um dos Pés");
        
        if (TemItem() == true) {
            String obj = ITEM.SortarItem();
            System.out.println("\n- Você achou uma " +obj+ " !!!");
                msm.OqueFazerComItem(obj, mochila, jogador);
        }
        else {
            System.out.println("\n- Você olha por tudo, mas não acha nada");
        }
    }
    else {
        System.out.println("Você já olhou o Guarda-Roupa");
    }     
}
//==============================================================================


//==============================================================================
/*  O Quadro vai ter uma chance de 5% de ter um cobre que vai ter uma nova arma
A ideia é ter 4 arma diferentes, e cada uma tento um Dano difente

    Mas ainda não começei a fazer o sistema de combate, então não vou mexer nisso 
por agora                                                                     */
public void Quadro() {
    System.out.println("TERMINAR DEPOIS");
}
//==============================================================================
    
    
    
}
