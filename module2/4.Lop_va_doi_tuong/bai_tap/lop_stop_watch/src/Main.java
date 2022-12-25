import java.util.Random;

public class Main {
    public static void main(String[] args){
        StopWatch watch1 = new StopWatch();
        watch1.start();
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            Random rand = new Random();
            array[i]= rand.nextInt();
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
      watch1.stop();
        System.out.println("thời gian thuc thi:"+ watch1.getElapsedTime()+" ms");
    }
}


