public class Fraction {
    int numerator;
    int denominator;

    public Fraction () {
        this.numerator = 0;
        this.denominator = 0;
    }

    public Fraction(int numberator, int denumerator) {
        this.numerator = numberator;
        this.denominator = denumerator;
    }

    public Fraction (Fraction otherFraction) {
        this.numerator = otherFraction.numerator;
        this.denominator = otherFraction.denominator;
    }

    public String toString() {
        return this.numerator  + "/" + this.denominator;
    }
     
    public boolean equals(Object object) {
        boolean isEqual = false;
    
        if(object instanceof Fraction) {
            Fraction otherFraction = (Fraction) object;
    
            if(( this.numerator /  this.denominator) == ( otherFraction.numerator /  otherFraction.denominator)) {
                isEqual = true;
            }
        }
        return isEqual;
    }
}
