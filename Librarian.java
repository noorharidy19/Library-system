/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.*;

public class Librarian extends User implements Serializable {
    private Date currentDateAndTime; 
    private double maxRevenue;
    private int noofborrowings;
     private ArrayList<Book> CreateOrder=new ArrayList<>();
//  private transient   Scanner s=new Scanner(System.in);
    ArrayList<Book> b; 
    public Librarian( String name, int ID, int PIN, String username,Admin a) {
        super(name, ID, PIN, username);
        this.b=a.getBookk(); 
       
            currentDateAndTime=new Date();
        
    }
    public ArrayList<Book> getB() {
        return b;
    }
    public double getMaxRevenue() {
        return maxRevenue;
    }


   public void CreateBorrowings(Book BorrowedBook,Borrower borrower) throws IOException{ 
       CreateOrder=borrower.getCreateOrder();
        currentDateAndTime = new Date();
       if(CreateOrder.contains(BorrowedBook)){ 
           BorrowedBook.updateNoofBorrowings();
           int quantityAfterBorrowing=BorrowedBook.getQuantity()-1; 
           BorrowedBook.setQuantity(quantityAfterBorrowing);
           borrower.addbook(BorrowedBook);
           noofborrowings++; 
           maxRevenue+=BorrowedBook.getPrice();
           System.out.println(BorrowedBook.getName()+" Has been borrowed by :"+borrower.getName()+" At "+currentDateAndTime);

       }
       else{
           System.out.println("unavaliable book");
       }
   }
   
    public void CancelBorrowings(Book BorrowedBook,Borrower borrower){
        Date currentDateAndTime = new Date();
      if(borrower.check(BorrowedBook)){
          borrower.removebook(BorrowedBook);
          noofborrowings--;
      }
      if(b.contains(BorrowedBook)){
          int quantityAfterRemoving=BorrowedBook.getQuantity()+1;
           BorrowedBook.setQuantity(quantityAfterRemoving);
      }
      else
          b.add(BorrowedBook);
           
       
    System.out.println(BorrowedBook.getName()+" Has been canceled by :"+getName()+" At "+currentDateAndTime);
    }
    
       public double calculatePayment(Borrower borrower){
           ArrayList<Book> borr=borrower.readCreateOrder(); 
           double totalprice=0;
          for(Book boook:borr){ 
              double o=boook.getPrice();
              totalprice+=o; 
             
           }
           return totalprice;
       }
            
 
   
public int getnumberofborrowings(){
    return noofborrowings;
}

    
public String RecommendCategory(Borrower boorrow) {
    ArrayList<Category> AmrBook = new ArrayList<>();
Category[]c=Category.values();
    for (int i = 0; i < 5; i++) {
        AmrBook.add(c[i]);
    }
    
   

    while (true) {
        try {
            Category x = AmrBook.get((int) Math.round(AmrBook.size() % Math.random()));
            StringBuilder bookC=new StringBuilder();
            bookC.append(x);
            for (Book book : b) {
                if (book.getCategory().equals(x)) {
                    bookC.append("\n").append("Book name:").append(book.getName()); 
                }
            }
            return bookC.toString();
        } catch (IndexOutOfBoundsException e) {
            System.out.print("");
        }
    }
}
 public String BorrowingDetails(Date date){
     Date currentDateAndTime = date;
     Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDateAndTime);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date thirtyDaysLater = calendar.getTime();
         //Date thirtyDaysLater = adddays(currentDateAndTime,30);
//     System.out.println("Borrow date "+currentDateAndTime);
     System.out.println("due date "+thirtyDaysLater);
            
      System.out.println("Book has to be in the same condition");
     return "due date "+thirtyDaysLater;
 }
 
 
}

