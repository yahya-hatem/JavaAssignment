import java.util.Scanner;

public class StudentGrade {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] names = new String[5];
        int[][] grades = new int[5][3];

        // Enter students and grades
        for (int i = 0; i < 5; i++) {

            System.out.print("Enter student name: ");
            names[i] = input.nextLine();

            for (int j = 0; j < 3; j++) {

                do {
                    System.out.print("Enter subject " + (j + 1) + " grade: ");
                    grades[i][j] = input.nextInt();
                    if (grades[i][j] < 0 || grades[i][j] > 100)
                        System.out.println("Invalid grade.");
                } while (grades[i][j] < 0 || grades[i][j] > 100);
            }

            input.nextLine();
        }

        int choice;

        do {

            System.out.println("\n (menu) ");
            System.out.println("1- Show All Students");
            System.out.println("2- Show Students Grades");
            System.out.println("33- Search Student");
            System.out.println("4- Count Passed Students");
            System.out.println("5- Average Each Subject");
            System.out.println("6- Highest Grade Each Subject");
            System.out.println("7- Letter Grades");
            System.out.println("0- Exit");

            System.out.print("Please Enter choice : ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    for (int i = 0; i < 5; i++) {
                        System.out.println(names[i]);
                    }

                    break;

                case 2:

                    for (int i = 0; i < 5; i++) {

                        System.out.println("\n" + names[i]);

                        for (int j = 0; j < 3; j++) {
                            System.out.println("Subject " + (j + 1) + ": " + grades[i][j]);
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter student name: ");
                    String search = input.nextLine();

                    boolean found = false;

                    for (int i = 0; i < 5; i++) {

                        if (names[i].equalsIgnoreCase(search)) {

                            found = true;

                            System.out.println("Student Found");

                            for (int j = 0; j < 3; j++) {
                                System.out.println("Subject " + (j + 1) + ": " + grades[i][j]);
                            }
                        }
                    }

                    if (!found)
                        System.out.println("Student Not Found");

                    break;

                case 4:

                    int passed = 0;

                    for (int i = 0; i < 5; i++) {

                        int sum = 0;

                        for (int j = 0; j < 3; j++) {
                            sum += grades[i][j];
                        }

                        if (sum / 3.0 >= 50)
                            passed++;
                    }

                    System.out.println("Passed Students = " + passed);

                    break;

                case 5:

                    for (int j = 0; j < 3; j++) {

                        int sum = 0;

                        for (int i = 0; i < 5; i++) {
                            sum += grades[i][j];
                        }

                        System.out.println("Average Subject " + (j + 1) + " = " + (sum / 5.0));
                    }

                    break;

                case 6:

                    for (int j = 0; j < 3; j++) {

                        int max = grades[0][j];

                        for (int i = 1; i < 5; i++) {

                            if (grades[i][j] > max)
                                max = grades[i][j];
                        }

                        System.out.println("Highest Grade Subject is " + (j + 1) + " = " + max);
                    }

                    break;

                case 7:

                    for (int i = 0; i < 5; i++) {

                        System.out.println("\n" + names[i]);

                        for (int j = 0; j < 3; j++) {

                            String letter;

                            if (grades[i][j] >= 85)
                                letter = "A";
                            else if (grades[i][j] >= 75)
                                letter = "B";
                            else if (grades[i][j] >= 65)
                                letter = "C";
                            else if (grades[i][j] >= 50)
                                letter = "D";
                            else
                                letter = "F";

                            System.out.println("Subject " + (j + 1) + ": " + grades[i][j] + " -> " + letter);
                        }
                    }

                    break;

                case 0:
                    System.out.println("Good Bye");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 0);


    }
}