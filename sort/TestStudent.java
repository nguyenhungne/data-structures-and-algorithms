import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestStudent {
    public static void main(String[] args) {
        // Create a list of students
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 80, 75, 85));
        students.add(new Student("Bob", 90, 60, 70));
        students.add(new Student("Charlie", 85, 80, 90));

        // Sort in descending order
        Collections.sort(students, new StudentAverageComparatorDesc());
        System.out.println("\nSorted in descending order by average grade:");
        for (Student s : students) {
            System.out.println(s.getName() + ": " + s.getAverage());
        }
    }
}
