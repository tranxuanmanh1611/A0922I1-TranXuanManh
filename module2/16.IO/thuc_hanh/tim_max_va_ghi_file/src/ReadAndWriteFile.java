import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath) {
        List<Integer> numbers = null;
        try {
            numbers = new ArrayList<>();
            File file = new File(filePath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Đường dẫn file bị sai hoặc file không tồn tại");
        } catch (Exception e) {
            System.err.println("Nội dung lỗi");
        }
        return numbers;
    }

    public void writeFile(String filePath, int max) {
        try {
            File file = new File(filePath);
            FileWriter writer = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("\n"+"Max là: " +max);
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Đường dẫn file bị sai hoặc file không tồn tại");
        }
    }
}
