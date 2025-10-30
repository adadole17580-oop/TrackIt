module com.example.trackitapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.trackitapp to javafx.fxml;
    exports com.example.trackitapp;
}