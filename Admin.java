/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;


/**
 *
 * @author Hassan Hatem
 */
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

public class Admin extends User implements Serializable {

    private static ArrayList<Book> bookk = new ArrayList<>();
    private static ArrayList<User> userr = new ArrayList<>();

    public ArrayList<User> getUserr() {
        return userr;
    }

    public ArrayList<Book> getBookk() {
        return bookk;
    }

    public Admin(String name, int ID, int PIN, String username) {
        super(name, ID, PIN, username);

    }
    

    public void add(Book book, Supplier supplier) throws FileNotFoundException, IOException {
        ArrayList<Book> bookkssupplier = supplier.getSup();
        if (bookkssupplier.contains(book)) {
            if (bookk.contains(book)) {
                int l = book.getQuantity() + 1;
                book.setQuantity(l);
////           int numOrders=(supplier.getNoOfOrders()+1);
////           supplier.setNoOfOrders(numOrders);
 System.out.println("book " + book.getName() + " quantity incresed in the Library "
                        + "");

            } else if (!bookk.contains(book)) {
                book.setQuantity(1);
                bookk.add(book);
                System.out.println("book " + book.getName() + " is added succesfully to the Library "
                        + "");
                
            }
        } else {

            System.out.println("Unable to add this book to the library");
        }

//        System.out.println("admin list");
//       for(int i=0;i<bookks.size();i++){
//       System.out.println(bookks.get(i).getName());
    }

    public void Remove(Book book) throws FileNotFoundException {
        if (bookk.contains(book)) {
            bookk.remove(book);
            if(book.getQuantity()>1){
               int l = book.getQuantity() - 1;
                book.setQuantity(l);
            
             System.out.println("book " + book.getName() + " is decresed succesfully to the Library ");
            }
             else if(book.getQuantity()==1){
                  book.setQuantity(0);
                  System.out.println("book " + book.getName() + " is removed succesfully to the Library ");
             }
    
        } else {
            System.out.println("Book not found");
        }

    }
    
    public void Edit(Book book,double x) throws FileNotFoundException {
        for(Book b:bookk){
        if (bookk.contains(book)) {
                    
                    book.setPrice(x);
                    System.out.println("new price "+book.getPrice());

        } else {
            System.out.println("book not found");
        }

    }
    }

    public String List(int x,String name,Category category,double price) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
        switch (x) {
            case 1: //byname
                System.out.println("enter name");
//                String name2 = sc.next();
                for (Book book : bookk) {
                    if (book.getName().equals(name))
                    {
                    System.out.println("book is found");
                    return (book.getName()+" price "+book.getPrice()+" category "+book.getCategory());
                    
                }
                }
                break;
            case 2: //by category
                System.out.println("enter cateory");

//                String categ2 = sc.next();
                for (Book book : bookk) {
                    if (book.getCategory().equals(category)){
                    System.out.println("book is found");
                    return (book.getName()+" price "+book.getPrice()+" category "+book.getCategory());
                    }
                }
                break;
            case 3: //byprice
                System.out.println("enter price");
//                double priceee = sc.nextDouble();
                for (Book book : bookk) {
                    if (book.getPrice() == price){
                   System.out.println("book is found");
                    return(book.getName()+" price "+book.getPrice()+" category "+book.getCategory());
                }
                }
                break;
          
        }
        return null;
    }

    public void add(User user) throws IOException {
       
        if(userr.contains(user)){
            System.out.println("user already exists");
        }
        else{
             userr.add(user);
        }
       
    }

    public void Remove(String user) {
       for(User use:userr){
       if(user.equalsIgnoreCase(use.getName())){
           userr.remove(use);
           break;
       }
               
       }
//        if (userr.contains(user)) {
//            
//            System.out.println(user.getName()+ "removed from system");
//        } else {
//            System.out.println("User not found");
//        }

    
    }
    public void Edit(User u,int x,int id,int pin,String uname) throws FileNotFoundException {
         for (User user : userr) {
        if (userr.contains(user)) {
            
       
            switch (x) {
                case 1://edit name
                    System.out.println("enter new name");
//                    String nameUser = sc.next();
                    user.setUsername(uname);
                    System.out.println("new name is "+user.getUsername());
                    break;
                case 2: //edit ID
                    System.out.println("verify user id:");
                            

//                    int IdUser = sc.nextInt();
                   
                        
                            System.out.println("enter new id:");
//                            int idd=sc.nextInt();
                            user.setID(id);
                            System.out.println("new id is "+user.getID());
                        
                        break;
                    
                case 3: //edit pass
                    System.out.println("enter new pass");
                    
                    user.setPIN(pin);
                     System.out.println("new pin is "+user.getPIN());
                    break;
            }
            }

        }
    }

    public String ListUser(int x,String y,int id,String z) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("search:name press 1");
        System.out.println("seach:ID press 2");
       System.out.println("search:usename press 3");
        switch (x) {
            case 1: //byname
                System.out.println("enter name");
//                String name1 = sc.next();
                for (User user : userr) {
                    if (user.getName().equals(y)){
                    System.out.println("user is found");
                   return user.getName()+" id "+user.getID();
                    
                    }
                }
                break;
            case 2: //byId
                System.out.println("enter id");

//                int ID = sc.nextInt();
                for (User user : userr) {
                    if (user.getID() == id){
                        System.out.println("user is found");
                    return user.getName()+" id "+user.getID();
                    
                    }
                   
                }
                break;

            case 3: //by username
                System.out.println("enter username");
//                String Username = sc.next();
                for (User user : userr) {
                    if (user.getUsername().equals(z)){
                        System.out.println("user is found");
                    return user.getName()+" id "+user.getID();
                     
                    }
                   
                }
                break;
        }
return null;
    }

    public Category getCategoryOfBook(Book book) {
        if (bookk.contains(book)) {
            return (book.getCategory());
        }
            return Category.DEFAULT_CATEGORY;
     }
    
    public String getMostBorrowedBook() {
        int max = 0;
        String s = "";
    
   
       for(Book checkBook:bookk){
           if(max<checkBook.getNoOfBorrowings()){
               max=checkBook.getNoOfBorrowings();
           s=checkBook.getName();
                   } 
               
           }
       String x=s+" with max borrow "+max;
        return x ;
    }
    
   
    
    public String librarianwithmaxborrow() {

        int maxborrow = 0;
        String name = "";
        for (User user : userr) {
            if (user instanceof Librarian) {
                if (maxborrow < ((Librarian) user).getnumberofborrowings()) {
                    maxborrow = ((Librarian) user).getnumberofborrowings();
                    name = ((Librarian) user).getName();
                }
            }
        }
        
       String x= name + " with " + maxborrow + " borrowings";
        return x ;
    }

    public String borrowerwithmaxborrow() {

        int maxborrow = 0;
        String name = "";
        for (User user : userr) {
            if (user instanceof Borrower) {
                if (maxborrow < ((Borrower) user).getnumberofborrowings()) {
                    maxborrow = ((Borrower) user).getnumberofborrowings();
                    name = ((Borrower) user).getName();
                }
            }
        }
       
        String x= name + " with " + maxborrow + " borrowings";
        return x ;

    }

    public String librarianwithmaxrevenue() {

        double revenue = 0;
        String name = "";
        for (User user : userr) {
            if (user instanceof Librarian) {
                if (revenue < ((Librarian) user).getMaxRevenue()) {
                    revenue = ((Librarian) user).getMaxRevenue();
                    name = ((Librarian) user).getName();
                }
            }
        }
        String x= name + " with " + revenue+ " revenue";
        return x ;

    }

    public String borrowerwithmaxrevenue() {

        double revenue = 0;
        String name = "";
        for (User user : userr) {
            if (user instanceof Borrower) {
                if (revenue < ((Borrower) user).getmaxRevenue()) {
                    revenue = ((Borrower) user).getmaxRevenue();
                    name = ((Borrower) user).getName();
                }
            }
        }
        String x= name + " with " + revenue+ " revenue";
        return x;
    }

    public String Supplierwithmaxrevenue() {

        double revenue = 0;
        String name = "";
        for (User user : userr) {
            if (user instanceof Supplier) {
                
                if (revenue < ((Supplier) user).getMaxRevenue()) {

                    revenue = ((Supplier) user).getMaxRevenue();
                    name = ((Supplier) user).getName();
                }
            }
        }
        String x= name + " withmax revnue " + revenue;
        return x;

    }

    public String SupplierWithmaxOrders() {

        int maxborrow = 0;
        String name = "";
        for (User user : userr) {
            if (user instanceof Supplier) {
                if (maxborrow < ((Supplier) user).getNoOfOrders()) {
                    maxborrow = ((Supplier) user).getNoOfOrders();
                    name = ((Supplier) user).getName();
                }
            }
        }
        String x= name + " with maxorders " + maxborrow;
        return x;

    }

    public int getNumberOfBorrows() {
       
        int total = 0;
        for (int i = 0; i < bookk.size(); i++) {
            total += bookk.get(i).getNoOfBorrowings();

        }
        return total;
    }

    public HashMap<Librarian, Integer> ViewNoOfBorrowingsPerEachLibraian() {
        HashMap<Librarian, Integer> L = new HashMap<>();
        for (User user : userr) {
            if (user instanceof Librarian) {
                L.put(((Librarian) user), ((Librarian) user).getnumberofborrowings());
            }
        }
        return L;

    }

//    public String NoOfBorrowingsPerEachLibrarian() {
//        HashMap<Librarian, Integer> map = ViewNoOfBorrowingsPerEachLibraian();
//        String x="";
//        for (Librarian librarian : map.keySet()) {
////            System.out.println("Librarian name: " + librarian.getName() + " Libraiab ID: " + librarian.getID() + ", Number of Borrowings: " + map.get(librarian));
//        
//        x="Librarian name: " + librarian.getName() + " Libraiab ID: " + librarian.getID() + ", Number of Borrowings: " + map.get(librarian);
//        }
//        return x;
//    }

    public HashMap<Borrower, Integer> ViewNoOfBorrowingsPerEachBorrower() {
        HashMap<Borrower, Integer> L = new HashMap<>();
        for (User user : userr) {
            if (user instanceof Borrower) {
                L.put(((Borrower) user), ((Borrower) user).getnumberofborrowings());
            }
        }
        return L;

    }

//    public String NoOfBorrowingsPerEachBorrower() {
//        HashMap<Borrower, Integer> map = ViewNoOfBorrowingsPerEachBorrower();
//        String x="";
//        for (Borrower borrower : map.keySet()) {
////            System.out.println("Borrower name: " + borrower.getName() + " Borrower ID: " + borrower.getID() + ", Number of Borrowings: " + map.get(borrower));
//        
//        x="Borrower name: " + borrower.getName() + " Borrower ID: " + borrower.getID() + ", Number of Borrowings: " + map.get(borrower);
//        
//        }
//        return x;
//    }

    public HashMap<Supplier, Integer> ViewNoOfOrdersPerEachSupplier() {
        HashMap<Supplier, Integer> L = new HashMap<>();
        for (User user : userr) {
            if (user instanceof Supplier) {
                L.put(((Supplier) user), ((Supplier) user).getNoOfOrders());
            }
        }
        return L;

    }

//    public String NoOfOrdersPerEachSupplier() {
//        String x="";
//        HashMap<Supplier, Integer> map = ViewNoOfOrdersPerEachSupplier();
//        for (Supplier supplier : map.keySet()) {
////            System.out.println("Supplier name: " + supplier.getName() + " Supplier ID: " + supplier.getID() + ", Number of orders " + map.get(supplier));
//        
//        x="Supplier name: " + supplier.getName() + " Supplier ID: " + supplier.getID() + ", Number of orders " + map.get(supplier);
//        }
//                return x;
//    }
//     public void writeBooks() throws FileNotFoundException, IOException {
//        
//        FileWriter file = new FileWriter("Hridy.txt");
//        PrintWriter p = new PrintWriter(file);
//        for(Book book:bookk){
//            p.println(book.getName() + " " + book.getCategory() + " " + book.getPrice() + " " + book.getQuantity() + " " + book.getRating() + " " + book.getNoOfBorrowings()+" "+book.getBookID());
//        }
//        p.close();
//
//    }

        public void writeBookss() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("BOOK.bin"));
            oos.writeObject(bookk);
            System.out.println(bookk);
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
            ois = new ObjectInputStream(new FileInputStream("BOOK.bin"));
            bookk = (ArrayList<Book>) ois.readObject();
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
        return bookk;
    }
        public void writeUserss() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("USER.bin"));
            oos.writeObject(userr);
            
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

  public ArrayList<User> readUserss() {
//        ArrayList<User> users = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("USER.bin"));
            userr = (ArrayList<User>) ois.readObject();
            System.out.println("Objects read from file");
//            System.out.println(userr);
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
        return userr;
    }
//    public void writeUsers() throws FileNotFoundException, IOException {
//        FileWriter file = new FileWriter("x.txt");
//        PrintWriter p = new PrintWriter(file);
//        for(User user:userr){
//        p.println(user.getName() + " " + user.getID() + " " + user.getPIN() + " " + user.getUsername());
//        }
//        p.close();
//
//    }
//
////    public void ReadBooks() throws FileNotFoundException {
////        File file = new File("hridy.txt");
////        Scanner sc = new Scanner(file);
////        while (sc.hasNext()) {
////            String Line=sc.next();
////            System.out.println(Line);
////        }
////        
////    }
//     public void ReadUsers() throws FileNotFoundException {
//        File file = new File("USERS.txt");
//        Scanner sc = new Scanner(file);
//        while (sc.hasNext()) {
//            String Line=sc.next();
//            System.out.println(Line);
//        }
//        
//    }

}
