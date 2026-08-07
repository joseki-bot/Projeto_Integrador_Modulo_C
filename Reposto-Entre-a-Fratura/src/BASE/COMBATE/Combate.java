
package BASE.COMBATE;

import BASE.PERSONAGEM.*;
import BASE.OUTROS.*;
import BASE.SOM.*;
import java.util.*;


public class Combate {
    
    Entrada scN = new Entrada();
    Mensagens MSM = new Mensagens();
    Scanner scL = new Scanner (System.in);
    Random ale = new Random();
    
    public boolean Luta(Jogador J, Monstro M, DanoArmas DA, EscolhaArma EA, INVENTARIO I) throws InterruptedException {
        boolean Tem_Bala = false ;
        boolean Armado = true;
        boolean finalizador = false;
        boolean PQSIM = false;
        boolean CONFIRMADOR = true;
        
        int multiplicador = 1;
        int Sorte = 0;
        
    do {
        if (PQSIM == false) {
            Tem_Bala = DA.TemBala(EA.getArma());
        }
        
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ Jogador:                  ║");
        System.out.printf ("║ Vida : %-19d║%n", J.getVida());
        System.out.printf ("║ Bala : %-19d║%n", DA.getBala());
        System.out.printf ("║ Arma : %-19s║%n", EA.getArma());
        System.out.println("╠══════════════════════════════╣");
        System.out.printf ("║ Monstro : %-16s║%n", M.getNomeMostro());
        System.out.printf ("║ Vida : %-19d║%n", M.getVidaMostro());
        System.out.println("╠══════════════════════════════╣");
        MSM.Menu_Combate(Armado);
        int Escolha = scN.lerInt(scL);
        
        switch (Escolha) {
            case 1 -> { // Atacar
                if (Tem_Bala == true) {
                    System.out.println("DANO: " +EA.ATAQUE());
                    M.MonstroLevaDano(EA.ATAQUE());
                    if (Armado == true) {
                        DA.MininuirBala();
                    }
                }
                else {
                    System.out.println("VOCÊ ESTÁ SEM BALA");
                }
                break;
            }
            case 2 -> { // Mirar
                Sorte = ale.nextInt(1, 11);
                if (Tem_Bala == true) {
                    if (Sorte <=7) {
                        System.out.println("VOCÊ MIRA E CONSEGUE ACERTAR  " +M.getNomeMostro());
                        System.out.println("DANO: " +EA.ATAQUE() * 2);
                        M.MonstroLevaDano(EA.ATAQUE()*2);
                    
                        if (Armado == true) {
                            DA.MininuirBala();
                        }
                    }
                    else {
                        System.out.println("VOCÊ MIRA, MAS " +M.getNomeMostro()+ " CHEGOU MUITO PERTO");
                        multiplicador = 2;
                    }
                }
                else {
                    System.out.println("VOCÊ ESTÁ SEM BALA");
                }
                break;
            }
            case 3 -> { // Abrir a mochila
                boolean Tem_Item = I.MostrarInventarios();
                
                if (Tem_Item == true) {
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
            case 4 -> { // Recargar
                System.out.println("Você abrir a mochila procurando por Munição");
                if (I.VerSeTemBala() == true) {
                    System.out.println("E consegue achar");
                    I.REMOVER("Bala");
                    DA.recarregarArma(EA.getArma());
                }
                else {
                    Armado = false;
                    System.out.println("E não consegue achar nada");
                    System.out.println("\nVOCÊ TEM UMA OPÇÃO");
                    System.out.println("SAIR NO SOCO");
                    EA.SOCO();
                    Armado = false;
                    PQSIM = false;
                }
                break;
            }
            case 69 -> { // Comando para pode zera a vida do jogador
                J.setVida(0);
                
            }
            
        }
        
        if (M.getVidaMostro() > 0) {
            Sorte = ale.nextInt(1, 11);
            if (Sorte <= 5) {
                System.out.println(M.getNomeMostro()+" te ataca");
                J.LevarDano(M.getDanoMostro() * multiplicador);
                System.out.println("DANO LEVADO: " + M.getDanoMostro() * multiplicador);
                multiplicador = 1;
            }
            else if (Sorte >= 7) {
                System.out.println(M.getNomeMostro()+ " erra o seu ataque");
                multiplicador = 1;
            }
            else {
                System.out.println(M.getNomeMostro() + " começa a prepara um ataque");
                multiplicador = multiplicador * 3;
            }
        }
        if (J.getVida() <= 0) {
            finalizador = true;
            CONFIRMADOR = false;
        }
        else if (M.getVidaMostro() <= 0){
            finalizador = true;
            CONFIRMADOR = true;
        }
    } while (finalizador != true);  
        return CONFIRMADOR;
    }
    
}
