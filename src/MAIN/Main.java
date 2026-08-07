package MAIN;

import BASE.COMBATE.Combate;
import BASE.COMBATE.DanoArmas;
import BASE.COMBATE.EscolhaArma;
import BASE.COMBATE.Monstro;
import BASE.HOTEL.Quarto;
import BASE.INTERACAO.Verficar_A_Mochila;
import BASE.INTERACAO.Verficar_Arma;
import BASE.INTERACAO.Verificar_Quarto;
import BASE.ITEM.DefinindoItem;
import BASE.ITEM.EfeitoItem;
import BASE.OUTROS.AnimacaoDaMensagem;
import BASE.OUTROS.Entrada;
import BASE.OUTROS.Mensagens;
import BASE.PERSONAGEM.INVENTARIO;
import BASE.PERSONAGEM.Jogador;
import BASE.SOM.Som;
import VISUAL.TESTE_DE_IMAGENS.TelaQuarto;
import VISUAL.COMBATE.*;
import java.util.Scanner;

import javax.swing.SwingUtilities;

/**
 * Único ponto de entrada do jogo.
 * Cria o jogador, a mochila e abre a tela do quarto.
 */
public class Main {

    public static void main(String[] args) {
        
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -    
// Aqui vai ficar todos os importes de tudo oque for usado

// Coisas do Java
    Scanner scL = new Scanner(System.in);
    
// Do Folder INTERACAO
    Verficar_A_Mochila IntVM = new Verficar_A_Mochila();
    Verficar_Arma IntVA = new Verficar_Arma();
    Verificar_Quarto IntVQ = new Verificar_Quarto();
    
// Do Folder do Combate
    DanoArmas DA = new DanoArmas(0, 0, 0);
    EscolhaArma EA = new EscolhaArma("Pistola");
    Monstro M = new Monstro(null, 0, 0);
    Combate C = new Combate();
    
// Do Folder Hotel
    Quarto Q = new Quarto();
    
// Do folder ITEM
    DefinindoItem DI = new DefinindoItem(null);
    EfeitoItem EI = new EfeitoItem();
    
// Do folder OUTROS
    Entrada scN = new Entrada();
    Mensagens MSM =  new Mensagens();
    AnimacaoDaMensagem AM = new AnimacaoDaMensagem();
    
// Do folder Personagem
    INVENTARIO I = new INVENTARIO();
    Jogador J = new Jogador(150);
    
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


//==============================================================================
// AQUI VAI COMEÇA O CÒDIGO
    EA.PISTOLA();
    DA.recarregarArma("Pistola");
    I.AdicionarItem("Bala");
    I.AdicionarItem("Banana");
    
    Som musica = new Som();
    musica.tocarLoop("/BASE/SOM/Musica_Fundo.wav");
    
    TelaQuarto tela = new TelaQuarto(I, J, DA, EA);
    tela.setVisible(true);
    
    }
}