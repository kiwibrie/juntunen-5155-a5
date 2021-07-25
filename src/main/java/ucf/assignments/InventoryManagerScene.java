package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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

    //---------------------------------------------------------------------------- EDIT MENU
    @FXML public MenuItem EditSelectedMenuItem;
    @FXML public MenuItem DeleteSelectedMenuItem;

    @FXML public void EditSelectedClicked(ActionEvent actionEvent){
        editSelectedItem();
    }

    public void editSelectedItem(){
        int this_index = InventoryTable.getSelectionModel().getSelectedIndex();

        EditSerialTextBox.setText(inventory.inventoryList.get(this_index).getSerialNumber());
        EditNameTextBox.setText(inventory.inventoryList.get(this_index).getName());
        EditPriceTextBox.setText(String.valueOf(inventory.inventoryList.get(this_index).getValue()).substring(1));

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

    //---------------------------------------------------------------------------- NEW ITEM TAB
    @FXML public Tab NewItemTab;
    @FXML public Button AddItemButton;
    @FXML public TextField AddSerialTextBox;
    @FXML public TextField AddNameTextBox;
    @FXML public TextField AddPriceTextBox;

    @FXML public void AddItemClicked(ActionEvent actionEvent){
        try{
            addItemConfirmed();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addItemConfirmed() throws IOException {
        try{
            String serial = AddSerialTextBox.getText();
            String name = AddNameTextBox.getText();
            double value = Double.parseDouble(AddPriceTextBox.getText());

            if(!isItemValid(name, serial, value)){
                return;
            }

            inventory.addItem(name, serial, value);
            updateTableView(inventory.inventoryList);

            AddSerialTextBox.clear();
            AddNameTextBox.clear();
            AddPriceTextBox.clear();
        } catch (NumberFormatException e) {
            callError("Item Price Error");
        }
    }

    //---------------------------------------------------------------------------- EDIT ITEM TAB
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
        try{
            String serial = EditSerialTextBox.getText();
            String name = EditNameTextBox.getText();
            double value = Double.parseDouble(EditPriceTextBox.getText());

            if(!isItemValid(name, serial, value)){
                return;
            }

            inventory.addItem(name, serial, value);
            updateTableView(inventory.inventoryList);

            EditItemTab.setDisable(true);
            EditSerialTextBox.clear();
            EditNameTextBox.clear();
            EditPriceTextBox.clear();
        } catch (NumberFormatException e) {
            callError("Item Price Error");
        }
    }

    //---------------------------------------------------------------------------- SEARCH TAB
    @FXML public Tab SearchTab;
    @FXML public Button SearchButton;
    @FXML public TextField SearchTextBox;
    @FXML public RadioButton SearchSerialRadio;
    @FXML public RadioButton SearchNameRadio;

    @FXML public void SearchButtonClicked(ActionEvent actionEvent){
        String term = SearchTextBox.getText();
        if(SearchSerialRadio.isSelected()){
            searchSerialConfirmed(term);
        } else if (SearchNameRadio.isSelected()){
            searchNameConfirmed(term);
        }
    }

    public void searchSerialConfirmed(String term){
        updateTableView(inventory.searchBySerial(term));
        SearchTextBox.clear();
    }

    public void searchNameConfirmed(String term){
        updateTableView(inventory.searchByName(term));
        SearchTextBox.clear();
    }

    @FXML public void SearchSerialRadioClicked(ActionEvent actionEvent){
        SearchNameRadio.setSelected(false);
    }

    @FXML public void SearchNameRadioClicked(ActionEvent actionEvent){
        SearchSerialRadio.setSelected(false);
    }

    //---------------------------------------------------------------------------- INVENTORY TABLE todo
    @FXML TableView<Item> InventoryTable;
    @FXML TableColumn<String, String> SerialNumberColumn;
    @FXML TableColumn<String, String> ItemNameColumn;
    @FXML TableColumn<String, String> PriceColumn;

    public void updateTableView(List<Item> updatedList){
        ObservableList<Item> itemObservableList = FXCollections.observableList(updatedList);

        InventoryTable.setItems(itemObservableList);
        SerialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("SerialNumber"));
        ItemNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        PriceColumn.setCellValueFactory(new PropertyValueFactory<>("Value"));
    }

    //---------------------------------------------------------------------------- ERROR SCENES
    @FXML public Button ErrorOKButton;

    @FXML public void ErrorOKClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) ErrorOKButton.getScene().getWindow();
        stage.close();
    }

    //---------------------------------------------------------------------------- MISC

    public boolean isItemValid(String name, String serial, double price){
        Item item = new Item(name, serial, price);

        if(item.getSerialNumber() == null){
            callError("Serial Number Error");
            return false;
        }
        if(!item.getSerialNumber().equals(serial)){
            callError("Serial Number Error");
            return false;
        }
        if(inventory.searchBySerial(serial).size() >= 1){
            callError("Serial Number Exists Error");
            return false;
        }

        if(item.getName() == null){
            callError("Item Name Error");
            return false;
        }
        if(!item.getName().equals(name)){
            callError("Item Name Error");
            return false;
        }

        if(String.valueOf(price).equals(item.getValue())){
            callError("Item Price Error");
            return false;
        }

        return true;
    }

    public void callError(String key){
        try{
            Stage stage = new Stage();
            sceneManager.loadScene(stage, key);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
