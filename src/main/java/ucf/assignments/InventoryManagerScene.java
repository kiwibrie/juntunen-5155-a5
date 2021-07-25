package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class InventoryManagerScene {

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
        //editselected function call
    }

    public void editSelectedItem(){
        //fill serial number textbox
        //fill item name textbox
        //fill price textbox
        //delete old item
        //make edit tab visible
    }

    @FXML public void DeleteSelectedClicked(ActionEvent actionEvent){
        //deleteselected function call
    }

    public void deleteSelectedItem(){
        //search for item
        //delete item
        //update tableview
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
        //edititem function call
    }

    public void editItemConfirmed(){
        //get serial number from textbox
        //get item name from textbox
        //get price from textbox
        //add item to inventory list
        //update tableview
        //then make the edit tab invisible
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
