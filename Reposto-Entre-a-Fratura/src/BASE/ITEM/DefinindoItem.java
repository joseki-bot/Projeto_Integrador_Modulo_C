package BASE.ITEM;

import java.util.Random;

public class DefinindoItem {
    private String [] Item;

    public DefinindoItem (String[] Item) {
        this.Item = new String [] {"Bala", "Maçã", "Banana", "Poção", "Erva"};
    }

    public String[] getItem() {
        return Item;
    }
    
    

    public String SortarItem () {
        Random ale = new Random();
        int Quantidade = Item.length - 1;
        int sorte = ale.nextInt(0, Quantidade);
        
        return Item[sorte];
    }
    
    
}
