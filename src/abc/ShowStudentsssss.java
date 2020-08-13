
package abc;
import java.io.File;
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
public class ShowStudentsssss extends Application{
Button back = new Button("Back");
ListView studentList = new ListView();
    public void start(Stage s) throws ClassNotFoundException,SQLException{
studentList.getItems().clear();
        
    AnchorPane pane = new AnchorPane();
    pane.getChildren().add(0, back);
    pane.getChildren().add(0, studentList);
    back.setLayoutX(30);
    back.setLayoutY(30);
    studentList.setLayoutX(10);
    studentList.setLayoutY(70);
    studentList.setPrefSize(1200,600);
    studentList.setFixedCellSize(50);
    
    pane.setStyle("-fx-background-color: indigo;");
    File f = new File("src/abc/AdminStyle.css");
    pane.getStylesheets().add(f.toURI().toString());
    Scene scene= new Scene(pane,1300,695);
    //// event handler
    back.setOnAction(new EventHandler<ActionEvent>(){
    public void handle(ActionEvent e){
        Adminnnnnnnnn obj = new Adminnnnnnnnn();
        Stage st = new Stage();
        obj.start(st);
        s.hide();
    }
    
    });
    
    
    /////////////////// retrieving contents from database
    Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        studentList.getItems().add("cmsID            name             fName             dept             degree             address             contact");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campus_data","root","its@pass1");
Statement stmt = con.createStatement();
String sql="select cmsid, stname, fname, department, degree, address, contact from student";

  ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
    String cmsID=rs.getString("cmsid");
    String name=rs.getString("stname");
    String fName = rs.getString("fname");
    String dept = rs.getString("department");
    String degree = rs.getString("degree");
    String address = rs.getString("address");
    String contact = rs.getString("contact");
    studentList.getItems().add(cmsID+"          "+name+"          "+fName+"          "+dept+"          "+degree+"          "+address+"          "+contact);
}
stmt.close();
con.close();
    //////////////
    
    s.setScene(scene);
    s.setTitle("Show Students");
    s.show();
    
}
    
}
