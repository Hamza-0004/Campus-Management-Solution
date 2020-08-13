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
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.text.Font;
/**
 *
 * @author Ahmed Ali
 */
public class Homepageeeeeeee extends Application  {
 

    private AnchorPane homePane;

    private  AnchorPane pane2;
    
    Button studentBut = new Button("Student");
    Button teacherBut = new Button("Teacher");
    Button adminBut = new Button("Admin");
    public void start(Stage primaryStage) {


              
         homePane = new AnchorPane();
         pane2 = new AnchorPane();       


      
     
     
      homePane.getChildren().add(0,pane2);
        //view.setLayoutX(90);
     
        pane2.setLayoutX(400);
        pane2.setLayoutY(10);
       
        //Insets insets= new Insets(110,50,50,50);
       //pane2.setPadding(insets);p
       File aptImg= new File("src/abc/iba-logo.PNG");
       
       Image aptechImg = new Image(aptImg.toURI().toString());
       ImageView aptechView = new ImageView(aptechImg);


       aptechView.setLayoutX(130);
       pane2.getChildren().add(0,aptechView);
       pane2.getChildren().add(1,studentBut);
         pane2.getChildren().add(2,teacherBut);
           pane2.getChildren().add(3,adminBut);

           
           studentBut.setLayoutX(210);
           studentBut.setLayoutY(250);

           teacherBut.setLayoutX(210);
           teacherBut.setLayoutY(350);
           
           adminBut.setLayoutX(210);
           adminBut.setLayoutY(450);
       
       pane2.setPrefSize(500, 690);
       
       pane2.setStyle("-fx-border-radius:50px;");
       
       File f2= new File("C:\\Users\\Ahmed Ali\\Desktop\\sukkur-iba-office.jpg");
       
       Image img = new Image(f2.toURI().toString());
       BackgroundImage bImg= new BackgroundImage(img,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
       Background bg= new Background(bImg);
       homePane.setBackground(bg);
      
       
       pane2.setStyle(" -fx-background-color: rgba(255,255,255,0.6);");
      
        
        
        
        File f= new File("src/abc/style.css");
        homePane.getStylesheets().add(f.toURI().toString());
        Scene scene = new Scene(homePane, 1300, 695);
      
        /// event handler
        adminBut.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e){
            
            AdminHomePageee ahp = new AdminHomePageee();
            Stage s107= new Stage();
            ahp.start(s107);
            primaryStage.hide();
        }
        
        
        });
        studentBut.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e){
            
            StudentHomePageeeee shp = new StudentHomePageeeee();
            Stage s108= new Stage();
            shp.start(s108);
            primaryStage.hide();
        }
        
        
        });
        teacherBut.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e){
            
            TeacherHomePageeee thp = new TeacherHomePageeee();
            Stage s108= new Stage();
            thp.start(s108);
            primaryStage.hide();
        }
        
        
        });
        
        
        
        /////////////////////
        
        
        primaryStage.setTitle("Sukkur IBA University");
        
           primaryStage.setScene(scene);
        primaryStage.show();
      
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
