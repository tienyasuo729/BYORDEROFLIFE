package repository;

import model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOTest {
    static String file = "C:\\codegym\\text\\java\\Tiem_cam_do_tien_thanh\\src\\data\\file";

    public static void write(Customer[] customers) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(customers);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void read() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Customer[] restoredCustomers = (Customer[]) objectInputStream.readObject();
            System.out.println("Đọc file thành công.");

            // In thông tin khách hàng đã đọc
            for (Customer a : restoredCustomers) {
                System.out.println(a.toString());
            }
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
