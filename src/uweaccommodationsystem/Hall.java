/*
Class: UWEAccommodationSystem
Description: Object representation of halls in the UWE building (halls containing
    rooms). Contains all details for halls.
Created: 27/01/2020
Updated: 27/01/2020
Authors: Michael Tonkin (Michael2.Tonkin@live.uwe.ac.uk)
*/

package uweaccommodationsystem;

import java.util.ArrayList;

public class Hall {
    
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private String hallName;
    private int hallNum;
    private String hallAddress;
    private String hallTelNum;
    
    //constructor: Hall
    //description: initialise all variables when creating a new hall
    //parameters: hallName- String (the name of the hall)
    //hallNum - int (the hall number)
    //hallAddress - String (the address of the hall)
    //hallTel - String (the telephone of the hall)
    public Hall(String hallName, int hallNum, String hallAddress, String hallTelNum)
    {
        this.hallName = hallName;
        this.hallNum = hallNum;
        this.hallAddress = hallAddress;
        this.hallTelNum = hallTelNum;
    }
    
    //getter functions to access all variables in the class when they are needed.
    public String getHallTel()
    {
        return hallTelNum;
    }
    
    public String getHallName()
    {
        return hallName;   
    }
    
    public String getHallAddress()
    {
        return hallAddress;
    }
    
    public int getHallNum()
    {
        return hallNum;
    }
    
    public ArrayList<Room> getRooms()
    {
        return rooms;
    }
    
    //function: addRoom
    //description: adds a room to our list of rooms for this hall.
    public void addRoom(Room room)
    {
     rooms.add(room);
    }
}
