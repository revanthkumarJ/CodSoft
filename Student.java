public class Student {
    String name;
    String year;
    String rollNo;
    double grade;
    String college;
    Student next;

    Student(String name, String year, String rollNo, double grade, String college) {
        this.name = name;
        this.year = year;
        this.rollNo = rollNo;
        this.grade = grade;
        this.college = college;
        this.next = null;
    }

    public String toString() {
        return name + " " + year + " " + rollNo + " " + grade + " " + college;
    }

    public String getData() {
        return "Name:" + name + " Year:" + year + " Roll No:" + rollNo + " Grade:" + grade + " College:" + college;
    }
}
