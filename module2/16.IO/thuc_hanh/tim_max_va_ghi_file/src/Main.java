import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        String path = "D:\\\\codegym\\\\codegym\\\\module2\\\\16.IO\\\\thuc_hanh\\\\tim_max_va_ghi_file\\numbers.txt";
        List<Integer> numbers = readAndWriteFile.readFile(path);
        int max = FindMax.findMax(numbers);
        readAndWriteFile.writeFile(path, max);
    }
}
