package test;
public class Student {
	private String name;
    private int age;
    private String rollNumber;
    private String department;
    public Student(String name, int age, String rollNumber, String department) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
        this.department = department;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Student Details:\n" +
                "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Roll Number: " + rollNumber + "\n" +
                "Department: " + department;
    }
}

