package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void setNameEasy() {
        Item item = new Item("New Item", "0123456789", 10.99);
        item.setName("Changed Item Name");
        assertEquals("Changed Item Name", item.name);
        assertNotEquals("New Item", item.name);
    }

    @Test
    void setNameTooLong() {
        Item item = new Item("New Item", "0123456789", 10.99);
        item.setName("THIS STRING IS 275 CHARACTERS xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx256 WAY TOO LONG");
        assertEquals("New Item", item.name);
        assertNotEquals("THIS STRING IS 275 CHARACTERS xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx256 WAY TOO LONG", item.name);
    }

    @Test
    void setNameTooShort(){
        Item item = new Item("New Item", "0123456789", 10.99);
        item.setName("1");
        assertEquals("New Item", item.name);
        assertNotEquals("1", item.name);
    }

    @Test
    void getNameBase() {
        Item item = new Item("New Item", "0123456789", 10.99);
        assertEquals("New Item", item.getName());
    }

    @Test
    void getNameAfterChange() {
        Item item = new Item("New Item", "0123456789", 10.99);
        item.setName("Changed Item Name");
        assertEquals("Changed Item Name", item.getName());
        assertNotEquals("New Item", item.getName());
    }

    @Test
    void setSerialNumberEasy() {
        Item item = new Item("New Item", "0123456789", 10.99);
        item.setSerialNumber("XXXXXXXXXX");
        assertEquals("XXXXXXXXXX", item.serialnumber);
        assertNotEquals("0123456789", item.serialnumber);
    }

    @Test
    void setSerialNumberSpecialChars() {
        Item item = new Item("New Item", "0123456789", 10.99);
        item.setSerialNumber("**********");
        assertEquals("0123456789", item.serialnumber);
        assertNotEquals("**********", item.serialnumber);
    }

    @Test
    void setSerialNumberTooLong() {
        Item item = new Item("New Item", "0123456789", 10.99);
        item.setSerialNumber("toolongtoolong");
        assertEquals("0123456789", item.serialnumber);
        assertNotEquals("toolongtoolong", item.serialnumber);
    }

    @Test
    void setSerialNumberTooShort() {
        Item item = new Item("New Item", "0123456789", 10.99);
        item.setSerialNumber("short");
        assertEquals("0123456789", item.serialnumber);
        assertNotEquals("short", item.serialnumber);
    }

    @Test
    void getSerialNumberBase() {
        Item item = new Item("New Item", "0123456789", 10.99);
        assertEquals("0123456789", item.getSerialNumber());
    }

    @Test
    void getSerialNumberAfterChange() {
        Item item = new Item("New Item", "0123456789", 10.99);
        item.setSerialNumber("XXXXXXXXXX");
        assertEquals("XXXXXXXXXX", item.getSerialNumber());
    }

    @Test
    void setValueEasy() {
        Item item = new Item("New Item", "0123456789", 10.99);
        item.setValue(4.99);
        assertEquals("$4.99", item.value);
        assertNotEquals("$10.99", item.value);
    }

    @Test
    void getValueBase() {
        Item item = new Item("New Item", "0123456789", 10.99);
        assertEquals("$10.99", item.getValue());
    }

    @Test
    void getValueAfterChange() {
        Item item = new Item("New Item", "0123456789", 10.99);
        item.setValue(2);
        assertEquals("$2.00", item.getValue());
        assertNotEquals("$10.99", item.getValue());
    }
}