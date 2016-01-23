import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import java.text.DecimalFormat;

public class Calculations {

    public static final ObservableList<String> LIST =
        FXCollections.observableArrayList("Magnitude", "Unit Vector",
                "Vector Addition", "Vector Subtraction", "Scalar Multiplication",
                "Relativistic Momentum", "Non-Relativistic Momentum",
                "Impulse Momentum", "Iterative Calculation",
                "Analytic Calculation", "Gravitational Force",
                "Energy Principle", "Angular Momentum Principle");

    public static String magnitude(String v1) {
        Vector vec1 = new Vector(v1);
        return vec1.magnitude();
    }

    public static Vector unitVector(String v1) {
        Vector vec1 = new Vector(v1);
        return vec1.unitVector();
    }

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

    public static Vector scalarMultiplication(String v1, String scal) {
        Vector vec1 = new Vector(v1);
        Double scalar = Double.valueOf(scal);
        return vec1.scalarProduct(scalar);
    }

    public static Vector relativisticMomentum(String v1, String m) {
        double c = Double.valueOf("3.00e8");
        Vector vel = new Vector(v1);
        double mass = Double.valueOf(m);
        double gamma = 1.0 / (1.0 - ((Double.valueOf(vel.magnitude()) / c)
                * (Double.valueOf(vel.magnitude()) / c)));
        CalcScenes.addon = new DecimalFormat("##0.##E0").format(gamma);
        return vel.scalarProduct(gamma * mass);
    }

    public static Vector nonrelativisticMomentum(String v1, String m) {
        Vector vel = new Vector(v1);
        double mass = Double.valueOf(m);
        return vel.scalarProduct(mass);
    }

    public static Vector impulseMomentum(String nf, String t) {
        Vector netForce = new Vector(nf);
        double time = Double.valueOf(t);
        return netForce.scalarProduct(time);
    }

    public static void icMomentum() {
        //TODO
    }

    public static void icVelocity() {
        //TODO
    }

    public static void icDistance() {
        //TODO
    }

    public static void acMomentum() {
        //TODO
    }

    public static void acVelocity() {
        //TODO
    }

    public static void acDistance() {
        //TODO
    }

    public static void energyPrinciple() {
        //TODO
    }

    public static void angularMomentum() {
        //TODO
    }

    public static void gravitationalForce() {
        //TODO
    }

}
