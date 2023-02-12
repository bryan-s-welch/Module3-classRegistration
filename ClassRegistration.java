package CEN3024C;
import java.util.Scanner;
import java.util.ArrayList;

public class ClassRegistration {
    static ArrayList<String> completedCourses = new ArrayList<>();

    public static void main(String[] args) {
        // List of courses and their prerequisites
        String[][] courses = {
                {"Math 101", "None"},
                {"Math 102", "Math 101"},
                {"History 101", "None"},
                {"History 102", "History 101"},
                {"Science 101", "None"},
                {"Science 102", "Science 101"}
        };

        Scanner input = new Scanner(System.in);

        System.out.println("\nEnter the list of completed courses, separated by a comma (e.g. Math 101, Science 101):" +
                "\n\nCourse List: Math 101, Math 102, History 101, History 102, Science 101, Science 102");
        String[] userInput = input.nextLine().split(", ");

        for (String course : userInput) {
            completedCourses.add(course);
        }

        System.out.println("\nEnter the list of courses you want to register for, separated by a comma (e.g. Math 101, Science 101):" +
                "\n\nCourse List: Math 101, Math 102, History 101, History 102, Science 101, Science 102");
        userInput = input.nextLine().split(", ");

        ArrayList<String> registeredCourses = new ArrayList<>();
        for (String course : userInput) {
            if (checkPrerequisites(courses, course)) {
                registeredCourses.add(course);
            } else {
                System.out.println("Error: You have not completed the prerequisites for " + course + ".");
            }
        }

        System.out.println("\nFinal course schedule:");
        for (String registeredCourse : registeredCourses) {
            System.out.println(registeredCourse);
        }
    }

    public static boolean checkPrerequisites(String[][] courses, String course) {
        for (String[] pair : courses) {
            if (pair[0].equals(course)) {
                if (!completedCourses.contains(pair[1]) && !pair[1].equals("None")) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}