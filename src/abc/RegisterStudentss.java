
package abc;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class RegisterStudentss extends Application{
    Label stdtLabel = new Label("Student Name");
    Label courseLabel = new Label("Course Name");
    ChoiceBox stdtChoiceBox = new ChoiceBox();
    ChoiceBox courseChoiceBox = new ChoiceBox();
    Button back = new Button("Back");
    Button registerBut = new Button("Register");
  Connection con;
    public void start (Stage s){
        
        AnchorPane pane = new AnchorPane();
       File f = new File("src/abc/AdminStyle.css");
       pane.getStylesheets().add(f.toURI().toString());
       pane.getChildren().add(stdtLabel);
       pane.getChildren().add(courseLabel);
       pane.getChildren().add(stdtChoiceBox);
       pane.getChildren().add(courseChoiceBox);
       pane.getChildren().add(registerBut);
       pane.getChildren().add(back);
       /// layout X
       stdtLabel.setLabelFor(stdtChoiceBox);
       courseLabel.setLabelFor(courseChoiceBox);
       stdtLabel.setLayoutX(50);
       courseLabel.setLayoutX(50);
       stdtChoiceBox.setLayoutX(200);
       courseChoiceBox.setLayoutX(200);
       registerBut.setLayoutX(200);
       back.setLayoutX(20);
       // layout y
       stdtLabel.setLayoutY(100);
       courseLabel.setLayoutY(200);
       stdtChoiceBox.setLayoutY(100);
       courseChoiceBox.setLayoutY(200);
       registerBut.setLayoutY(300);
       back.setLayoutY(20);
///////////////////
      /// inserting elements into choice Boxes
    try{
      Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campus_data","root","its@pass1");
    Statement stmt = con.createStatement();
    String sql= "select cmsid,stname from student";
    ResultSet rs = stmt.executeQuery(sql);
    while(rs.next()){
        String cmsID = rs.getString("cmsid");
        String name = rs.getString("stname");
        stdtChoiceBox.getItems().add(cmsID+"   "+name);
    }
    sql = "select cid, cname from course";
    rs=stmt.executeQuery(sql);
    // inserting elemnts into course choice boc
    while(rs.next()){
        String cid = rs.getString("cid");
        String cName = rs.getString("cname");
        courseChoiceBox.getItems().add(cid+"   "+cName);
    }
    }
    catch(ClassNotFoundException e){}catch(SQLException ex){}
       
       /////////////

///////event handler
back.setOnAction(new EventHandler<ActionEvent>(){
public void handle(ActionEvent e){
    Adminnnnnnnnn obj = new Adminnnnnnnnn();
    Stage s101 = new Stage();
    obj.start(s101);
    s.hide();
    
} 



});
registerBut.setOnAction(new EventHandler<ActionEvent>(){
public void handle(ActionEvent e){
    try{
    
        String cmsID = stdtChoiceBox.getSelectionModel().getSelectedItem().toString().substring(0, 11);
        String courseID = courseChoiceBox.getSelectionModel().getSelectedItem().toString().substring(0, 7);
  String sName = stdtChoiceBox.getSelectionModel().getSelectedItem().toString().substring(12);
  String courseName = courseChoiceBox.getSelectionModel().getSelectedItem().toString().substring(8);
        System.out.println(cmsID);
        System.out.println(courseID);
Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        
   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campus_data","root","its@pass1");
            
   String sql = "select sid from student_course where cid='"+courseID+"'";
   PreparedStatement stmt =con.prepareStatement(sql);
   
   String sidFromDB="";
   boolean enrolled=false;
   ResultSet rs = stmt.executeQuery();
   while(rs.next()){
       sidFromDB=rs.getString("sid");
        if(sidFromDB.equalsIgnoreCase(cmsID))
    enrolled=true;   
       
   }
   // already enrolled dont enroll
   if(enrolled)
   { JOptionPane.showMessageDialog(null, sName+" is already enrolled in "+courseName, "Forbidden", JOptionPane.ERROR_MESSAGE); e.consume();}
   // not enrolled, enroll now
   else{
            System.out.println("enrolling");
   sql= "insert into student_course(sid,cid) values('"+cmsID+"','"+courseID+"')";
   stmt= con.prepareStatement(sql);
   stmt.execute();
  
stmt.close();
con.clearWarnings();
   System.out.println("enrolled");
   JOptionPane.showMessageDialog(null, sName+" successfully enrolled in "+courseName, "Enrolled", JOptionPane.INFORMATION_MESSAGE);
   
   }
    
    
    }
    catch(ClassNotFoundException exc){}catch(SQLException ex){}
    
} 



});

//////

       Scene scene = new Scene(pane,900,500);
        s.setTitle("Enroll Students in Courses");
        s.setScene(scene);
        s.show();
        
        
        
        
    }
    
    public static void main(String [] args){
        launch(args);
    }
}
