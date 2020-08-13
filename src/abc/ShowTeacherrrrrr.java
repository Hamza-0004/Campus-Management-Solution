
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
public class ShowTeacherrrrrr extends Application{
Button back = new Button("Back");
ListView teacherList = new ListView();
    public void start(Stage s) throws ClassNotFoundException,SQLException{
        System.out.println("displaying updated teacher list");
        teacherList.getItems().clear();
    AnchorPane pane = new AnchorPane();
    pane.getChildren().add(0, back);
    pane.getChildren().add(0, teacherList);
    back.setLayoutX(30);
    back.setLayoutY(30);
    teacherList.setLayoutX(10);
    teacherList.setLayoutY(70);
    teacherList.setPrefSize(1200,600);
    teacherList.setFixedCellSize(50);
    
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
            teacherList.getItems().add("cmsID           name             fName              dept                 address              contact              designation");
Connection    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campus_data","root","its@pass1");
Statement stmt = con.createStatement();
String sql="select cmsid, tname, fname, department,  address, contact, designation from teacher";
    
  ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
    String cmsID=rs.getString("cmsid");
    String name=rs.getString("tname");
    String fName = rs.getString("fname");
    String dept = rs.getString("department");
    String address = rs.getString("address");
    String contact = rs.getString("contact");
    String designation = rs.getString("designation");

    teacherList.getItems().add(cmsID+"          "+name+"          "+fName+"          "+dept+"             "+address+"          "+contact+"          "+designation);
}
stmt.close();
con.close(); 
    //////////////
    
    s.setScene(scene);
    s.setTitle("Show Teachers");
    s.show();
    
}
    
}
