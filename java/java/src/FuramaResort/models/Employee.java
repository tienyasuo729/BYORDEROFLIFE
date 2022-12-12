package FuramaResort.Models;

public class Employee extends Person{
    private String timeForJob;
    private String skill;
    private String degree;

    public Employee(int cccd, String name, int age, String gender, String timeForJob, String skill, String degree) {
        super(cccd, name, age, gender);
        this.timeForJob = timeForJob;
        this.skill = skill;
        this.degree = degree;
    }

    public void howToMove(String move){
        System.out.println(move);
    }
}
