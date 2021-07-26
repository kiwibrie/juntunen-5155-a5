package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SceneManager {
    Map<String, String> scenelist;

    public SceneManager(){
        this.scenelist = new HashMap<>();
        scenelist.put("InventoryManager", "InventoryManager.fxml");
        scenelist.put("Serial Number Error", "SerialError.fxml");
        scenelist.put("Serial Number Exists Error", "SerialExists.fxml");
        scenelist.put("Item Name Error", "NameError.fxml");
        scenelist.put("Item Price Error", "PriceError.fxml");
        scenelist.put("Save Inventory Failure", "SaveError.fxml");
        scenelist.put("Load Inventory Failure", "LoadError.fxml");
    }

    public void loadScene(Stage stage, String key) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource(scenelist.get(key)))));
        stage.setScene(scene);
        stage.setTitle(key);
        stage.setResizable(false);
    }
}
