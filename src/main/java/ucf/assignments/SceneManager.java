package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import javafx.scene.Scene;

import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    Map<String, String> scene;

    public SceneManager(){
        this.scene = new HashMap<>();
        scene.put("Main Scene", "InventoryManager.fxml");
        scene.put("Error Scene", "Error.fxml");
    }

    public void loadScene(String key){
        //todo loadScene
    }
}
