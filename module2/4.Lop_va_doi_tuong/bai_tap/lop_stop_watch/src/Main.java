public class Main {
    public static void main(String[] args){
        StopWatch watch1 = new StopWatch();
        watch1.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i)   ;
        }
      watch1.stop();
        System.out.println("thời gian thuc thi:"+ watch1.getElapsedTime()+" ms");
    }
}


