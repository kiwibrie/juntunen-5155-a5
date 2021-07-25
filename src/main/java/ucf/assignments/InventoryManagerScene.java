package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class InventoryManagerScene {
    SceneManager sceneManager;
    Inventory inventory;

    public InventoryManagerScene(){
        this.inventory = new Inventory();
        sceneManager = new SceneManager();
    }

    //---------------------------------------------------------------------------- FILE MENU todo
    @FXML public MenuItem SaveTSV;
    @FXML public MenuItem SaveHTML;
    @FXML public MenuItem SaveJSON;
    @FXML public MenuItem LoadTSV;
    @FXML public MenuItem LoadHTML;
    @FXML public MenuItem LoadJSON;
    @FXML public MenuItem CloseMenuItem;

    @FXML public void SaveTSVClicked(ActionEvent actionEvent){
        //path = file chooser stuff
        saveTSVFile();
    }

    public void saveTSVFile(){
        //include String path in parameter
        //tab separated values... idk yet
    }

    @FXML public void SaveHTMLClicked(ActionEvent actionEvent){
        //path = file chooser stuff
        saveHTMLFile();
    }

    public void saveHTMLFile(){
        //html... also idk
    }

    @FXML public void SaveJSONClicked(ActionEvent actionEvent){
        //save as json method call DISABLED
    }

    public void saveJSONFile(){
        //to work on but i dont plan to do json
    }

    @FXML public void LoadTSVClicked(ActionEvent actionEvent){
        //path = file chooser stuff
        loadTSVFile();
    }

    public void loadTSVFile(){
        //load a tsv... idk
    }

    @FXML public void LoadHTMLClicked(ActionEvent actionEvent){
        //path = file chooser stuff
        loadHTMLFile();
    }

    public void loadHTMLFile(){
        //load an html file i guess
    }

    @FXML public void LoadJSONClicked(ActionEvent actionEvent){
        //load JSON file method call DISABLED
    }

    public void loadJSONFile(){
        //disabled too
    }

    @FXML public void CloseSelected(ActionEvent actionEvent){
        closeApp();
    }

    public void closeApp(){
        Platform.exit();
    }

    //---------------------------------------------------------------------------- EDIT MENU todo
    @FXML public MenuItem EditSelectedMenuItem;
    @FXML public MenuItem DeleteSelectedMenuItem;

    @FXML public void EditSelectedClicked(ActionEvent actionEvent){
        editSelectedItem();
    }

    public void editSelectedItem(){
        int this_index = InventoryTable.getSelectionModel().getSelectedIndex();

        EditSerialTextBox.setText(inventory.inventoryList.get(this_index).getSerialNumber());
        EditNameTextBox.setText(inventory.inventoryList.get(this_index).getName());
        EditPriceTextBox.setText(String.valueOf(inventory.inventoryList.get(this_index).getValue()));

        inventory.inventoryList.remove(this_index);
        EditItemTab.setDisable(false);
    }

    @FXML public void DeleteSelectedClicked(ActionEvent actionEvent){
        deleteSelectedItem();
    }

    public void deleteSelectedItem(){
        int this_index = InventoryTable.getSelectionModel().getSelectedIndex();
        inventory.deleteItem(inventory.inventoryList.get(this_index));
        updateTableView(inventory.inventoryList);
    }

    //---------------------------------------------------------------------------- ADD ITEM TAB todo
    @FXML public Tab NewItemTab;
    @FXML public Button AddItemButton;
    @FXML public TextField AddSerialTextBox;
    @FXML public TextField AddNameTextBox;
    @FXML public TextField AddPriceTextBox;

    @FXML public void AddItemClicked(ActionEvent actionEvent){
        //add item function call
    }

    public void addItemConfirmed(){
        //get serial number from textbox
        //get item name from textbox
        //get price from textbox
        //add item to inventory list
        //update tableview
    }

    //---------------------------------------------------------------------------- EDIT ITEM TAB todo
    @FXML public Tab EditItemTab;
    @FXML public Button EditItemButton;
    @FXML public TextField EditSerialTextBox;
    @FXML public TextField EditNameTextBox;
    @FXML public TextField EditPriceTextBox;

    @FXML public void EditItemClicked(ActionEvent actionEvent){
        try{
            editItemConfirmed();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editItemConfirmed() throws IOException {
        String serial = EditSerialTextBox.getText();
        String name = EditNameTextBox.getText();
        double value = Double.parseDouble(EditPriceTextBox.getText());
        Item item = new Item(name, serial, value);

        if(!item.getSerialNumber().equals(serial)){
            Stage stage = new Stage();
            sceneManager.loadScene(stage, "Serial Number Error");
            stage.show();
        }
        if(!item.getName().equals(name)){
            Stage stage = new Stage();
            sceneManager.loadScene(stage, "Item Name Error");
            stage.show();
        }
        if(item.getValue() != value){
            Stage stage = new Stage();
            sceneManager.loadScene(stage, "Item Price Error");
            stage.show();
        }

        updateTableView(inventory.inventoryList);
        EditItemTab.setDisable(true);
    }

    //---------------------------------------------------------------------------- SEARCH TAB todo
    @FXML public Tab SearchTab;
    @FXML public Button SearchButton;
    @FXML public TextField SearchTextBox;
    @FXML public RadioButton SearchSerialRadio;
    @FXML public RadioButton SearchNameRadio;

    @FXML public void SearchButtonClicked(ActionEvent actionEvent){
        /*
        get search term from text box
        if (search by serial), search serial method
        if (search by name), search name method
         */
    }

    public void searchSerialConfirmed(String term){

    }

    public void searchNameConfirmed(String term){

    }

    @FXML public void SearchSerialRadioClicked(ActionEvent actionEvent){
        //if this clicked, turn off other
    }

    @FXML public void SearchNameRadioClicked(ActionEvent actionEvent){
        //if this clicked, turn off other
    }

    //---------------------------------------------------------------------------- INVENTORY TABLE todo
    @FXML TableView<Item> InventoryTable;

    public void updateTableView(List<Item> updatedList){
        //make given list observable
        //update table with this list
    }
}
