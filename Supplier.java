/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author Hassan Hatem
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
public class Supplier extends User implements Serializable { 
    private double maxRevenue;
    private  int noOfOrders;
    private ArrayList<Book> sup;
    public Supplier(String name, int ID, int PIN, String username) {
        super(name, ID, PIN, username);
        noOfOrders=0; 
        sup=new ArrayList<>();
    }
    public int getNoOfOrders() {
        return noOfOrders;
    }

    public void setNoOfOrders(int noOfOrders) {
        this.noOfOrders = noOfOrders;
        
    }
    
      

    public ArrayList<Book> getSup() { 
        return sup;
    }
    
    public void addSuppBooks(Book book,Admin admin) { 
     
           sup.add(book);
           maxRevenue+=book.getPrice(); 
         
             
        System.out.println(admin.getName()+" "+"Ordered this Book "+book.getName()+" by Supplier: "+this.getName());
        
      
    
    }

    public double getMaxRevenue() { 
        return maxRevenue;
    }
       
  public void writeBookss() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("supp.bin"));
            oos.writeObject(sup);
            System.out.println("Objects written to file");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

   public ArrayList<Book> readBookss() {
//        ArrayList<Book> books = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("supp.bin"));
            sup = (ArrayList<Book>) ois.readObject();
            System.out.println("Books read from file");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sup;
    }
       
    } 
    

    

