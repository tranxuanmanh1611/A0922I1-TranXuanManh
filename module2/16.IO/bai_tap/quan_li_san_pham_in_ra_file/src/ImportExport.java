import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImportExport {
    public static void exportData(String path, List<Product> productList) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Đã xuất file");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Product> importData(String path) {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<Product> productList = new ArrayList<>();
            productList = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return productList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

