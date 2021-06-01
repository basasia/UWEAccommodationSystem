/*
Class: Property
Description: stores all the data in temporary memory to be displayed on the gui.
Created: 01/02/2020
Updated: 24/02/2020
Authors: Asia Benyadilok.
*/
package uweaccommodationsystem.guicontrollers;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Property {
         
    private SimpleIntegerProperty leaseNum;
    private SimpleStringProperty hallName;
    private SimpleIntegerProperty hallNum;
    private SimpleIntegerProperty roomNum;
    private SimpleStringProperty studentName;
    private SimpleStringProperty occupancy;
    private SimpleStringProperty cleaningStatus;
    private SimpleIntegerProperty studentID;
    private SimpleDoubleProperty monthlyRentRate;
    private SimpleIntegerProperty leaseDuration;
    private SimpleStringProperty hallTel;
    private SimpleStringProperty hallAddress; 

     //Constructor: Property
    //Description: is populated with data from UWEAccommodationSystem
    //Parameters: the details to be displayed on the gui table.
    public Property(String hallName, 
                    int hallNum, 
                    String hallAddress, 
                    String hallTel, 
                    int roomNum, 
                    int leaseNum,
                    int leaseDuration,
                    double monthlyRentRate,
                    String studentName, 
                    int studentID, 
                    String occupancy, 
                    String cleaningStatus ){
        
     this.hallName = new SimpleStringProperty(hallName);
     this.hallNum = new SimpleIntegerProperty(hallNum);
     this.hallAddress = new SimpleStringProperty(hallAddress);
     this.hallTel = new SimpleStringProperty(hallTel);
     this.roomNum = new SimpleIntegerProperty(roomNum);
     this.leaseNum = new SimpleIntegerProperty(leaseNum);
     this.leaseDuration = new SimpleIntegerProperty(leaseDuration);
     this.monthlyRentRate = new SimpleDoubleProperty(monthlyRentRate);
     this.studentName = new SimpleStringProperty(studentName);
     this.studentID = new SimpleIntegerProperty(studentID);
     this.occupancy = new SimpleStringProperty(occupancy);
     this.cleaningStatus = new SimpleStringProperty(cleaningStatus);  
    }

    //getters and setters
    public void setStudentID(int studentID) {
        this.studentID = new SimpleIntegerProperty(studentID);
    }

    public void setMonthlyRentRate(double monthlyRentRate) {
        this.monthlyRentRate = new SimpleDoubleProperty(monthlyRentRate);
    }

    public void setLeaseDuration(int leaseDuration) {
        this.leaseDuration =  new SimpleIntegerProperty(leaseDuration);
    }

    public void setHallTel(String hallTel) {
        this.hallTel = new SimpleStringProperty(hallTel);
    }

    public void setHallAddress(String hallAddress) {
        this.hallAddress = new SimpleStringProperty(hallAddress);
    }

    public void setLeaseNum(int leaseNum) {
        this.leaseNum = new SimpleIntegerProperty(leaseNum);
    }

    public void setHallName(String hallName) {
        this.hallName = new SimpleStringProperty(hallName);
    }

    public void setHallNum(int hallNum) {
        this.hallNum = new SimpleIntegerProperty(hallNum);
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = new SimpleIntegerProperty(roomNum);
    }

    public void setStudentName(String studentName) {
        this.studentName = new SimpleStringProperty(studentName);
    }

    public void setOccupancy(String occupancy) {
        this.occupancy = new SimpleStringProperty(occupancy);
    }

    public void setCleaningStatus(String cleaningStatus) {
        this.cleaningStatus = new SimpleStringProperty(cleaningStatus);
    }

    public int getLeaseNum() {
        return leaseNum.get();
    }

    public String getHallName() {
        return hallName.get();
    }

    public int getHallNum() {
        return hallNum.get();
    }

    public int getRoomNum() {
        return roomNum.get();
    }

    public String getStudentName() {
        return studentName.get();
    }

    public String getOccupancy() {
        return occupancy.get();
    }

    public String getCleaningStatus() {
        return cleaningStatus.get();
    }
    
    public int getStudentID() {
        return studentID.get();
    }

    public double getMonthlyRentRate() {
        return monthlyRentRate.get();
    }

    public int getLeaseDuration() {
        return leaseDuration.get();
    }

    public String getHallTel() {
        return hallTel.get();
    }

    public String getHallAddress() {
        return hallAddress.get();
    }
    
    
}
