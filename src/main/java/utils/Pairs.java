package utils;

public class Pairs<X, Y> {
    private X x;
    private Y y;

    public Pairs(){

    }

    public Pairs(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X getFirst() {
        return x;
    }

    public void setFirst(X x) {
        this.x = x;
    }

    public Y getSecond() {
        return y;
    }

    public void setSecond(Y y) {
        this.y = y;
    }
}