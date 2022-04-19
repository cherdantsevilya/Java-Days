package day03.ex01;

public class ProducerConsumer {
    private int capacity = 0;
    synchronized public void printMessage(String message) throws InterruptedException {
        if (message.equals("Egg")) {
            while (capacity == 1)
                wait();
            capacity = 1;
        } else {
            while (capacity == 0)
                wait();
            capacity = 0;
        }
        System.out.println(message);
        notify();
    }
}


