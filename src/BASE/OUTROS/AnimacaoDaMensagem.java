package BASE.OUTROS;

public class AnimacaoDaMensagem {
    public void LetraPorLetra (String Texto, int Velocidade) throws InterruptedException {
        
        for (int i = 0; i<Texto.length(); i++) {
            System.out.print(Texto.charAt(i));
        }
    }
    
    public void PalavraPorPalavra (String Texto, int Valocidade) throws InterruptedException {
        String[] palavras = Texto.split(" ");

        for (int i = 0; i < palavras.length; i++) {
            System.out.print(palavras[i] + " ");
        }
    }
}
