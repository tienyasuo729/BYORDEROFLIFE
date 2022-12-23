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

    public String getTimeForJob() {
        return timeForJob;
    }

    public void setTimeForJob(String timeForJob) {
        this.timeForJob = timeForJob;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "timeForJob='" + timeForJob + '\'' +
                ", skill='" + skill + '\'' +
                ", degree='" + degree + '\'' +
                '}' + "\n";
    }

    public void howToMove(String move){
        System.out.println(move);
    }
}
