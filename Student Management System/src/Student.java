public class Student {

        int id;
        String name;
        double[] grades;

        public Student(int id, String name, double grade1, double grade2) {
            this.id = id;
            this.name = name;
            grades = new double[2];
            grades[0] = grade1;
            grades[1] = grade2;
        }

        public double getFinalGrade() {
            return (grades[0] + grades[1]) / 2;
        }

        public String getStatus() {
            double grade = getFinalGrade();

            if (grade >= 90)
                return "Excellent";
            else if (grade >= 75)
                return "Very Good";
            else if (grade >= 60)
                return "Pass";
            else
                return "Fail";
        }

        public void display() {
            System.out.println("----------------------------");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Subject 1: " + grades[0]);
            System.out.println("Subject 2: " + grades[1]);
            System.out.println("Final Grade: " + getFinalGrade());
            System.out.println("Status: " + getStatus());
        }
    }

