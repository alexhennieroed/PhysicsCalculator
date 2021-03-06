import com.sun.media.sound.MidiUtils;
import com.sun.prism.GraphicsResource;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLWriter;

public class CalcScenes {

    private static Label ans;
    private static TextField pasteTo;
    public static String addon;

    public static void home() {
        Label hello = new Label("Hello!");
        hello.setFont(new Font(50));
        Label name = new Label("Welcome to Physics Calculator!");
        name.setFont(new Font(35));
        Label instr = new Label("Select an equation type on the left to get started");
        instr.setFont(new Font(25));
        Label test = new Label();
        UserInterface.data.getChildren().clear();
        UserInterface.data.getChildren().addAll(hello, name, instr, test);
        UserInterface.data.setAlignment(Pos.CENTER);
    }

    public static void magnitude() {
        UserInterface.data.getChildren().clear();
        TextField vector1 = new TextField();
        vector1.setPromptText("Vector <x,y,z>");
        pasteTo = vector1;
        Button mag = new Button("MAGNITUDE");
        mag.setOnAction(event -> {
            String answer = Calculations.magnitude(vector1.getText());
            String v1 = vector1.getText();
            Label prob = new Label("|" + v1 + "| =");
            ans = new Label(answer);
            UserInterface.data.getChildren().addAll(prob, ans);
        });
        UserInterface.data.getChildren().addAll(new Label("Magnitude"),
                vector1, mag);
    }

    public static void unitVector() {
        UserInterface.data.getChildren().clear();
        TextField vector1 = new TextField();
        vector1.setPromptText("Vector <x,y,z>");
        pasteTo = vector1;
        Button unit = new Button("Unit Vector");
        unit.setOnAction(event -> {
            String answer = Calculations.unitVector(vector1.getText()).toString();
            ans = new Label(answer);
            UserInterface.data.getChildren().addAll(ans);
        });
        UserInterface.data.getChildren().addAll(new Label("Unit Vector"),
                vector1, unit);
    }

    public static void vectorAddition() {
        UserInterface.data.getChildren().clear();
        TextField vector1 = new TextField();
        vector1.setPromptText("Vector <x,y,z>");
        vector1.setOnMouseClicked(event -> pasteTo = vector1);
        TextField vector2 = new TextField();
        vector2.setPromptText("Vector <x,y,z>");
        vector2.setOnMouseClicked(event -> pasteTo = vector2);
        Button add = new Button("ADD");
        add.setOnAction(event -> {
            String answer = Calculations.vectorAddition(vector1.getText(),
                vector2.getText());
            String v1 = vector1.getText();
            String v2 = vector2.getText();
            Label prob = new Label(v1 + " + " + v2 + " =");
            ans = new Label(answer);
            UserInterface.data.getChildren().addAll(prob, ans);
        });
        UserInterface.data.getChildren().addAll(new Label("Addition"),
            vector1, vector2, add);
    }

    public static void vectorSubtraction() {
        UserInterface.data.getChildren().clear();
        TextField vector1 = new TextField();
        vector1.setPromptText("Vector <x,y,z>");
        vector1.setOnMouseClicked(event -> pasteTo = vector1);
        TextField vector2 = new TextField();
        vector2.setPromptText("Vector <x,y,z>");
        vector2.setOnMouseClicked(event -> pasteTo = vector2);
        Button sub = new Button("SUBTRACT");
        sub.setOnAction(event -> {
            String answer = Calculations.vectorSubtraction(vector1.getText(),
                vector2.getText());
            String v1 = vector1.getText();
            String v2 = vector2.getText();
            Label prob = new Label(v1 + " - " + v2 + " =");
            ans = new Label(answer);
            UserInterface.data.getChildren().addAll(prob, ans);
        });
        UserInterface.data.getChildren().addAll(new Label("Subtraction"),
            vector1, vector2, sub);
    }

    public static void scalarMultiplication() {
        UserInterface.data.getChildren().clear();
        TextField vector1 = new TextField();
        vector1.setPromptText("Vector <x,y,z>");
        vector1.setOnMouseClicked(event -> pasteTo = vector1);
        TextField scalar = new TextField();
        scalar.setPromptText("scalar");
        scalar.setOnMouseClicked(event -> pasteTo = scalar);
        Button mult = new Button("MULTIPLY");
        mult.setOnAction(event -> {
            String answer = Calculations.scalarMultiplication(vector1.getText(),
                    scalar.getText()).toString();
            String v1 = vector1.getText();
            String v2 = scalar.getText();
            Label prob = new Label(v1 + " * " + v2 + " =");
            ans = new Label(answer);
            UserInterface.data.getChildren().addAll(prob, ans);
        });
        UserInterface.data.getChildren().addAll(new Label("Multiplication"),
                vector1, scalar, mult);
    }

    public static void relativisticMomentum() {
        UserInterface.data.getChildren().clear();
        TextField vector1 = new TextField();
        vector1.setPromptText("Velocity <x,y,z>");
        vector1.setOnMouseClicked(event -> pasteTo = vector1);
        TextField mass = new TextField();
        mass.setPromptText("mass(kg)");
        mass.setOnMouseClicked(event -> pasteTo = mass);
        TextField momentum = new TextField();
        momentum.setPromptText("Momentum <x,y,z>");
        momentum.setOnMouseClicked(event -> pasteTo = mass);
        Button calc = new Button("CALCULATE");
        calc.setOnAction(event -> {
            Label form = new Label();
            Label prob = new Label();
            if (momentum.getText().equals("")) {
                String answer = Calculations.relativisticMomentum(vector1.getText(),
                        mass.getText()).toString();
                String vel = vector1.getText();
                String ma = mass.getText();
                form.setText("p=" + GreekLetters.GAMMA + "mv");
                prob.setText(ma + " * " + vel + " =");
                ans = new Label(answer);
            } else if (mass.getText().equals("")) {
                String answer = Double.toString(Calculations.relativisticMass(vector1.getText(),
                        momentum.getText()));
                String vel = vector1.getText();
                String mo = momentum.getText();
                form.setText("m=p/" + GreekLetters.GAMMA + "v");
                prob.setText(mo + " / " + vel + " =");
                ans = new Label(answer);
            } else if (vector1.getText().equals("")) {
                String answer = Calculations.relativisticVelocity(momentum.getText(),
                        mass.getText()).toString();
                String mo = momentum.getText();
                String ma = mass.getText();
                form.setText(GreekLetters.GAMMA + "v=p/m");
                prob.setText(mo + " * " + ma + " =");
                ans = new Label(answer);
            }
            UserInterface.data.getChildren().addAll(form, prob, ans);
        });
        UserInterface.data.getChildren().addAll(new Label("Relativistic Momentum"),
                vector1, mass, momentum, calc);
    }

    public static void nonrelativisticMomentum() {
        UserInterface.data.getChildren().clear();
        TextField vector1 = new TextField();
        vector1.setPromptText("Velocity <x,y,z>");
        vector1.setOnMouseClicked(event -> pasteTo = vector1);
        TextField mass = new TextField();
        mass.setPromptText("mass(kg)");
        mass.setOnMouseClicked(event -> pasteTo = mass);
        TextField momentum = new TextField();
        momentum.setPromptText("momentum <x,y,z>");
        momentum.setOnMouseClicked(event1 -> pasteTo = momentum);
        Button calc = new Button("CALCULATE");
        calc.setOnAction(event -> {
            Label form = new Label();
            Label prob = new Label();
            if (momentum.getText().equals("")) {
                String answer = Calculations.nonrelativisticMomentum(vector1.getText(),
                        mass.getText()).toString();
                String vel = vector1.getText();
                String ma = mass.getText();
                form.setText("p=mv");
                prob.setText(ma + " * " + vel + " =");
                ans = new Label(answer);
            } else if (mass.getText().equals("")) {
                String answer = Double.toString(Calculations.nonrelativisticMass(vector1.getText(),
                        momentum.getText()));
                String vel = vector1.getText();
                String mo = momentum.getText();
                form.setText("m=p/v");
                prob.setText(mo + " / " + vel + " =");
                ans = new Label(answer);
            } else if (vector1.getText().equals("")) {
                String answer = Calculations.nonrelativisticVelocity(momentum.getText(),
                        mass.getText()).toString();
                String mo = momentum.getText();
                String ma = mass.getText();
                form.setText("v=p/m");
                prob.setText(mo + " * " + ma + " =");
                ans = new Label(answer);
            }
            UserInterface.data.getChildren().addAll(form, prob, ans);
        });
        UserInterface.data.getChildren().addAll(new Label("Non-Relativistic Momentum"),
                vector1, mass, momentum, calc);
    }

    public static void impulseMomentum() {
        UserInterface.data.getChildren().clear();
        TextField vector1 = new TextField();
        vector1.setPromptText("Net Force <x,y,z>");
        vector1.setOnMouseClicked(event -> pasteTo = vector1);
        TextField time = new TextField();
        time.setPromptText(GreekLetters.DELTA + "time(s)");
        time.setOnMouseClicked(event -> pasteTo = time);
        TextField momentum = new TextField();
        momentum.setPromptText("Momentum <x,y,z>");
        momentum.setOnMouseClicked(event -> pasteTo = momentum);
        Button calc = new Button("CALCULATE");
        calc.setOnAction(event -> {
            Label form = new Label();
            Label prob = new Label();
            if (momentum.getText().equals("")) {
                String answer = Calculations.impulseMomentum(vector1.getText(),
                        time.getText()).toString();
                String fnet = vector1.getText();
                String ti = time.getText();
                form.setText(GreekLetters.DELTA + "p=Fₙₔₜ" + GreekLetters.DELTA + "t");
                prob.setText(fnet + " * " + ti + " =");
                ans = new Label(answer);
            } else if (time.getText().equals("")) {
                String answer = Double.toString(Calculations.impulseTime(vector1.getText(),
                        momentum.getText()));
                String fnet = vector1.getText();
                String mo = momentum.getText();
                form.setText(GreekLetters.DELTA + "t=" + GreekLetters.DELTA + "p/Fₙₔₜ");
                prob.setText(mo + " / " + fnet + " =");
                ans = new Label(answer);
            } else if (vector1.getText().equals("")) {
                String answer = Calculations.impulseVelocity(momentum.getText(),
                        time.getText()).toString();
                String mo = momentum.getText();
                String ti = time.getText();
                form.setText("Fₙₔₜ=" + GreekLetters.DELTA + "p/" + GreekLetters.DELTA + "t");
                prob.setText(mo + " * " + ti + " =");
                ans = new Label(answer);
            }
            UserInterface.data.getChildren().addAll(form, prob, ans);
        });
        UserInterface.data.getChildren().addAll(new Label("Impulse Momentum"),
                vector1, time, momentum, calc);
    }

    public static void iterativeCalculation() {
        UserInterface.data.getChildren().clear();
        Button mom = new Button("MOMENTUM");
        mom.setOnAction(event -> icMomentum());
        Button vel = new Button("VELOCITY");
        vel.setOnAction(event -> icVelocity());
        Button dis = new Button("DISTANCE");
        dis.setOnAction(event -> icDistance());
        UserInterface.data.getChildren().addAll(new Label("Iterative Calculation"),
                new Label("Choose your desired path"), mom, vel, dis);
    }

    public static void icMomentum() {
        UserInterface.data.getChildren().clear();
        UserInterface.data.getChildren().addAll(new Label("{iter calc mom}"));
    }

    public static void icVelocity() {
        UserInterface.data.getChildren().clear();
        UserInterface.data.getChildren().addAll(new Label("{iter calc vel}"));
    }

    public static void icDistance() {
        UserInterface.data.getChildren().clear();

        UserInterface.data.getChildren().addAll(new Label("{iter calc dis}"));
    }

    public static void analyticCalculation() {
        UserInterface.data.getChildren().clear();
        Button mom = new Button("MOMENTUM");
        mom.setOnAction(event -> acMomentum());
        Button vel = new Button("VELOCITY");
        vel.setOnAction(event -> acVelocity());
        Button dis = new Button("DISTANCE");
        dis.setOnAction(event -> acDistance());
        UserInterface.data.getChildren().addAll(new Label("Analytic Calculation"),
                new Label("Choose your desired path"), mom, vel, dis);
    }

    public static void acMomentum() {
        UserInterface.data.getChildren().clear();
        UserInterface.data.getChildren().addAll(new Label("{ana calc mom}"));
    }

    public static void acVelocity() {
        UserInterface.data.getChildren().clear();
        UserInterface.data.getChildren().addAll(new Label("{ana calc vel}"));
    }

    public static void acDistance() {
        UserInterface.data.getChildren().clear();
        UserInterface.data.getChildren().addAll(new Label("{ana calc dis}"));
    }

    public static void energyPrinciple() {
        UserInterface.data.getChildren().clear();
        UserInterface.data.getChildren().addAll(new Label("{ener prin}"));
    }

    public static void angularMomentum() {
        UserInterface.data.getChildren().clear();
        UserInterface.data.getChildren().addAll(new Label("{ang mome}"));
    }

    public static void gravitationalForce() {
        UserInterface.data.getChildren().clear();
        UserInterface.data.getChildren().addAll(new Label("{grav force}"));
    }

    public static void copyData() {
        if (ans == null) { return; }
        String data = ans.getText();
        UserInterface.copyItem.setText(data);
    }

    public static void pasteData() {
        if (UserInterface.copyItem.getText().equals("[Your Copied Item Here]")) { return; }
        String data = UserInterface.copyItem.getText();
        pasteTo.setText(data);
    }
}
