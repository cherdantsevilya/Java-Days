import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "Week";
        int countOfWeek = 0;
        int minGrade = 0;
        long listMinGrade = 0;

        while (true) {
            if (in.hasNextInt() && in.nextInt() == 42) {
                printList(listMinGrade, countOfWeek);
                in.close();
                System.exit(0);
            }
            if (str.equals(in.next()) == false) {
                System.err.println("IllegalArgument: " + str);
                in.close();
                System.exit(-1);
            }
            if (in.hasNextInt() && in.nextInt() == ++countOfWeek) {
                if (countOfWeek > 18) {
                    System.err.println("IllegalArgument: 18 weeks is the max");
                    in.close();
                    System.exit(-1);
                }
                minGrade = getMinGrade(in);
                listMinGrade = getListMinGrade(listMinGrade, minGrade);
            }
            else {
                System.err.println("IllegalArgument: weeks should go in order");
                in.close();
                System.exit(-1);
            }
        }
    }
    
    private static int getMinGrade(Scanner in) {
        int min = 10;
        for (int i = 0; i < 5; i++) {
            int num = in.nextInt();
            if (num < min)
                min = num;
        }
        return (min);
    }

    private static long getListMinGrade(long list, int grade) {
        if (list != 0)
            list *= 10;
        list += grade;
        return (list);
    }

    private static void printList(long listMinGrade, int countOfWeek) {
        long div = 1;

        for (int i = 1; i < countOfWeek; i++)
            div *= 10;
        for (int j = 1; j <= countOfWeek; j++) {
            System.out.print("Week " + j + " ");
            for (int k = 1; k <= listMinGrade / div; k++)
                System.out.print("=");
            System.out.println(">");
            listMinGrade = listMinGrade % div;
            div = div / 10;
        }
    }
}