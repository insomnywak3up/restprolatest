package kz.aitu.rest2423.restpro.Abstract;

public abstract class Person {
    private static int idCounter = 1;
    public int id;
    private String name;
    private int age;
    private String subject;

    public Person() {}

    // constructor
    public Person(String name, int age, int id) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.id = id;
        this.subject = subject;
    }

    // getters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be a positive number");
        }
    }


    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nAge: " + age + " years";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return id == person.id && name.equals(person.name);
    }


    @Override
    public int hashCode() {
        return (name == null ? 0 : name.hashCode()) + id;
    }
}

