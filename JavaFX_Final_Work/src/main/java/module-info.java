module com.example.javafx_groupwork {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_groupwork to javafx.fxml;
    exports com.example.javafx_groupwork;
}