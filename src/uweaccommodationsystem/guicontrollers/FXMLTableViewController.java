/*
Class: FXMLTableVewController
Description: handles interaction with the FXMLTableView.fxml file. Essentially
             handles input on the TableView screen.
Created: 30/01/2020.
Updated: 05/02/2020.
Authors: Asia Benyadilok
*/
package uweaccommodationsystem.guicontrollers;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import uweaccommodationsystem.Hall;
import uweaccommodationsystem.UWEAccommodationSystem;


public class FXMLTableViewController implements Initializable {
 //create all attributes by using fxid from TableView
    public TableView<Property> tableView;

    public TableColumn<Property, Integer> ColLeaseNum;
    public TableColumn<Property, String> ColHallName;
    public TableColumn<Property, Integer> ColHallNum;
    public TableColumn<Property, Integer> ColRoomNum;
    public TableColumn<Property, String> ColStudentName;
    public TableColumn<Property, String> ColOccupancy;
    public TableColumn<Property, String> ColCleaningStatus;

    public TextField TextFieldLeaseNum;
    public TextField TextFieldLeaseDuration;
    public TextField TextFieldStudentName;
    public TextField TextFieldStudentID;
    public TextField TextFieldMonthlyRentRate;
    public ComboBox comboBoxCleaningStatus;
    public ComboBox comboBoxOccupancy;
    public ComboBox comboBoxHalls;
    public Label labelHallName;
    public Label labelHallNum;
    public Label labelHallAddress;
    public Label labelHallTel;
    public Label labelRoomNum;
    public Label labelLeaseNum;
    public Label labelLeaseDuration;
    public Label labelStudentName;
    public Label labelStudentID;
    public Label labelMonthlyRentRate;
    public Label labelOccupancy;
    public Label labelCleaningStatus;

    public Button DeleteButton;
    public Button SaveButton;
    
    //ObservableList of data to display on table
    ObservableList<Property> observableList = FXCollections.observableArrayList
    (
            UWEAccommodationSystem.getInstance().getProperty()
    );
    
    //temp observableList to display specific hall's data 
    ObservableList<Property> showList = FXCollections.observableArrayList();
    
    //ObservableList of choice for cleaning status, occupancy and halls
    ObservableList<String> cleaningStatusList = FXCollections.observableArrayList("Clean", "Dirty", "Offline");
    ObservableList<String> occupancyList = FXCollections.observableArrayList("Occupied", "Unoccupied");
    ObservableList<String> hallList = FXCollections.observableArrayList("All","H1", "H2", "H3");
    
 //method: changeScreenButtonClicked
 //parameters: ActionEvent event - parsed by javafx.
 //Description: called when user click logout button, change back to LoginView
 //taking the user to the login view interface.
    
    @FXML
    public void changeScreenButtonClicked(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/FXMLLoginView.fxml"));

        Scene scene = new Scene(root);
        //set stage to window and get stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("University of the West of England Bristol Accommodation");
        window.setScene(scene);
        window.show();
    }
    
 //method: handleClickedHallList
 //parameters: ActionEvent event - parsed by javafx.
 //Description: called when user click logout button, change back to LoginView
 //taking the user to the login view interface.
    
    @FXML
    public void handleClickedHallList() {
    //empty showList 
    showList.clear();
    
    if(comboBoxHalls.getValue()=="All")
     {
          tableView.setItems(observableList);
     }
    else
    {
        for(int i=0; i<observableList.size();i++)
        {
            if(comboBoxHalls.getValue()=="H1"){
                if(observableList.get(i).getHallNum()==1)
                {
                    showList.add(observableList.get(i));
                }
            }
            else if(comboBoxHalls.getValue()=="H2"){
                if(observableList.get(i).getHallNum()==2)
                {
                    showList.add(observableList.get(i));
                }
            }
            else if(comboBoxHalls.getValue()=="H3"){
                if(observableList.get(i).getHallNum()==3)
                {
                    showList.add(observableList.get(i));
                }
            }
        }
     tableView.setItems(showList);
    }


    }

 //method: handleSaveProperty
 //parameters: ActionEvent event - parsed by javafx.
 //Description: called when user click save button
 //taking the information from textfield and save it back to object
    
    @FXML
    private void handleSaveProperty()   {
        
        //get index
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
          if (selectedIndex >= 0) 
        {
        //check if inputs are valid or not
        if (isInputValid()) {
            Property selectedProperty = tableView.getSelectionModel().getSelectedItem();
            
            //check the account before allow to save
            if (UWEAccommodationSystem.getAccType() == 'h' || UWEAccommodationSystem.getAccType() == 'r') {
                
                //if textfield is empty
                if((TextFieldLeaseNum.getText().equals("")) || 
                   (TextFieldStudentID.getText().equals("")) || 
                   (TextFieldMonthlyRentRate.getText().equals("")))
                {
                //save leaseNum, StudentID, MonthlyRentRate  as 0
                selectedProperty.setLeaseNum(0);
                selectedProperty.setStudentID(0);
                selectedProperty.setMonthlyRentRate(0);
                selectedProperty.setStudentName(TextFieldStudentName.getText());
                selectedProperty.setOccupancy((String) comboBoxOccupancy.getValue());
                }
                else{
                    
                //save as user inputs
                selectedProperty.setLeaseNum(Integer.parseInt(TextFieldLeaseNum.getText()));
                selectedProperty.setStudentName(TextFieldStudentName.getText());
                selectedProperty.setStudentID(Integer.parseInt(TextFieldStudentID.getText()));
                selectedProperty.setMonthlyRentRate(Double.parseDouble(TextFieldMonthlyRentRate.getText()));
                selectedProperty.setOccupancy((String) comboBoxOccupancy.getValue());
            }
            }
            
            //for warden and root(ALL) to save cleaning status
            selectedProperty.setCleaningStatus((String) comboBoxCleaningStatus.getValue());

            //update tableList
            if(comboBoxHalls.getValue() == "All")
            {
                observableList.set(selectedIndex, selectedProperty);
            }
            else
            {
                showList.set(selectedIndex, selectedProperty);
                tableView.setItems(showList);
            }
            //show new updated
            showPropertyDetails(selectedProperty);
        }
        
        }
            else 
        {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Data Selected");
            alert.setContentText("Please select a row in the table.");

            alert.showAndWait();
        }

    }
 //method: handleDeleteProperty
 //parameters: ActionEvent event - parsed by javafx.
 //Description: called when user click delete button
 //delete the lease of the item selected

    @FXML
    //actions for delete property
    private void handleDeleteProperty()  {
        
        //get index
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        //if selection is valid
        if (selectedIndex >= 0) 
        {
             //get selected item
        Property selectedProperty = tableView.getSelectionModel().getSelectedItem();
        //delete lease information
        selectedProperty.setLeaseNum(0);
        selectedProperty.setLeaseDuration(0);
        selectedProperty.setStudentName("");
        selectedProperty.setStudentID(0);
        selectedProperty.setMonthlyRentRate(0);
        selectedProperty.setOccupancy("Unoccupied");
        selectedProperty.setCleaningStatus("Offline");
        
            //show new updated
            if(comboBoxHalls.getValue() == "All")
            {
                observableList.set(selectedIndex, selectedProperty);
            }
            else
            {
                showList.set(selectedIndex, selectedProperty);
                tableView.setItems(showList);
            }
            showPropertyDetails(selectedProperty);
        } 
        else 
        {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Data Selected");
            alert.setContentText("Please select a row in the table.");

            alert.showAndWait();
        }
    }
    
  //method: handleClickProperty
 //parameters: ActionEvent event - parsed by javafx. 
 //Description: called when user select object on table
    @FXML
    private void handleClickProperty() {
        
        //if account is hallmanager or root
        if (UWEAccommodationSystem.getAccType() == 'h' || UWEAccommodationSystem.getAccType() == 'r') {
                                   
            if (comboBoxOccupancy.getValue() == "Unoccupied") {
                
                TextFieldStudentID.setDisable(true);
                TextFieldMonthlyRentRate.setDisable(true);
                TextFieldLeaseNum.setDisable(true);
                TextFieldLeaseDuration.setDisable(true);
                TextFieldStudentName.setDisable(true);


            }
            if (comboBoxOccupancy.getValue() == "Occupied") {
                TextFieldStudentID.setDisable(false);
                TextFieldMonthlyRentRate.setDisable(false);
                TextFieldLeaseNum.setDisable(false);
                TextFieldLeaseDuration.setDisable(false);
                TextFieldStudentName.setDisable(false);
                SaveButton.setDisable(false);
            }
        }
    }
 //method: handleClickStatusBar
 //parameters: ActionEvent event - parsed by javafx. 
 //Description: called when user click roomstatus dropdown menu
//disable edit Lease when user change room to unoccupied
    @FXML
    private void handleClickStatusBar() 
    {
        //if account is hallmanager or root
        if (UWEAccommodationSystem.getAccType() == 'h' || UWEAccommodationSystem.getAccType() == 'r') 
        {
            
            if (comboBoxOccupancy.getValue() == "Unoccupied") 
            {

                TextFieldStudentID.setDisable(true);
                TextFieldMonthlyRentRate.setDisable(true);
                TextFieldLeaseNum.setDisable(true);
                TextFieldLeaseDuration.setDisable(true);
                TextFieldStudentName.setDisable(true);
                comboBoxCleaningStatus.setValue("Offline");
                SaveButton.setDisable(true);

            }
            if (comboBoxOccupancy.getValue() == "Occupied") 
            {
                TextFieldStudentID.setDisable(false);
                TextFieldMonthlyRentRate.setDisable(false);
                TextFieldLeaseNum.setDisable(false);
                TextFieldLeaseDuration.setDisable(false);
                TextFieldStudentName.setDisable(false);
                comboBoxCleaningStatus.setValue("Clean");
                SaveButton.setDisable(false);

            }

        }
        //if account is root(All)
        //automatically change cleaning status based on when occupancy is changed.
          if (UWEAccommodationSystem.getAccType() == 'r') {
          if (comboBoxOccupancy.getValue() == "Unoccupied"){
               comboBoxCleaningStatus.setValue("Offline");
          }
            if (comboBoxOccupancy.getValue() == "Occupied") {
             comboBoxCleaningStatus.setValue("Clean");
            }
          }
        

    }


//method: isInputValid
//parameters: none
//Description: called to check if user inputs are valid or not
    
    private boolean isInputValid() {
        String errorMessage = "";
        //get item selected
        Property selectedProperty = tableView.getSelectionModel().getSelectedItem();
       
        if (comboBoxOccupancy.getValue() == "Occupied") {
        if (UWEAccommodationSystem.getAccType() == 'h' || UWEAccommodationSystem.getAccType() == 'r'){
            
            //input validation for student name (so no numbers or special characters).
            if (TextFieldStudentName.getText() == null
                    || TextFieldStudentName.getText().length() == 0
                    || !TextFieldStudentName.getText().matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$")) {
                errorMessage += "No valid student name!\n";
            }

            if (TextFieldStudentID.getText() == null || TextFieldLeaseNum.getText().length() == 0) {
                errorMessage += "No valid Student ID !\n";
            } else {
              //check for duplicate student id
                for (int x = 0; x < observableList.size(); x++) {
                    //check if id is duplicate or not and id is change or not if not then there will be no error
                    if (TextFieldStudentID.getText().equals(Integer.toString(observableList.get(x).getStudentID())) && 
                        !(TextFieldStudentID.getText().equals(Integer.toString(selectedProperty.getStudentID())))) {
                        errorMessage += "Duplicate student id!\n";
                        break;
                    }

                }

                // try to parse the Student ID into an int.
                try {
                    Integer.parseInt(TextFieldStudentID.getText());
                } catch (NumberFormatException e) {
                    errorMessage += "No valid Student ID (must be an integer)!\n";
                }
            }

            if (TextFieldLeaseNum.getText() == null || TextFieldLeaseNum.getText().length() == 0) {
                errorMessage += "No valid lease number !\n";
            } else {

               //check that there are no duplicate lease numbers       
                for (int x = 0; x < observableList.size(); x++) {
                     //check if lease num is duplicate or not and lease num is change or not if not then there will be no error
                    if (TextFieldLeaseNum.getText().equals(Integer.toString(observableList.get(x).getLeaseNum()))&& 
                       !(TextFieldLeaseNum.getText().equals(Integer.toString(selectedProperty.getLeaseNum())))) {
                        errorMessage += "Duplicate lease number!\n";
                        break;
                    }
          
                }

                // try to parse the lease num into an int.
                try {
                    Integer.parseInt(TextFieldLeaseNum.getText());
                } catch (NumberFormatException e) {
                    errorMessage += "No valid lease number (must be an integer)!\n";
                }
            }

            if (TextFieldLeaseDuration.getText() == null || TextFieldLeaseDuration.getText().length() == 0) {
                errorMessage += "No valid lease Duration !\n";
            } else {
                // try to parse the lease Duration into an int.
                try {
                    Integer.parseInt(TextFieldLeaseDuration.getText());
                } catch (NumberFormatException e) {
                    errorMessage += "No valid lease Duration (must be an integer)!\n";
                }
            }

            if (TextFieldMonthlyRentRate.getText() == null || TextFieldMonthlyRentRate.getText().length() == 0) {
                errorMessage += "No valid Monthly Rent Rate !\n";
            } else {
                // try to parse the Monthly Rent Rate into an int.
                try {
                    Double.parseDouble(TextFieldMonthlyRentRate.getText());
                } catch (NumberFormatException e) {
                    errorMessage += "No valid Monthly Rent Rate (must be a double)!\n";
                }
            }
        }
            
            //if room is occupied, cleaning status cannot be offline
            if (comboBoxCleaningStatus.getValue() == "Offline") {
                errorMessage += "This room is Occupied cannot change to Offline\n";
            }

        }

        //if there are errors
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

 //method: showPropertyDetails
 //parameters: Property TestProperty 
 //Description: called to show data on textfield and label
    private void showPropertyDetails(Property TestProperty) {
        //if object is not empty
        if (TestProperty != null) {
            // Fill the labels with info from the property object.
            TextFieldLeaseNum.setText(Integer.toString(TestProperty.getLeaseNum()));
            TextFieldLeaseDuration.setText(Integer.toString(TestProperty.getLeaseDuration()));
            TextFieldStudentName.setText(TestProperty.getStudentName());
            TextFieldStudentID.setText(Integer.toString(TestProperty.getStudentID()));
            TextFieldMonthlyRentRate.setText(Double.toString(TestProperty.getMonthlyRentRate()));
            comboBoxOccupancy.setValue(TestProperty.getOccupancy());
            comboBoxCleaningStatus.setValue(TestProperty.getCleaningStatus());

            labelHallName.setText(TestProperty.getHallName());
            labelHallNum.setText(Integer.toString(TestProperty.getHallNum()));
            labelHallAddress.setText(TestProperty.getHallAddress());
            labelHallTel.setText(TestProperty.getHallTel());
            labelRoomNum.setText(Integer.toString(TestProperty.getRoomNum()));
            labelLeaseNum.setText(Integer.toString(TestProperty.getLeaseNum()));
            labelLeaseDuration.setText(Integer.toString(TestProperty.getLeaseDuration()));
            labelStudentName.setText(TestProperty.getStudentName());
            labelStudentID.setText(Integer.toString(TestProperty.getStudentID()));
            labelMonthlyRentRate.setText(Double.toString(TestProperty.getMonthlyRentRate()));
            labelOccupancy.setText(TestProperty.getOccupancy());
            labelCleaningStatus.setText(TestProperty.getCleaningStatus());

            //if the room is unoccupied show nothing about lease infornation 
            if (comboBoxOccupancy.getValue() == "Unoccupied") {
                labelLeaseNum.setText("");
                labelLeaseDuration.setText("");
                labelStudentID.setText("");
                labelMonthlyRentRate.setText("");
                TextFieldLeaseNum.setText("");
                TextFieldLeaseDuration.setText("");
                TextFieldStudentName.setText("");
                TextFieldStudentID.setText("");
                TextFieldMonthlyRentRate.setText("");
            }

        } else {
            // object is null, remove all the text.
            TextFieldLeaseNum.setText("");
            TextFieldLeaseDuration.setText("");
            TextFieldStudentName.setText("");
            TextFieldStudentID.setText("");
            TextFieldMonthlyRentRate.setText("");
            comboBoxOccupancy.setValue("");
            comboBoxCleaningStatus.setValue("");

        }
    }

 
    /*
    Method: intialize
    Description: populates the screen with details from system data and relevant editting buttons.
                 Account authentication is partly done here.
    Parameters: Handled by javafx, do not change.
    Warning: Do not attempt to call this method anywhere else in the program.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //construct the columns on the table
        ColLeaseNum.setCellValueFactory(new PropertyValueFactory<>("LeaseNum"));
        ColStudentName.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
        ColHallName.setCellValueFactory(new PropertyValueFactory<>("HallName"));
        ColHallNum.setCellValueFactory(new PropertyValueFactory<>("HallNum"));
        ColRoomNum.setCellValueFactory(new PropertyValueFactory<>("RoomNum"));
        ColOccupancy.setCellValueFactory(new PropertyValueFactory<>("Occupancy"));
        ColCleaningStatus.setCellValueFactory(new PropertyValueFactory<>("CleaningStatus"));

        //Here we are checking that the user has the privillages to view Lease and Student details
        //if the account is warden then they will be unable to view leasenumber and student name.
        if (UWEAccommodationSystem.getAccType() == 'w') {
            ColLeaseNum.setVisible(false);
            ColStudentName.setVisible(false);

            TextFieldStudentID.setDisable(true);
            TextFieldMonthlyRentRate.setDisable(true);
            TextFieldLeaseNum.setDisable(true);
            TextFieldLeaseDuration.setDisable(true);
            TextFieldStudentName.setDisable(true);
            comboBoxOccupancy.setDisable(true);
            DeleteButton.setVisible(false);

        }

            //Disable Cleaning Status if logged in as hallmanager
        if (UWEAccommodationSystem.getAccType() == 'h') {
            comboBoxCleaningStatus.setDisable(true);
        }
              
        //show items on tableView
        tableView.setItems(observableList);
        
        //set cleaning status option
        comboBoxHalls.setItems(hallList);

        //set cleaning status option
        comboBoxCleaningStatus.setItems(cleaningStatusList);

        //set occupancy options
        comboBoxOccupancy.setItems(occupancyList);

        //set halls options
        comboBoxHalls.setValue("All");
        // Clear Testproperty details.
        showPropertyDetails(null);
        // Listen for selection changes and show the property details when changed.
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPropertyDetails(newValue));

    }

}
