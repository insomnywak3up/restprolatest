package kz.aitu.rest2423.restpro.Abstract;

import kz.aitu.rest2423.restpro.Interfaces.Staff;

public abstract class Employee extends Person implements Staff {
    private String department;

    public Employee(String name, int age, String department, int id) {
        super(name, age, id);
        this.department = department;
    }
    public Employee() {}

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartment: " + department;
    }
}

