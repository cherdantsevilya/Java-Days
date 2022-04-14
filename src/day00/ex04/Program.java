import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        char [] lineArray = line.toCharArray();
        int [] characterArray = new int[65535];
        int [] charsArray = new int[10];
        int [] countSymbArray = new int[10];
        int [] heightArray = new int[10];
        int i, j, countSymb, charSymb, max;

        for (i = 0; i < line.length(); i++) {
            characterArray[lineArray[i]]++;
            if (characterArray[lineArray[i]] > 999) {
                System.out.println("Error: 999");
                System.exit(-1);
            }
        }
        for (i = 0; i < 10; i++) {
            charSymb = 0;
            countSymb = 0;
            for (j = 0; j < 65535; j++) {
                if (characterArray[j] > countSymb) {
                    countSymb = characterArray[j];
                    charSymb = j;
                }
            }
            charsArray[i] = charSymb;
            countSymbArray[i] = countSymb;
            characterArray[charSymb] = 0;
        }
        max = countSymbArray[0];
        if (max <= 0)
            System.exit(0);
        if (countSymbArray[0] < 10) {
            for (i = 0; i < 10; i++)
                heightArray[i] = countSymbArray[i];
        }
        else {
            for (i = 0; i < 10; i++)
                heightArray[i] = countSymbArray[i] * 10 / max;
        }
        for (i = 10; i >= 0; i--) {
            for (j = 0; j < 10; j++) {
                if (countSymbArray[j] == 0)
                    continue ;
                if (i > heightArray[j])
                    System.out.print("   ");
                else if (i == heightArray[j])
                    System.out.print("  " + countSymbArray[j]);
                else
                    System.out.print("  #");
            }
            System.out.println();
        }
        for (i = 0; i < 10; i++)
            System.out.print("  " + (char)charsArray[i]);
        System.out.println();
    }
}