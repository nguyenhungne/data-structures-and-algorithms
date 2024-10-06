import java.util.Comparator;

public class StudentAverageComparatorDesc implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return Double.compare(student2.getAverage(), student1.getAverage());
    }
}
