package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class InventoryManager extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            InventoryManagerScene scene = new InventoryManagerScene();
            Stage stage = new Stage();
            scene.sceneManager.loadScene(stage, "InventoryManager");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
