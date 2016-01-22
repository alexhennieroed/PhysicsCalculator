import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserInterface extends Application {

    private Stage myStage;
    private Scene home;
    private ListView<String> options;
    public static VBox data;

    @Override
    public void start(Stage stage) {
        myStage = stage;

        options = new ListView<String>(Calculations.LIST);
        options.setOnMouseClicked(event -> {
            directScene(options.getSelectionModel().getSelectedItem());
        });
        options.setPrefWidth(400);
        data = new VBox();
        data.setPrefWidth(800);
        CalcScenes.home();
        HBox main = new HBox();
        main.getChildren().addAll(options, data);
        home = new Scene(main);
        myStage.setScene(home);
        myStage.setHeight(800);
        myStage.setWidth(1200);
        myStage.setTitle("Physics Calculator");
        myStage.show();
    }

    public void directScene(String name) {
        if (name.equals("Vector Addition")) {
            CalcScenes.vectorAddition();
        } else if (name.equals("Vector Subtraction")) {
            CalcScenes.vectorSubtraction();
        } else if (name.equals("Relativistic Momentum")) {
            CalcScenes.relativisticMomentum();
        } else if (name.equals("Non-Relativistic Momentum")) {
            CalcScenes.nonrelativisticMomentum();
        } else if (name.equals("Impulse Momentum")) {
            CalcScenes.impulseMomentum();
        } else if (name.equals("Iterative Calculation")) {
            CalcScenes.iterativeCalculation();
        } else if (name.equals("Analytic Calculation")) {
            CalcScenes.analyticCalculation();
        } else {
            System.out.println("What the hell just happened?");
        }
    }

}
