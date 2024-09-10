class DoubleNode {
    protected Double data;
    protected DoubleNode next;


    public DoubleNode() {
        this.data = null;
        this.next = null;
    }

    public DoubleNode(Double data) {
        this.data = data;
        this.next = null;
    }

    public DoubleNode(Double data, DoubleNode next) {
        this.data = data;
        this.next = next;
    }

    public Double getData() {
        return this.data;
    }

    public void setData(Double data) {
        this.data = data;
    }

    public DoubleNode getNext() {
        return this.next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
}