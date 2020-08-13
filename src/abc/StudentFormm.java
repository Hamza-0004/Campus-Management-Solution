
package abc;

import java.sql.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.input.Dragboard;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class StudentFormm extends Application{
static  File photoFile;
    Dragboard db;
    Button back= new Button("Back");
    Label heading= new Label("Student Enrollment Form");
    Label fullNameLabel = new Label("Full Name");
    TextField fullNameTextField = new TextField();
    Label fatherNameLabel = new Label("Father Name");
    TextField fatherNameTextField = new TextField();
        Label cmsIDLabel = new Label("CMS ID");
    TextField cmsIDTextField = new TextField();
        Label passwordLabel = new Label("Password");
TextField passwordTextField = new TextField();
        Label deptLabel = new Label("Department");
ChoiceBox deptChoiceBox = new ChoiceBox();
        Label degreeLabel = new Label("Degree");
ChoiceBox degreeChoiceBox = new ChoiceBox();
Label addressLabel = new Label("Address");
TextField addressTextField = new TextField();
Button submit =  new Button("Submit");
ImageView imgView = new ImageView();
Label contactLabel = new Label("Contact");
TextField contactTextField = new TextField();
private AnchorPane pane;
public void start(Stage stg) {
    System.out.println("Student enrollment form start");
    
    pane = new AnchorPane();
        /// addding components on anchor pane
        pane.getChildren().add(0, back);
        pane.getChildren().add(1, heading);
       pane.getChildren().add(2, fullNameLabel);
       pane.getChildren().add(3, fullNameTextField);
       pane.getChildren().add(4, fatherNameLabel);
       pane.getChildren().add(5, fatherNameTextField);
       pane.getChildren().add(6, cmsIDLabel);
       pane.getChildren().add(7, cmsIDTextField);
       pane.getChildren().add(8, passwordLabel);
       pane.getChildren().add(9, passwordTextField);
       pane.getChildren().add(10, deptLabel);
       pane.getChildren().add(11, deptChoiceBox);
       pane.getChildren().add(12, degreeLabel);
       pane.getChildren().add(13, degreeChoiceBox);
       pane.getChildren().add(14, addressLabel);
       pane.getChildren().add(15, addressTextField);
       pane.getChildren().add(16, submit);
       pane.getChildren().add(17, imgView);
       pane.getChildren().add(18, contactLabel);
       pane.getChildren().add(19, contactTextField);
       /////////////////////////////////

        File f= new File("src/abc/AdminStyle.css");
        pane.getStylesheets().add(f.toURI().toString());
        pane.setStyle("-fx-background-color: indigo;");
 Scene scene = new Scene(pane, 1300, 695);
/// alignment and setting
 back.setLayoutX(30);
        back.setLayoutY(30);
        heading.setLayoutX(250);
        heading.setLayoutY(20);
        heading.setFont(Font.font("monotype corsiva", 50));
       heading.setTextFill(Paint.valueOf("white"));
fullNameTextField.setPromptText("Full Name");
fullNameTextField.setLayoutY(150);
fullNameTextField.setLayoutX(200);
fullNameLabel.setLayoutY(150);
fullNameLabel.setLayoutX(60);
fullNameLabel.setFont(Font.font("calibiri", 30));
fullNameLabel.setTextFill(Paint.valueOf("white"));
fullNameTextField.setPrefSize(400, 30);
fullNameTextField.setFont(Font.font("calibiri", 20));
fatherNameLabel.setLayoutX(30);
fatherNameTextField.setLayoutX(200);
fatherNameLabel.setLayoutY(200);
fatherNameTextField.setLayoutY(200);
fullNameLabel.setLabelFor(fullNameTextField);
fatherNameLabel.setLabelFor(fatherNameTextField);
fatherNameTextField.setPromptText("Father Name");
fatherNameLabel.setFont(Font.font("calibiri", 30));
fatherNameLabel.setTextFill(Paint.valueOf("white"));
fatherNameTextField.setFont(Font.font("calibiri", 20));
fatherNameTextField.setPrefSize(400, 30);

cmsIDLabel.setFont(Font.font("calibiri", 20));
cmsIDLabel.setTextFill(Paint.valueOf("white"));
cmsIDLabel.setLayoutY(150);
cmsIDLabel.setLayoutX(700);
cmsIDLabel.setLabelFor(cmsIDTextField);

cmsIDTextField.setPrefSize(200, 30);
cmsIDTextField.setLayoutY(150);
cmsIDTextField.setLayoutX(800);
cmsIDTextField.setPromptText("CMSID");
cmsIDTextField.setFont(Font.font("calibiri", 20));

passwordLabel.setFont(Font.font("calibiri", 20));
passwordLabel.setTextFill(Paint.valueOf("white"));
passwordLabel.setLayoutX(700);
passwordLabel.setLayoutY(200);
passwordLabel.setLabelFor(passwordTextField);

passwordTextField.setPrefSize(200, 30);
passwordTextField.setLayoutX(800);
passwordTextField.setLayoutY(200);
passwordTextField.setFont(Font.font("calibiri", 20));
passwordTextField.setText("1234");
passwordTextField.setOpacity(0.4);
passwordTextField.setEditable(false);
passwordTextField.setMouseTransparent(true);

contactLabel.setFont(Font.font("calibiri", 20));
contactLabel.setTextFill(Paint.valueOf("white"));
contactLabel.setLayoutX(700);
contactLabel.setLayoutY(250);
contactLabel.setLabelFor(contactTextField);

contactTextField.setPrefSize(200, 30);
contactTextField.setLayoutX(800);
contactTextField.setLayoutY(250);
contactTextField.setFont(Font.font("calibiri", 20));
contactTextField.setPromptText("Contact");

deptLabel.setLabelFor(deptChoiceBox);
deptLabel.setFont(Font.font("calibiri", 30));
deptLabel.setTextFill(Paint.valueOf("white"));

degreeLabel.setFont(Font.font("calibiri", 30));
degreeLabel.setTextFill(Paint.valueOf("white"));

degreeLabel.setLabelFor(degreeChoiceBox);
deptLabel.setLayoutX(40);
degreeLabel.setLayoutY(250);
deptLabel.setLayoutY(250);
deptChoiceBox.setLayoutX(200);
deptChoiceBox.setLayoutY(255);
degreeLabel.setLayoutX(60);
degreeLabel.setLayoutY(300);
degreeChoiceBox.setLayoutX(200);
degreeChoiceBox.setLayoutY(300);
degreeChoiceBox.setPrefSize(200, 30);
deptChoiceBox.setPrefSize(200, 30);

addressLabel.setLabelFor(addressTextField);
addressLabel.setLayoutX(40);
addressLabel.setLayoutY(350);
addressLabel.setFont(Font.font("calibiri", 30));
addressLabel.setTextFill(Paint.valueOf("white"));
addressTextField.setLayoutX(200);
addressTextField.setLayoutY(350);
addressTextField.setPromptText("Address");
addressTextField.setPrefSize(500, 40);
addressTextField.setFont(Font.font("calibiri", 20));
submit.setLayoutX(300);
submit.setLayoutY(550);
submit.setPrefSize(500, 30);
///////////


///// adding photo to image view
 photoFile = new File("src/abc/jk.jpg");
Image img= new Image(photoFile.toURI().toString());
imgView.setImage(img);
imgView.setFitHeight(270);
imgView.setFitWidth(255);
imgView.setLayoutX(1030);
imgView.setLayoutY(50);
/////////////////////


/// adding choice in choice box

deptChoiceBox.getItems().add(0, "Department of Business Admin");
    System.out.println("Business aDmin added");
deptChoiceBox.getItems().add(1, "Department of Computer Science");
deptChoiceBox.getItems().add(2, "Department of Electrical Engin");
deptChoiceBox.getItems().add(3, "Department of Education");
deptChoiceBox.getItems().add(4, "Department of Mathematics");


//////////////////////

//Event handler
back.setOnAction(new EventHandler<ActionEvent>(){
public void handle(ActionEvent e){
    Adminnnnnnnnn ad= new Adminnnnnnnnn();
    Stage s= new Stage();
    ad.start(s);
    stg.hide();
    
    
    
}

});
deptChoiceBox.setOnAction(new EventHandler<ActionEvent>(){
public void handle(ActionEvent e){
    if(deptChoiceBox.getValue().equals("Department of Computer Science")){
        degreeChoiceBox.getItems().clear();
        degreeChoiceBox.getItems().add(0, "BS Computer Science");
        degreeChoiceBox.getItems().add(1, "BS Software Engineering");
    }
    else  if(deptChoiceBox.getValue().equals("Department of Business Admin")){
        System.out.println("Business admin clicked");      degreeChoiceBox.getItems().clear();
        degreeChoiceBox.getItems().add(0, "BBA");
        degreeChoiceBox.getItems().add(1, "MBA");
    }
    else if(deptChoiceBox.getValue().equals("Department of Electrical Engin"))
    { degreeChoiceBox.getItems().clear();
        degreeChoiceBox.getItems().add(0, "BE");}
        
    
    else if(deptChoiceBox.getValue().equals("Department of Education"))
    {degreeChoiceBox.getItems().clear();  degreeChoiceBox.getItems().add(0, "B.Ed");}
        
    
    else if(deptChoiceBox.getValue().equals("Department of Mathematics"))
    { degreeChoiceBox.getItems().clear();        degreeChoiceBox.getItems().add(0, "BS Mathematics");}
        
    
}

});
       imgView.setOnDragEntered(new EventHandler <DragEvent>(){
       public void handle(DragEvent e){
           System.out.println("drag entered");
         imgView.setOpacity(0.3);
       }
      
           
            
       });
       
       ///////////////////////////////////////////////////////////
   
       imgView.setOnDragDropped(new EventHandler <DragEvent>(){
       public void handle(DragEvent e){
          System.out.println("drag Dropped");
                 db=e.getDragboard();
      
   photoFile= db.getFiles().get(0);
   Image photoImg = new Image(photoFile.toURI().toString());
   imgView.setImage(photoImg);
   imgView.setOpacity(1);
       }
      
           
           
       }); ///////////////////////////////////////
       
       
       ////////////////////////////////////////////
       
imgView.setOnDragOver(new EventHandler<DragEvent>(){
public void handle(DragEvent e){
e.acceptTransferModes(TransferMode.ANY);
    System.out.println("Drag Over");
 
    

}

});
       
       ////////////////////////////////////////////////
       imgView.setOnDragExited(new EventHandler <DragEvent>(){
       public void handle(DragEvent e){
           
           System.out.println(" Drag Exited");
           imgView.setOpacity(1);
       }
           
           
       });
  
       submit.setOnAction(new EventHandler<ActionEvent>(){
       public void handle(ActionEvent e) {
           String cmsID=cmsIDTextField.getText();
           String password=passwordTextField.getText();
           String name=fullNameTextField.getText();
           String fatherName=fatherNameTextField.getText();
           String dept= deptChoiceBox.getValue().toString();
           String degree= degreeChoiceBox.getValue().toString();
           String contact=contactTextField.getText();
           String address= addressTextField.getText().toString();
           imgView.getImage();
           
           if(cmsIDTextField.getText().trim().isEmpty() || passwordTextField.getText().trim().isEmpty() || fullNameTextField.getText().trim().isEmpty() || fatherNameTextField.getText().trim().isEmpty() || contactTextField.getText().trim().isEmpty() || addressTextField.getText().trim().isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please fill all text fields");
            }
           else if(cmsIDTextField.getText().length() != 11)
           {
                JOptionPane.showMessageDialog(null,"there should be 11 characters in CMS-ID");
           }
           else
           {
           
           try{
           
Connection con;
           
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campus_data","root","its@pass1");
    
        System.out.println("connection established");

String sql2="INSERT INTO student(cmsID,pass,stname,fName,Department,Degree,Address,contact,university,photo) values(?,?,?,?,?,?,?,?,?,?)";

System.out.println("Insertion happened");

PreparedStatement pStmt=con.prepareStatement(sql2);
pStmt.setString(1, cmsID);
pStmt.setString(2, password);
pStmt.setString(3, name);
pStmt.setString(4, fatherName);
pStmt.setString(5, dept);
pStmt.setString(6, degree);
pStmt.setString(7, address);
pStmt.setString(8, contact);
pStmt.setString(9, "Sukkur IBA University");

InputStream iStream = new FileInputStream(photoFile);
pStmt.setBinaryStream(10, iStream,(int)photoFile.length());
pStmt.execute();


//stmt.execute(sql);


JOptionPane.showMessageDialog(null, name+" successfully enrolled in "+degree+" of "+dept+" ", "Success", JOptionPane.INFORMATION_MESSAGE);
con.close();
pStmt.close();
submit.setDisable(true);
           }
           catch(ClassNotFoundException exe){exe.printStackTrace();}
           catch(SQLException exep){
               System.out.println("Exception handling.......");
               JOptionPane.showMessageDialog(null,"CMS-ID can not be duplicate...");
           }
           catch(FileNotFoundException exepo){exepo.printStackTrace();}
       }
       }
       
       });

////


stg.setTitle("Student Enrollment Form");
      stg.setScene(scene);
        stg.show();

    
    
}    

}
