import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class Calculations {

    public static final ObservableList<String> LIST =
        FXCollections.observableArrayList("Vector Addition",
        "Vector Subtraction", "Relativistic Momentum",
        "Non-Relativistic Momentum", "Impulse Momentum",
        "Iterative Calculation", "Analytic Calculation");

    public static Vector vectorAddition(String v1, String v2) {
        try {
            Vector vec1 = new Vector(v1);
            Vector vec2 = new Vector(v2);
            return vec1.add(vec2);
        } catch (VectorException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Vector vectorSubtraction(String v1, String v2) {
        try {
            Vector vec1 = new Vector(v1);
            Vector vec2 = new Vector(v2);
            return vec1.subtract(vec2);
        } catch (VectorException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void relativisticMomentum() {
        //TODO
    }

    public static void nonrelativisticMomentum() {
        //TODO
    }

    public static void impulseMomentum() {
        //TODO
    }

    public static void iterativeCalculation() {
        //TODO
    }

    public static void analyticCalculation() {
        //TODO
    }

}
