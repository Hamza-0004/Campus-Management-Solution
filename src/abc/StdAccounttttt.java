
package abc;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.control.ListView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.Event;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

public class StdAccounttttt extends Application{
Button showCourseBut = new Button("Show Course");
int listClickCount=0;    
Button back = new Button("Log Out");
Button changePasswordBut = new Button("Change Password");
PasswordField passTextField = new PasswordField();
Label stdLbl = new Label();
ImageView imgView =  new ImageView();
String accountToOpen="";
ListView courseList = new ListView();

ListView attendenceList = new ListView();
public void start(Stage s) throws ClassNotFoundException,SQLException{
    
    AnchorPane pane = new AnchorPane();
    pane.getChildren().add(0, back);
pane.getChildren().add(1, stdLbl);
pane.getChildren().add(2, imgView);
pane.getChildren().add(3,showCourseBut);
pane.getChildren().add(4,courseList);
pane.getChildren().add(5,attendenceList);
pane.getChildren().add(6,changePasswordBut);
pane.getChildren().add(7,passTextField);
/////////////////////// setup
attendenceList.setVisible(false);

stdLbl.setFont(Font.font("monotype corsiva", 30));
stdLbl.setTextFill(Paint.valueOf("blue"));
stdLbl.setLayoutX(1000);
stdLbl.setLayoutY(40);
imgView.setLayoutX(800);
imgView.setLayoutY(30);
imgView.setFitHeight(180);
imgView.setFitWidth(180);
///////////////
    back.setLayoutX(30);
    back.setLayoutY(30);
    
courseList.setVisible(false);
    showCourseBut.setLayoutX(100);
    showCourseBut.setLayoutY(300);
    showCourseBut.setPrefSize(400, 30);
    courseList.setLayoutX(50);
    courseList.setLayoutY(350);
    courseList.setPrefSize(600, 500);
    
        attendenceList.setLayoutX(100);
    attendenceList.setLayoutY(350);
    attendenceList.setPrefSize(900, 500);
    
    changePasswordBut.setLayoutX(800);
    changePasswordBut.setLayoutY(300);
    
    passTextField.setLayoutX(800);
    passTextField.setLayoutY(400);
    passTextField.setVisible(false);
/////////choice D

     

////


    
    File f = new File("src/abc/AdminStyle.css");
    pane.getStylesheets().add(f.toURI().toString());
    Scene scene= new Scene(pane,1300,695);
    
    /// set the bg
           
       File f2= new File("src/abc/smoggyIba.jpg");
       System.out.println("set new background 111111111111111111111111");
       Image img = new Image(f2.toURI().toString());
       BackgroundImage bImg= new BackgroundImage(img,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
       Background bg= new Background(bImg);
       pane.setBackground(bg);

    
imgView.setImage(img);    
    
    /////////////////
    //// event handler
    back.setOnAction(new EventHandler<ActionEvent>(){
    public void handle(ActionEvent e){
        Homepageeeeeeee obj = new Homepageeeeeeee();
        Stage st = new Stage();
        obj.start(st);
        s.hide();
    }
    
    });
    
    
    /////////////////// retrieving contents from database
                 Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        
Connection    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campus_data?useSSL=false","root","its@pass1");
Statement stmt = con.createStatement();
String sql="select cmsid, stname, fname, department, degree, address, contact,photo from student where cmsid='"+accountToOpen+"'";
    
  ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
    String cmsID=rs.getString("cmsid");
    String name=rs.getString("stname");
    String fName = rs.getString("fname");
    String dept = rs.getString("department");
    String degree = rs.getString("degree");
    String address = rs.getString("address");
    String contact = rs.getString("contact");
           InputStream is;
       OutputStream os;
       ByteArrayOutputStream bos;
        Blob blobFile;
       int length;
       int bufferSize;
        
           // blobFile= rs.getBlob("PHOTO");
        blobFile=rs.getBlob("PHOTO");
        System.out.println("blob got");
        is=  blobFile.getBinaryStream();
        bos = new ByteArrayOutputStream();
        String savedAddress="C://temp.png";
        try{
        os = new FileOutputStream("C://temp.png");
         bufferSize=1024;
        length= (int)blobFile.length();
        
        byte[] buffer = new byte[bufferSize];
         while((length = is.read(buffer)) != -1)
        {
          bos.write(buffer,0,length);
        }
        bos.writeTo(os);

        }catch(IOException e){} 
        File f00=  new File(savedAddress);
        Image img00 = new Image(f00.toURI().toString());
        imgView.setImage(img00);
    stdLbl.setText(name+"\n"+degree);
s.setTitle(name);
}
stmt.close();
con.close(); 
showCourseBut.setOnAction(new EventHandler<ActionEvent>(){
public void handle(ActionEvent e){
       try{
                 Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campus_data?useSSL=false","root","its@pass1");
            System.out.println("Connection established");
  Statement stmt = con.createStatement();
 String sql = "select cid from student_course where sid='"+accountToOpen+"'";
            System.out.println("executinng query");
ResultSet rs = stmt.executeQuery(sql);
            System.out.println("executed 1");
            //////////////////////////////////////
            System.out.println(accountToOpen);
            ///////////////////////////////////////
String courseID="";
// finding course ID

Statement inner = con.createStatement();
while(rs.next()){
     courseID =rs.getString("cid");
    System.out.println(courseID);
     sql = "select cname from course where cid='"+courseID+"'";
     ResultSet rss = inner.executeQuery(sql);
     String courseName = "";
     
     // finding courseName
     while(rss.next()){
         courseName = rss.getString("cname");
         System.out.println("inserting into courseList View");
         courseList.getItems().add(courseID+"     "+courseName);
     }
    
}
 
courseList.setVisible(true);

showCourseBut.setVisible(false);
        }
        catch(ClassNotFoundException ex){}catch(SQLException exc){}
    
courseList.setVisible(true);
    
}

});

    //////////////
   // eventhandler
           
changePasswordBut.setOnAction(new EventHandler<ActionEvent>(){
    public void handle(ActionEvent e){

        passTextField.setVisible(true);
        passTextField.setPromptText("Enter new Password");
        passTextField.setPrefSize(200, 30);
    }

});
passTextField.setOnAction(new EventHandler<ActionEvent>(){
public void handle(ActionEvent e){
    String password = passTextField.getText();
    try{

                 Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campus_data?useSSL=false","root","its@pass1");
            System.out.println("Connection established");
  Statement stmt = con.createStatement();
  String sql = "update student set pass='"+password+"' where cmsid='"+accountToOpen+"'";
  System.out.println("Here I am......... CMSID: "+accountToOpen);
  stmt.executeUpdate(sql);
  System.out.println("working..............");
  JOptionPane.showMessageDialog(null, "password updated", "Updated", JOptionPane.INFORMATION_MESSAGE);
    }
        catch(ClassNotFoundException ex){}catch(SQLException exc){}
}

});    
    
    s.setScene(scene);
    
    s.show();
    
}
    
}
