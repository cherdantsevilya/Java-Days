package day03.ex01;

public class MyThread extends Thread {

    private int num;
    private String message;
    private ProducerConsumer obj;

    public MyThread(int num, String message, ProducerConsumer obj) {
        this.num = num;
        this.message = message;
        this.obj = obj;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            try {
                obj.printMessage(message);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
