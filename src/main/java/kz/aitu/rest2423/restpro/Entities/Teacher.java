package kz.aitu.rest2423.restpro.Entities;
import kz.aitu.rest2423.restpro.Abstract.Employee;
public class Teacher extends Employee {
    private String subject;

    public Teacher(int id, String name, int age, String department, String subject) {
        super(name, age, department, id);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
    public Teacher() {}
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " is teaching " + subject + ".");
    }

    @Override
    public String toString() {
        return super.toString() + "\nSubject: " + subject;
    }
}