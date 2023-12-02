module com.example.javafxproject222 {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.sql;

    opens com.example.javafxproject222 to javafx.fxml;
    exports com.example.javafxproject222;
}
