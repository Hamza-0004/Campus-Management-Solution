
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
import java.net.URISyntaxException;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
class CreateCourseeeee extends Application {
     
     Button btn = new Button("Back");
     Label courseIDLabel = new Label("Course ID");
     Label courseNameLabel = new Label("Course Name");
     Label taughtByLabel = new Label("Taught By");
     TextField courseIDTextField = new TextField();
     TextField courseNameTextField = new TextField();
     ChoiceBox taughtByChoiceBox = new ChoiceBox();
          Button createCourseBut = new Button("Create Course");
     public void start(Stage pStage) {
         System.out.println("Opening Create Course");
         // adding componens to anchor pane 
        AnchorPane Apane = new AnchorPane();
        Apane.getChildren().add(0, btn);
        Apane.getChildren().add(1, courseIDLabel);
        Apane.getChildren().add(2, courseNameLabel);
        Apane.getChildren().add(3, taughtByLabel);
        Apane.getChildren().add(4, courseIDTextField);
        Apane.getChildren().add(5, courseNameTextField);
        Apane.getChildren().add(6, taughtByChoiceBox);
        Apane.getChildren().add(7, createCourseBut);
        ////////////////////////////////////////////
        /// aligning the components
        courseIDLabel.setLabelFor(courseIDTextField);
       courseNameLabel.setLabelFor(courseNameTextField);
       taughtByLabel.setLabelFor(taughtByChoiceBox);
       ///// set layout Y
       courseIDLabel.setLayoutY(80);
       courseNameLabel.setLayoutY(80);
       taughtByLabel.setLayoutY(80);
       courseIDTextField.setLayoutY(90);
       courseNameTextField.setLayoutY(90);
       taughtByChoiceBox.setLayoutY(90);
       createCourseBut.setLayoutY(200);
       
       /// set layout X
     courseIDLabel.setLayoutX(40);
       courseNameLabel.setLayoutX(320);
       taughtByLabel.setLayoutX(760);
       courseIDTextField.setLayoutX(190);
       courseNameTextField.setLayoutX(510);
       taughtByChoiceBox.setLayoutX(900);
       createCourseBut.setLayoutX(1100);
       //////////setup
       courseIDTextField.setPromptText("Course ID");
       courseNameTextField.setPromptText("Course Name");
       courseIDTextField.setPrefSize(120, 40);
       courseNameTextField.setPrefSize(250, 40);
       courseIDLabel.setFont(Font.font("calibiri", 30));
       courseNameLabel.setFont(Font.font("calibiri", 30));
       taughtByLabel.setFont(Font.font("calibiri", 30));
       
        courseIDLabel.setTextFill(Paint.valueOf("Blue"));
       courseNameLabel.setTextFill(Paint.valueOf("Blue"));
       taughtByLabel.setTextFill(Paint.valueOf("Blue"));
       courseIDTextField.setFont(Font.font("calibiri", 20));
       courseNameTextField.setFont(Font.font("calibiri", 20));
   
       //// inserting teacher names into choice box
       try{
             Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        
  Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campus_data","root","its@pass1");
        String sql="select cmsid,tname from teacher";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
       while(rs.next()){
           String cmsIDFromDatabase = rs.getString("cmsid");
           String nameFromDatabase =rs.getString("tname");
           
           taughtByChoiceBox.getItems().add(cmsIDFromDatabase+"    "+nameFromDatabase);
       }
       stmt.close();
       con.close();
       }
       catch(SQLException ex){}catch(ClassNotFoundException exc){}
       
       ////////////////
        
// event handler
  btn.setOnMouseClicked(new EventHandler<MouseEvent>(){
     public void handle(MouseEvent e){
         System.out.println(" Clicked");
        Adminnnnnnnnn hp =new Adminnnnnnnnn();
        Stage hStage= new Stage();
        
        hp.start(hStage);
        
        
        pStage.hide();
     }
     
     
     });
        
        
  createCourseBut.setOnMouseClicked(new EventHandler<MouseEvent>(){
  public void handle(MouseEvent e){
      
        String courseID = courseIDTextField.getText();
        String courseName = courseNameTextField.getText();
        String cmsIdofTeacher = taughtByChoiceBox.getSelectionModel().getSelectedItem().toString().substring(0,11);
        String teacherName = taughtByChoiceBox.getSelectionModel().getSelectedItem().toString().substring(11);
        if(courseIDTextField.getText().trim().isEmpty() || courseNameTextField.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please fill all text fields");
        }
        else if(courseIDTextField.getText().length() != 7)
        {
            JOptionPane.showMessageDialog(null,"there should be 7 characters in Corse ID");
        }
        else
        {
        try{
           
 
           //System.out.println("teacher CMS ID: "+cmsIdofTeacher);
           //System.out.println("teacher Name: "+teacherName);
           
           
           Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        // inserting a row into course table or creating a new course
           System.out.println(" inserting a row into course table or creating a new course");
 Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campus_data","root","its@pass1");
             System.out.println("connection established");
            
             String sql="insert into course(cid,cname) values('"+courseID+"','"+courseName+"')";
           System.out.println("query created");
             PreparedStatement stmt = con.prepareStatement(sql);
             System.out.println("statement created");
             System.out.println("executing query");
           stmt.execute();
           System.out.println("course created");
    
    System.out.println("gotten CMSID"+cmsIdofTeacher);
     sql ="insert into course_teacher(cid,tid) values('"+courseID+"','"+cmsIdofTeacher+"')";
     System.out.println("yes inserted");
     stmt= con.prepareStatement(sql);
    
    stmt.execute();
    stmt.close();
    con.close();

    JOptionPane.showMessageDialog(null, "Course ID: "+courseID+"\n"+"Course Name: "+courseName+"\n"+"Taught By: "+teacherName, "Course Successfully created", JOptionPane.INFORMATION_MESSAGE);
      createCourseBut.setDisable(true);
           System.out.println("new row inserted into course_teacher");
      
       }
       catch(SQLException ex){
            System.out.println("Exception handling.......");
            JOptionPane.showMessageDialog(null,"this Course is already created...");
       }
       catch(ClassNotFoundException exc){}
        }
        }
  });
//////////////////////
        
Scene scenee = new Scene(Apane, 1300, 695);
File css= new File("src/abc/AdminStyle.css");
Apane.getStylesheets().add(css.toURI().toString());
btn.setLayoutX(30);
btn.setLayoutY(30);

//// setting the backgroung

       File f2= new File("src/abc/smoggyIba.jpg");
       
       Image img = new Image(f2.toURI().toString());
       BackgroundImage bImg= new BackgroundImage(img,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
       Background bg= new Background(bImg);
       Apane.setBackground(bg);

pStage.setTitle("Create Course");
        
        pStage.setScene(scenee);
        pStage.show();
   
    }
     
     
}
