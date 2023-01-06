package IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class textIO {
    public static void main(String[] args) throws IOException {
        String name = "tiến";
        try{
            FileWriter fileWriter = new FileWriter("data.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(name);
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            System.out.println("error");
        }
    }
}
