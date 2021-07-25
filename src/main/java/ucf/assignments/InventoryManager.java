package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InventoryManager extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            InventoryManagerScene controller = new InventoryManagerScene();

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(controller.sceneManager.scenelist.get("InventoryManager"))));
            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setTitle("InventoryManager");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
