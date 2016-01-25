import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import java.text.DecimalFormat;
import java.util.DoubleSummaryStatistics;

public class Calculations {

    public static final double C = Double.valueOf("3.00e8");
    public static final double G = 9.8;
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

    public static String vectorAddition(String v1, String v2) {
        String errmsg = "";
        try {
            Vector vec1 = new Vector(v1);
            Vector vec2 = new Vector(v2);
            return vec1.add(vec2).toString();
        } catch (VectorException e) {
            errmsg = e.getMessage();
        }
        return errmsg;
    }

    public static String vectorSubtraction(String v1, String v2) {
        String errmsg = "";
        try {
            Vector vec1 = new Vector(v1);
            Vector vec2 = new Vector(v2);
            return vec1.subtract(vec2).toString();
        } catch (VectorException e) {
            errmsg = e.getMessage();
        }
        return errmsg;
    }

    public static Vector scalarMultiplication(String v1, String scal) {
        Vector vec1 = new Vector(v1);
        Double scalar = Double.valueOf(scal);
        return vec1.scalarProduct(scalar);
    }

    public static Vector relativisticMomentum(String v1, String m) {
        Vector vel = new Vector(v1);
        double mass = Double.valueOf(m);
        double gamma = 1.0 / (1.0 - ((Double.valueOf(vel.magnitude()) / C)
                * (Double.valueOf(vel.magnitude()) / C)));
        CalcScenes.addon = new DecimalFormat("##0.##E0").format(gamma);
        return vel.scalarProduct(gamma * mass);
    }

    public static double relativisticMass(String v1, String p) {
        Vector vel = new Vector(v1);
        Vector mo = new Vector(p);
        double gamma = 1.0 / (1.0 - ((Double.valueOf(vel.magnitude()) / C)
                * (Double.valueOf(vel.magnitude()) / C)));
        CalcScenes.addon = new DecimalFormat("##0.##E0").format(gamma);
        return (Double.valueOf(mo.magnitude()) / (Double.valueOf(vel.magnitude()) * gamma));
    }

    public static Vector relativisticVelocity(String p, String m) {
        Vector mo = new Vector(p);
        double mass = Double.valueOf(m);
        double[] vel = new double[mo.size()];
        for (int i = 0; i < vel.length; i++) {
            double q = mo.getData()[0] / mass;
            double qtwo = q * q;
            double bot = qtwo / (1 + (qtwo / (C * C)));
            vel[i] = Math.sqrt(qtwo / bot);
        }
        return new Vector(vel);
    }

    public static Vector nonrelativisticMomentum(String v1, String m) {
        Vector vel = new Vector(v1);
        double mass = Double.valueOf(m);
        return vel.scalarProduct(mass);
    }

    public static double nonrelativisticMass(String v1, String p) {
        Vector vel = new Vector(v1);
        Vector mo = new Vector(p);
        return Double.valueOf(vel.magnitude()) / Double.valueOf(mo.magnitude());
    }

    public static Vector nonrelativisticVelocity(String p, String m) {
        Vector vel = new Vector(p);
        double mass = Double.valueOf(m);
        return vel.scalarProduct(mass);
    }

    public static Vector impulseMomentum(String nf, String t) {
        Vector netForce = new Vector(nf);
        double time = Double.valueOf(t);
        return netForce.scalarProduct(time);
    }

    public static double impulseTime(String nf, String p) {
        Vector vel = new Vector(nf);
        Vector mo = new Vector(p);
        return Double.valueOf(vel.magnitude()) / Double.valueOf(mo.magnitude());
    }

    public static Vector impulseVelocity(String p, String t) {
        Vector vel = new Vector(p);
        double mass = Double.valueOf(t);
        return vel.scalarProduct(mass);
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
