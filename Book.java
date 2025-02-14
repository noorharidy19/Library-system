/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.Serializable;

/**
 *
 * @author Hassan Hatem
 */    enum Category {
        SC_FIC,
        HORROR,
        ROMANCE,
        CRIME,
        DEFAULT_CATEGORY;

        public static Category getSC_FIC() {
            return SC_FIC;
        }

        public static Category getHORROR() {
            return HORROR;
        }

        public static Category getROMANCE() {
            return ROMANCE;
        }

        public static Category getCRIME() {
            return CRIME;
        }
    }
    
public class Book implements Serializable {
    private String name;
    private Category category;
    private double price;
    private int quantity;
    private double rating;
    private int noOfBorrowings;
    private int BookID;


  
    public Book(){}

    public Book(String name, Category category, double price, int quantity,int rating,int noOfBorrowings,int BookID) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.rating=rating;
        this.noOfBorrowings=noOfBorrowings;
        this.BookID=BookID;
    }
       public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }
    
      public int getNoOfBorrowings() {
        return noOfBorrowings;
    }

      
      
    public void updateNoofBorrowings() { 
        noOfBorrowings++;
    }
    

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
