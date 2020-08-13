
package abc;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javax.swing.JOptionPane;
import javafx.scene.input.Dragboard;
public class TeacherFormmm extends Application{
    
    File photoFile;
    Dragboard db;
    Button back= new Button("Back");
    Label heading= new Label("Teacher Enrollment Form");
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
        
Label addressLabel = new Label("Address");
TextField addressTextField = new TextField();
Button submit =  new Button("Submit");
ImageView imgView = new ImageView();

Label contactLabel = new Label("Contact");
TextField contactTextField = new TextField();
Label designationLabel = new Label("Designation");
ChoiceBox designationChoiceBox = new ChoiceBox();
private AnchorPane pane;
public void start(Stage tStg){
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
       
     pane.getChildren().add(12, addressLabel);
       pane.getChildren().add(13, addressTextField);
       pane.getChildren().add(14, submit);
       pane.getChildren().add(15, imgView);
       
       pane.getChildren().add(16, contactLabel);
       pane.getChildren().add(17, contactTextField);
       pane.getChildren().add(18, designationLabel);
       pane.getChildren().add(19, designationChoiceBox);

       pane.setStyle("-fx-background-color: indigo;");
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
passwordTextField.setEditable(false);
passwordTextField.setOpacity(0.4);
passwordTextField.setMouseTransparent(true);

deptLabel.setLabelFor(deptChoiceBox);
deptLabel.setFont(Font.font("calibiri", 30));
deptLabel.setTextFill(Paint.valueOf("white"));


contactLabel.setFont(Font.font("calibiri", 20));
contactLabel.setTextFill(Paint.valueOf("white"));
contactLabel.setLayoutX(700);
contactLabel.setLayoutY(250);
contactLabel.setLabelFor(contactTextField);
contactTextField.setPromptText("Contact");

contactTextField.setPrefSize(200, 30);
contactTextField.setLayoutX(800);
contactTextField.setLayoutY(250);
contactTextField.setFont(Font.font("calibiri", 20));


designationLabel.setFont(Font.font("calibiri", 20));
designationLabel.setTextFill(Paint.valueOf("white"));
designationLabel.setLayoutX(695);
designationLabel.setLayoutY(300);
designationLabel.setLabelFor(designationChoiceBox);


designationChoiceBox.setPrefSize(200, 30);
designationChoiceBox.setLayoutX(800);
designationChoiceBox.setLayoutY(300);


deptLabel.setLayoutX(40);

deptLabel.setLayoutY(250);
deptChoiceBox.setLayoutX(200);
deptChoiceBox.setLayoutY(255);
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
deptChoiceBox.getItems().add(0, "Department of Business Admin.");
deptChoiceBox.getItems().add(1, "Department of Computer Science");
deptChoiceBox.getItems().add(2, "Department of Electrical Engin");
deptChoiceBox.getItems().add(3, "Department of Education");
deptChoiceBox.getItems().add(4, "Department of Mathematics");


designationChoiceBox.getItems().add(0, "Lecturer");
designationChoiceBox.getItems().add(1, "Assistant Professor");
designationChoiceBox.getItems().add(2, "Associate Professor");

//////////////////////

//EventH handler
back.setOnAction(new EventHandler<ActionEvent>(){
public void handle(ActionEvent e){
    Adminnnnnnnnn ad= new Adminnnnnnnnn();
    Stage s= new Stage();
    ad.start(s);
    tStg.hide();
    
    
    
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
   Image img = new Image(photoFile.toURI().toString());
   imgView.setImage(img);
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
           
           System.out.println(" Drag Extited");
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
           String designation=designationChoiceBox.getValue().toString();
           String contact=contactTextField.getText();
           String address= addressTextField.getText().toString();
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
            Connection con;
           try{
             Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campus_data","root","its@pass1");
        
           System.out.println("connection established");
        
        String sql2="insert into teacher(cmsID,pass,tname,fName,Department,Address,contact,university,designation,photo) values(?,?,?,?,?,?,?,?,?,?)";

           PreparedStatement pStmt = con.prepareStatement(sql2);
        pStmt.setString(1, cmsID);
        pStmt.setString(2, password);
        pStmt.setString(3, name);
        pStmt.setString(4, fatherName);
        pStmt.setString(5, dept);
        pStmt.setString(6, address);
        pStmt.setString(7, contact);
        pStmt.setString(8, "Sukkur IBA University");
        pStmt.setString(9, designation);
InputStream iStream = new FileInputStream(photoFile);
pStmt.setBinaryStream(10, iStream,(int)photoFile.length());

pStmt.execute();


JOptionPane.showMessageDialog(null, name+" successfully enrolled in  "+dept+" as "+designation, "Success", JOptionPane.INFORMATION_MESSAGE);

con.close();
pStmt.close();
submit.setDisable(true);
           }
           catch(ClassNotFoundException exe){exe.printStackTrace();}
           catch(SQLException exep){
               exep.printStackTrace();
               System.out.println("Exception handling.......");
               JOptionPane.showMessageDialog(null,"CMS-ID can not be duplicate...");
           }
           catch(FileNotFoundException exepo){exepo.printStackTrace();}
           
           }
       }
       
       });





////


tStg.setTitle("Teacher Enrollment Form");
      tStg.setScene(scene);
        tStg.show();

    
    
}    

}
