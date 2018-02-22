import java.util.Scanner;
import java.util.*;
public class desafioBin{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num, i = 0;
        String bin = " ";

        System.out.println("Digite o número: ");
        num = input.nextInt();
        do{
            bin += num%2;
            num /= 2;
            ++i;
        }while(num!=0);

        StringBuffer binario = new StringBuffer(bin);
        binario.reverse();
        System.out.print(binario);
    }
}
