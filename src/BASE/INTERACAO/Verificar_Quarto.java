
package BASE.INTERACAO;

import BASE.COMBATE.*;
import BASE.HOTEL.*;
import BASE.ITEM.*;
import BASE.OUTROS.*;
import BASE.PERSONAGEM.*;
import BASE.INTERACAO.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Verificar_Quarto {

    private static void cls() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
    
    Mensagens MSM = new Mensagens();
    AnimacaoDaMensagem AM = new AnimacaoDaMensagem();
    Scanner scL = new Scanner (System.in);
    
    
    // Quarto numero 0, o quarto que o jogador vai acordar
    public boolean Quarto_0 (boolean JaOlhou, String [][] Olhado_Quarto, 
    INVENTARIO I, Jogador J, Quarto Q) throws InterruptedException {
        
        if (JaOlhou == false) {
                boolean loop = false;
                boolean FinalizadorQuarto = false;
                int loop_2 = 1;
            
            do {
                MSM.Quarto(loop_2);
                loop_2++;
                int OP = Entrada.lerInt(scL);
                
                switch (OP) {
                    case 1 -> { // Verficar cama
                        if ("cama".equalsIgnoreCase(Olhado_Quarto[0][0])) {
                            loop = true;
                        }
                        else {
                            loop = false;
                            Olhado_Quarto[0][0] = "cama";
                        }
                        Q.Cama(loop, I, J);
                        break;
                    }
                    case 2 -> { // Verificar Criado-Mudo
                        if ("Criado-Mudo".equalsIgnoreCase(Olhado_Quarto[0][1])) {
                            loop = true;
                        }
                        else {
                            loop = false;
                            Olhado_Quarto[0][1] = "Criado-Mudo";
                        }
                        Q.CriadoMudo(loop, I, J);
                        break;
                    }
                    case 3 -> { // Verificar Guarda-Roupa
                        if ("Guarda-Roupa".equalsIgnoreCase(Olhado_Quarto[0][2])) {
                            loop = true;
                        }
                        else {
                            loop = false;
                            Olhado_Quarto[0][2] = "Guarda-Roupa";
                        }
                        Q.GuardaRoupa(loop, I, J);
                        break;
                    }
                    case 4 -> { // Quadro
                        if (!"Quadro".equalsIgnoreCase(Olhado_Quarto[0][3])) {
                            System.out.println("Fazer depois");
                            Olhado_Quarto[0][3] = "Quadro";
                        }
                        Q.Quadro();
                        break;
                    }
                    case 5 -> { // SAIR
                        System.out.println("Você já olhou o suficiente");
                        FinalizadorQuarto = true;
                        break;
                    }
                    default -> {
                        MSM.MensagemDeErro();
                    }
                }
                cls();
                
            } while (FinalizadorQuarto != true);
                if( ( "cama".equalsIgnoreCase(Olhado_Quarto[0][0]) ) &&
                    ( "Criado-Mudo".equalsIgnoreCase(Olhado_Quarto[0][1]) ) &&
                    ( "Guarda-Roupa".equalsIgnoreCase(Olhado_Quarto[0][2]) ) &&
                    ( "Quadro".equalsIgnoreCase(Olhado_Quarto[0][3]) ) ) {
                    
                    String Texto = "Não Tem Mais Nada Para Você Olhar Aqui";
                    AM.PalavraPorPalavra(Texto, 300);
                    JaOlhou =  true;
                }
            } 
            else {
                JaOlhou = false;
            }
            return JaOlhou;
    }
    
    
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -    
    // Quarto  número 1
    public boolean Quarto_1 (boolean JaOlhou, String [][] Olhado_Quarto, 
    INVENTARIO I, Jogador J, Quarto Q) throws InterruptedException {
        
        if (JaOlhou == false) {
                boolean loop = false;
                boolean FinalizadorQuarto = false;
                int loop_2 = 1;
            
            do {
                MSM.Quarto(loop_2);
                loop_2++;
                int OP = Entrada.lerInt(scL);
                
                switch (OP) {
                    case 1 -> { // Verficar cama
                        if ("cama".equalsIgnoreCase(Olhado_Quarto[1][0])) {
                            loop = true;
                        }
                        else {
                            loop = false;
                            Olhado_Quarto[1][0] = "cama";
                        }
                        Q.Cama(loop, I, J);
                        break;
                    }
                    case 2 -> { // Verificar Criado-Mudo
                        if ("Criado-Mudo".equalsIgnoreCase(Olhado_Quarto[1][1])) {
                            loop = true;
                        }
                        else {
                            loop = false;
                            Olhado_Quarto[1][1] = "Criado-Mudo";
                        }
                        Q.CriadoMudo(loop, I, J);
                        break;
                    }
                    case 3 -> { // Verificar Guarda-Roupa
                        if ("Guarda-Roupa".equalsIgnoreCase(Olhado_Quarto[1][2])) {
                            loop = true;
                        }
                        else {
                            loop = false;
                            Olhado_Quarto[1][2] = "Guarda-Roupa";
                        }
                        Q.GuardaRoupa(loop, I, J);
                        break;
                    }
                    case 4 -> { // Quadro
                        if (!"Quadro".equalsIgnoreCase(Olhado_Quarto[1][3])) {
                            System.out.println("Fazer depois");
                            Olhado_Quarto[1][3] = "Quadro";
                        }
                        Q.Quadro();
                        break;
                    }
                    case 5 -> { // SAIR
                        System.out.println("Você já olhou o suficiente");
                        FinalizadorQuarto = true;
                        break;
                    }
                    default -> {
                        MSM.MensagemDeErro();
                    }
                }
                cls();
                
            } while (FinalizadorQuarto != true);
                if( ( "cama".equalsIgnoreCase(Olhado_Quarto[1][0]) ) &&
                    ( "Criado-Mudo".equalsIgnoreCase(Olhado_Quarto[1][1]) ) &&
                    ( "Guarda-Roupa".equalsIgnoreCase(Olhado_Quarto[1][2]) ) &&
                    ( "Quadro".equalsIgnoreCase(Olhado_Quarto[1][3]) ) ) {
                    
                    String Texto = "Não Tem Mais Nada Para Você Olhar Aqui";
                    AM.PalavraPorPalavra(Texto, 300);
                    JaOlhou =  true;
                }
            } 
            else {
                JaOlhou = false;
            }
            return JaOlhou;
    }
//==============================================================================    
    
    
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -    
    // Quarto  número 2
    public boolean Quarto_2 (boolean JaOlhou, String [][] Olhado_Quarto, 
    INVENTARIO I, Jogador J, Quarto Q) throws InterruptedException {
        
        if (JaOlhou == false) {
                boolean loop = false;
                boolean FinalizadorQuarto = false;
                int loop_2 = 1;
            
            do {
                MSM.Quarto(loop_2);
                loop_2++;
                int OP = Entrada.lerInt(scL);
                
                switch (OP) {
                    case 1 -> { // Verficar cama
                        if ("cama".equalsIgnoreCase(Olhado_Quarto[2][0])) {
                            loop = true;
                        }
                        else {
                            loop = false;
                            Olhado_Quarto[2][0] = "cama";
                        }
                        Q.Cama(loop, I, J);
                        break;
                    }
                    case 2 -> { // Verificar Criado-Mudo
                        if ("Criado-Mudo".equalsIgnoreCase(Olhado_Quarto[2][1])) {
                            loop = true;
                        }
                        else {
                            loop = false;
                            Olhado_Quarto[2][1] = "Criado-Mudo";
                        }
                        Q.CriadoMudo(loop, I, J);
                        break;
                    }
                    case 3 -> { // Verificar Guarda-Roupa
                        if ("Guarda-Roupa".equalsIgnoreCase(Olhado_Quarto[2][2])) {
                            loop = true;
                        }
                        else {
                            loop = false;
                            Olhado_Quarto[2][2] = "Guarda-Roupa";
                        }
                        Q.GuardaRoupa(loop, I, J);
                        break;
                    }
                    case 4 -> { // Quadro
                        if (!"Quadro".equalsIgnoreCase(Olhado_Quarto[2][3])) {
                            System.out.println("Fazer depois");
                            Olhado_Quarto[2][3] = "Quadro";
                        }
                        Q.Quadro();
                        break;
                    }
                    case 5 -> { // SAIR
                        System.out.println("Você já olhou o suficiente");
                        FinalizadorQuarto = true;
                        break;
                    }
                    default -> {
                        MSM.MensagemDeErro();
                    }
                }
                cls();
                
            } while (FinalizadorQuarto != true);
                if( ( "cama".equalsIgnoreCase(Olhado_Quarto[2][0]) ) &&
                    ( "Criado-Mudo".equalsIgnoreCase(Olhado_Quarto[2][1]) ) &&
                    ( "Guarda-Roupa".equalsIgnoreCase(Olhado_Quarto[2][2]) ) &&
                    ( "Quadro".equalsIgnoreCase(Olhado_Quarto[2][3]) ) ) {
                    
                    String Texto = "Não Tem Mais Nada Para Você Olhar Aqui";
                    AM.PalavraPorPalavra(Texto, 300);
                    JaOlhou =  true;
                }
            } 
            else {
                JaOlhou = false;
            }
            return JaOlhou;
    }
//==============================================================================    

    
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -    
    // Quarto  número 3
    public boolean Quarto_3 (boolean JaOlhou, String [][] Olhado_Quarto, 
    INVENTARIO I, Jogador J, Quarto Q) throws InterruptedException {
        
        if (JaOlhou == false) {
                boolean loop = false;
                boolean FinalizadorQuarto = false;
                int loop_2 = 1;
            
            do {
                MSM.Quarto(loop_2);
                loop_2++;
                int OP = Entrada.lerInt(scL);
                
                switch (OP) {
                    case 1 -> { // Verficar cama
                        if ("cama".equalsIgnoreCase(Olhado_Quarto[3][0])) {
                            loop = true;
                        }
                        else {
                            loop = false;
                            Olhado_Quarto[3][0] = "cama";
                        }
                        Q.Cama(loop, I, J);
                        break;
                    }
                    case 2 -> { // Verificar Criado-Mudo
                        if ("Criado-Mudo".equalsIgnoreCase(Olhado_Quarto[3][1])) {
                            loop = true;
                        }
                        else {
                            loop = false;
                            Olhado_Quarto[3][1] = "Criado-Mudo";
                        }
                        Q.CriadoMudo(loop, I, J);
                        break;
                    }
                    case 3 -> { // Verificar Guarda-Roupa
                        if ("Guarda-Roupa".equalsIgnoreCase(Olhado_Quarto[3][2])) {
                            loop = true;
                        }
                        else {
                            loop = false;
                            Olhado_Quarto[3][2] = "Guarda-Roupa";
                        }
                        Q.GuardaRoupa(loop, I, J);
                        break;
                    }
                    case 4 -> { // Quadro
                        if (!"Quadro".equalsIgnoreCase(Olhado_Quarto[3][3])) {
                            System.out.println("Fazer depois");
                            Olhado_Quarto[3][3] = "Quadro";
                        }
                        Q.Quadro();
                        break;
                    }
                    case 5 -> { // SAIR
                        System.out.println("Você já olhou o suficiente");
                        FinalizadorQuarto = true;
                        break;
                    }
                    default -> {
                        MSM.MensagemDeErro();
                    }
                }
                cls();
                
            } while (FinalizadorQuarto != true);
                if( ( "cama".equalsIgnoreCase(Olhado_Quarto[3][0]) ) &&
                    ( "Criado-Mudo".equalsIgnoreCase(Olhado_Quarto[3][1]) ) &&
                    ( "Guarda-Roupa".equalsIgnoreCase(Olhado_Quarto[3][2]) ) &&
                    ( "Quadro".equalsIgnoreCase(Olhado_Quarto[3][3]) ) ) {
                    
                    String Texto = "Não Tem Mais Nada Para Você Olhar Aqui";
                    AM.PalavraPorPalavra(Texto, 300);
                    JaOlhou =  true;
                }
            } 
            else {
                JaOlhou = false;
            }
            return JaOlhou;
    }
//==============================================================================
    
    
}
