package abc;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.geometry.Insets;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

import java.lang.InterruptedException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;
/**
 *
 * @author Ahmed Ali
 */
public class TeacherHomePageeee extends Application  {
  Button back = new Button("Back");   
    Label usernameLabel= new Label("User Name");
    private AnchorPane homePane;
    Label passwordLabel= new Label("Password");
    private  AnchorPane pane2;
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Submit");
              
         homePane = new AnchorPane();
         pane2 = new AnchorPane();       TextField userName= new TextField();
          PasswordField password= new PasswordField();
       pane2.getChildren().add(0,btn);
        
     //temp   
     ///////////////////////////////
     btn.setOnMouseClicked(new EventHandler<MouseEvent>(){
     public void handle(MouseEvent e){
         System.out.println("Mouse Clicked");
          String uN=userName.getText();
          String p= password.getText();

          
                        try{Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        
Connection    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campus_data?useSSL=false","root","its@pass1");
Statement stmt = con.createStatement();
String sql="select cmsid from teacher";
    
  ResultSet rs = stmt.executeQuery(sql);
boolean accountExists=false;
  while(rs.next()){
String cmsID=rs.getString("cmsid");
if(uN.equalsIgnoreCase(cmsID))
    accountExists=true;
  }
 // accouont exits now check the password
  if(accountExists)
  {
       sql="select pass from teacher where cmsid='"+uN+"'";
    boolean passwordCorrect=false;
  rs = stmt.executeQuery(sql);
  while(rs.next()){
      String passwordFromDatabase=rs.getString("pass");
      if(p.equals(passwordFromDatabase))
         passwordCorrect=true;
  }
  // password correct now open the account
  if(passwordCorrect){
      TeacherAccounttttt tA = new TeacherAccounttttt();
      Stage s000= new Stage();
      tA.accountToOpen=uN;
      tA.start(s000);
      primaryStage.hide();
  }
  else
      JOptionPane.showMessageDialog(null, "Incorrect Password", "Error", JOptionPane.ERROR_MESSAGE);
      
      
  }
  // account does not exits
  else{
     JOptionPane.showMessageDialog(null, "This account does not exists", "Error", JOptionPane.ERROR_MESSAGE);
  }
                           }
                           catch(ClassNotFoundException ex){} catch(SQLException exc){} 
          
     }
     
     });
     ////////////////////////////////////////
     password.setOnAction(new EventHandler<ActionEvent>(){
     public void handle(ActionEvent e){
         System.out.println("Key Pressed");
          String uN=userName.getText();
          String p= password.getText();
          
          
                           try{Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        
Connection    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campus_data?useSSL=false","root","its@pass1");
Statement stmt = con.createStatement();
String sql="select cmsid from teacher";
    
  ResultSet rs = stmt.executeQuery(sql);
boolean accountExists=false;
  while(rs.next()){
String cmsID=rs.getString("cmsid");
if(uN.equalsIgnoreCase(cmsID))
    accountExists=true;
  }
 // accouont exits now check the password
  if(accountExists)
  {
       sql="select pass from teacher where cmsid='"+uN+"'";
    boolean passwordCorrect=false;
  rs = stmt.executeQuery(sql);
  while(rs.next()){
      String passwordFromDatabase=rs.getString("pass");
      if(p.equals(passwordFromDatabase))
         passwordCorrect=true;
  }
  // password correct now open the account
  if(passwordCorrect){
      TeacherAccounttttt tA = new TeacherAccounttttt();
      Stage s000= new Stage();
      tA.accountToOpen=uN;
      tA.start(s000);
      primaryStage.hide();
  }
  else
      JOptionPane.showMessageDialog(null, "Incorrect Password", "Error", JOptionPane.ERROR_MESSAGE);
      
  }
  // account does not exits
  else{
     JOptionPane.showMessageDialog(null, "This account does not exists", "Error", JOptionPane.ERROR_MESSAGE);
  }
                           }
                           catch(ClassNotFoundException ex){} catch(SQLException exc){} 

     }
     
     });
     back.setOnAction(new EventHandler<ActionEvent>(){
     public void handle(ActionEvent e){
         
         Homepageeeeeeee hp = new Homepageeeeeeee();
         Stage s = new Stage();
         hp.start(s);
         primaryStage.hide();
         
     }
     
     });
////////////////////////////////////////////

      homePane.getChildren().add(0,pane2);
     homePane.getChildren().add(1,back);
      //view.setLayoutX(90);
        btn.setLayoutX(270);
        btn.setLayoutY(400);
        pane2.setLayoutX(400);
        pane2.setLayoutY(10);
       
              
             back.setLayoutX(30);
        back.setLayoutY(30);
        //Insets insets= new Insets(110,50,50,50);
       //pane2.setPadding(insets);p
       File aptImg= new File("src/abc/iba-logo.PNG");
       
       Image aptechImg = new Image(aptImg.toURI().toString());
       ImageView aptechView = new ImageView(aptechImg);
      aptechView.setLayoutX(130);
       pane2.getChildren().add(1,aptechView);
       pane2.getChildren().add(2,userName);
       pane2.getChildren().add(3,password);
   pane2.getChildren().add(4,usernameLabel);
   pane2.getChildren().add(5,passwordLabel);
        usernameLabel.setLayoutY(240);
        passwordLabel.setLayoutY(290);
        usernameLabel.setLayoutX(25);
        passwordLabel.setLayoutX(25);
   
       userName.setLayoutY(250);
       password.setLayoutY(300);
       userName.setLayoutX(170);
       password.setLayoutX(170);
       userName.setPrefSize(300, 30);
       password.setPrefSize(300, 30);
      
       pane2.setPrefSize(500, 690);
       
       pane2.setStyle("-fx-border-radius:50px;");
       
       File f2= new File("src/abc/smoggyIba.jpg");
       
       Image img = new Image(f2.toURI().toString());
       BackgroundImage bImg= new BackgroundImage(img,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
       Background bg= new Background(bImg);
       homePane.setBackground(bg);
      
       
       pane2.setStyle(" -fx-background-color: rgba(255,255,255,0.6);");
      
        File f= new File("src/abc/style.css");
        homePane.getStylesheets().add(f.toURI().toString());
        Scene scene = new Scene(homePane, 1300, 695);
        
        primaryStage.setTitle("Teacher");
        
        usernameLabel.setFont(Font.font("calibiri", 30));
        passwordLabel.setFont(Font.font("calibiri", 30));
userName.requestFocus();
userName.setFont(Font.font("calibri", 20));
        primaryStage.setScene(scene);
        primaryStage.show();
      
    }
 
}
