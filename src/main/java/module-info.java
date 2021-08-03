module ucf.assignments {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    opens ucf.assignments to javafx.graphics, javafx.fxml;
    exports ucf.assignments;
}