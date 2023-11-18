module com.example.stickherogame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.stickherogame to javafx.fxml;
    exports com.example.stickherogame;
}