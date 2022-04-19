package day03.ex00;

public class Program {

    public static void main(String[] args) throws InterruptedException {
        int num = 0;
        if (args.length == 1 && args[0].startsWith("--count=")) {
            num = Integer.parseInt(args[0].replaceAll("[^0-9]", ""));
        } else {
            System.out.println("Error");
            System.exit(-1);
        }

        MyThread thread1 = new MyThread(num, "Egg");
        MyThread thread2 = new MyThread(num, "Hen");

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        for (int i = 0; i < num; i++) {
            System.out.println("Human");
        }
    }
}
