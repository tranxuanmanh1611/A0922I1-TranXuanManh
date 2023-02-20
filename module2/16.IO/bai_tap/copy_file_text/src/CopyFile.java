import java.io.*;
import java.util.LinkedList;

public class CopyFile {
    public LinkedList<String> readFile(String path) {
        LinkedList<String> data = new LinkedList<>();
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line);
            }
            bufferedReader.close();
            System.out.println("Da doc xong");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    public void writeStringToFile(String path,LinkedList<String> data){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
           String temp ="";
            for(String str :  data){
               temp+=str;
               temp+= "\n";
            }
            bufferedWriter.write(temp);
            System.out.println("Da ghi xong");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void copyFile(String source,String destination){

           writeStringToFile(destination,readFile(source));

    }
}
