module org.una.laboratorio1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires com.jfoenix;
    requires java.ws.rs;
    requires java.sql;
    requires java.logging;
    
    opens org.una.laboratorio1 to javafx.fxml;
    exports org.una.laboratorio1;
}
