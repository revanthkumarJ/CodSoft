import java.io.*;

public class StudentMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StudentManagementSystem s = new StudentManagementSystem();
        int i = 5;
        do {
            try {
                System.out.println(
                        "0:Exit 1:Add a Student 2:Search for a student 3:Remove a Student 4:Display all Students 5:Edit Existing Student");
                i = Integer.parseInt(br.readLine());
                if (i == 1) {
                    System.out.print("Enter Name:");
                    String name = br.readLine();
                    System.out.print("Year:");
                    String year = br.readLine();
                    System.out.print("ID:");
                    String id = br.readLine();
                    System.out.print("Grade:");
                    double grade = Double.parseDouble(br.readLine());
                    System.out.print("College:");
                    String college = br.readLine();
                    s.addStudent(name, year, id, grade, college);
                } else if (i == 2) {
                    System.out.print("Enter Id:");
                    String id = br.readLine();
                    s.search(id);
                } else if (i == 3) {
                    System.out.print("Enter Id:");
                    String id = br.readLine();
                    s.removeStudent(id);
                } else if (i == 4) {
                    s.displayAllStudents();
                }
                else if(i==5)
                {
                    System.out.print("Enter Name:");
                    String name = br.readLine();
                    System.out.print("Year:");
                    String year = br.readLine();
                    System.out.print("ID:");
                    String id = br.readLine();
                    System.out.print("Grade:");
                    double grade = Double.parseDouble(br.readLine());
                    System.out.print("College:");
                    String college = br.readLine();
                    s.update(name, year, id,grade, college);
                }
                else if(i!=0)
                {
                    System.out.println("Provide valid Input");
                }
            } catch (Exception e) {
                System.out.println("Provide  valid input!");
            }

        } while (i != 0);
        s.toFile();
        br.close();
    }
}
