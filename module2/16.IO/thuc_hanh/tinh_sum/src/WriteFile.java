import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public void writeNumber(String path, int number) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Integer.toString(number));
            bufferedWriter.write("\n");
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Đường dẫn sai, hoặc file không tồn tại");
        } finally {
            System.out.println("Đã thêm thành công số " + number);
        }
    }
    public void writeString(String path,String data) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.write("\n");
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Đường dẫn sai, hoặc file không tồn tại");
        } finally {
            System.out.println("Đã thêm thành công data " +"'"+ data+"'");
        }
    }
}
