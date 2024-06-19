import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DiagnosisApp extends Application {

    private TextField patientNameField;
    private TextField diagnosisField;
    private Label infoLabel;
    private TableView<Diagnosis> tableView;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Diagnosis Information");

        // Create UI components
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(8);

        Label nameLabel = new Label("Patient Name:");
        GridPane.setConstraints(nameLabel, 0, 0);
        patientNameField = new TextField();
        GridPane.setConstraints(patientNameField, 1, 0);

        Label diagnosisLabel = new Label("Diagnosis:");
        GridPane.setConstraints(diagnosisLabel, 0, 1);
        diagnosisField = new TextField();
        GridPane.setConstraints(diagnosisField, 1, 1);

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addDiagnosis());
        GridPane.setConstraints(addButton, 0, 2);

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> searchDiagnosis());
        GridPane.setConstraints(searchButton, 1, 2);

        infoLabel = new Label("Name: Your Name | StudentID: Your StudentID");
        GridPane.setConstraints(infoLabel, 0, 3, 2, 1);

        tableView = new TableView<>();
        GridPane.setConstraints(tableView, 0, 4, 2, 1);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        grid.getChildren().addAll(nameLabel, patientNameField, diagnosisLabel, diagnosisField,
                addButton, searchButton, infoLabel, tableView);

        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addDiagnosis() {
        // Implement database insertion here
        // Example:
        String patientName = patientNameField.getText();
        String diagnosis = diagnosisField.getText();

        // Assuming you have a DatabaseHandler class with a method to insert diagnosis
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.insertDiagnosis(patientName, diagnosis);

        // Optionally, clear fields after adding
        patientNameField.clear();
        diagnosisField.clear();
    }

    private void searchDiagnosis() {
        // Implement database retrieval here
        // Example:
        DatabaseHandler databaseHandler = new DatabaseHandler();
        tableView.setItems(databaseHandler.getAllDiagnoses());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
