import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndRead {

    public static final String BLANK = "";
    public static final String COMMA = ",";

    public static void writeFile(String path, List<Countries> countriesList) {
        try {
            File file = new File(path);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Countries country : countriesList) {
                bufferedWriter.write(country.toStringToFile());
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Countries> readFile(String path) {
        List<Countries> countriesList = new ArrayList<>();
        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().equals(BLANK)) {
                    continue;
                }
                String[] entry = line.split(COMMA);
                countriesList.add(new Countries(Integer.parseInt(entry[0]), entry[1], entry[2]));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countriesList;
    }
}
