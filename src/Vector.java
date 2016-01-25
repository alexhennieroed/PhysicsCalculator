import java.text.DecimalFormat;

public class Vector {

    private double[] data;
    private int size;

    public Vector(String in) {
        String rawIn = in.substring(1, in.length() - 1);
        String[] bits = rawIn.split(",");
        this.data = new double[bits.length];
        this.size = data.length;
        for (int k = 0; k < size; k++) {
            data[k] = Double.valueOf(bits[k]);
        }
    }

    public Vector(double[] in) {
        data = in;
        size = in.length;
    }

    public Vector add(Vector addon) throws VectorException {
        if (this.size != addon.size) {
            throw new VectorException("Vectors are different sizes");
        }
        double[] data2 = addon.getData();
        double[] answer = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            answer[i] = this.data[i] + data2[i];
        }
        return new Vector(answer);
    }

    public Vector subtract(Vector takeoff) throws VectorException {
        if (this.size != takeoff.size) {
            throw new VectorException("Vectors are different sizes");
        }
        double[] data2 = takeoff.getData();
        double[] answer = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            answer[i] = this.data[i] - data2[i];
        }
        return new Vector(answer);
    }

    public Vector scalarProduct(double scalar) {
        double[] answer = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            answer[i] = scalar * this.data[i];
        }
        return new Vector(answer);
    }

    public String magnitude() {
        double num = 0;
        for (double dat : data) {
            num += (dat * dat);
        }
        double bum = Math.sqrt(num);
        return new DecimalFormat("##0.##E0").format(bum);
    }

    public Vector unitVector() {
        double[] din = new double[size];
        for (int i = 0; i < size; i++) {
            din[i] = data[i] / Double.valueOf(magnitude());
        }
        return new Vector(din);
    }

    public double[] getData() {
        return data;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String vec = "<";
        for (double tin : data) {

            vec = vec + new DecimalFormat("##0.##E0").format(tin) + ", ";
        }
        vec = vec.substring(0, vec.length() - 2);
        vec += ">";
        return vec;
    }

}
