import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserInterface extends Application {

    private Stage myStage;
    private Scene home;
    private ListView<String> options;
    public static VBox data;
    public static Label copyItem;

    @Override
    public void start(Stage stage) {
        myStage = stage;

        options = new ListView<String>(Calculations.LIST);
        options.setOnMouseClicked(event -> {
            if (options.getSelectionModel().getSelectedItem() == null) {
                return;
            }
            directScene(options.getSelectionModel().getSelectedItem());
        });
        options.setPrefWidth(300);
        options.setPrefHeight(530);
        copyItem = new Label("[Your Copied Item Here]");
        Button copy = new Button("COPY");
        copy.setMinWidth(60);
        copy.setOnAction(event -> {
            CalcScenes.copyData();
        });
        Button paste = new Button("PASTE");
        paste.setMinWidth(65);
        paste.setOnAction(event -> {
            CalcScenes.pasteData();
        });
        Label copyTitle = new Label("Current Item: ");
        copyTitle.setMinWidth(80);
        HBox coTop = new HBox();
        coTop.setMinHeight(30);
        coTop.getChildren().addAll(copyTitle, copyItem);
        coTop.setAlignment(Pos.CENTER_LEFT);
        HBox coBot = new HBox();
        coBot.setPrefHeight(40);
        coBot.getChildren().addAll(copy, paste);
        VBox copyOption = new VBox();
        copyOption.setPrefWidth(300);
        copyOption.setPrefHeight(80);
        copyOption.getChildren().addAll(coTop, coBot);
        VBox voHolder = new VBox();
        voHolder.getChildren().addAll(options, copyOption);
        data = new VBox();
        data.setPrefWidth(600);
        CalcScenes.home();
        HBox main = new HBox();
        main.getChildren().addAll(voHolder, data);
        main.requestFocus();
        home = new Scene(main);
        myStage.setScene(home);
        myStage.setHeight(600);
        myStage.setWidth(900);
        myStage.setTitle("Physics Calculator");
        myStage.show();
    }

    public void directScene(String name) {
        if (name.equals("Vector Addition")) {
            CalcScenes.vectorAddition();
        } else if (name.equals("Vector Subtraction")) {
            CalcScenes.vectorSubtraction();
        } else if (name.equals("Scalar Multiplication")) {
            CalcScenes.scalarMultiplication();
        }else if (name.equals("Relativistic Momentum")) {
            CalcScenes.relativisticMomentum();
        } else if (name.equals("Non-Relativistic Momentum")) {
            CalcScenes.nonrelativisticMomentum();
        } else if (name.equals("Impulse Momentum")) {
            CalcScenes.impulseMomentum();
        } else if (name.equals("Iterative Calculation")) {
            CalcScenes.iterativeCalculation();
        } else if (name.equals("Analytic Calculation")) {
            CalcScenes.analyticCalculation();
        } else if (name.equals("Magnitude")) {
            CalcScenes.magnitude();
        } else if (name.equals("Unit Vector")) {
            CalcScenes.unitVector();
        } else if (name.equals("Energy Principle")) {
            CalcScenes.energyPrinciple();
        } else if (name.equals("Angular Momentum Principle")) {
            CalcScenes.angularMomentum();
        } else if (name.equals("Gravitational Force")) {
            CalcScenes.gravitationalForce();
        } else {
            System.out.println("What the hell just happened?");
        }
    }

}
