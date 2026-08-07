
package BASE.OUTROS;

import java.util.Scanner;


public class Entrada {
    
     public static int lerInt(Scanner sc) {
        while (true) {
            System.out.print("=> ");
            if (sc.hasNextInt()) {
                int numero = sc.nextInt();
                sc.nextLine(); // Limpa o ENTER
                return numero;
            } else {
                System.out.println("\nOpção inválida!");
                System.out.println("Digite apenas números.\n");
                sc.nextLine(); // Descarta o valor inválido
            }
        }
    }
    
}
