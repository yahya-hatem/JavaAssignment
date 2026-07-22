import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        Student[] students = new Student[n];


        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("ID: ");
            int id = input.nextInt();

            input.nextLine();

            System.out.print("Name: ");
            String name = input.nextLine();

            double grade1;
            do {
                System.out.print("Subject 1 Grade (0-100): ");
                grade1 = input.nextDouble();
            } while (grade1 < 0 || grade1 > 100);

            double grade2;
            do {
                System.out.print("Subject 2 Grade (0-100): ");
                grade2 = input.nextDouble();
            } while (grade2 < 0 || grade2 > 100);

            students[i] = new Student(id, name, grade1, grade2);
        }

        int choice;

        do {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Display Students");
            System.out.println("2. Calculate Average Grade");
            System.out.println("3. Find Highest Grade");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Count Passed and Failed");
            System.out.println("6. Sort Students by Grade");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:

                    for (Student s : students)
                        s.display();

                    break;

                case 2:

                    double sum = 0;

                    for (Student s : students)
                        sum += s.getFinalGrade();

                    System.out.println("Average Grade = " + (sum / n));

                    break;

                case 3:

                    Student highest = students[0];

                    for (Student s : students) {
                        if (s.getFinalGrade() > highest.getFinalGrade())
                            highest = s;
                    }

                    System.out.println("Highest Grade Student:");
                    highest.display();

                    break;

                case 4:

                    System.out.print("Enter ID: ");
                    int searchId = input.nextInt();

                    boolean found = false;

                    for (Student s : students) {

                        if (s.id == searchId) {
                            s.display();
                            found = true;
                            break;
                        }

                    }

                    if (!found)
                        System.out.println("Student not found.");

                    break;

                case 5:

                    int pass = 0;
                    int fail = 0;

                    for (Student s : students) {

                        if (s.getFinalGrade() >= 60)
                            pass++;
                        else
                            fail++;

                    }

                    System.out.println("Passed Students = " + pass);
                    System.out.println("Failed Students = " + fail);

                    break;

                case 6:

                    for (int i = 0; i < students.length - 1; i++) {

                        for (int j = i + 1; j < students.length; j++) {

                            if (students[i].getFinalGrade() < students[j].getFinalGrade()) {

                                Student temp = students[i];
                                students[i] = students[j];
                                students[j] = temp;

                            }

                        }

                    }

                    System.out.println("Students Sorted Successfully.");

                    break;

                case 0:

                    System.out.println("Goodbye!");

                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 0);

    }
}