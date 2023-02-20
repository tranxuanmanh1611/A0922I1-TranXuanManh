public class Main {
    public static void main(String[] args) {
        String sourcePath = "D:\\codegym\\codegym\\module2\\16.IO\\bai_tap\\copy_file_text\\source_copy\\sourceFile.txt";
        String destinationPath = "D:\\codegym\\codegym\\module2\\16.IO\\bai_tap\\copy_file_text\\destination_copy\\destinationFile.txt";
        CopyFile copyFile = new CopyFile();
        copyFile.copyFile(sourcePath, destinationPath);
    }
}
