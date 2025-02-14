/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.InputMismatchException;
public class Borrower extends User implements Serializable {
    private int noofborrowings;
    private double maxRevenue;
     private ArrayList<Book> CreateOrder;//Cart of borrower
private ArrayList<Book> AdminBooks;//Library books
private ArrayList<Book> hasbooks;//el librarian create order for borrower
    public ArrayList<Book> getCreateOrder() {
        return CreateOrder;
    }

    public ArrayList<Book> getAdminBooks() {
        return AdminBooks;
    }
    
//private transient Scanner s= new Scanner(System.in);
  
    
    public ArrayList<Book> getHasbooks() {
        return hasbooks;
    }
    
    public Borrower(String name, int ID, int PIN, String username,Admin a) {
        super(name, ID, PIN, username);
        noofborrowings=0;
        hasbooks= new ArrayList<>();
        CreateOrder=new ArrayList();
       AdminBooks=a.readBookss();
    }
    
    public boolean check(Book book){//libraian ek 3mal fiha add
        
       return hasbooks.contains(book);
      
    }
    public String completepurchase(Librarian l ){
        System.out.println("your ordred books are:");
         StringBuilder s=new StringBuilder();
         s.append("Your Ordere Books Are ");
         for(Book book:readCreateOrder()){
             s.append(book.getName()).append(" price ").append(book.getPrice()).append("\n");
             
         }
         s.append("total ammout").append(l.calculatePayment(this));
         return s.toString();
    }
//     System.out.println("1) Cash ");
//     System.out.println("2) Credit Card");
// int choice = s.nextInt();            
// switch(choice){
//     case 1:
//         double totalamount=0;
//         for(Book a:CreateOrder){
//             totalamount+=a.getPrice();
//         }
//         System.out.println("Payment is Cash ...");
//         System.out.println("Proceeding with the following amount : "+totalamount);
//         l.BorrowingDetails();
//         break;
//     case 2:
//         double total=0;
//         for(Book a:CreateOrder){
//             total+=a.getPrice();
//         }
//         System.out.println("Payment witt card ...");
//         System.out.println("Proceeding with the following amount : "+total);
//         CardPayment();
//         System.out.println("order confirmed");
//        
//     
//          l.BorrowingDetails();
//         
//         break;
//     default:
//         System.out.println("Invalid Choice ");
// }
// 
//    }
//    public void checking(){
//        for(Book b:AdminBooks){
//            System.out.println("createeee "+b.getName());
//                    
//        }
//    }
    public void CreateOrder(Book book) {
//    if (AdminBooks.contains(book)) {
        CreateOrder.add(book);
        System.out.println("Book added to the order successfully");
//    } else {
//        System.out.println("Book not found in the AdminBooks list");
//    }
}
    public void CancelOrder(Book book){
         if(CreateOrder.contains(book)){
            CreateOrder.remove(book);
        }
    }
    public void addbook(Book book) throws IOException{
        hasbooks.add(book);
        System.out.println("book added succesfully");
        noofborrowings++;
        maxRevenue+=book.getPrice();
       
    }
     public void removebook(Book book){
         if(hasbooks.contains(book)){
        hasbooks.remove(book);
    }
     }
public int getnumberofborrowings(){
    return noofborrowings;
}
public double getmaxRevenue(){
    return maxRevenue;
}

public void RateBook(Book book,int Enterrating)
{ 
    
   
//    Scanner c=new Scanner(System.in);
    System.out.println("Enter num from 0 to 5");
//    double Enterrating=c.nextDouble();
    double sum=0;
    
   if(Enterrating>=0&&Enterrating<=5){
    if(book.getRating()==0){
         book.setRating(Enterrating);
         System.out.println("rating="+ book.getRating());
         
    }
    else
    {
        sum=book.getRating()+Enterrating;
       book.setRating(sum/2.0);
       System.out.println("rating="+ book.getRating());
    }  
   
            
   }
   else{
       System.out.println("Rating out of range");
   }
   
  
}
   public void CardPayment()  {
       try{

       
        Scanner sc = new Scanner(System.in);
        System.out.println("EnterCard Number:");
        
        int Count=0;
        while(Count<=3){
             int count2=0;
       long cardNo = sc.nextLong();
       while(cardNo>0){
           cardNo/=10;
             count2++; 
       }
       
        if(count2==11){
            System.out.println("correct card number");
            System.out.println("continue");
            break;
            
        }
        else{
        System.out.println("incorect card number");
        Count++;
        }
       
        }
       
        System.out.println("Enter Expiry Date (MM/YY):");
        int expirydate;
        expirydate = sc.nextInt();
       
         System.out.print("/");   
         
        expirydate = sc.nextInt();
         
        
        
        System.out.println("Enter CVV:");
        // string to check the input
        int count=0;
        while(count<=3){
             int count2=0;
       int cvv = sc.nextInt();
       while(cvv>0){
           cvv/=10;
             count2++; 
       }
       
        if(count2==3){
            System.out.println("correct cvv");
            System.out.println("Payment successful!");
            break;
        }
        else{
        System.out.println("incorect cvv");
        count++;
        }
       
        }
       
            
       }
    
       catch(InputMismatchException e){ 
           System.out.println("Payment failed. Please check your card details.");
       }
      
   }
    public void writeBorrowings() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("borrowings.bin"));
            oos.writeObject(hasbooks);
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
public ArrayList<Book> readBorrowings() {
    ArrayList<Book> books = new ArrayList<>();
    ObjectInputStream ois = null;
    try {
        ois = new ObjectInputStream(new FileInputStream("borrowings.bin"));
        books = (ArrayList<Book>) ois.readObject();
        System.out.println("Objects read from file");
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
    return books;
}
     public void writeCreateOrder() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("createOrder.bin"));
            oos.writeObject(CreateOrder);
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
public ArrayList<Book> readCreateOrder() {
//    ArrayList<Book> books = new ArrayList<>();
    ObjectInputStream ois = null;
    try {
        ois = new ObjectInputStream(new FileInputStream("createOrder.bin"));
        CreateOrder = (ArrayList<Book>) ois.readObject();
        System.out.println("Orderrr read from file");
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
    return CreateOrder;
}
//   public void writeborrowings() throws FileNotFoundException, IOException {
//        FileWriter file = new FileWriter("borrowings.txt");
//        PrintWriter p = new PrintWriter(file);
//        for(Book book:hasbooks){
//         p.println(book.getName() + " " + book.getCategory() + " " + book.getPrice() + " " + book.getQuantity() + " " + book.getRating() + " " + book.getNoOfBorrowings()+" "+book.getBookID());
//        }
//        p.close();
//
//    }
//
//    public void ReadBorrowings() throws FileNotFoundException {
//        File file = new File("borrowings.txt");
//        Scanner sc = new Scanner(file);
//        while (sc.hasNext()) {
//            String Line=sc.next();
//            System.out.println(Line);
//        }
//        
//    }
   
}
    
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

    


