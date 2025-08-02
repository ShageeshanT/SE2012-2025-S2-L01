import java.util.Scanner;

public class marks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        int[][] matrix = null;

        while (true) {
            System.out.println("\n-----AVAILABLE OPERATIONS-----");
            System.out.println("1. Enter no of students ");
            System.out.println("2. Update student mark ");
            System.out.println("3. Get the average for a subject ");
            System.out.println("4. Get the average for a student ");
            System.out.println("5. Get the total mark of a student ");
            System.out.println("6. Grades");
            System.out.println("7. EXIT \n");
            System.out.print("ENTER THE OPTION: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter number of students: ");
                    n = scanner.nextInt();
                    matrix = new int[n][3];

                    for (int i = 0; i < n; i++) {
                        System.out.println("Enter marks for Student " + (i + 1));
                        System.out.print("Maths: ");
                        matrix[i][0] = scanner.nextInt();
                        System.out.print("Physics: ");
                        matrix[i][1] = scanner.nextInt();
                        System.out.print("Chemistry: ");
                        matrix[i][2] = scanner.nextInt();
                    }
                    break;

                case 2:
                    if (matrix == null) {
                        System.out.println("No students found. Please enter student data first.");
                        break;
                    }

                    System.out.print("Enter student no: ");
                    int studentNo = scanner.nextInt();

                    System.out.print("Enter subject no (1=maths, 2=physics, 3=chemistry): ");
                    int subjectNo1 = scanner.nextInt();

                    if ((studentNo >= 1 && studentNo <= n) && (subjectNo1 >= 1 && subjectNo1 <= 3)) {
                        System.out.print("Enter the mark: ");
                        int mark = scanner.nextInt();
                        matrix[studentNo - 1][subjectNo1 - 1] = mark;
                        System.out.println("Mark updated successfully.");
                    } else {
                        System.out.println("Invalid student or subject number.");
                    }
                    break;

                case 3:
                    if (matrix == null) {
                        System.out.println("No data found. Please add students first.");
                        break;
                    }

                    System.out.print("Enter subject no (1=maths, 2=physics, 3=chemistry): ");
                    int subjectNo = scanner.nextInt();
                    int total = 0;
                    for (int i = 0; i < n; i++) {
                        total += matrix[i][subjectNo - 1];
                    }
                    double average = total / (double) n;
                    System.out.println("Average marks for subject " + subjectNo + ": " + average);
                    break;

                case 4:
                    if (matrix == null) {
                        System.out.println("No data found. Please add students first.");
                        break;
                    }

                    System.out.print("Enter student no: ");
                    int stNo = scanner.nextInt();

                    if (stNo >= 1 && stNo <= n) {
                        int total1 = 0;
                        for (int j = 0; j < 3; j++) {
                            total1 += matrix[stNo - 1][j];
                        }
                        double average1 = total1 / 3.0;
                        System.out.println("Average marks for student " + stNo + ": " + average1);
                    } else {
                        System.out.println("Invalid student number.");
                    }
                    break;

                case 5:
                    if (matrix == null) {
                        System.out.println("No students found");
                        break;
                    }

                    System.out.print("Enter student no: ");
                    int studentNumber = scanner.nextInt();

                    if (studentNumber >= 1 && studentNumber <= n) {
                        int totalMarks = 0;
                        for (int j = 0; j < 3; j++) {
                            totalMarks += matrix[studentNumber - 1][j];
                        }
                        System.out.println("Total marks for student " + studentNumber + ": " + totalMarks);
                    } else {
                        System.out.println("Invalid student number.");
                    }
                    break;
                case 6:
                    System.out.printf("%-10s %-10s %-10s %-10s\n", "Student", "Maths", "Physics", "Chemistry");

                    for (int i = 0; i < n; i++) {
                        String g1 = grade(matrix[i][0]);
                        String g2 = grade(matrix[i][1]);
                        String g3 = grade(matrix[i][2]);

                        System.out.printf("%-10d %-10s %-10s %-10s\n", i + 1, g1, g2, g3);
                    }
                    break;

                case 7:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");

            }
        }
    }
    public static String grade(int mark) {
        if (mark >= 75) return "A";
        else if (mark >= 65) return "B";
        else if (mark >= 50) return "C";
        else if (mark >= 35) return "S";
        else return "Fail";
    }

}
