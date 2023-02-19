import java.util.Random;

public class CreateRandomArray {
    public int[] createRandomArray() {
        Random rd = new Random();
        int[] randomArray = new int[100];
        for (int i = 0; i < 100; i++) {
            randomArray[i] = rd.nextInt();
        }
        return randomArray;
    }
}
