module com.example.stickherogame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;


    opens com.example.stickherogame to javafx.fxml;
    exports com.example.stickherogame;
}