import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class StudentManagementSystem {
    Student head = null;
    HashSet<String> set = new HashSet<>();

    StudentManagementSystem() throws IOException {
        getFile();
    }

    public void addStudent(String name, String year, String roll, double grade, String college) {
        if(name.length()==0 || year.length()==0 || roll.length()==0 || college.length()==0)
        {
            System.out.println("Fields should not be empty");
            return;
        }
        if (set.contains(roll)) {
            System.out.println("Student with given ID already Existed");
            return;
        }
        Student a = new Student(name, year, roll, grade, college);
        set.add(roll);
        a.next = head;
        head = a;
    }

    public void removeStudent(String n) {
        if (!set.contains(n)) {
            System.out.println("Not Found");
            return;
        }
        if (head.rollNo.equals(n)) {
            head = head.next;
            return;
        }
        Student temp = head;
        Student prev = null;
        while (temp != null) {
            if (temp.rollNo.equals(n)) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public void update(String name, String year, String roll, double grade, String college)
    {
        if(!set.contains(roll))
        {
            addStudent(name, year, roll, grade, college);
        }
        else
        {
            Student temp=head;
            while(temp!=null)
            {
                if(temp.rollNo.equals(roll))
                {
                    temp.name=name;
                    temp.year=year;
                    temp.grade=grade;
                    temp.college=college;
                    break;
                }
                temp=temp.next;
            }
        }
    }

    public void search(String id) {
        if (!set.contains(id)) {
            System.out.println("Student with given Id Not Found");
            return;
        }
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo.equals(id)) {
                System.out.println(temp.getData());
                break;
            }
            temp = temp.next;
        }
    }

    public void displayAllStudents() {
        System.out.println();
        if (head == null) {
            System.out.println("No Data Present");
            return;
        }
        Student s = head;
        System.out.println("All Students:");
        while (s != null) {
            System.out.println(s.getData());
            s = s.next;
        }
        System.out.println();
    }

    public void toFile() throws IOException {
        FileWriter fw = new FileWriter("students.txt");
        BufferedWriter br = new BufferedWriter(fw);
        Student s = head;
        while (s != null) {
            br.write(s + "\n");
            s = s.next;
        }
        br.close();
    }

    public void getFile() throws IOException {
        FileReader f = new FileReader("students.txt");
        BufferedReader br = new BufferedReader(f);
        String line = br.readLine();
        while (line != null) {
            StringTokenizer st = new StringTokenizer(line);
            String name = st.nextToken();
            String year = st.nextToken();
            String rollNo = st.nextToken();
            double grade = Double.parseDouble(st.nextToken());
            String college = st.nextToken();
            addStudent(name, year, rollNo, grade, college);
            line = br.readLine();
        }
        br.close();
    }

}
