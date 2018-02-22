import java.util.Scanner;
import java.util.*;
import java.util.Random;
public class exercicioTres{
    public static void main(String[] args){
        Random gerador = new Random();
        Scanner input = new Scanner(System.in);
        int num_aleatorio = gerador.nextInt(11);
        int c=3, num=0;
        while(c>0){
            System.out.println("\nInforme o número: ");
            num = input.nextInt();
            if(num == num_aleatorio){
                System.out.println("Parabéns! Você acertou!");
                c = 0;
            } else {
                --c;
                if(c == 0){
                System.out.printf("Você perdeu! O número era %d \n", num_aleatorio);
                } else {
                    System.out.printf("Você errou! Ainda tem %d chance(s) \n", c);
                }

            }
        }
    }
}
