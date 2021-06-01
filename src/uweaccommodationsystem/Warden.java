/*
Class: HallManager
Description: object defines the Warden. Currently it only needs to store 
their log-in information.
Created: 27/01/2020 (Christy Francis)
Updated: 18/02/2020 (Michael Tonkin - header added)
*/

package uweaccommodationsystem;


public class Warden {
    private String password;
    private String userName;
    
    public String getUsrename(){
        
        return this.userName;
        
    }
    
    public String getPassword(){
        return this.password;
    }
    
}
