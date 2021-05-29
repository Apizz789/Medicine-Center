package Medicine.FrontEnd;

import Medicine.BackEnd.API;
import Medicine.BackEnd.BSymptom;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Symptom {

    Stage body = new Stage();

    String output = "";
    Button back = new Button("back");
    BorderPane U1Pane = new BorderPane();
    HBox CB = new HBox(10);

    StackPane SYMStackPane = new StackPane();
    StackPane Bgsym = new StackPane();

    public Symptom(Stage primary) throws FileNotFoundException {

        Button btn = new Button("Click to result");
        

        try {
            back.setAlignment(Pos.BOTTOM_CENTER);
            back.setPrefWidth(150);
            btn.setPrefWidth(150);
            back.setStyle("-fx-background-color:rgb(250, 144, 5) ; -fx-border-color: black;");  //ส้ม
            back.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Symptom.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.body.setOnHidden((e) -> {
            this.body.hide();
            primary.show();
        });

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);

        pane.setAlignment(Pos.CENTER);
        List<CheckBox> listCB = new ArrayList<>();

//        pane.add(back, 0, 11, 3, 1);
        int index = 0;

        CheckBox cb = new CheckBox(String.format("ปวดหัว"));
        listCB.add(cb);
        pane.add(cb, 1, 0);

        CheckBox cb1 = new CheckBox(String.format("ปวดท้อง"));
        listCB.add(cb1);
        pane.add(cb1, 2, 0);

        CheckBox cb2 = new CheckBox(String.format("ผื่นคัน"));
        listCB.add(cb2);
        pane.add(cb2, 1, 1);

        CheckBox cb3 = new CheckBox(String.format("ท้องเสีย"));
        listCB.add(cb3);
        pane.add(cb3, 2, 1);

        CheckBox cb4 = new CheckBox(String.format("เวียนศีรษะ "));
        listCB.add(cb4);
        pane.add(cb4, 1, 2);

        CheckBox cb5 = new CheckBox(String.format("อาเจียน"));
        listCB.add(cb5);
        pane.add(cb5, 2, 2);

        CheckBox cb6 = new CheckBox(String.format("มีไข้"));
        listCB.add(cb6);
        pane.add(cb6, 1, 3);

        CheckBox cb7 = new CheckBox(String.format("เจ็บคอ"));
        listCB.add(cb7);
        pane.add(cb7, 2, 3);

        CheckBox cb8 = new CheckBox(String.format("คัดจมูก"));
        listCB.add(cb8);
        pane.add(cb8, 1, 4);

        CheckBox cb9 = new CheckBox(String.format("แน่นหน้าอก"));
        listCB.add(cb9);
        pane.add(cb9, 2, 4);

        //  P:\Project_JAVA_Medicine\src\Medicine\FrontEnd\Fonts\Serithai-Regular.ttf
        cb.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        cb1.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        cb2.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        cb3.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        cb4.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        cb5.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        cb6.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        cb7.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        cb8.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        cb9.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));

        btn.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));

        btn.setStyle("-fx-background-color:rgb(147, 216, 237) ; -fx-border-color: black;"); //147, 216, 237

        ImageView imgg = new ImageView(new Image(new FileInputStream(new File("src/Medicine/FrontEnd/Images/BG_PAGE.png"))));
        ImageView bgSym = new ImageView(new Image(new FileInputStream(new File("src/Medicine/FrontEnd/Images/BG_PAGE.png"))));
        SYMStackPane.getChildren().add(imgg);
        Bgsym.getChildren().add(bgSym);

        btn.setOnAction(((t) -> {
            for (CheckBox x : listCB) {
                if (x.isSelected()) {
                    output += String.format(" %s", x.getText());

                }
            }
            String s = Register.getusrname();
            BSymptom st = new BSymptom(output, s);

            API.addSymptom(st);
            System.out.println("Result : " + output);
            System.out.println(API.getAllSymptom());

            this.body.hide();
            primary.show();
        }));
        back.setOnAction((ActionEvent ex) -> {
            this.body.hide();
            primary.show();
        });

        pane.setAlignment(Pos.CENTER);
        pane.add(btn, 5, 11, 3, 1);
        pane.add(back, 1, 11, 5, 1);


        SYMStackPane.getChildren().add(pane);

        U1Pane.setCenter(SYMStackPane);
        U1Pane.setTop(GLOBALBAR(primary));
        Scene scene = new Scene(U1Pane, 700, 650);

        this.body.setScene(scene);

    }

    public void show() {
        this.body.show();
    }

public HBox GLOBALBAR(Stage a) {
        HBox loginBar = new HBox();
        loginBar.setStyle("-fx-background-color:rgb(245, 95, 120) ");
        //closeImage.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Medicine/FrontEnd/Images/cancle2.png")));

        try {

            ImageView minImage = new ImageView(new Image(new FileInputStream("src/Medicine/FrontEnd/Images/min1.png")));
            loginBar.getChildren().add(minImage);
            minImage.setOnMouseClicked((t) -> {
                try {
                    ImageView minImage2 = new ImageView(new Image(new FileInputStream("src/Medicine/FrontEnd/Images/min2.png")));
                    loginBar.getChildren().add(minImage2);
                    a.setIconified(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            loginBar.setAlignment(Pos.CENTER_RIGHT);

            ImageView closeImage = new ImageView(new Image(new FileInputStream("src/Medicine/FrontEnd/Images/cancle1.png")));
            ImageView closeImage2 = new ImageView(new Image(new FileInputStream("src/Medicine/FrontEnd/Images/cancle2.png")));
//            closeImage.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Medicine/FrontEnd/Images/min2.png"))); // NOI18N

            loginBar.getChildren().add(closeImage);
            closeImage.setOnMouseClicked((t) -> {

                System.exit(0);
            });
            closeImage.addEventHandler(MouseEvent.MOUSE_MOVED, (MouseEvent t) -> {
                // ImageView closeImage2 = new ImageView(new Image(new FileInputStream("src/Medicine/FrontEnd/Images/cancle2.png")));

                //button.setTextFill(Color.web("#333138"));
            });
            closeImage.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent t) -> {
//             loginBar.getChildren().add(closeImage);

            });
            loginBar.setAlignment(Pos.CENTER_RIGHT);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginBar;
    }

}
