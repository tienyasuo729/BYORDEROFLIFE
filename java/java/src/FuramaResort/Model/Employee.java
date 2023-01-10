package FuramaResort.Model;

public class Employee extends People {
    private String skills;

    public Employee(int cccd, String name, int age, String skills) {
        super(cccd, name, age);
        this.skills = skills;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "skills='" + skills + '\'' +
                "} " + super.toString();
    }

    @Override
    public void move() {
        System.out.println("Move on foot");
    }
}
