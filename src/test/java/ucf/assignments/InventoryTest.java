package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void addItemEasy() {
        Inventory inventory = new Inventory();
        inventory.addItem("New Item", "0123456789", 10.99);

        assertEquals("New Item", inventory.inventoryList.get(0).name);
        assertEquals("0123456789", inventory.inventoryList.get(0).serialnumber);
        assertEquals("$10.99", inventory.inventoryList.get(0).value);
        assertEquals(1, inventory.inventoryList.size());
    }

    @Test
    void addItemSameSerialNumber(){
        Inventory inventory = new Inventory();
        inventory.addItem("New Item", "0123456789", 10.99);
        inventory.addItem("Item 2", "0123456789", 10.99);

        assertEquals(1, inventory.inventoryList.size());
        assertEquals("New Item", inventory.inventoryList.get(0).name);
    }

    @Test
    void deleteItemEasy() {
        Inventory inventory = new Inventory();
        Item item1 = new Item("Item 1", "0123456789", 10.99);
        Item item2 = new Item("Item 2", "XXXXXXXXXX", 2.99);

        inventory.inventoryList.add(item1);
        inventory.inventoryList.add(item2);
        inventory.deleteItem(item1);

        assertEquals(1, inventory.inventoryList.size());
        assertEquals("Item 2", inventory.inventoryList.get(0).name);
    }

    @Test
    void searchByName() {
        Inventory inventory = new Inventory();
        inventory.addItem("New Item", "0123456789", 10.99);
        inventory.addItem("Another Item", "XXXXXXXXXX", 10.99);
        inventory.addItem("Another New Item", "XXXXX12345", 10.99);

        assertEquals(2, inventory.searchByName("Another").size());
        assertEquals(2, inventory.searchByName("New").size());
        assertEquals(3, inventory.searchByName("").size());
    }

    @Test
    void searchBySerial() {
        Inventory inventory = new Inventory();
        inventory.addItem("New Item", "0123456789", 10.99);
        inventory.addItem("Another Item", "XXXXXXXXXX", 10.99);
        inventory.addItem("Another New Item", "XXXXX12345", 10.99);

        assertEquals(2, inventory.searchBySerial("X").size());
        assertEquals(2, inventory.searchBySerial("XXXXX").size());
        assertEquals(1, inventory.searchBySerial("456").size());
        assertEquals(1, inventory.searchBySerial("X1").size());
        assertEquals(3, inventory.searchBySerial("").size());
    }

    @Test
    void searchDuplicateSerial(){
        Inventory inventory = new Inventory();
        inventory.addItem("New Item", "0123456789", 10.99);
        inventory.addItem("Another Item", "XXXXXXXXXX", 10.99);
        inventory.addItem("Another New Item", "XXXXX12345", 10.99);

        assertTrue(inventory.duplicateSerialExists("0123456789"));
        assertTrue(inventory.duplicateSerialExists("XXXXXXXXXX"));
        assertTrue(inventory.duplicateSerialExists("XXXXX12345"));
        assertFalse(inventory.duplicateSerialExists("ASDFGHJKL0"));
    }

    @Test
    void saveTSV() {
        try{
            Inventory inventory = new Inventory();
            inventory.addItem("New Item", "0123456789", 10.99);
            inventory.addItem("Another Item", "XXXXXXXXXX", 10.99);
            inventory.addItem("Another New Item", "XXXXX12345", 10.99);

            File file = new File("Downloads/saveTSVtest.txt");
            inventory.saveTSV(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void loadTSV() {
        try{
            Inventory inventory = new Inventory();
            File file = new File("Downloads/test list.txt");
            inventory.loadTSV(file);

            assertEquals(3, inventory.inventoryList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void saveHTML() {
        try{
            Inventory inventory = new Inventory();
            inventory.addItem("New Item", "0123456789", 10.99);
            inventory.addItem("Another Item", "XXXXXXXXXX", 10.99);
            inventory.addItem("Another New Item", "XXXXX12345", 10.99);

            File file = new File("Downloads/saveHTMLtest.txt");
            inventory.saveHTML(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void loadHTML() {
        try{
            Inventory inventory = new Inventory();
            File file = new File("Downloads/htmltestsave.txt");
            inventory.loadTSV(file);

            assertEquals(3, inventory.inventoryList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}