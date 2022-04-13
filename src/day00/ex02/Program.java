import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int countCoffeeRequest = 0;
        int num;

        while (true) {
            if (in.hasNextInt()) {
                num = in.nextInt();
                if (num == 42) {
                    System.out.println("Count of coffee-request – " + countCoffeeRequest);
                    in.close();
                    System.exit(0);
                }
                if (primeNumber(num))
                    countCoffeeRequest++;
            }
            else {
                System.out.println("IllegalArgument");
                in.close();
                System.exit(-1); 
            }
        }
    }

    private static boolean primeNumber(int num) {
        int result = 0;

        while (num > 0) {
            result += num % 10;
            num = num / 10;
        }
        if (result > 1) {
            int count;
            for (count = 2; count * count <= result; count++) {
                if (result % count == 0)
                    return (false);
            }
            return (true);
        }
        return (false);
    }
}