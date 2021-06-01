/*
Class: Room
Description: Contains information for a generic room, which can be instantiated
for any individual room.
Created: 27/01/2020 (Asia Benyadilok).
Updated: 18/02/2020 (Michael Tonkin - added header).
*/

package uweaccommodationsystem;

public class Room
{
    private int roomNumber;
    private String roomStatus;
    private String cleaningStatus;
    private Lease lease;
    
    public Room(int roomNumber)
    {
        this.roomNumber = roomNumber;
    }
    
    public int getRoomNumber()
    {
        return this.roomNumber; 
    }
    
    public String getRoomStatus()
    {
        return this.roomStatus;
    }
    
    public String getCleaningStatus()
    {
        return this.cleaningStatus;
    }
    
    public void setCleaningStatus(String cleaningStatus)
    {
        this.cleaningStatus = cleaningStatus;
    }
  
    public void setRoomStatus(String roomStatus)
    {
        this.roomStatus = roomStatus;
    }
    
    public void setLease(Lease lease)
    {
        this.lease = lease;
    }
    
    public Lease getLease()
    {
        return this.lease;
    }
}
