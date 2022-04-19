package day03.ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {

    public static void main(String[] args) throws InterruptedException {

        int arraySize = 0;
        int threadsCount = 0;
        if (args.length == 2 && args[0].startsWith("--arraySize=") && args[1].startsWith("--threadsCount")) {
            arraySize = Integer.parseInt(args[0].replaceAll("[^0-9]", ""));
            threadsCount = Integer.parseInt(args[1].replaceAll("[^0-9]", ""));
            if (arraySize > 2_000_000 || arraySize < threadsCount) {
                System.out.println("Error");
                System.exit(-1);
            }
        } else {
            System.out.println("Error");
            System.exit(-1);
        }

        int[] arrayInt = new int[arraySize];
        Random random = new Random();
        int sum = 0;
        for (int i = 0; i < arraySize; i++) {
            arrayInt[i] = random.nextInt(1000);
            sum += arrayInt[i];
        }
        System.out.println("Sum: " + sum);


        int range = (arraySize / threadsCount);
        int start = 0;
        int finish = range - 1;
        List<MyThread> threads = new ArrayList<>();
        for (int i = 0; i < threadsCount - 1; i++) {
            MyThread thread = new MyThread(i + 1, start, finish, arrayInt);
            start += range;
            finish += range;
            threads.add(thread);
        }
        finish = arraySize - 1;
        MyThread thread = new MyThread(threadsCount, start, finish, arrayInt);
        threads.add(thread);

        int sumByThreads = 0;
        for (MyThread t : threads) {
            t.start();
        }
        for (MyThread t : threads) {
            t.join();
            sumByThreads += t.getSum();
        }
        System.out.println("Sum by threads: " + sumByThreads);
    }
}
