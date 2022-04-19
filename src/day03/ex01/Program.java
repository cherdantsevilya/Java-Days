package day03.ex01;

public class Program {

    public static void main(String[] args) throws InterruptedException {
        int num = 0;
        if (args.length == 1 && args[0].startsWith("--count=")) {
            num = Integer.parseInt(args[0].replaceAll("[^0-9]", ""));
        } else {
            System.out.println("Error");
            System.exit(-1);
        }

        ProducerConsumer obj = new ProducerConsumer();

        MyThread producer = new MyThread(num, "Egg", obj);
        MyThread consumer = new MyThread(num, "Hen", obj);

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
