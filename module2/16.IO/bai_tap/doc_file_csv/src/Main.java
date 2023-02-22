public class Main {
    public static void main(String[] args) {
        for (Countries country : WriteAndRead.readFile("D:\\codegym\\codegym\\module2\\16.IO\\bai_tap\\doc_file_csv\\countries")) {
            System.out.println(country.toStringToFile());
        }
    }
}

