    import java.util.Scanner;

    public class Test {
        private static lab3a.Person[] person = new lab3a.Person[4];

        public static void main(String[] args) {
            person[0]= new lab3a.Person(1, "nguyen van a", true);
            person[1]= new lab3a.Person(2, "nguyen van b", true);
            scanInfo();
            printInfo();
        }

        public static void scanInfo() {
            for (int i = 0; i < person.length; i++) {
                if (person[i] == null){
                    Scanner input = new Scanner(System.in);
                    person[i] = new lab3a.Person();
                    System.out.print("Enter ID: ");
                    int id = input.nextInt();
                    input.nextLine();
                    person[i].setId(id);
                    System.out.print("Enter Name: ");
                    person[i].setName(input.nextLine());
                    System.out.print("Enter Gender: ");
                    person[i].setGender(Boolean.parseBoolean(input.nextLine()));
                }
            }
        }

        public static void printInfo() {
            for (int i = 0; i < person.length; i++) {
                System.out.println("-------------------");
                System.out.println("| ID  | Name  | Gender |");
                System.out.printf("| %d | %s | %s    |\n", person[i].getId(), person[i].getName(), (person[i].getGender() ? "Male" : "Female"));
            }
        }
    }


