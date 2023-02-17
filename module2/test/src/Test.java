import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        File newFile = new File("CodeGym.txt");
        InputStream is = new FileInputStream("CodeGym.txt");

        int i = -1;

        // Đọc lần lượt các byte (8bit) trong luồng và lưu vào biến i
        // Khi đọc ra giá trị -1 nghĩa là kết thúc luồng.
        while ((i = is.read()) != -1) {
            System.out.println((char) i);
        }
        is.close();
    }

    public static int sum(int n) {
        if (n >= 1) {
            return sum(n - 1) + n;
        }
        return n;
    }
}


