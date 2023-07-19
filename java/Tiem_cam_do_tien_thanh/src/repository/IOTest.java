    package repository;

    import model.*;

    import java.io.*;
    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;

    public class IOTest {
        public static List<Phone> phonesRepository = new ArrayList<>();
        public static List<Laptop> laptopsRepository = new ArrayList<>();
        public static List<Vehicle> vehiclesRepository = new ArrayList<>();
        private static String filePhone = "D:\\codegym\\text\\java\\Tiem_cam_do_tien_thanh\\src\\data\\Phone";
        private static String fileLaptop = "D:\\codegym\\text\\java\\Tiem_cam_do_tien_thanh\\src\\data\\Laptop";
        private static String fileVehicle = "D:\\codegym\\text\\java\\Tiem_cam_do_tien_thanh\\src\\data\\Vehicle";
        public static void writePhone() {
            try {
                FileWriter fileWriter = new FileWriter(filePhone);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (Phone phone : phonesRepository) {
                    String phoneText = phone.toString();
                    bufferedWriter.write(phoneText);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                fileWriter.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public static void writeLaptop() {
            try {
                FileWriter fileWriter = new FileWriter(fileLaptop);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (Laptop laptop : laptopsRepository) {
                    // Ghi thông tin của từng đối tượng Phone vào file dưới dạng văn bản
                    String phoneText = laptop.toString();
                    bufferedWriter.write(phoneText);
                    bufferedWriter.newLine(); // Xuống dòng sau khi ghi mỗi đối tượng
                }
                bufferedWriter.close();
                fileWriter.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public static void writeVehicle() {
            try {
                FileWriter fileWriter = new FileWriter(fileVehicle);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (Vehicle vehicle : vehiclesRepository) {
                    // Ghi thông tin của từng đối tượng Phone vào file dưới dạng văn bản
                    String phoneText = vehicle.toString();
                    bufferedWriter.write(phoneText);
                    bufferedWriter.newLine(); // Xuống dòng sau khi ghi mỗi đối tượng
                }
                bufferedWriter.close();
                fileWriter.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static void readPhone() {
            try {
                FileReader fileReader = new FileReader(filePhone);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split("\\|");

                    // Remove any leading/trailing spaces for each part
                    for (int i = 0; i < parts.length; i++) {
                        parts[i] = parts[i].trim();
                    }

                    // Extract individual values from parts array
                    int id = Integer.parseInt(parts[0].split("\\.")[0].trim());
                    String name = parts[1].split(":")[1].trim();
                    String cccd = parts[2].split(":")[1].trim();
                    int price = Integer.parseInt(parts[3].split(":")[1].trim());
                    String manufacturerPhone = parts[4].split(":")[1].trim();
                    String namePhone = parts[5].split(":")[1].trim();
                    String pawnDateStr = parts[6].split(":")[1].trim();
                    Date pawnDate = null;
                    try {
                        pawnDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(pawnDateStr);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    String phoneNumber = parts[7].split(":")[1].trim();
                    String password = parts[8].split(":")[1].trim();
                    String status = parts[9].split(":")[1].trim();
                    String note = parts[10].split(":")[1].trim();

                    // Create and return the Phone object
                    phonesRepository.add(new Phone(id, name, cccd, price, phoneNumber, pawnDate, note, manufacturerPhone, namePhone, password, status));
                }
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public static void readLaptop() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileLaptop);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                laptopsRepository = (List<Laptop>) objectInputStream.readObject();
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
        public static void readVehicle() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileVehicle);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                vehiclesRepository = (List<Vehicle>) objectInputStream.readObject();
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
