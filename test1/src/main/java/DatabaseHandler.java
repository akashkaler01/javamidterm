import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseHandler {

    private Connection conn;

    public DatabaseHandler() {
        // Initialize database connection
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String user = "your_username";
        String password = "your_password";

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDiagnosis(String patientName, String diagnosis) {
        String query = "INSERT INTO diagnoses (patient_name, diagnosis) VALUES (?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, patientName);
            statement.setString(2, diagnosis);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Diagnosis> getAllDiagnoses() {
        ObservableList<Diagnosis> diagnosesList = FXCollections.observableArrayList();
        String query = "SELECT * FROM diagnoses";

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String patientName = resultSet.getString("patient_name");
                String diagnosis = resultSet.getString("diagnosis");

                diagnosesList.add(new Diagnosis(patientName, diagnosis));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return diagnosesList;
    }
}
