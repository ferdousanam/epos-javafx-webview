module org.epos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens org.epos to javafx.fxml;
    exports org.epos;
}