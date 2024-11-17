public class IntegerTriple {
    private Integer weight;
    private Integer source;
    private Integer destination;

    public IntegerTriple(Integer weight, Integer source, Integer destination) {
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getSource() {
        return source;
    }

    public Integer getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "(" + weight + ", " + source + ", " + destination + ")";
    }
}
