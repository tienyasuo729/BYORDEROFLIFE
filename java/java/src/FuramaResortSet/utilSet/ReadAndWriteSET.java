package FuramaResortSet.utilSet;

import FuramaResortSet.ModelSet.EmployeeSET;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Set;
import java.util.TreeSet;

public class ReadAndWriteSET {

//    public static void write(Set<EmployeeSET> employeeList){
//        try {
//            FileWriter fileWriter =new FileWriter("D:\\codegym\\text\\java\\java\\src\\FuramaResortSet\\DataSet\\EmployeeSet");
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            for (EmployeeSET e: employeeList) {
//                bufferedWriter.write(e.toString());
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//            fileWriter.close();
//        }catch (Exception e){
//            System.out.println("Error, can not find file");
//        }
//    }

    public static void write(EmployeeSET employeeList){
        try {
            FileWriter fileWriter =new FileWriter("C:\\codegym\\text\\java\\java\\src\\FuramaResortSet\\DataSet\\EmployeeSet", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(employeeList));
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Error, can not find file");
        }
    }

    public static Set<EmployeeSET> ReadAll(){
        Set<EmployeeSET> list = new TreeSet<>();
        String [] nn;
        String line = null;
        try{
            FileReader fileReader = new FileReader("C:\\codegym\\text\\java\\java\\src\\FuramaResortSet\\DataSet\\EmployeeSet");
            BufferedReader bufferedReader =new BufferedReader(fileReader);
            do {
                line = bufferedReader.readLine();
                if (line != null){
                    nn = line.split(",");
                    list.add(new EmployeeSET(nn[0],nn[1],Integer.parseInt(nn[2]),nn[3]));
                }
            }while (line != null);
            bufferedReader.close();
            fileReader.close();
        }catch (Exception e){
            System.out.println("error");
        }
        return list;
    }

    public static String Read(String pathFile){
        String line = null;
        try{
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader =new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
        }catch (Exception e){

        }
        return line;
    }
}
