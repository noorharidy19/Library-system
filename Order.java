/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hassan Hatem
 */
public class Order {


     private  ArrayList<Book> Order = new ArrayList<>(); //orders of all sup
    private ArrayList<Book> OrdersFromSupp = new ArrayList<>(); //order of 1 sup

    public ArrayList<Book> getOrder() {
        return Order;
    }

   

    public Order(Admin a) {

    }

    public void addOrderBooks(Supplier supplier, Book book) throws IOException { 

        OrdersFromSupp = supplier.getSup(); 
 
        if (OrdersFromSupp.contains(book)) {
            if (Order.contains(book)) {
                int l = book.getQuantity() + 1; 
                book.setQuantity(l);

            } else if (!Order.contains(book)) {
                Order.add(book);
                System.out.println("book " + book.getName() + " is added succesfully to order list "
                        + "");
            }
   

        }

    }
     public void writeOrders() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Order.bin",true));
            oos.writeObject(Order);
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

   public ArrayList<Book> readOrders() {
//        ArrayList<Book> books = new ArrayList<>();
        ObjectInputStream ois = null;
        
        try {
            ois = new ObjectInputStream(new FileInputStream("Order.bin"));
            Order = (ArrayList<Book>) ois.readObject();
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

        return Order;
    }
}
//     public void writeOrder() throws FileNotFoundException, IOException {
//        FileWriter file = new FileWriter("order.txt");
//        PrintWriter p = new PrintWriter(file);
//        for(Book book:Order){
//         p.println(book.getName() + " " + book.getCategory() + " " + book.getPrice() + " " + book.getQuantity() + " " + book.getRating() + " " + book.getNoOfBorrowings()+" "+book.getBookID());
//        }
//        p.close();
//
//    }
//
//    public void ReadOrder() throws FileNotFoundException {
//        File file = new File("order.txt");
//        Scanner sc = new Scanner(file);
//        while (sc.hasNext()) {
//            String Line=sc.next();
//            System.out.println(Line);
//        }
//        
//    }

