/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Hassan Hatem
 */
public abstract class User implements Serializable{ 
    private String name;
    private int ID;
    private int PIN;
    private String username;
    


    public User(String name, int ID, int PIN, String username) {
        this.name = name;
        this.ID = ID;
        this.PIN = PIN;
        this.username = username;
        

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
      this.ID=ID;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
  public User Login(int PIN, String username, Admin a) {
    ArrayList<User> users =a.readUserss();

    for (User u : users) {
        if (u.getPIN() == PIN && u.getUsername().equals(username)) {
            return u; 
        }
    }

    return null;  
}
     
     

    public boolean SignUp(String name,int ID,int PIN,String username,Admin a){
        boolean Complete=true;
        ArrayList<User> users=a.readUserss();
        for(User u:users){
        if(u.getID()==ID||u.getUsername().equals(username)){
            Complete=false;
            }
        }
//        if(Complete){
//        setID(ID);
//        setUsername(username);
//        setName(name);
//        setPIN(PIN);
//        
//        }
        
        return Complete;
    }
    
}
