/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.FrontEnd;

import Medicine.BackEnd.*;
import java.io.FileNotFoundException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author USER
 */
public class GUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(API.getAllSymptom());

        Pane pane = new Pane();
        stage.setScene(Setscene(stage));
        stage.centerOnScreen();
        stage.show();
       
    }

    public Scene Setscene(Stage stage) throws FileNotFoundException {
        Register a = new Register(stage);
        
        stage.setTitle("LOGIN_PAGE");
        stage.initStyle(StageStyle.UNDECORATED);
        return a.scene[1];
    }

    public static void main(String[] args) throws InterruptedException {
//        new LOGIN().setVisible(true); 
        API.InitDrugInform();
        launch(args);

    }
}
//***********************************************************************************/
