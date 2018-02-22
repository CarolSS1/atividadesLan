import java.util.Scanner;
import java.util.*;
public class exercicioUm{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int h;
        float sal, valor;
        String n = "", v;

        System.out.printf("Nome do funcionario: ");
        n = input.next();
        System.out.printf("Horas trabalhadas: ");
        h = input.nextInt();
        System.out.printf("Valor pago por hora: ");
        v = input.next();
        valor = Float.parseFloat(v);
        sal = h*valor;
        System.out.printf("%s ", n);
        System.out.printf("seu salário é de R$ %f \n", sal);
    }
}
