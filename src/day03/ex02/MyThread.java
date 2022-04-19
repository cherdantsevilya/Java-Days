package day03.ex02;

public class MyThread extends Thread {

   private int numOfThread;
   private int startOfRange;
   private int finishOfRange;
   private int[] arrayInt;
   private int sumOfRange;

   public MyThread(int i, int start, int finish, int[] array) {
       this.numOfThread = i;
       this.startOfRange = start;
       this.finishOfRange = finish;
       this.arrayInt = array;
   }

    @Override
    public void run() {
       for (int i = startOfRange; i <= finishOfRange; i++) {
           this.sumOfRange += arrayInt[i];
       }
        System.out.println("Thread " + numOfThread + ": from " + startOfRange + " to " + finishOfRange + " sum is " + sumOfRange);
    }

    public int getSum() { return this.sumOfRange; }

}
