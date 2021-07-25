package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SceneManagerTest {

    @Test
    void createManager(){
        SceneManager scm = new SceneManager();
        assertEquals("InventoryManager.fxml", scm.scenelist.get("InventoryManager"));
        assertEquals("SerialError.fxml", scm.scenelist.get("Serial Number Error"));
        assertEquals("SerialExists.fxml", scm.scenelist.get("Serial Number Exists Error"));
        assertEquals("NameError.fxml", scm.scenelist.get("Item Name Error"));
        assertEquals("PriceError.fxml", scm.scenelist.get("Item Price Error"));
    }
}