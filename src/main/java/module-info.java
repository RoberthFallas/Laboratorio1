module org.una.laboratorio1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.una.laboratorio1 to javafx.fxml;
    exports org.una.laboratorio1;
}
