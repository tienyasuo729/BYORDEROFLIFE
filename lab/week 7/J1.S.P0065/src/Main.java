public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            StudentManager studentManager = new StudentManager();

            System.out.println("====== Quản lý thông tin học sinh ======");

            while (true) {
                System.out.print("Tên: ");
                String name = scanner.nextLine();
                System.out.print("Lớp: ");
                String className = scanner.nextLine();
                System.out.print("Toán: ");
                double math = scanner.nextDouble();
                System.out.print("Hóa học: ");
                double chemistry = scanner.nextDouble();
                System.out.print("Vật lý: ");
                double physics = scanner.nextDouble();

                Student student = new Student();
                student.setName(name);
                student.setClassName(className);
                student.setMath(math);
                student.setChemistry(chemistry);
                student.setPhysics(physics);

                studentManager.addStudent(student);

                System.out.print("Bạn có muốn nhập thông tin học sinh khác? (Y/N): ");
                String input = scanner.next();
                if (!input.equalsIgnoreCase("Y")) {
                    break;
                }

                scanner.nextLine(); // Xoá ký tự xuống dòng
            }

            studentManager.classifyStudents();

            int studentCount = 1;
            for (Student student : studentManager.getStudents()) {
                System.out.println("------ Thông tin học sinh " + studentCount + " ------");
                System.out.println("Tên: " + student.getName());
                System.out.println("Lớp: " + student.getClassName());
                System.out.println("Trung bình: " + student.getAverage());
                System.out.println("Loại: " + student.getType());
                studentCount++;
            }

            System.out.println("-------- Thống kê loại học sinh -----");
            HashMap<String, Double> typeStatistics = studentManager.getTypeStatistics();
            for (String type : typeStatistics.keySet()) {
                System.out.println(type + ": " + typeStatistics.get(type) + "%");
            }

            scanner.close();
        }
}