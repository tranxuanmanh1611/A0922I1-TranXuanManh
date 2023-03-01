import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào đường dẫn file nguồn");
        String sourcePath = sc.next();
        System.out.println("Nhập vào đích đến");
        String destinationPath =sc.next();
        File fileSource = new File(sourcePath);
        File fileDestination = new File(destinationPath);
       try {
 //          copyFileUsingJavaFiles(fileSource,fileDestination);
           copyFileUsingStream(fileSource,fileDestination);
       }catch (IOException e){
           System.err.println("Không thể copy");
           e.printStackTrace();
       }
    }

    public static void copyFileUsingJavaFiles(File source, File destination) throws IOException {
        Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void copyFileUsingStream(File source, File destination) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {

            inputStream = new FileInputStream(source);
            outputStream = new FileOutputStream(destination);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        }finally {
            inputStream.close();
            outputStream.close();
        }
    }

}
