package org.una.laboratorio1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import org.una.laboratorio1.utils.AppContext;
import org.una.laboratorio1.utils.FlowController;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        AppContext.getInstance();
        FlowController.getInstance().InitializeFlow(stage, null);
        FlowController.getInstance().goViewInWindow("LogIn");
    }

    public static void main(String[] args) {
        launch();
    }

}