import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int num = 0;
        
        if (in.hasNextInt()) {
            num = in.nextInt();
            in.close();
        }
        else {
            System.err.println("IllegalArgument");
            in.close();
            System.exit(-1);
        }
        if (num < 2) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        } 
        else {
            int count;
            for (count = 2; count * count <= num; count++) {
                if (num % count == 0) {
                    System.out.println("false " + --count);
                    System.exit(0);
                }
            }
            System.out.println("true " + --count);
        }
    }
}