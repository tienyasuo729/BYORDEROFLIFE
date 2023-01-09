package FuramaResort.Model;

public class employee extends people{
    private String skills;

    public employee(int cccd, String name, int age, String skills) {
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
        return "employee{" +
                super.toString() + '\'' +
                "skills='" + skills + "} ";
    }

    @Override
    public void move() {
        System.out.println("Move on foot");
    }
}
