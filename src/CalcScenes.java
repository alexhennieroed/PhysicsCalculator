import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class CalcScenes {

    public static void home() {
        Label hello = new Label("Hello!");
        hello.setFont(new Font(50));
        Label name = new Label("Welcome to Physics Calculator!");
        name.setFont(new Font(35));
        UserInterface.data.getChildren().clear();
        UserInterface.data.getChildren().addAll(hello, name);
    }

    public static void vectorAddition() {
        UserInterface.data.getChildren().clear();
        TextField vector1 = new TextField();
        vector1.setPromptText("<x,y,z>");
        TextField vector2 = new TextField();
        vector2.setPromptText("<x,y,z>");
        Button add = new Button("ADD");
        add.setOnAction(event -> {
            String answer = Calculations.vectorAddition(vector1.getText(),
                vector2.getText()).toString();
            String v1 = vector1.getText();
            String v2 = vector2.getText();
            Label prob = new Label(v1 + " + " + v2);
            Label ans = new Label(answer);
            UserInterface.data.getChildren().addAll(prob, ans);
        });
        UserInterface.data.getChildren().addAll(new Label("Addition"),
            vector1, vector2, add);
    }

    public static void vectorSubtraction() {
        UserInterface.data.getChildren().clear();
        TextField vector1 = new TextField();
        vector1.setPromptText("<x,y,z>");
        TextField vector2 = new TextField();
        vector2.setPromptText("<x,y,z>");
        Button sub = new Button("SUBTRACT");
        sub.setOnAction(event -> {
            String answer = Calculations.vectorSubtraction(vector1.getText(),
                vector2.getText()).toString();
            String v1 = vector1.getText();
            String v2 = vector2.getText();
            Label prob = new Label(v1 + " + " + v2);
            Label ans = new Label(answer);
            UserInterface.data.getChildren().addAll(prob, ans);
        });
        UserInterface.data.getChildren().addAll(new Label("Subtraction"),
            vector1, vector2, sub);
    }

    public static void relativisticMomentum() {
        UserInterface.data.getChildren().clear();
        UserInterface.data.getChildren().addAll(new Label("rel mo"));
    }

    public static void nonrelativisticMomentum() {
        UserInterface.data.getChildren().clear();
        UserInterface.data.getChildren().addAll(new Label("nonrel mo"));
    }

    public static void impulseMomentum() {
        UserInterface.data.getChildren().clear();
        UserInterface.data.getChildren().addAll(new Label("imp mo"));
    }

    public static void iterativeCalculation() {
        UserInterface.data.getChildren().clear();
        UserInterface.data.getChildren().addAll(new Label("iter calc"));
    }

    public static void analyticCalculation() {
        UserInterface.data.getChildren().clear();
        UserInterface.data.getChildren().addAll(new Label("ana calc"));
    }

}
