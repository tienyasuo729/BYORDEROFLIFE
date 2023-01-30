package FuramaResortSet.utilSet;

import FuramaResort.Model.Employee;
import FuramaResortSet.ModelSet.EmployeeSET;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Set;

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
            FileWriter fileWriter =new FileWriter("D:\\codegym\\text\\java\\java\\src\\FuramaResortSet\\DataSet\\EmployeeSet", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(employeeList));
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Error, can not find file");
        }
    }

    public static void Read(String pathFile){
        try{
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader =new BufferedReader(fileReader);

            bufferedReader.close();
            fileReader.close();
        }catch (Exception e){

        }
    }
}
