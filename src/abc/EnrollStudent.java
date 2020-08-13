
package abc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.File;
class EnrollStudent extends Application {
     Button back = new Button("Back");
      private  AnchorPane pane;
private Scene scene ;

      public void start(Stage pStage){
    
   pane = new AnchorPane();
     pane.getChildren().add(0, back);
    File f= new File("src/abc/AdminStyle.css");
    pane.getStylesheets().add(f.toURI().toString());
back.setLayoutX(30);
back.setLayoutY(30);
scene= new Scene(pane, 1300, 695);
        

////// EventHandler
back.setOnAction(new EventHandler<ActionEvent>(){
public void handle(ActionEvent e){
    Adminnnnnnnnn admin= new Adminnnnnnnnn();
    Stage s= new Stage();
    admin.start(s);
    pStage.hide();
    
}


});
//////////// 

pStage.setTitle("New");
        
        pStage.setScene(scene);
        //pStage.show();
    
}

}
