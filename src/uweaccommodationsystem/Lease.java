/*
Class: UWEAccommodationSystem
Description: A lease is an object which can be identified with a room.
    This class contains all pertenent information for the lease, such as 
    the rent, address and student.
Created: 28/01/2020
Updated: 28/01/2020
Authors: Michael Tonkin (Michael2.Tonkin@live.uwe.ac.uk)
*/


package uweaccommodationsystem;


public class Lease {
    
    private int duration;
    private Student student;
    private int leaseID;
    private String address;
    private double rentRateMonthly;
    
    /*
    Function: Lease (constructor)
    Description: creates and initialises the lease object when called
    Parameters: duration - how long the lease is valid for.
                leaseID - a unique id for the lease object.
                addresss - the address associated with the lease.
    */
    public Lease(int duration, int leaseID, String address)
    {
        this.duration = duration;
        this.leaseID = leaseID;
        this.address = address;
    }
    
    //We set the student associated with the lease here.
    //The student class can be found in the same package,
    //uweaccommodationsystem.
    public void setStudent(Student student)
    {
        this.student = student;
    }
    
    
    //getters and setters for appropriate values
    public Student getStudent()
    {
        return this.student;
    }
    
    public void setRentRate(double rentRate)
    {
        this.rentRateMonthly = rentRate;
    }
    
    public double getRentRate()
    {
        return rentRateMonthly;
    }
    
    public int getLeaseID()
    {
        return leaseID;
    }
    
    public int getDuration()
    {
        return duration;
    }
            
    public String getAddress()
    {
        return address;
    }
}