# Inventory Manager - Assignment 5
### UCF COP 3330 Summer 2021 with Hollander

## Requirements of the program
1. The user shall interact with the application through a Graphical User Interface
2. The user shall be able to store at least 100 inventory items
    - Each inventory item shall have a value representing its monetary value in US dollars
    - Each inventory item shall have a unique serial number in the format of XXXXXXXXXX where 
      X can be either a letter or digit
    - Each inventory item shall have a name between 2 and 256 characters in length (inclusive)
3. The user shall be able to add a new inventory item
    - The application shall display an error message if the user enters an existing serial number 
      for the new item
4. The user shall be able to remove an existing inventory item
5. The user shall be able to edit the value of an existing inventory item
6. The user shall be able to edit the serial number of an existing inventory item
    - The application shall prevent the user from duplicating the serial number
7. The user shall be able to edit the name of an existing inventory item
8. The user shall be able to sort the inventory items by value
9. The user shall be able to sort inventory items by serial number
10. The user shall be able to sort inventory items by name
11. The user shall be able to search for an inventory item by serial number
12. The user shall be able to search for an inventory item by name
13. The user shall be able to save their inventory items to a file
    - The user shall be able to select the file format from among the following set of options:
      TSV (tab-separated value), HTML, JSON
        - TSV files shall list one inventory item per line, separate each field within an inventory 
          item using a tab character, and end with the extension .txt
        - HTML files shall contain valid HTML and end with the extension .html
        - JSON files shall contain valid JSON and end with the extension .json
    - The user shall provide the file name and file location of the file to save
14. The user shall be able to load inventory items from a file that was previously created by the 
    application.
    - The user shall provide the file name and file location of the file to load
    
##How to use the program##

**To add an inventory item:**

In the `New Item` tab, fill out the `serial number`, `item name`, and `price` text boxes and click the 
`Add Item` button on the right.

*If an error occurs, read the error text and adjust your input accordingly.*

**To remove an inventory item:**

Select the item you wish to remove in the `Inventory Table`, then navigate to the `Edit` Menu in the 
top left of your window. From the dropdown, select `Delete Selected Item`.

**To edit the values of an existing inventory item:**

Select the item you wish to edit in the `Inventory Table`, then navigate to the `Edit` Menu in the 
top left of your window. From the dropdown, select `Edit Selected Item`. Change your current tab to
the now available `Edit Item` tab. Modify the values you wish to edit, then click the `Edit Item`
button on the right.

*If an error occurs, read the error text and adjust your input accordingly.*

**To sort the items in the inventory:**

Click the header of the value you wish to sort by. The header will cycle through 
descending order, ascending order, and no sort. 

*For example, if I wished to sort the inventory from highest to lowest prices, I would 
click the header `Price` two times.*

**To search by `serial number`:**

Select the `Search` tab from within the tab menu. While there, you can type a search term
into the available text box. Select the radio button `by Serial` and click the `Search` button.
The `Inventory Table` will update with all items containing your search term.

*To reset the `Inventory Table`, make sure the search text box is clear and click the
`Search` button again. It does not matter which radio button is selected.*

**To search by `name`:**

Select the `Search` tab from within the tab menu. While there, you can type a search term
into the available text box. Select the radio button `by Name` and click the `Search` button.
The `Inventory Table` will update with all items containing your search term.

*To reset the `Inventory Table`, make sure the search text box is clear and click the
`Search` button again. It does not matter which radio button is selected.*

**To save your inventory as TSV, HTML, or JSON file:**

*As TSV*

*As HTML*

*As JSON*\
This program does not currently support JSON files.

**To load your inventory from a TSV, HTML, or JSON file:**

*As TSV*

*As HTML*

*As JSON*\
This program does not currently support JSON files.