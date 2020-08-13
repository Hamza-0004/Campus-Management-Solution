
package abc;
import java.sql.SQLException;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.net.URISyntaxException;
import javafx.scene.control.ButtonBar;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

 class Adminnnnnnnnn extends Application{
     
    Button btn = new Button("Back");
    Button enrollStdtBut = new Button("Enroll A Student");
    Button showStdtBut = new Button("Show Students");
    Button enrollTeacherBut = new Button("Enroll Teacher");
    Button showTeachersBut = new Button("Show Teachers");
    Button createCourseBut = new Button("Create Course");
Button registerStudentsBut = new Button("Register Students In Courses");

    public void start(Stage pStg){
         System.out.println("admin start");
         // adding componens to anchor pane 
        AnchorPane Apane = new AnchorPane();
        Apane.getChildren().add(0, btn);
        Apane.getChildren().add(1, enrollStdtBut);
        Apane.getChildren().add(2, showStdtBut);
        Apane.getChildren().add(3, enrollTeacherBut);
        Apane.getChildren().add(4, showTeachersBut);
        Apane.getChildren().add(5, createCourseBut);
        Apane.getChildren().add(6, registerStudentsBut);
        
        //// set up dialog
       
        ///////
        
        ////////////////////////////////////////////
        /// aligning the buttons
        enrollStdtBut.setLayoutY(150);
        showStdtBut.setLayoutY(250);
        enrollTeacherBut.setLayoutY(350);
        showTeachersBut.setLayoutY(450);
        
        enrollStdtBut.setLayoutX(250);
        showStdtBut.setLayoutX(250);
        enrollTeacherBut.setLayoutX(250);
        showTeachersBut.setLayoutX(250);
        
        enrollStdtBut.setPrefWidth(500);
        showStdtBut.setPrefWidth(500);
        enrollTeacherBut.setPrefWidth(500);
        showTeachersBut.setPrefWidth(500);
        
        createCourseBut.setLayoutX(250);
        createCourseBut.setLayoutY(550);
        createCourseBut.setPrefWidth(500);
        createCourseBut.setPrefWidth(500);
        
        
        registerStudentsBut.setLayoutX(250);
        registerStudentsBut.setLayoutY(650);
        registerStudentsBut.setPrefWidth(500);
        registerStudentsBut.setPrefWidth(500);

        ///////////////////////
        /////////Event Handlers
        enrollStdtBut.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e){
            System.out.println("enrol student button clicked");
            StudentFormm obj101= new StudentFormm();
            Stage s101= new Stage();
            obj101.start(s101);
            pStg.hide();
        }
        
        });
        
enrollTeacherBut.setOnAction(new EventHandler<ActionEvent>(){
public void handle(ActionEvent e){
    TeacherFormmm tF = new TeacherFormmm();
    Stage s102 = new Stage();
    tF.start(s102);
    
    pStg.hide();
}


});

  btn.setOnMouseClicked(new EventHandler<MouseEvent>(){
     public void handle(MouseEvent e){
         System.out.println("Mouse Clicked");
        AdminHomePageee hp =new AdminHomePageee();
        Stage hStage= new Stage();
        
        hp.start(hStage);
        
        
        pStg.hide();
     }
     
     
     });
        
        
showStdtBut.setOnAction(new EventHandler<ActionEvent>(){
public void handle(ActionEvent e){
    System.out.println("Show students button clicked");
    ShowStudentsssss ss = new ShowStudentsssss();
Stage s0 = new Stage();
try{
ss.start(s0);}catch(ClassNotFoundException ex){ex.printStackTrace();} catch(SQLException exe){exe.printStackTrace();}
    pStg.hide();
}

});
showTeachersBut.setOnAction(new EventHandler<ActionEvent>(){
public void handle(ActionEvent e){
    
    ShowTeacherrrrrr sT = new ShowTeacherrrrrr();
    Stage st = new Stage();
    try{sT.start(st);} catch(ClassNotFoundException ex){ex.printStackTrace();} catch(SQLException exe){exe.printStackTrace();}
    pStg.hide();
}

});
createCourseBut.setOnAction(new EventHandler<ActionEvent>(){
public void handle(ActionEvent e){
    System.out.println("Course Create Button Clicked");
    CreateCourseeeee c = new CreateCourseeeee();
    Stage s108 = new Stage();
    c.start(s108);
    pStg.hide();
}


});


 registerStudentsBut.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e){
            System.out.println("enrol student button clicked");
            RegisterStudentss obj101= new RegisterStudentss();
            Stage s101= new Stage();
            obj101.start(s101);
            pStg.hide();
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



///////////////////
pStg.setTitle("Admin");
        
        pStg.setScene(scenee);
        pStg.show();

        
        
    }
     

     
}
