package org.epos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.epos.config.Config;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static String app_url;

    public StackPane renderWebview() {
        WebView myWebView = new WebView();
        WebEngine webEngine = myWebView.getEngine();

        webEngine.load(app_url);

        StackPane root = new StackPane();
        root.getChildren().add(myWebView);

        return root;
    }

    @Override
    public void start(Stage stage) throws IOException {
        app_url = Config.get("APP_URL");

        stage.setTitle(Config.get("APP_NAME"));
        StackPane root = this.renderWebview();
        Scene scene = new Scene(root, 640, 480);
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}