/*
Class: HallManager
Description: object defines the Hall Manager. Currently it only needs to store 
their log-in information.
Created: 27/01/2020 (Christy Francis)
Updated: 18/02/2020 (Michael Tonkin - header added)
*/

package uweaccommodationsystem;

public class HallManager {
    
    private String userName;
    private String password;
    
    public String getPassword(){
        
        return this.password;
    }
    
    public String getUserName(){
        return this.userName;
    }
    
}
