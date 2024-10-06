public class Student {
    private String name;
    private double mathematics;
    private double programming;
    private double DSA1;

    public Student(String name, double mathematics, double programming, double DSA1) {
        this.name = name;
        this.mathematics = mathematics;
        this.programming = programming;
        this.DSA1 = DSA1;
    }

    public double getAverage() {
        return (mathematics + programming + DSA1) / 3.0;
    }

    public String getName() {
        return name;
    }
}
