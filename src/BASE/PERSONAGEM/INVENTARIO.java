package BASE.PERSONAGEM;

import java.util.ArrayList;
import BASE.ITEM.*;
import BASE.PERSONAGEM.*;

public class INVENTARIO{
    
//==============================================================================
    EfeitoItem EI = new EfeitoItem();
    
//==============================================================================
    
    
//==============================================================================
/*
    Esse metodo vai ser usado para ser o inventarios, ele no primeiro momento vai
    ser usado como base e ser puxado por outros métodos
*/
    ArrayList <String> Inventario;
    private String Item;

    public INVENTARIO() {
        Inventario = new ArrayList<>();
    }
    
    public INVENTARIO(ArrayList<String> Inventario) {
        this.Inventario = Inventario;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String Item) {
        this.Item = Item;
    }
    
    public ArrayList<String> getInventario() {
        return Inventario;
    }
    
//==============================================================================

//==============================================================================
/*
    Esse método vai ser usado para Mostrar os item que o jogador escolheu guardar
na mochila
*/
    public boolean MostrarInventarios() {
        int contador = 1;
        boolean TemItem = false;
        
        if (!Inventario.isEmpty()) {
            System.out.println("Dentro da mochila tem os seguintes itens\n");
            for (String mostrar : Inventario) {
                System.out.print("| " +contador);
                System.out.printf("-> %-10s" ,mostrar);
                if (contador % 2 == 0) {
                }
                contador++;
            }
            TemItem = true;
        }
        else {
            System.out.println("E você vê que não tem nada dentro da Mochila");
            TemItem = false;
        }
        return TemItem;
    }
//==============================================================================
    
//==============================================================================
/*
    Esse metodo é para adicionar um item no inventário, e o inventario va ser
limitado a 10 itens    
 */
    public void AdicionarItem (String Item) {
        String Gambiara = Item;
        if (Inventario.size() < 10) {
            System.out.println("Você adicionou " +Gambiara+ " na Mochila");
            Inventario.add(Gambiara);
        }
        else {
            System.out.println("A Mochila está cheia, não é possivel adicionar mais nada");
        }
    }
//==============================================================================
/*
    Esse metódo é para remover um item que já está guardado dentro da mochila
*/
    public void RemoverItemMochila (int Escolha) {
        if ( (Escolha < 1) || (Escolha > 10) || (Escolha > Inventario.size()) ) {
            System.out.println("Opção Invalida !!!");
            System.out.println("Por Favor escolha um dos itens Listado");
        }
        else {
            System.out.println("Você jogou fora " +Inventario.get(Escolha-1)+ "");
            Inventario.remove(Escolha-1);
        }
    }
//==============================================================================
    
//==============================================================================
    public void UsarItemMochila (int Escolha, Jogador jogador) throws InterruptedException {
        if ( (Escolha < 1) || (Escolha > 10) || (Escolha > Inventario.size()) ) {
            System.out.println("Opção Invalida !!!");
            System.out.println("Por Favor escolha um dos itens Listado");
        }
        else {
            setItem(Inventario.get(Escolha-1));
            System.out.println("Você usou " +Inventario.get(Escolha-1)+ "");
            Inventario.remove(Escolha-1);
            
            EI.Efeito(Item, jogador);
        }
    }
//==============================================================================
    
    
//==============================================================================
    public boolean VerSeTemBala () {
        return Inventario.contains("Bala");
    }
//==============================================================================

    
//==============================================================================
    public void REMOVER (String ITEM) {
        Inventario.remove(ITEM);
    }
//==============================================================================


    
}
