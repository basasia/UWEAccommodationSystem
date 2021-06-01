/*
Class: Student
Description: Object represents a student, commonly associated with lease.
Created: 28/01/2020
Updated: 28/01/2020
Authors: Michael Tonkin (Michael2.Tonkin@live.uwe.ac.uk)
*/
package uweaccommodationsystem;


public class Student {
    
    private int studentID;
    private String studentName;
    
    //initialise a new student with studentID and studentName
    public Student(int studentID, String studentName)
    {
        this.studentID = studentID;
        this.studentName = studentName;
    }
    
    public void setStudentname(String studentName)
    {
        this.studentName = studentName;
    }
    
    public void setStudentID(int studentID)
    {
        this.studentID = studentID;
    }
    
    public String getStudentName()
    {
        return studentName;
    }
    
    public int getStudentID()
    {
        return studentID;
    }
    
}
