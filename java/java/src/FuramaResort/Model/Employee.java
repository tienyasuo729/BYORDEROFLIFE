package FuramaResort.Model;

public class Employee extends People {
    private String skills;

    public Employee(String cccd, String name, int age, String skills) {
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
        return String.format("Employee ( CCCD: %s, Name: %s, Age: %s, Skill: %s )\n", super.getCccd(),super.getName(), super.getAge(), skills );
    }

    @Override
    public void move() {
        System.out.println("Move on foot");
    }
}
