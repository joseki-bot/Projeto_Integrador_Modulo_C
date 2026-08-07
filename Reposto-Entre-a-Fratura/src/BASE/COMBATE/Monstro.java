
package BASE.COMBATE;

import java.util.Random;

public class Monstro {
    private String NomeMostro;
    private int VidaMostro, DanoMostro;

    public Monstro(String NomeMostro, int VidaMostro, int DanoMostro) {
        this.NomeMostro = NomeMostro;
        this.VidaMostro = VidaMostro;
        this.DanoMostro = DanoMostro;
    }

    
    // Nome do Mostro
    public String getNomeMostro() {
        return NomeMostro;
    }
    public void setNomeMostro(String NomeMostro) {
        this.NomeMostro = NomeMostro;
    }

    
    // Vida do Mostro 
    public int getVidaMostro() {
        if (VidaMostro < 0) {
            VidaMostro = 0;
        }
        return VidaMostro;
    }
    public void setVidaMostro(int VidaMostro) {
        this.VidaMostro = VidaMostro;
    }

    
    // Dano do Mostro
    public int getDanoMostro() {
        return DanoMostro;
    }
    public void setDanoMostro(int DanoMostro) {
        this.DanoMostro = DanoMostro;
    }
    
    
    public void SortearMonstro () {
        Random ale = new Random();
        int Sorte = ale.nextInt(5);
        
        switch (Sorte) { 
            case 0 -> { // Zumbi
                setNomeMostro("Zumbi");
                setVidaMostro(100);
                setDanoMostro(15);
                break;
            }
            case 1 -> { // Esqueleto
                setNomeMostro("Esqueleto");
                setVidaMostro(75);
                setDanoMostro(35);
                break;
            }
            case 2 -> { // Goblin
                setNomeMostro("Goblin");
                setVidaMostro(50);
                setDanoMostro(2);
                break;
            }
            case 3 -> { // Lobo
                setNomeMostro("Lobo");
                setVidaMostro(65);
                setDanoMostro(10);
                break;
            }
            case 4 -> { // Aranha
                setNomeMostro("Aranha");
                setVidaMostro(50);
                setDanoMostro(20);
                break;
            }
        }
    }    
    public void MAHORAGA () {
        setNomeMostro("MAHORAGA");
        setVidaMostro(1069);
        setDanoMostro(26);
    }
    
    
    public void MonstroLevaDano(int dano) {
        this.VidaMostro -= dano;
    }
    
}
