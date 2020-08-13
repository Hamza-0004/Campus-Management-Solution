
package abc;
import javafx.event.Event;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.control.PasswordField;
import javax.swing.JOptionPane;
public class TeacherAccounttttt extends Application{

    int listClickCount=0;
            Connection con;
Statement stmt;
    Button back = new Button("Log Out");
Label teacherLbl = new Label();
ImageView imgView =  new ImageView();
String accountToOpen="";
Button showCourseBut =  new Button("Show My Courses");
ListView courseList = new ListView();
Button changePasswordBut = new Button("Change Password");
PasswordField passTextField = new PasswordField();
public void start(Stage s) throws ClassNotFoundException,SQLException{
    
    AnchorPane pane = new AnchorPane();
    pane.getChildren().add(0, back);
pane.getChildren().add(1, teacherLbl);
pane.getChildren().add(2, imgView);
pane.getChildren().add(3, showCourseBut);
pane.getChildren().add(4, courseList);
pane.getChildren().add(5, changePasswordBut);
pane.getChildren().add(4, passTextField);

courseList.setVisible(false);

    changePasswordBut.setLayoutX(800);
    changePasswordBut.setLayoutY(300);
    
    passTextField.setLayoutX(800);
    passTextField.setLayoutY(400);
    passTextField.setVisible(false);
///// choice d


////////////

/////////////////////// setup
teacherLbl.setFont(Font.font("monotype corsiva", 30));
teacherLbl.setTextFill(Paint.valueOf("blue"));
teacherLbl.setLayoutX(1000);
teacherLbl.setLayoutY(40);
imgView.setLayoutX(800);
imgView.setLayoutY(30);
imgView.setFitHeight(180);
imgView.setFitWidth(180);
///////////////
    back.setLayoutX(30);
    back.setLayoutY(30);
    showCourseBut.setLayoutX(100);
    showCourseBut.setLayoutY(300);
    showCourseBut.setPrefSize(400, 30);
    courseList.setLayoutX(50);
    courseList.setLayoutY(350);
    courseList.setPrefSize(600, 500);
    
    File f = new File("src/abc/AdminStyle.css");
    pane.getStylesheets().add(f.toURI().toString());
    Scene scene= new Scene(pane,1300,695);
    
    /// set the bg
           
       File f2= new File("src/abc/smoggyIba.jpg");
       
       Image img = new Image(f2.toURI().toString());
       BackgroundImage bImg= new BackgroundImage(img,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
       Background bg= new Background(bImg);
       pane.setBackground(bg);

    
imgView.setImage(img);    
    
    /////////////////
   
    
    /////////////////// retrieving contents from database
    
                 Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        
Connection    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campus_data?useSSL=false","root","its@pass1");
Statement stmt = con.createStatement();
String sql="select cmsid, tname, fname, department,  address, contact,designation,photo from teacher where cmsid='"+accountToOpen+"'";
    
  ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
    String cmsID=rs.getString("cmsid");
    String name=rs.getString("tname");
    String fName = rs.getString("fname");
    String dept = rs.getString("department");
    String designation = rs.getString("designation");
    String address = rs.getString("address");
    String contact = rs.getString("contact");
    
//studentList.getItems().add(cmsID+"          "+name+"          "+fName+"          "+dept+"          "+degree+"          "+address+"          "+contact);
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
        String savedAddress="D://temp.png";
        try{
        os = new FileOutputStream("D://temp.png");
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

teacherLbl.setText(name+"\n"+designation);
    s.setTitle(name);
}
 //// event handler
    back.setOnAction(new EventHandler<ActionEvent>(){
    public void handle(ActionEvent e){
        Homepageeeeeeee obj = new Homepageeeeeeee();
        Stage st = new Stage();
        obj.start(st);
        s.hide();
    }
    
    });
    showCourseBut.setOnAction(new EventHandler<ActionEvent>(){
    public void handle(ActionEvent e){
        try{
                 Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campus_data?useSSL=false","root","its@pass1");
            System.out.println("Connection established");
  Statement stmt = con.createStatement();
 String sql = "select cid from course_teacher where tid='"+accountToOpen+"'";
            System.out.println("executinng query");
ResultSet rs = stmt.executeQuery(sql);
            System.out.println("executed");
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
        
        
    }
    
    
    });
           
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
  String sql = "update teacher set pass='"+password+"' where cmsid='"+accountToOpen+"'";
  stmt.executeUpdate(sql);
  JOptionPane.showMessageDialog(null, "password updated", "Updated", JOptionPane.INFORMATION_MESSAGE);
    }
        catch(ClassNotFoundException ex){}catch(SQLException exc){}
}

});    
          

    s.setScene(scene);
    
    s.show();
    
}
    
}
