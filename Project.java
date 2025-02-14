/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

/**
 *
 * @author Hassan Hatem
 */
//import java.util.Scanner;
//import java.io.PrintWriter;
//import java.io.File;
import javafx.scene.paint.Color;
import java.io.File;
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.exit;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//import java.io.IOException;
//import java.util.ArrayList;
public class Project extends Application {
      private int count = 0;
      private int count1 = 0;
      private int count2 = 0;
      private int count3 = 0;
      private int count4 = 0;
     private int countMax = 5;
  @Override
    public void start(Stage Pstage) throws Exception {
        
        Admin a1=new Admin("Amrr",1517,1234,"amr");
        Supplier s2=new Supplier( "Mostafa", 2269, 4489, "mostafa");
        Supplier s1=new Supplier( "Noor", 2387, 5789, "noor");
        Librarian l1=new Librarian( "Bassel", 3211, 1249, "bassel@Lib3211",a1) ;
        Librarian l2=new Librarian( "Serag", 3577, 4098, "serag",a1) ;
        Librarian l3=new Librarian( "Sara", 3933, 8755, "Sara",a1) ;
        Borrower b1=new Borrower("Haridy",4577,2247,"haridy",a1);
        Borrower b2=new Borrower("Nourhan",4168,1788,"nourhan@borrLib@4168",a1);
        Borrower b3=new Borrower("Ahmed",4694,9699,"ahmed@borrLib4964",a1);
        Book book1=new Book("harry potter",Category.SC_FIC,150,4,0,0,12);
        Book book2=new Book("the notebook",Category.ROMANCE,150,4,0,0,15);
        Book book3=new Book("Beauty and the beast",Category.ROMANCE,170,3,0,0,7);
        Book book4=new Book("Marvel",Category.SC_FIC,170,3,0,0,5);
        Book book5=new Book("nader foada",Category.HORROR,100,3,0,0,8);
        Order or=new Order(a1);
        
        //ADDING ALREADY EXSISTING USERS IN THE SYSTEM
//        a1.add(a1);
//        a1.add(s1);
//        a1.add(s2);
//        a1.add(l1);
//        a1.add(l2);
//        a1.add(l3);
//        a1.add(b1);
//        a1.add(b2);
//        a1.add(b3);
////        s1.addSuppBooks(book1, a1);
//        s1.addSuppBooks(book2, a1);
//        s1.addSuppBooks(book3, a1);
////        s1.addSuppBooks(book5, a1);
//        for(Book book:s1.getSup()){
//        or.addOrderBooks(s1, book);
//        }
//        
//        or.writeOrders();
//        s1.writeBookss();
        s1.setNoOfOrders((s1.getNoOfOrders()+1));
        System.out.println(s1.getNoOfOrders());
        a1.add(book1,s1);
        a1.add(book2,s1);
       
        a1.add(book3,s1);
//        
//        a1.Remove(book3);
b1.CreateOrder(book1);
b1.CreateOrder(book2);
//    
//     l1.CreateBorrowings(book1, b1);
////     l2.CreateBorrowings(book2, b1);
////     l3.CancelBorrowings(book4, b3);
//       
////    a1.writeBookss();
//   a1.writeUserss();

    ArrayList<Book> bk=a1.readBookss();
    ArrayList<Book> sp=or.readOrders();
    ArrayList<Book> spp=s1.readBookss();
    ArrayList<User> usr=a1.readUserss();
    ArrayList<Book>borrowerOrder=b1.getCreateOrder();
//     a1.writeUserss();

      for(User b:usr){
      System.out.println(b.getName());
      }
      for(Book b:bk){
      System.out.println(b.getName());
      }
    ArrayList<Book>borrowerOrderr=(b1.getHasbooks());
    
    Button bt1=new Button("Login");
    Button bt2=new Button("Signup");
    Label label=new Label("welcome to the library");
//    label.setStyle("-fx-background-color: BURLYWOOD ");
    VBox v=new VBox();
    v.getChildren().addAll(label,bt1,bt2);
     File file1 = new File("C:/Users/Hassan Hatem/Documents/NetBeansProjects/Project/LIBjpg.jpg");
        String imageUrll = file1.toURI().toString();
        Image image1 = new Image(imageUrll);
        ImageView iv2 = new ImageView(image1);
    iv2.setFitHeight(300);   iv2.setFitWidth(500);
     StackPane rott=new StackPane(iv2,v);
     Scene scenee=new Scene(rott);
     v.setAlignment(Pos.CENTER);
     v.setPadding(new Insets(10));
     v.setSpacing(10);
     label.setTextFill(Color.WHITE);
     label.setStyle("-fx-font-weight: bold;");
    label.setFont(new Font(30));
   
     Pstage.setScene(scenee);
     Pstage.setTitle("LIBRARY SYSTEM");
     Pstage.setResizable(false);
     Pstage.show();
    bt2.setOnAction(e->{
           File file = new File("C:/Users/Hassan Hatem/Documents/NetBeansProjects/Project/LIBjpg.jpg");
        String imageUrl = file.toURI().toString();
        Image image = new Image(imageUrl);
        ImageView iv = new ImageView(image);
    iv.setFitHeight(300);   iv.setFitWidth(500);
    StackPane rot=new StackPane();
         GridPane root=new GridPane();
     Label lbl1=new Label("Name");
     Label lbl2=new Label("ID");
     Label lbl3=new Label("PIN");
     Label lbl4=new Label("Username");
     lbl1.setStyle("-fx-font-weight: bold;");
     lbl2.setStyle("-fx-font-weight: bold;");
     lbl3.setStyle("-fx-font-weight: bold;");
     lbl4.setStyle("-fx-font-weight: bold;");
     lbl1.setTextFill(Color.WHITE);
     lbl2.setTextFill(Color.WHITE);
     lbl3.setTextFill(Color.WHITE);
     lbl4.setTextFill(Color.WHITE);
//     l.setTextFill(Color.WHITE);
//    l.setFont(new Font(20));
    lbl4.setFont(new Font(25));
    lbl3.setFont(new Font(25));
    lbl1.setFont(new Font(25));
    lbl2.setFont(new Font(25));
     TextField name=new TextField();
     TextField ID=new TextField();
     TextField pass=new TextField();
     TextField useername=new TextField();
     Button bt=new Button("Register");
     RadioButton rb1 = new RadioButton("Borrower");
    RadioButton rb2 = new RadioButton("Librarian");
    RadioButton rb3 = new RadioButton("Supplier");
    rb1.setTextFill(Color.WHITE);
     rb2.setTextFill(Color.WHITE);
     rb3.setTextFill(Color.WHITE);
    HBox i = new HBox(10,rb1,rb2,rb3);
    i.setAlignment(Pos.BOTTOM_LEFT);
    i.setPadding(new Insets(10));
    ToggleGroup tg = new ToggleGroup();
    rb1.setToggleGroup(tg);
    rb2.setToggleGroup(tg);
    rb3.setToggleGroup(tg);
     root.add(lbl1,0,0);
     root.add(name,1,0);
     root.add(lbl2,0,1);
     root.add(ID,1,1);
     root.add(lbl3,0,2);
     root.add(pass,1,2);
     root.add(lbl4,0,3);
     root.add(useername,1,3);
     root.add(i,0 , 4);
     root.add(bt,1,5);
     root.setAlignment(Pos.CENTER);
     root.setPadding(new Insets(10));
     root.setHgap(10);
     root.setVgap(10);
     rot.getChildren().addAll(iv,root);
     Scene scene=new Scene(rot,500,300);
     Stage stage=new Stage();
     stage.setScene(scene);
     stage.setTitle("Registration");
     stage.setResizable(false);
     stage.show();
     bt.setOnAction(a->{
if(name.getText().isEmpty()||ID.getText().isEmpty()||useername.getText().isEmpty()||pass.getText().isEmpty()){
    Alert ad = new Alert(Alert.AlertType.ERROR);
    ad.setContentText("PLEASE COMPLETE YOUR INFORMAION");
    ad.setHeaderText(null);
    ad.show();
}


else 
{
    int value= Integer.parseInt(ID.getText());
    int pin= Integer.parseInt(pass.getText());
    boolean isTrue=a1.SignUp(name.getText(),value,pin,useername.getText(), a1);
    if (!isTrue) {
    Alert ad = new Alert(Alert.AlertType.ERROR);
    ad.setContentText("CANNOT ENTER THIS ID");
    ad.setHeaderText(null);
    ad.show();
} 
    else {
    
    try { 
        RadioButton rb;
    rb = (RadioButton) tg.getSelectedToggle();
        if(rb.getText().equals("Borrower")){
        Borrower b=new Borrower(name.getText(),value,pin,useername.getText(),a1);
        a1.add(b);
        a1.writeUserss();
        }
        else if(rb.getText().equals("Librarian")){
        Librarian L=new Librarian(name.getText(),value,pin,useername.getText(),a1);
        a1.add(L);
        a1.writeUserss();
        }
        else
        {
        Supplier s=new Supplier( name.getText(),value,pin,useername.getText());
        a1.add(s);
        a1.writeUserss();
        }
        Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText("Thank you for registration");
        ad.setHeaderText(null);
        ad.show();
    } catch (IOException ex) {
        Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
           });
             
     
    });
    
    
    
    bt1.setOnAction(q->{
    
        File file = new File("C:/Users/Hassan Hatem/Documents/NetBeansProjects/Project/LIBjpg.jpg");
        String imageUrl = file.toURI().toString();
        Image image = new Image(imageUrl);
        ImageView iv = new ImageView(image);
    iv.setFitHeight(300);   iv.setFitWidth(500);
    StackPane rot=new StackPane();
         GridPane root=new GridPane();
     Label lbl=new Label("ENTER YOUR INFORMATION");
     Label lbl4=new Label("PIN");
     Label lbl3=new Label("Username");
     lbl.setStyle("-fx-font-weight: bold;");
     lbl4.setStyle("-fx-font-weight: bold;");
     lbl3.setStyle("-fx-font-weight: bold;");
     lbl3.setTextFill(Color.WHITE);
     lbl4.setTextFill(Color.WHITE);
     lbl.setTextFill(Color.WHITE);
     lbl4.setFont(new Font(30));
     lbl.setFont(new Font(20));
     lbl3.setFont(new Font(30));
     TextField pass=new TextField();
     TextField useername=new TextField();
     Button btt=new Button("Register");
     root.add(lbl,0,0);
     root.add(lbl3,0,1);
     root.add(useername,1,1);
     root.add(lbl4,0,2);
     root.add(pass,1,2);
     root.add(btt,1,3);
     root.setAlignment(Pos.CENTER);
     root.setPadding(new Insets(10));
     root.setHgap(10);
     root.setVgap(10);
     rot.getChildren().addAll(iv,root);
     Scene scene=new Scene(rot,500,300);
     Stage stage=new Stage();
     stage.setScene(scene);
     stage.setTitle("Login");
     stage.setResizable(false);
     stage.show();
     btt.setOnAction(a->{
if(useername.getText().isEmpty()||pass.getText().isEmpty()){
    Alert ad = new Alert(Alert.AlertType.ERROR);
    ad.setContentText("PLEASE COMPLETE YOUR INFORMAION");
    ad.setHeaderText(null);
    ad.show();
}
else{
int value= Integer.parseInt(pass.getText());
User Logged=a1.Login(value,useername.getText(),a1);
//User LoggedInBorrower=Logged;
// if(Logged instanceof Borrower){
//     LoggedInBorrower=((Borrower)Logged); 
// }
 if (Logged==null) {
    Alert ad = new Alert(Alert.AlertType.ERROR);
    ad.setContentText("Invalid information");
    ad.setHeaderText(null);
    ad.show();
} else {      
    if(Logged instanceof Admin){
         File fileee = new File("C:/Users/Hassan Hatem/Documents/NetBeansProjects/Project/LIBjpg.jpg");
        String imageUrlll = fileee.toURI().toString();
        Image imagee = new Image(imageUrlll);
        ImageView ivv = new ImageView(imagee);
    ivv.setFitHeight(300);   ivv.setFitWidth(500);
       Stage AdminStage=new Stage(); 
      ObservableList<String> oo = FXCollections.observableArrayList(
      "ADD BOOKS","REMOVE BOOKS","EDIT BOOKS","SEARCH BOOKS","ADD USER","REMOVE USER",
              "EDIT USER","SEARCH USER","GET NUMBER OF BORROWES","GET BOOK CATEGORIES","GET MOST BORROWED BOOK","LIBRARIAN WITH MAX BORROWS","BORROWER WITH MAX BORROWS",
      "LIBRARIAN WITH MAX REVENUE","BORROWER WITH MAX REVENUE","SUPPLIER WITH MAX REVENUE","SUPPLIER WITH MAX NUMBER OF ORDERS",
      "VIEW NUMBER OF BORROWINGS PER EACH LIBRARIAN","VIEW NUMBER OF BORROWINGS PER EACH BORROWER","VIEW NUMBER OF ORDERS PER EACH SUPPLIER");
    ComboBox cbo = new ComboBox(oo);
    cbo.setValue("Select");
    Button Adminbt=new Button("Next");
    Label admin=new Label("Welcome");
    admin.setStyle("-fx-font-weight: bold;");
    VBox box=new VBox(10,admin,cbo,Adminbt);
    box.setAlignment(Pos.CENTER);
     admin.setTextFill(Color.WHITE);
     admin.setFont(new Font(20));
    StackPane lll=new StackPane(ivv,box);
    Scene ss=new Scene(lll,500,300);
    AdminStage.setScene(ss);
    AdminStage.show();
    Adminbt.setOnAction(eh->{
         String AdminChoice = (String) cbo.getValue();
    if(AdminChoice.equals("ADD BOOKS")){
          ObservableList<String> bookss = FXCollections.observableArrayList();
         for(Book B:sp){
        bookss.add(B.getName());
         }
         ComboBox u=new ComboBox(bookss);
       Button Adminbt2=new Button("Add");
       TextField f=new TextField();
       VBox box1=new VBox(u,Adminbt2);
       box1.setAlignment(Pos.CENTER);
       box1.setSpacing(10);
       StackPane d=new StackPane(ivv,box1);
        Scene AddBook=new Scene(d);
        AdminStage.setScene(AddBook);
    AdminStage.show();
    Adminbt2.setOnAction(s->{
        String Choice = (String) u.getValue();
        System.out.println("choice"+Choice);
        Book b=null;
         for(Book B:sp){
//             System.out.println("book names"+B.getName());
             if(Choice.equalsIgnoreCase(B.getName())){
                b=B; 
             }
         }
            try {
                ((Admin)Logged).add(b,s1);
                ((Admin)Logged).writeBookss();
                  Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText("book "+ b.getName() +" added succsesfully");
        ad.setHeaderText(null);
        ad.show();
        
            } catch (IOException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            }
         
  
    
         
    
    });
    }
        if(AdminChoice.equals("SEARCH BOOKS")){
        ObservableList<String> us = FXCollections.observableArrayList("CATEOGORY","ID","NAME","PRICE");
         ComboBox u=new ComboBox(us);
        Button Adminbt5=new Button("LIST");
       TextField f=new TextField();
       VBox box1=new VBox(u,Adminbt5);
       box1.setAlignment(Pos.CENTER);
       box1.setSpacing(10);
       StackPane d=new StackPane(ivv,box1);
        Scene AddBook=new Scene(d);
        AdminStage.setScene(AddBook);
    AdminStage.show();
    Adminbt5.setOnAction(s->{
        String Choicee = (String) u.getValue();
        Button Adminbt1=new Button("Confirm");
       TextField fF=new TextField();
       VBox box12=new VBox(fF,Adminbt1);
       box12.setAlignment(Pos.CENTER);
       box12.setSpacing(10);
       StackPane dD=new StackPane(ivv,box12);
        Scene AddBookk=new Scene(dD);
        AdminStage.setScene(AddBookk);
    AdminStage.show();
    Adminbt1.setOnAction(r->{
         if(Choicee.equals("NAME")){
            try {
                String U=((Admin)Logged).List(1, fF.getText(), null, 0);
                Alert ssS=new Alert(Alert.AlertType.INFORMATION);
                ssS.setContentText(U);
                ssS.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         else if(Choicee.equals("PRICE")){
             int price=Integer.parseInt(fF.getText());
           try {
                String U=((Admin)Logged).List(3, "0", null, price);
                Alert ssS=new Alert(Alert.AlertType.INFORMATION);
                ssS.setContentText(U);
                ssS.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            }  
         }
       else{  
        Category[]c=Category.values();
    ObservableList<Category> cat = FXCollections.observableArrayList();
    for(Category cat1:c){
    cat.add(cat1);
    }
    ComboBox categories = new ComboBox(cat);
        Button Adminbtt=new Button("Confirm");
       VBox box123=new VBox(categories,Adminbtt);
       box123.setAlignment(Pos.CENTER);
       box123.setSpacing(10);
       StackPane dDD=new StackPane(ivv,box123);
        Scene AddBookkk=new Scene(dDD);
        AdminStage.setScene(AddBookkk);
        AdminStage.show();
    Adminbtt.setOnAction(i->{
        Category e=(Category)categories.getValue();
                try {
                  
               String U=((Admin)Logged).List(2, "0", e, 0);
               Alert ssS=new Alert(Alert.AlertType.INFORMATION);
                ssS.setContentText(U);
                ssS.show();
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
             }  
    });
            }
    });
   
    });
        }
            
    if(AdminChoice.equals("SEARCH USER")){
        ObservableList<String> us = FXCollections.observableArrayList("USERNAME","ID","NAME");
         ComboBox u=new ComboBox(us);
        Button Adminbt5=new Button("LIST");
       TextField f=new TextField();
       VBox box1=new VBox(u,Adminbt5);
       box1.setAlignment(Pos.CENTER);
       box1.setSpacing(10);
       StackPane d=new StackPane(ivv,box1);
        Scene AddBook=new Scene(d);
        AdminStage.setScene(AddBook);
    AdminStage.show();
    Adminbt5.setOnAction(s->{
        String Choicee = (String) u.getValue();
        Button Adminbt1=new Button("Confirm");
       TextField fF=new TextField();
       VBox box12=new VBox(fF,Adminbt1);
       box12.setAlignment(Pos.CENTER);
       box12.setSpacing(10);
       StackPane dD=new StackPane(ivv,box12);
        Scene AddBookk=new Scene(dD);
        AdminStage.setScene(AddBookk);
    AdminStage.show();
    Adminbt1.setOnAction(r->{
         if(Choicee.equals("NAME")){
            try {
                String U=((Admin)Logged).ListUser(1, fF.getText(), 0, "0");
                Alert ssS=new Alert(Alert.AlertType.INFORMATION);
                ssS.setContentText(U);
                ssS.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
            else if(Choicee.equals("USERNAME")){
               
             try {
               String  U = ((Admin)Logged).ListUser(3, "0", 0, fF.getText());
               Alert ssS=new Alert(Alert.AlertType.INFORMATION);
                ssS.setContentText(U);
                ssS.show();
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
            else{
              try {
                  int id=Integer.parseInt(fF.getText());
               String  U = ((Admin)Logged).ListUser(2, "0", id, "0");
               Alert ssS=new Alert(Alert.AlertType.INFORMATION);
                ssS.setContentText(U);
                ssS.show();
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
             }  
            
    }
    });
   
    });
    }
    else  if(AdminChoice.equals("EDIT BOOKS")){
//        ObservableList<String> us = FXCollections.observableArrayList("USERNAME","ID","PIN");
//         ComboBox u=new ComboBox(us);
        Button Adminbt5=new Button("EDIT");
       TextField f=new TextField();
      TextField ff=new TextField();
       VBox box1=new VBox(ff,f,Adminbt5);
       box1.setAlignment(Pos.CENTER);
       box1.setSpacing(10);
       StackPane d=new StackPane(ivv,box1);
        Scene AddBook=new Scene(d);
        AdminStage.setScene(AddBook);
        AdminStage.show();
       
        
    
    Adminbt5.setOnAction(s->{
         double x=Double.parseDouble(f.getText());
        for(Book b:bk){
            if(b.getName().equals(ff.getText())){
                try {
                    ((Admin)Logged).Edit(b,x );
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
                ((Admin)Logged).writeUserss();
                Alert ssS=new Alert(Alert.AlertType.INFORMATION);
                ssS.setContentText("done");
                ssS.show();
                break;
            }
        }
       
                     
    
    });
    }
    else if(AdminChoice.equals("EDIT USER")){
        ObservableList<String> us = FXCollections.observableArrayList("USERNAME","ID","PIN");
         ComboBox u=new ComboBox(us);
        Button Adminbt5=new Button("EDIT");
       TextField f=new TextField();
     
       VBox box1=new VBox(f,u,Adminbt5);
       box1.setAlignment(Pos.CENTER);
       box1.setSpacing(10);
       StackPane d=new StackPane(ivv,box1);
        Scene AddBook=new Scene(d);
        AdminStage.setScene(AddBook);
        AdminStage.show();
       
        
    
    Adminbt5.setOnAction(s->{
         String x=f.getText();
        for(User U:usr){
            if(U.getName().equals(x)){
        String Choicee = (String) u.getValue();
        Button Adminbt1=new Button("Confirm");
       TextField fF=new TextField();
       VBox box12=new VBox(fF,Adminbt1);
       box12.setAlignment(Pos.CENTER);
       box12.setSpacing(10);
       StackPane dD=new StackPane(ivv,box12);
        Scene AddBookk=new Scene(dD);
        AdminStage.setScene(AddBookk);
    AdminStage.show();
    
    Adminbt1.setOnAction(r->{
         if(Choicee.equals("USERNAME")){
            try {
                ((Admin)Logged).Edit(U,1, 0, 0,fF.getText() );
                ((Admin)Logged).writeUserss();
//                ((Admin)Logged).readUserss();
                Alert ssS=new Alert(Alert.AlertType.INFORMATION);
                ssS.setContentText("done");
                ssS.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
            else if(Choicee.equals("ID")){
               
             try {
                 int id=Integer.parseInt(fF.getText());
               ((Admin)Logged).Edit(U,2, id, 0,"0");
                ((Admin)Logged).writeUserss();
//                ((Admin)Logged).readUserss();
               Alert ssS=new Alert(Alert.AlertType.INFORMATION);
                ssS.setContentText("done");
                ssS.show();
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
            else{
                int pin=Integer.parseInt(fF.getText());
             try {
                 ((Admin)Logged).Edit(U,3, 0, pin,"0");
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
             }
                ((Admin)Logged).writeUserss();
                ((Admin)Logged).readUserss();
                Alert ssS=new Alert(Alert.AlertType.INFORMATION);
                ssS.setContentText("done");
                ssS.show();
            }
    
    });
            }
        }
    
    });
    }
     
     if(AdminChoice.equals("ADD USER")){
         
          ObservableList<String> us = FXCollections.observableArrayList();
         for(User U:usr){
        us.add(U.getName());
         }
         ComboBox u=new ComboBox(us);
       Button Adminbt5=new Button("Add");
       TextField f=new TextField();
       VBox box1=new VBox(u,Adminbt5);
       box1.setAlignment(Pos.CENTER);
       box1.setSpacing(10);
       StackPane d=new StackPane(ivv,box1);
        Scene AddBook=new Scene(d);
        AdminStage.setScene(AddBook);
    AdminStage.show();
    Adminbt5.setOnAction(s->{
        String Choice = (String) u.getValue();
         for(User U:usr){
             if(Choice.equals(U.getName())){  
            try {
                ((Admin)Logged).add(U);
                  Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText("USER "+ U.getName() +" added succsesfully");
        ad.setHeaderText(null);
        ad.show();
        break;
            } catch (IOException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
  
    
         }
    
    });
    }
    
    if(AdminChoice.equals("REMOVE BOOKS")){
//        a1.readBookss();
//        ArrayList<Book> bk=a1.readBookss();
          ObservableList<String> bok = FXCollections.observableArrayList();
         for(Book B:bk){
        bok.add(B.getName());
         }
         ComboBox u=new ComboBox(bok);
       Button Adminbt4=new Button("Remove");
       TextField f=new TextField();
       VBox box1=new VBox(u,Adminbt4);
       box1.setAlignment(Pos.CENTER);
       box1.setSpacing(10);
       StackPane d=new StackPane(ivv,box1);
        Scene AddBook=new Scene(d);
        AdminStage.setScene(AddBook);
    AdminStage.show();
    Adminbt4.setOnAction(s->{
        String Choice = (String) u.getValue();
         for(Book B:bk){
             if(Choice.equals(B.getName())){ 
                 try {
                     ((Admin)Logged).Remove(B);
                     ((Admin)Logged).writeBookss();
                 } catch (FileNotFoundException ex) {
                     Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 Alert at = new Alert(Alert.AlertType.INFORMATION);
                 at.setContentText("Book"+ B.getName() +" removed succsesfully");
                 at.setHeaderText(null);
                 at.show();
                 break;
                 
         }
             
  
         }
//           ArrayLbk = a1.readBookss();
//                bok.clear();
//                for (Book updatedBook : bk) {
//                    bok.add(updatedBook.getName());
//                }
//                break;
    
    
    });
    }
    else if(AdminChoice.equals("REMOVE USER")){
//        ArrayList<User> usr=a1.readUserss();
          ObservableList<String> us = FXCollections.observableArrayList();
         for(User U:usr){
        us.add(U.getName());
         }
         ComboBox u=new ComboBox(us);
       Button Adminbt4=new Button("Remove");
       TextField f=new TextField();
       VBox box1=new VBox(u,Adminbt4);
       box1.setAlignment(Pos.CENTER);
       box1.setSpacing(10);
       StackPane d=new StackPane(ivv,box1);
        Scene AddBook=new Scene(d);
        AdminStage.setScene(AddBook);
    AdminStage.show();
    Adminbt4.setOnAction(s->{
        String Choice = (String) u.getValue();
         for(User U:usr){
             if(Choice.equals(U.getName())){ 
                 System.out.println(U.getName());
                 ((Admin)Logged).Remove(Choice);
                 ((Admin)Logged).writeUserss();
                 Alert at = new Alert(Alert.AlertType.INFORMATION);
                 at.setContentText("User"+ U.getName() +" removed succsesfully");
                 at.setHeaderText(null);
                 at.show();
                 break;
         }
  
         }
    
    
    });
    }
    else if(AdminChoice.equals("GET MOST BORROWED BOOK")){
       String MostBorrowed=a1.getMostBorrowedBook();
        Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText(MostBorrowed);
        ad.setHeaderText("Most borrowed book");
        ad.show();
    }
    else if(AdminChoice.equals("GET BOOK CATEGORIES")){
          Label ch=new Label("Enter book name");
          ch.setStyle("-fx-font-weight: bold;");
    ch.setTextFill(Color.WHITE);
     ch.setFont(new Font(20));
       TextField f=new TextField();
       Button btx=new Button("Enter");
       HBox box1=new HBox(ch,f,btx);
       box1.setAlignment(Pos.CENTER);
       box1.setSpacing(10);
       StackPane Pane=new StackPane(ivv,box1);
       Scene n=new Scene(Pane);
       AdminStage.setScene(n);
       AdminStage.show();
       btx.setOnAction(t->{
           ArrayList<Book> libb=a1.getBookk();
           Category resultCategory =null;
           for(Book bb:libb){
           if(f.getText().equalsIgnoreCase(bb.getName())){
                resultCategory = a1.getCategoryOfBook(bb);
        break;
           }
               }
           if(resultCategory!=null){
               Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText(resultCategory.toString());
        ad.setHeaderText("The Category of this Book");
        ad.show();
           }
           else{
                      Alert ad = new Alert(Alert.AlertType.ERROR);
        ad.setContentText("Invalid book name");
        ad.setHeaderText(null);
        ad.show(); 
           }
       });
       

        
    }
     else if(AdminChoice.equals("LIBRARIAN WITH MAX BORROWS")){
    
        String Lib=a1.librarianwithmaxborrow();
        Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText(Lib);
        ad.setHeaderText("Librarian with max borrows");
        ad.show();
    
     }
    
     else if(AdminChoice.equals("BORROWER WITH MAX BORROWS")){
    
        String bor=a1.borrowerwithmaxborrow();
        Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText(bor);
        ad.setHeaderText("Borrowe with max borrows");
        ad.show();
    
     }
     else if(AdminChoice.equals("SUPPLIER WITH MAX NUMBER OF ORDERS")){
    
        String Supp =a1.SupplierWithmaxOrders();
        Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText(Supp);
        ad.setHeaderText("Supplier with max number of orders");
        ad.show();
    
     }
    else if(AdminChoice.equals("LIBRARIAN WITH MAX REVENUE")){
    
        String Lib=a1.librarianwithmaxrevenue();
        Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText(Lib);
        ad.setHeaderText("Librarian with max revenue");
        ad.show();
    
     }
    
     else if(AdminChoice.equals("BORROWER WITH MAX REVENUE")){
    
        String bor=a1.borrowerwithmaxrevenue();
        Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText(bor);
        ad.setHeaderText("Borrowe with max REVENUE");
        ad.show();
    
     }
     else if(AdminChoice.equals("SUPPLIER WITH MAX REVENUE")){
    
        String Supp =a1.Supplierwithmaxrevenue();
        Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText(Supp);
        ad.setHeaderText("Supplier with max revenue");
        ad.show();
    
     }
else if (AdminChoice.equals("VIEW NUMBER OF BORROWINGS PER EACH LIBRARIAN")) {
    HashMap<Librarian, Integer> borrowingsPerLibrarian = a1.ViewNoOfBorrowingsPerEachLibraian();
    StringBuilder result = new StringBuilder();

    for (Map.Entry<Librarian, Integer> entry : borrowingsPerLibrarian.entrySet()) {
        Librarian librarian = entry.getKey();
        int numberOfBorrowings = entry.getValue();

        // Append information to the StringBuilder
        result.append("Librarian name: ").append(librarian.getName())
              .append(", Librarian ID: ").append(librarian.getID())
              .append(", Number of Borrowings: ").append(numberOfBorrowings)
              .append("\n"); // Add newline for better readability
    }

    Alert ad = new Alert(Alert.AlertType.INFORMATION);
    ad.setContentText(result.toString());
    ad.setHeaderText("NUMBER OF BORROWINGS PER EACH LIBRARIAN");
    ad.show();
}

else if (AdminChoice.equals("VIEW NUMBER OF BORROWINGS PER EACH BORROWER")) {
    HashMap<Borrower, Integer> borrowingsPerBorrower = a1.ViewNoOfBorrowingsPerEachBorrower();
    StringBuilder result = new StringBuilder();

    for (Map.Entry<Borrower, Integer> entry : borrowingsPerBorrower.entrySet()) {
        Borrower borrower = entry.getKey();
        int numberOfBorrowings = entry.getValue();

        // Append information to the StringBuilder
        result.append("Borrower name: ").append(borrower.getName())
              .append(", Borrower ID: ").append(borrower.getID())
              .append(", Number of Borrowings: ").append(numberOfBorrowings)
              .append("\n"); // Add newline for better readability
    }

    Alert ad = new Alert(Alert.AlertType.INFORMATION);
    ad.setContentText(result.toString());
    ad.setHeaderText("NUMBER OF BORROWINGS PER EACH BORROWER");
    ad.show();
}
   else if (AdminChoice.equals("VIEW NUMBER OF ORDERS PER EACH SUPPLIER")) {
    HashMap<Supplier, Integer> ordersPerSupplier = a1.ViewNoOfOrdersPerEachSupplier();
    StringBuilder result = new StringBuilder();

    for (Map.Entry<Supplier, Integer> entry : ordersPerSupplier.entrySet()) {
        Supplier supplier = entry.getKey();
        int numberOfOrders = entry.getValue();

        // Append information to the StringBuilder
        result.append("Supplier name: ").append(supplier.getName())
              .append(", Supplier ID: ").append(supplier.getID())
              .append(", Number of Orders: ").append(numberOfOrders)
              .append("\n"); // Add newline for better readability
    }

    Alert ad = new Alert(Alert.AlertType.INFORMATION);
    ad.setContentText(result.toString());
    ad.setHeaderText("NUMBER OF ORDERS PER EACH SUPPLIER");
    ad.show();
}
    else if (AdminChoice.equals("GET NUMBER OF BORROWES")) {
    
    Alert ad = new Alert(Alert.AlertType.INFORMATION);
    int numberOfBorrows = a1.getNumberOfBorrows();
    String numberOfBorrowsAsString = String.valueOf(numberOfBorrows);
    ad.setContentText(numberOfBorrowsAsString);
    ad.setHeaderText("NUMBER OF BORROWES");
    ad.show();
    
    }
    
    });  
    
    
    } 
 //     System.out.println("1-CREATE BORROWINGS");
//                     System.out.println("2-CANCEL BORROWINGS");
//                     System.out.println("3-CALCULATE PAYMENT"); 
    
    

    
    else if(Logged instanceof Borrower){
       Borrower Borr=((Borrower)Logged);
         Stage BorrowerStage=new Stage(); 
          File fileeee = new File("C:/Users/Hassan Hatem/Documents/NetBeansProjects/Project/LIBjpg.jpg");
        String imageUrllll = fileeee.toURI().toString();
        Image imageee = new Image(imageUrllll);
        ImageView ivvv = new ImageView(imageee);
    ivvv.setFitHeight(300);   ivvv.setFitWidth(500);
      ObservableList<String> ooo = FXCollections.observableArrayList("VIEW BOOKS","VIEW RECOMMENDED CATEGORY","VIEW ORDER HISTORY","RATE BOOK");
    ComboBox cboo = new ComboBox(ooo);
    cboo.setValue("Select");
    Button Bbt=new Button("Next");
    Label lib=new Label("Welcome");
    VBox boxx=new VBox(lib,cboo,Bbt);
    boxx.setAlignment(Pos.CENTER);
    lib.setStyle("-fx-font-weight: bold;");
     lib.setTextFill(Color.WHITE);
     lib.setFont(new Font(20));
    StackPane ll=new StackPane(ivvv,boxx);
    Scene ssl=new Scene(ll,500,300);
    BorrowerStage.setScene(ssl);
    BorrowerStage.show();
    Bbt.setOnAction(e->{
    String BorrowerChoice = (String) cboo.getValue();
    if (BorrowerChoice.equals("VIEW BOOKS")){
//        ArrayList<Book> libraryBooks=a1.readBookss();
        ObservableList<String> bookk = FXCollections.observableArrayList();

for (Book b : bk) {
    bookk.add(b.getName());
}
        ComboBox cbook = new ComboBox(bookk);
    cbook.setValue("Select");
        Button Bbtt=new Button("Add to cart");
        Button Bb=new Button("Confirm Order");
        
    Label b=new Label("choose books");
    VBox borr=new VBox(b,cbook,Bbtt,Bb);
    borr.setAlignment(Pos.CENTER);
     b.setTextFill(Color.WHITE);
     b.setFont(new Font(20));
    b.setStyle("-fx-font-weight: bold;");
    StackPane z=new StackPane(ivvv,borr);
        Scene borrower=new Scene(z,500,300);
        BorrowerStage.setScene(borrower);
    BorrowerStage.show();
    Bbtt.setOnAction(l->{
        String Borrower = (String) cbook.getValue();
         for (Book bb : bk){
             
             
            if(bb.getName().equals( Borrower)){
                System.out.println(bb.getName());
            
//        ((Borrower)Logged).checking();
           ((Borrower)Logged).CreateOrder(bb);
           ((Borrower)Logged).writeCreateOrder();
//            ((Borrower)Logged).readCreateOrder();
            Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText("book added succsesfully");
        ad.setHeaderText(null);
        ad.show();
            
        break;
         }
        else if(Borrower.equalsIgnoreCase("select")){
                Alert add = new Alert(Alert.AlertType.ERROR);
        add.setContentText("choose book first");
        add.setHeaderText(null);
        add.show();
        break; 
                }
        }
         
    });
    Bb.setOnAction(eh->{
    Label lab=new Label(((Borrower)Logged).completepurchase(l1));
     Date currentDateAndTime=new Date();
    lab.setStyle("-fx-font-weight: bold;");
    lab.setTextFill(Color.WHITE);
     
    Button card=new Button("Card");
    Button cash=new Button("Cash");
    
     VBox bor=new VBox(lab,cash,card);
    bor.setAlignment(Pos.CENTER);
     
    StackPane zz=new StackPane(ivvv,bor);
        Scene w=new Scene(zz,500,300);
        BorrowerStage.setScene(w);
    BorrowerStage.show();
    cash.setOnAction(h->{
    
      Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText("Your order is confirmed on "+currentDateAndTime.toString());
        ad.setHeaderText("CASH PAYMENT");
        ad.showAndWait();
        Alert add = new Alert(Alert.AlertType.WARNING);
        add.setContentText(l1.BorrowingDetails(currentDateAndTime));
        add.setHeaderText("Book has to be in the same condition");
        add.show();
    
    });
    card.setOnAction(o->{
     Label labl=new Label("card number");
     Label labll=new Label("CVV"); 
     Label lablll=new Label("PIN");
     labl.setStyle("-fx-font-weight: bold;");
    labl.setTextFill(Color.WHITE);
     labl.setFont(new Font(20));
     labll.setStyle("-fx-font-weight: bold;");
    labll.setTextFill(Color.WHITE);
     labll.setFont(new Font(20));
     lablll.setStyle("-fx-font-weight: bold;");
    lablll.setTextFill(Color.WHITE);
     lablll.setFont(new Font(20));
    Button confirm=new Button("Confirm");
    TextField no=new TextField();
    TextField cvv=new TextField();
    TextField oin=new TextField();
    GridPane k=new GridPane();
     k.add(labl,0,0);
     k.add(no,1,0);
     k.add(labll,0,1);
     k.add(cvv,1,1);
     k.add(lablll,0,2);
     k.add(oin,1,2);
     k.add(confirm,1,3);
     k.setAlignment(Pos.CENTER);
     k.setPadding(new Insets(10));
     k.setHgap(10);
     k.setVgap(10);
     StackPane t=new StackPane(ivvv,k);
        Scene r=new Scene(t,500,300);
        BorrowerStage.setScene(r);
    BorrowerStage.show();
    confirm.setOnAction(f->{
    Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText("Your order is confirmed on "+currentDateAndTime.toString());
        ad.setHeaderText("CARD PAYMENT");
        ad.showAndWait();
         Alert add = new Alert(Alert.AlertType.WARNING);
        add.setContentText(l1.BorrowingDetails(currentDateAndTime));
        add.setHeaderText("Book has to be in the same condition");
        add.show();
    
    });
    });
        
    
    
    
    });
    }
    else if (BorrowerChoice.equals("VIEW RECOMMENDED CATEGORY")){
        String w=l1.RecommendCategory(((Borrower)Logged));
         Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText(w);
        ad.setHeaderText("Recommended catgeory for you And Books");
        ad.show();
    }
    else if (BorrowerChoice.equals("VIEW ORDER HISTORY")){
        ArrayList<Book> books = ((Borrower)Logged).getHasbooks();
        double price=l1.calculatePayment(((Borrower)Logged));
        StringBuilder a2=new StringBuilder();
               for(Book xx:books){
               a2.append("Book name: ").append(xx.getName())
              .append(", Book ID: ").append(xx.getBookID())
              .append("\n");
               }a2.append("price ").append(String.valueOf(price));
                Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText(a2.toString());
        ad.setHeaderText("Order History");
        ad.show();
        
    }
    else if (BorrowerChoice.equals("RATE BOOK")){

//         ArrayList<Book> bkk=a1.getBookk();
          ObservableList<String> bok = FXCollections.observableArrayList();
         for(Book B:bk){
        bok.add(B.getName());
         }
         ComboBox u=new ComboBox(bok);
        
        
        Label rate=new Label("choose book to rate");
        rate.setStyle("-fx-font-weight: bold;");
    rate.setTextFill(Color.WHITE);
     rate.setFont(new Font(20));
        Button con=new Button("confirm");
        ToggleGroup stars=new ToggleGroup();
        ToggleButton starButton = new ToggleButton();
        ToggleButton starButton1 = new ToggleButton();
        ToggleButton starButton2 = new ToggleButton();
        ToggleButton starButton3 = new ToggleButton();
        ToggleButton starButton4 = new ToggleButton();
        starButton.setToggleGroup(stars);
        starButton1.setToggleGroup(stars);
        starButton2.setToggleGroup(stars);
        starButton3.setToggleGroup(stars);
        starButton4.setToggleGroup(stars);
        
        
        
        Polygon star = new Polygon(
                20, 0,
        26, 14,
        42, 14,
        30, 24,
        36, 40,
        20, 32,
        4, 40,
        10, 24,
        0, 14,
        16, 14
        );
          Polygon star1 = new Polygon(
                20, 0,
        26, 14,
        42, 14,
        30, 24,
        36, 40,
        20, 32,
        4, 40,
        10, 24,
        0, 14,
        16, 14
        );
            Polygon star2 = new Polygon(
                20, 0,
        26, 14,
        42, 14,
        30, 24,
        36, 40,
        20, 32,
        4, 40,
        10, 24,
        0, 14,
        16, 14
        );
              Polygon star3 = new Polygon(
                20, 0,
        26, 14,
        42, 14,
        30, 24,
        36, 40,
        20, 32,
        4, 40,
        10, 24,
        0, 14,
        16, 14
        );
                Polygon star4 = new Polygon(
                20, 0,
        26, 14,
        42, 14,
        30, 24,
        36, 40,
        20, 32,
        4, 40,
        10, 24,
        0, 14,
        16, 14
        );

        
     

        starButton.setGraphic(star);
        starButton.setStyle("-fx-background-color: transparent;");
        starButton1.setGraphic(star1);
        starButton1.setStyle("-fx-background-color: transparent;");
        starButton2.setGraphic(star2);
        starButton2.setStyle("-fx-background-color: transparent;");
        starButton3.setGraphic(star3);
        starButton3.setStyle("-fx-background-color: transparent;");
        starButton4.setGraphic(star4);
        starButton4.setStyle("-fx-background-color: transparent;");
        HBox starr=new HBox(starButton,starButton1,starButton2,starButton3,starButton4);
        VBox qq=new VBox(rate,u,starr,con);
        qq.setAlignment(Pos.CENTER);
        starr.setAlignment(Pos.CENTER);
        starr.setSpacing(5);
                
        qq.setSpacing(5);

        StackPane roott = new StackPane(ivvv,qq);
        Scene scenes = new Scene(roott, 500, 300);

        BorrowerStage.setScene(scenes);
        BorrowerStage.show();
       starButton.setOnAction(s -> {
    if (starButton.isSelected()) {
        count++;
        star.setFill(Color.GOLD);
    } else if (count ==1) {
        count--;
        star.setFill(Color.BLACK);
    }
});

starButton1.setOnAction(s -> {
    if (starButton1.isSelected()) {
        count++;
        star1.setFill(Color.GOLD);
    } else if (count == 2) {
        count--;
        star1.setFill(Color.BLACK);
    }
});

starButton2.setOnAction(s -> {
    if (starButton2.isSelected()) {
        count++;
        star2.setFill(Color.GOLD);
    } else if (count ==3) {
        count--;
        star2.setFill(Color.BLACK);
    }
});

starButton3.setOnAction(s -> {
    if (starButton3.isSelected()) {
        count++;
        star3.setFill(Color.GOLD);
    } else if (count ==4) {
        count--;
        star3.setFill(Color.BLACK);
    }
});

starButton4.setOnAction(s -> {
    if (starButton4.isSelected()) {
        count++;
        star4.setFill(Color.GOLD);
    } else if (count ==5) {
        count--;
        star4.setFill(Color.BLACK);
    }
});

        con.setOnAction(y->{
        String borchoie=(String) u.getValue();
         for(Book B:bk){
        if(borchoie.equals(B.getName()))
        ((Borrower)Logged).RateBook(B, count);
         Alert i=new Alert(Alert.AlertType.INFORMATION);
         i.setContentText("you rated book "+B.getName()+" "+ count+" stars");
         i.show();
         break;
         }
         
         
        });
         
         }
    
        
    });
    
    
    }
    
    
    
        else if(Logged instanceof Librarian){
         Stage LibrarianStage=new Stage();
          File fileeee = new File("C:/Users/Hassan Hatem/Documents/NetBeansProjects/Project/LIBjpg.jpg");
        String imageUrllll = fileeee.toURI().toString();
        Image imageee = new Image(imageUrllll);
        ImageView ivvv = new ImageView(imageee);
    ivvv.setFitHeight(300);   ivvv.setFitWidth(500);
      ObservableList<String> ooo = FXCollections.observableArrayList("CREATE or CANCEL BORROWINGS","CALCULATE PAYMENT");
    ComboBox cboo = new ComboBox(ooo);
    cboo.setValue("Select choice");
    Button lbt=new Button("Next");
    Label lib=new Label("Welcome");
    VBox boxx=new VBox(lib,cboo,lbt);
    boxx.setAlignment(Pos.CENTER);
     lib.setTextFill(Color.WHITE);
     lib.setFont(new Font(20));
     lib.setStyle("-fx-font-weight: bold;");
    StackPane ll=new StackPane(ivvv,boxx);
    Scene ssl=new Scene(ll,500,300);
    LibrarianStage.setScene(ssl);
    LibrarianStage.show();
    lbt.setOnAction(R->{
      String LibrarianChoice=(String)cboo.getValue();
         if(LibrarianChoice.equals("CREATE or CANCEL BORROWINGS")){
             
             
             
             StringBuilder a2=new StringBuilder();
             a2.append(b1.getName()).append(" Order").append("\n");
             for(Book A:borrowerOrder){
                 System.out.println(A.getName());
                 a2.append("Book name: ").append(A.getName())
              .append(", Book ID: ").append((char) A.getBookID()).append("price ").append(String.valueOf(A.getPrice()))
              .append("\n");
               }
             Button lb1=new Button("Cancel Borrowing");
             Button lb=new Button("Create Borrowing");
    Label li=new Label(a2.toString());
    VBox box=new VBox(li,lb,lb1);
    box.setAlignment(Pos.CENTER);
     li.setTextFill(Color.WHITE);
     li.setFont(new Font(20));
     li.setStyle("-fx-font-weight: bold;");
    StackPane lll=new StackPane(ivvv,box);
    Scene sen=new Scene(lll,500,300);
    LibrarianStage.setScene(sen);
    LibrarianStage.show();
//                 ((Librarian)Logged).CreateBorrowings(A,b1);
        lb.setOnAction(x->{
//         ArrayList<Book>borrowerOrd=(b1.getCreateOrder());
          if(borrowerOrder.isEmpty()){
                  Alert ad = new Alert(Alert.AlertType.ERROR);
                 ad.setContentText("there is no order to be created");
                 ad.setHeaderText(b1.getName()+" Order");
                 ad.show();
             }
             for(Book Aa:borrowerOrder){
             try {
                 ((Librarian)Logged).CreateBorrowings(Aa,b1);
                 Alert ad = new Alert(Alert.AlertType.INFORMATION);
    ad.setContentText("Order Created succssfully");
    ad.setHeaderText(b1.getName()+" Order");
    ad.show();
             } catch (IOException ex) {
                 Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
             }
             }
        
        
        }); 
        lb1.setOnAction(w->{
        
        
             for(Book Aa:borrowerOrderr){
                 ((Librarian)Logged).CancelBorrowings(Aa,b1);
                 Alert ad = new Alert(Alert.AlertType.INFORMATION);
                 ad.setContentText("Order Cancelled succssfully");
                 ad.setHeaderText(b1.getName()+" Order");
                 ad.show();
             }
             if(borrowerOrderr.isEmpty()){
                  Alert ad = new Alert(Alert.AlertType.ERROR);
                 ad.setContentText("there is no order to created be cancelled");
                 ad.setHeaderText(b1.getName()+" Order");
                 ad.show();
             }
        });
             
             
             
             
         }
         else if(LibrarianChoice.equals("CALCULATE PAYMENT")){
             double total=((Librarian)Logged).calculatePayment(b1);
             Alert ad = new Alert(Alert.AlertType.INFORMATION);
                 ad.setContentText(String.valueOf(total)+" LE");
                 ad.setHeaderText(b1.getName()+" Order total price");
                 ad.show();
                 if(total==0.0){
                 Alert ada = new Alert(Alert.AlertType.ERROR);
                 ada.setContentText("there is no order created to calculatr price");
                 ada.show();
                 }
         }
         
         
         
         
         
    });
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
         
    else if(Logged instanceof Supplier){
         Stage SupplierStage=new Stage(); 
          File fileee = new File("C:/Users/Hassan Hatem/Documents/NetBeansProjects/Project/LIBjpg.jpg");
        String imageUr = fileee.toURI().toString();
        Image imagee = new Image(imageUr);
        ImageView i = new ImageView(imagee);
    i.setFitHeight(300);   i.setFitWidth(500);
      ObservableList<String> osupplier = FXCollections.observableArrayList("CREATE YOUR ORDER","SHOW ALL ORDERS OF SUPPLIERS");
    ComboBox cbosup = new ComboBox(osupplier);
    Label P=new Label("WELCOME");
    P.setStyle("-fx-font-weight: bold;");
    P.setTextFill(Color.WHITE);
    P.setFont(new Font(20));
    Button n=new Button("select");
        VBox pp=new VBox(15,P,cbosup,n);
        pp.setAlignment(Pos.CENTER);
        StackPane pane=new StackPane(i,pp);
        Scene x=new Scene(pane,500,300);
        SupplierStage.setScene(x);
    SupplierStage.show();
    n.setOnAction(z->{
        String SupChoice = (String) cbosup.getValue();
     if(SupChoice.equals("CREATE YOUR ORDER")){
      
    
    Category[]c=Category.values();
    ObservableList<Category> cat = FXCollections.observableArrayList();
    for(Category cat1:c){
    cat.add(cat1);
    }
    ComboBox categories = new ComboBox(cat);
    categories.setValue("Select category");
    Button Sbt=new Button("Create Order");
    Label name=new Label("Name");
    Label id=new Label("ID");
    Label price=new Label("PRICE");
    Label quant=new Label("Quantity");
    name.setStyle("-fx-font-weight: bold;");
    name.setTextFill(Color.WHITE);
     name.setFont(new Font(15));
     quant.setStyle("-fx-font-weight: bold;");
    quant.setTextFill(Color.WHITE);
     quant.setFont(new Font(15));
     id.setStyle("-fx-font-weight: bold;");
    id.setTextFill(Color.WHITE);
     id.setFont(new Font(15));
     price.setStyle("-fx-font-weight: bold;");
    price.setTextFill(Color.WHITE);
     price.setFont(new Font(15));
     TextField Name=new TextField();
     TextField ID=new TextField();
      TextField PRICE=new TextField();
     TextField QUANTITY=new TextField();
     GridPane sup=new GridPane();
    sup.add(name,0,0);
     sup.add(Name,1,0);
     sup.add(id,0,1);
     sup.add(ID,1,1);
     sup.add(price,0,2);
     sup.add(PRICE,1,2);
     sup.add(quant,0,3);
     sup.add(QUANTITY,1,3);
     sup.add(categories,1 , 4);
     sup.add(Sbt,1,5);
     sup.setAlignment(Pos.CENTER);
     sup.setPadding(new Insets(10));
     sup.setHgap(10);
     sup.setVgap(10);
    StackPane suppp=new StackPane(i,sup);
    Scene ss=new Scene(suppp,500,300);
    SupplierStage.setScene(ss);
    SupplierStage.show();
    Sbt.setOnAction(s->{
         Category SChoice = (Category) categories.getValue();
    double value1= Double.parseDouble(PRICE.getText());
    int value2= Integer.parseInt(ID.getText());
    int value3= Integer.parseInt(QUANTITY.getText());
//    ArrayList<Book> ab=a1.getBookk();
    for(Book g:bk){
        if(value2==g.getBookID()){
        Alert ad = new Alert(Alert.AlertType.WARNING);
        ad.setContentText("this ID already exists");
        ad.setHeaderText(null);
        ad.show();
        break;
        }
        else if(value2!=g.getBookID()&&Name.getText().equalsIgnoreCase(g.getName())&&value1==g.getPrice()){
        Alert ad = new Alert(Alert.AlertType.WARNING);
        ad.setContentText("Wrong book ID");
        ad.setHeaderText(null);
        ad.show();  
        break;
        }
        else{
    Book bookk=new Book(Name.getText(),SChoice,value1,value3,0,0,value2);
    
        try {
            ((Supplier)Logged).addSuppBooks(bookk, a1);
            or.addOrderBooks(((Supplier)Logged), bookk);
           ((Supplier)Logged).writeBookss();
           or.writeOrders();
           ((Supplier)Logged).readBookss();
           or.readOrders();
           int X=((Supplier)Logged).getNoOfOrders()+1;
           ((Supplier)Logged).setNoOfOrders(X);
              Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText("book added succsesfully");
        ad.setHeaderText(null);
        ad.show();
        } catch (IOException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
        break;
    }
        
    }
      
    });
    
    
    }
            
     else if(SupChoice.equals("SHOW ALL ORDERS OF SUPPLIERS")){
//               ArrayList<Book> supOrders=or.readOrders();
               StringBuilder a2=new StringBuilder();
               for(Book xx:sp){
               a2.append("Book name: ").append(xx.getName())
              .append(", Book ID: ").append(xx.getBookID())
              .append("\n");
               }
                Alert ad = new Alert(Alert.AlertType.INFORMATION);
        ad.setContentText(a2.toString());
        ad.setHeaderText("Orders");
        ad.show();
               
               }
    
    
    });
   
    
    
    
    
    
    
    
    }
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
}
}
    

    
            });
});
}
             

    
    public static void main(String[] args) throws FileNotFoundException, IOException { 
       launch(args);
        Scanner s = new Scanner(System.in);
        
        
 
     

     
//     
//        //OPENING THE SYSTEM TO CHOOSE WHICH USER ARE YOU
//        System.out.println("Welcome to the Library");
//        System.out.println("Countinue as:");
//        System.out.println("1-Admin");      
//        System.out.println("2-Supplier");  
//        System.out.println("3-Librarian");  
//        System.out.println("4-Borrower");  
//        int choicee=s.nextInt();
//        
//            if(choicee==1) {//Admin 
//            //LOGIN MENU
//        System.out.println("Welcome to the Library enter 1 to login with your account");
//        System.out.println("Create a new account? enter 2 to create it");
//        int choice=s.nextInt();
//        switch(choice){
//            case 1:
//                 System.out.println("Enter your username : ");
//                 String user = s.next();
//                 System.out.println("Enter your pin : ");
//                 int pin=s.nextInt() ;
//                 boolean show=true;
//                 for(User users:a1.getUserr()){
//                     if(users instanceof Admin){
//                 while(pin==users.getPIN()&&user.equals(users.getUsername())){
//////                     if(show){
//////                     System.out.println("welcome:");
//////                     System.out.println("1-ADD BOOKS");
//////                     System.out.println("2-REMOVE BOOKS");
//////                     System.out.println("3-EDIT BOOKS");
//////                     System.out.println("4-SEARCH BOOKS");
//////                     System.out.println("5-get number of borrowes");
//////                     System.out.println("6-REMOVE USER");
//////                     System.out.println("7-EDIT USER");
//////                     System.out.println("8-SEARCH USER");
//////                     System.out.println("9-GET BOOK CATEGORIES");//ZAY EL SUPPIER
//                     System.out.println("10-GET MOST BORROWED BOOK");
//                     System.out.println("11-LIBRARIAN WITH MAX BORROWS");
//                     System.out.println("12-BORROWER WITH MAX BORROWS");
//                     System.out.println("13-LIBRARIAN WITH MAX REVENUE");
//                     System.out.println("14-BORROWER WITH MAX REVENUE");
//                     System.out.println("15-SUPPLIER WITH MAX REVENUE");
//                     System.out.println("16-SUPPLIER WITH MAX NUMBER OF ORDERS");
//                     System.out.println("17-VIEW NUMBER OF BORROWINGS PER EACH LIBRARIAN");
//                     System.out.println("18-VIEW NUMBER OF BORROWINGS PER EACH BORROWER");
//                     System.out.println("19-VIEW NUMBER OF ORDERS PER EACH SUPPLIER"); 
//                     show=false;
//                     }
//                     int x=s.nextInt();
//                     
//                     if(x==1){ //ADD BOOKS
//                          System.out.println("enter book ID");
//                         int u=s.nextInt();
//                        for(Book book:s1.getSup()){
//                           if(u==book.getBookID()) 
//                         a1.add(book,s1);
//                          
//                        }
//                        System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                         
//                     }
//                     else if(x==2){//REMOVE BOOKS
//                          System.out.println("enter book ID");//handle ConcurrentModificationException
//                        
//                        int q=s.nextInt();
//                         for(Book boook:a1.getBookk()){
//                              if(q==boook.getBookID()) 
//                                 a1.Remove(boook);
//                         }
//                         
//                     
//                          System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(x==3){//EDIT BOOKS
//                
//                          
//                        int n=s.nextInt();
//                         for(Book boook:a1.getBookk()){
//                             if(n==boook.getBookID()) {
//                               
//                         a1.Edit(boook);
//                     }
//                    }
//                          System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(x==4){//LIST BOOKS
//                          System.out.println("List books in the Library");
//                          a1.List();
//                           System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(x==5){//getNumberOfBorrows
//                     System.out.print("number of borrowes in the library");
//                         System.out.println(a1.getNumberOfBorrows()); 
//                     }
//                     
//                     else if(x==6){//REMOVE USER // ConcurrentModificationException =true;
//                   
//                         System.out.println("Remove user from the Library");
//                         System.out.println("enter user id");
//                        int ID=s.nextInt();
//                         for(User useeer:a1.getUserr()){
//                   if(useeer instanceof Admin||useeer instanceof Supplier||useeer instanceof Librarian||useeer instanceof Borrower){
//                             if(useeer.getID()==ID)
//                                 a1.Remove(useeer);
//                         }
//                         }
//                          System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(x==7){//EDIT USER
//                       System.out.println("Edit user in the Library");
//                       System.out.println("enter user id");
//                        int ID=s.nextInt();
//                         for(User useeer:a1.getUserr()){
//                             if(ID==useeer.getID())
//                                 a1.Edit(useeer);
//                         }
//                          System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(x==8){//LIST USER
//                      System.out.println("List users in the Library");
//                          a1.ListUser();
//                           System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(x==9){ //GET BOOKS CAREGORY
//                          System.out.println("enter Book ID");
//                        int l=s.nextInt();
//                         for(Book boook:a1.getBookk()){
//                              if(l==boook.getBookID()){
//                       System.out.println(a1.getCategoryOfBook(boook));
//                     }
//                         }
//                          System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(x==10){//MOST BORROWER BOOK
//                     a1.getMostBorrowedBook();
//                      System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(x==11){//LIBRARIAN WITH MAX BORROWS
//                         a1.librarianwithmaxborrow();
//                          System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     
//                     }
//                     else if(x==12){//BORROWER WITH MAX BORROWS
//                     a1.borrowerwithmaxborrow();
//                      System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(x==13){//LIBRARIAN WITH MAX REVENUE
//                     a1.librarianwithmaxrevenue();
//                      System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(x==14){//BORROWER WITH MAX REVENUE
//                     a1.borrowerwithmaxrevenue();
//                      System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(x==15){//SUPPLIER WITH MAX REVENUE
//                         a1.Supplierwithmaxrevenue();
//                          System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(x==16){//SUPPLIER WITH MAX NUMBER OF ORDERS
//                         a1.SupplierWithmaxOrders();
//                          System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(x==17){//VIEW NUMBER OF BORROWINGS PER EACH LIBRARIAN
//                         a1.NoOfBorrowingsPerEachLibrarian();
//                          System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(x==18){//VIEW NUMBER OF BORROWINGS PER EACH BORROWER
//                         a1.NoOfBorrowingsPerEachBorrower();
//                          System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(x==19){//VIEW NUMBER OF ORDERS PER EACH SUPPLIER
//                         a1.NoOfOrdersPerEachSupplier();
//                          System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }   
//                 }
//        
//                 }
//                 }
//                 break;
//            case 2:
//                System.out.println("enter library code");
//                int AdminCode=s.nextInt(); //admin code is equal 2023 it is only usable is you are one of the admins in the Libray
//                if(AdminCode==2023){
//                System.out.println("enter your name: ");
//                 String NAME = s.next();
//                 System.out.println("enter your id: ");
//                 int IDD=s.nextInt();
//                  System.out.println("create your username : ");
//                 String userrname = s.next();
//                 System.out.println("create your pin : ");
//                 int pinn=s.nextInt() ;
//                 
//                 Admin a3=new Admin(NAME,IDD,pinn,userrname);
//                    a1.add(a2);
//                    Project.main(args);//This means that you succesfully created your accountso you go back to login
//                    
//                    
//                }
//                 else{
//                    System.out.println("you are donthave the authority to signup as admin");
//                    
//                    System.out.println("press 1 to go back to main menu");
//                    System.out.println("press 2 to exit");
//                    int q=s.nextInt();
//                    if(q==1){
//                    Project.main(args);//you are not valid to bean admin
//                    }
//                    else{
//                        exit(1);
//                    }
//                         
//                         }
//                 break;
//           
//        }
//        }
//
//            
//            if(choicee==2){//SUPPlIER
//        System.out.println("Welcome to the Library enter 1 to login with your account");
//        System.out.println("Create a new account? enter 2 to create it");
//        int choice=s.nextInt();
//        switch(choice){
//            case 1:
//                 System.out.println("Enter your username : ");
//                 String usersup = s.next();
//                 System.out.println("Enter your pin : ");
//                 int pinsup=s.nextInt() ;
//                 boolean shows=true;
//                 for(User userss:a1.getUserr()){
//                     
//                 if(userss instanceof Supplier){
//                 while(pinsup==userss.getPIN()&&usersup.equals(userss.getUsername())){
//                     if(shows){
//                     System.out.println("welcome:");
//                     System.out.println("1-CREATE YOUR ORDER");
//                     System.out.println("2-SHOW ALL ORDERS OF SUPPLIERS");
//                 }
//                     shows=false;
//                     int Y=s.nextInt();
//                     if(Y==1){//CREATE YOUR ORDER
//                         System.out.println("enter how many books you want to order");
//                          int l=s.nextInt();
//                         for(int i=0;i<l;i++){
//                        System.out.println("enter book ID");
//                        int id=s.nextInt();
//                         for(Book boook:a1.getBookk()){
//                             if(id==boook.getBookID()){
//                               ((Supplier)userss).addSuppBooks(boook,a1);
//                         }
//                          
//                         }
//                     }
//                          s1.setNoOfOrders(s1.getNoOfOrders()+1);
//                          System.out.println(s1.getNoOfOrders());
//                         System.out.println("Do you want to view the menu again? (Y/N)");
//                     String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     shows = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                         
//                     
//                     else if(Y==2){//CONFIRM YOUR ORDER
//                         Order o1=new Order(a1);
//                          for(Book boook:((Supplier)userss).getSup()){
//                         o1.addOrderBooks(((Supplier)userss),boook);
//                         ((Supplier)userss).setNoOfOrders(((Supplier)userss).getNoOfOrders()+1);
//                           }
//                          System.out.println("Do you want to view the menu again? (Y/N)");
//                            String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     shows = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                      
//                 }
//                 }
//                 }
//                      break;
//                 
//                  case 2:
////                int AdminCode=s.nextInt(); //admin code is equal 2023 it is only usable is you are one of the admins in the Libray
////                if(AdminCode==2023){
//                System.out.println("enter your name: ");
//                 String NAME = s.next();
//                 System.out.println("enter your id: ");
//                 int IDD=s.nextInt();
//                  System.out.println("create your username: ");
//                 String userrname = s.next();
//                 System.out.println("create your pin: ");
//                 int pinn=s.nextInt();
//                 
//                 Supplier s3=new Supplier(NAME,IDD,pinn,userrname);
//                    a1.add(s3);
//                      System.out.println("acccont created succesfully");
//                    Project.main(args);//This means that you succesfully created your accountso you go back to login
//                    
//                    break;
//                
//              
//            }
//            }
//            
//                
//           if(choicee==3){//Librarian
//                System.out.println("Welcome to the Library enter 1 to login with your account");
//        System.out.println("Create a new account? enter 2 to create it");
//               int choice=s.nextInt();
//              switch(choice){
//            case 1:
//                 System.out.println("Enter your username : ");
//                 String userlib = s.next();
//                 System.out.println("Enter your pin : ");
//                 int pinlib=s.nextInt() ;
//                 boolean show=true;
//                 for(User userss:a1.getUserr()){
//                     if(userss instanceof Librarian){
//                     while(pinlib==userss.getPIN()&&userlib.equals(userss.getUsername())){
//                         if(show){
//                     System.out.println("welcome:");
//                     System.out.println("1-CREATE BORROWINGS");
//                     System.out.println("2-CANCEL BORROWINGS");
//                     System.out.println("3-CALCULATE PAYMENT"); 
//                 }
//                 
//                     show=false;
//                     int z=s.nextInt();
//                     if(z==1){ //CREATE BORROWINGS 
//                          System.out.println("enter book id");
//                          int x=s.nextInt();
//                        for(Book books:a1.getBookk()){
//                           if(x==books.getBookID()){
//                            
//                        ((Librarian)userss).CreateBorrowings(books, b1);//ADD BOOKS THE BORROER ORDERED
//                        
//                        }
//                        }
//                         System.out.println("Do you want to view the menu again? (Y/N)");
//                           String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(z==2){//CANCEL BORROWINGS
//                          System.out.println("enter book id");
//                          int x=s.nextInt();
//                        for(Book books:a1.getBookk()){
//                           if(x==books.getBookID()){
//                            
//                        ((Librarian)userss).CancelBorrowings(books, b1);//CANCEL BOOKS THE BORROER ORDERED
//                           }
//                        }
//                        System.out.println("Do you want to view the menu again? (Y/N)");
//                            String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(z==3){//CALCULATE PAYMENT
//                         ((Librarian)userss).calculatePayment(b1);
//                        
//                     }
//                     System.out.println("Do you want to view the menu again? (Y/N)");
//                           String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     
//                           
//              }
//                 }
//                 }
//            break; 
//            case 2:
//                 int LibCode=s.nextInt(); //Librarian code is equal 202 it is only usable if you are one of the Librarians in the Libray
//                if(LibCode==202){
//                System.out.println("enter your name: ");
//                 String NAME = s.next();
//                 System.out.println("enter your id: ");
//                 int IDD=s.nextInt();
//                  System.out.println("create your username : ");
//                 String userrname = s.next();
//                 System.out.println("create your pin : ");
//                 int pinn=s.nextInt() ;
//                 
//                 Librarian L4=new Librarian(NAME,IDD,pinn,userrname,a1);
//                    a1.add(L4);
//                    System.out.println("account created succefully");
//                    Project.main(args);//This means that you succesfully created your account so you go back to login
//                    
//                    
//                }
//                 else{
//                     System.out.println("you are donthave the authority to signup as Librarian");
//                   
//                    System.out.println("press 1 to go back to main menu");
//                    System.out.println("press 2 to exit");
//                     int q=s.nextInt();
//                    if(q==1){
//                    Project.main(args);//you are not valid to be a Libraian go bav=ck to menu
//                    }
//                    else{
//                        exit(1);
//                    }
//                   
//                        
//                         
//                         }
//                 break;
//           
//                
//           }
//    
//    
//           }
//                
//            if(choicee==4){ //Borrower 
//                 System.out.println("Welcome to the Library enter 1 to login with your account");
//        System.out.println("Create a new account? enter 2 to create it");
//                 int choice=s.nextInt();
//              switch(choice){
//            case 1:
//                 System.out.println("Enter your username : ");
//                 String userB = s.next();
//                 System.out.println("Enter your pin : ");
//                 int pinB=s.nextInt() ;
//                 boolean show=true;
//                 for(User users:a1.getUserr()){
//                 while(pinB==users.getPIN()&&userB.equals(users.getUsername())){
//                     if(show){
//                     System.out.println("welcome:");
//////                     System.out.println("1-VIEW RECOMMENDED CATEGORY");
//////                     System.out.println("2-VIEW ORDER HISTORY");
//////                     System.out.println("3-CONFIRM ORDER");
//////                     System.out.println("4-RATE BOOK");
//////                     }
//                     show=false;
//                     int k=s.nextInt();
//                     if(k==1){
//                        l1.RecommendCategory(((Borrower)users));
//                          System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(k==2){
//                         
//                         for(Book book:((Borrower)users).getHasbooks()){
//                             System.out.println(book.getName()+ " "+book.getPrice());
//                        
//                         }
//                        
//                         
//                           System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                     else if(k==3){//see your order detail and payment methods
//                         ((Borrower)users).completepurchase(l1 );
//                        System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                         
//                     }
//                     else if(k==4){//RATE THE ORDERED BOOKS
//                         System.out.println("enter book id");
//                         int e=s.nextInt();
//                        for(Book boook:((Borrower)users).getHasbooks()){
//                            if(e==boook.getBookID()){
//                         ((Borrower)users).RateBook(boook);
//                            }
//                     }
//                          System.out.println("Do you want to view the menu again? (Y/N)");
//                         String viewMenuAgain = s.next();
//
//                     if (viewMenuAgain.equalsIgnoreCase("Y")) {
//                     show = true; // Set showMenu to true to display the menu again
//                        } else {
//                                  break;
//                        }
//                     }
//                 }
//                 }
//              
//                 break;
//                     case 2:
//                     System.out.println("enter your name: ");
//                 String NAME = s.next();
//                 System.out.println("enter your id: ");
//                 int IDD=s.nextInt();
//                  System.out.println("create your username : ");
//                 String userrname = s.next();
//                 System.out.println("create your pin : ");
//                 int pinn=s.nextInt() ;
//                 
//                 Borrower b4=new Borrower(NAME,IDD,pinn,userrname);
//                    a1.add(b4);
//                     System.out.println("account created succefully");
//                    Project.main(args);//This means that you succesfully created your accountso you go back to login
//                    
//                    break;
//            
//              }
//            }
    }
        
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
     

//        System.out.println("Enter your username : ");
//        String user = s.next();
//        System.out.println("Enter your psasword : ");
//        String pass=s.next() ;
//        boolean valid=false;
//        for(User a:a1.getUserr()){
//            if(a instanceof Admin){
//                adminmenu();
//                valid=true;
//            }
//            else if(a instanceof Borrower){
//                borrowermenu();
//                valid=true;
//            }
//            else if(a instanceof Librarian)
//            {
//                librarianmenu();
//                valid=true;
//            }
//        }
//        if(!valid){
//            System.out.println("Incorrect Creditintials");
//        }
        
//         Supplier s2=new Supplier( "noooooor", 5, 122, "loll","ll");
//     Book b1=new Book("Marvel","sc fic",120,3,4,5);
//     Book b2=new Book("Harrypotter","sc fic",200,3,4,0);
//      Book b3=new Book("the note book","romance",1050,3,0,0);
//      Book b4=new Book("serag","romance",1050,3,0,0);
//      Order o1=new Order(n1);
//      Borrower a2=new Borrower("mostafa",4,1,"hh");
//     Librarian l2=new Librarian( "Serag", 5, 122, "lol",n1);
//     
//     n1.add(l1);
//     n1.add(l2);
//     n1.add(a1);
//     n1.add(a2);
//     n1.add(s1);
//     n1.add(s2);
//
//        
//     s2.addSuppBooks(b3,n1);
//     
//    s1.addSuppBooks(b2,n1);
//    s1.addSuppBooks(b3,n1);
//     
//   
//    
//    o1.addOrderBooks(s1, b2);
//    o1.addOrderBooks(s1, b3);
//     o1.addOrderBooks(s2, b3);
//    
//     n1.add(b2,s1);
//     
//     n1.add(b3,s1);
//  
//      n1.Supplierwithmaxrevenue();
//      n1.SupplierWithmaxOrders();
//      l1.CreateBorrowings(b4, a2);
//        System.out.println("-------------------------");
//     l1.BorrowingDetails();
//    
////     System.out.println(s1.getNoOfOrders());
//     
//     
//
//     l1.RecommendCategory(a2);
//     n1.NoOfOrdersPerEachSupplier();
    
     
//     Scanner sc=new Scanner(System.in);
//     int num=sc.nextInt();
             

//     
//     l1.CreateBorrowings(b2, a1);
////     System.out.println("remaining quantiy "+b1.getQuantity());
////     
//     l1.CreateBorrowings(b3, a2);
//     l1.CreateBorrowings(b3, a2);
//     l2.CreateBorrowings(b3, a2);
////    
////a1.CardPayment();
////        
//        n1.NoOfBorrowingsPerEachBorrower();
//        n1.NoOfBorrowingsPerEachLibrarian();
//
//      
//     Date start=new Date();
//      Calendar calendar = Calendar.getInstance();
//        calendar.setTime(start);
//        calendar.add(Calendar.DAY_OF_MONTH,1 );
//        Date end = calendar.getTime();
//     
        
//        n1.getMostBorrowedBook(start,end);
//        l1.BorrowingDetails();
//        System.out.println(n1.getNumberOfBorrows(start,end));
//        System.out.println(n1.getNumberOfBorrows());
//     System.out.println("remaining quantiy "+b1.getQuantity());
////        l1.CancelBorrowings(b1, a2);
////        System.out.println("quantiy "+b1.getQuantity());
//l1.RecommendCategory(a1);
//             l2.CreateBorrowings(b1, a1);
//  System.out.println(l1.calculatePayment( a2));
//      System.out.println(   l1.calculatePayment( a1));
////        System.out.println(a1.getnumberofborrowings());
////        n1.borrowerwithmaxborrow();
////        n1.borrowerwithmaxrevenue();
////       System.out.println(n1.getMostBorrowedBook());
////       n1.librarianwithmaxborrow();
////        n1.librarianwithmaxrevenue();
//l1.RecommendCategory( a2);
//        a1.RateBook(b3);
//        a2.RateBook(b3);
//        a2.CardPayment();
//     

  



    
    
    }
            
   

            







