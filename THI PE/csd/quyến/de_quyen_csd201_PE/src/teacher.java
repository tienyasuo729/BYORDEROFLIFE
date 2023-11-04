public class teacher implements Comparable<teacher>{
    int code;
    double coeff;
    public teacher(int code, double coeff) {
        this.code = code;
        this.coeff = coeff;
    }
    @Override public String toString() {
        return "("+code + "," + coeff+")";
    }
    @Override public int compareTo(teacher o) {
        if (code < o.code) return -1;
        if (code > o.code) return +1;
        return 0;
    }
}