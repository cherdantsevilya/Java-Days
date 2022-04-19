package day03.ex00;

public class MyThread extends Thread {

    private int num;
    private String message;

    public MyThread(int num, String message) {
        this.num = num;
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            System.out.println(message);
        }
    }
}
