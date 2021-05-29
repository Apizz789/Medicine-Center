package Medicine.FrontEnd;

import Medicine.BackEnd.*;
import Medicine.BackEnd.Drug;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
// TEst Push by dink

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dunkdink
 */
public class USER extends Application {

    
    ArrayList<String> type = new ArrayList<>();
    List<List<String>> name = new ArrayList<>();

    HBox suggestionBox = new HBox();
    VBox accountBox = new VBox(3);
    VBox gaiyangBox = new VBox(3);

    BorderPane U2Pane = new BorderPane();
    BorderPane U3Pane = new BorderPane();
      Scene sugges = new Scene(U3Pane, 600, 300); 
      
    Button button;

    Button logoutBtn = new Button("Logout");
    Button readDiagBtn = new Button("อ่านข้อความ");
    Button backBtn = new Button("ย้อนกลับ");
    Button deleteBtn = new Button("ลบข้อความ");
    Button gyBtn = new Button("Chat");

    HBox DEL_BACK = new HBox(30);

    VBox Set1 = new VBox(10);
    VBox Set2 = new VBox(10);
    HBox SSet1 = new HBox(100);
    HBox SSet2 = new HBox(20);
    VBox Set3 = new VBox(100);

    StackPane UserStackPane = new StackPane();
    StackPane BgUser = new StackPane();
    
    //.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
    ComboBox cb1 = new ComboBox();
    ComboBox cb2 = new ComboBox();

    ObservableList<String> Type = FXCollections.observableArrayList(cbtype());
    ObservableList<String> Type1 = FXCollections.observableArrayList(cbtype());
    ObservableList<List<String>> Medname = FXCollections.observableArrayList();
    ObservableList<List<String>> Medname1 = FXCollections.observableArrayList();
    ObservableList<List<String>> Medname2 = FXCollections.observableArrayList();
    //  ObservableList<String> count = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "---------------");

    ComboBox typeBox = new ComboBox(Type); //Updatepage Lower cb
    ComboBox typeBox2 = new ComboBox(Type1);
    ComboBox mednameBox = new ComboBox(Medname);
    ComboBox mednameBox2 = new ComboBox(Medname1);
    ComboBox mednameBox3 = new ComboBox(Medname2);
    //comment
    Comment third;

    int first = 0;

    public static void main(String[] args) {
        launch(args);
    }

    public boolean isDuplicate(Drug dg, ArrayList<String> kind) {
        int ch = 0;
        for (int i = 0; i < kind.size(); i++) {
            if (kind.get(i).equals(dg.getKind())) {
                ch = 1;
            }
        }
        if (ch == 1) {
            return true; // duplicate
        } else {
            return false;
        }

    }

    public boolean isDup2(Drug dg, List<String> temp) {
        int ch = 0;
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).equals(dg.getName())) {
                ch = 1;
            }
        }
        if (ch == 1) {
            return true;
        } else {
            return false;
        }

    }

    public ArrayList<String> cbtype() {
        ArrayList<String> type = new ArrayList<>();
        List<List<String>> name = new ArrayList<>();
        String line = new String();
        List<String> temp = new ArrayList<>();
        //  ArrayList chtype = new ArrayList<>();
        int[][] a = new int[50][50];
        int[] chtype = new int[50];
        int first = 0;
        //First Line is type

        ArrayList<Drug> arr = API.getAllDrug();
        for (int i = 0; i < arr.size(); i++) {
            temp.clear();
            System.out.println("LoopI");
            if (first == 0) {
                type.add(arr.get(i).getKind());
                System.out.println("Add First");
                first = 1;
            } else {

//                    System.out.print("Type =  "+type.get(k) + " vs ");
//                    System.out.println("Arr "+i +">>"+ arr.get(i).getKind());
                if (!isDuplicate(arr.get(i), type)) {
                    type.add(arr.get(i).getKind());
                    System.out.println("Added");
                }
            }
            System.out.println(type);
        }
        return type;
    }

    public List<List<String>> cbname() {
        ArrayList<String> type = new ArrayList<>();
        List<List<String>> name = new ArrayList<>();
        String line = new String();
        List<String> temp = new ArrayList<>();
        //  ArrayList chtype = new ArrayList<>();
        int[][] a = new int[50][50];
        int[] chtype = new int[50];
        int first = 0;
        //First Line is type

        ArrayList<Drug> arr = API.getAllDrug();
        for (int i = 0; i < arr.size(); i++) {
            temp.clear();
            System.out.println("LoopI");
            if (first == 0) {
                type.add(arr.get(i).getKind());
                System.out.println("Add First");
                first = 1;
            } else {

//                    System.out.print("Type =  "+type.get(k) + " vs ");
//                    System.out.println("Arr "+i +">>"+ arr.get(i).getKind());
                if (!isDuplicate(arr.get(i), type)) {
                    type.add(arr.get(i).getKind());
                    System.out.println("Added");
                }
            }
            System.out.println(type);
        }
        for (int i = 0; i < type.size(); i++) {
            temp = new ArrayList<>();
            for (int j = 0; j < arr.size(); j++) {
                if (type.get(i).equals(arr.get(j).getKind()) && !isDup2(arr.get(j), temp)) {
                    temp.add(arr.get(j).getName());
                }

                System.out.print("temp= " + temp);

            }
            name.add(temp);

            System.out.println("NAme= " + name);
        }
        return name;
    }

    public void ReadDATA2() {
        String line = new String();
        List<String> temp = new ArrayList<>();
        //  ArrayList chtype = new ArrayList<>();
        int[][] a = new int[50][50];
        int[] chtype = new int[50];
        //int first = 0;
        //First Line is type
        ArrayList<Drug> arr = API.getAllDrug();
        for (int i = 0; i < arr.size(); i++) {
            temp.clear();
            System.out.println("LoopI");
            if (first == 0) {
                type.add(arr.get(i).getKind());
                System.out.println("Add First");
                first = 1;
            } else {

                if (!isDuplicate(arr.get(i), type)) {
                    type.add(arr.get(i).getKind());
                    System.out.println("Added");
                }
            }
            System.out.println(type);
        }
        for (int i = 0; i < type.size(); i++) {
            temp = new ArrayList<>();
            for (int j = 0; j < arr.size(); j++) {
                if (type.get(i).equals(arr.get(j).getKind()) && !isDup2(arr.get(j), temp)) {
                    temp.add(arr.get(j).getName());
                }

                System.out.print("temp= " + temp);

            }
            name.add(temp);

            System.out.println("NAme= " + name);
        }

    }

    @Override
    public void start(Stage userStage) throws Exception { // this is main!
        userStage.initStyle(StageStyle.UNDECORATED);
        userStage.setScene(Setscene(userStage));
        userStage.centerOnScreen();
        userStage.show();

    }

    public Scene Setscene(Stage userStage) throws FileNotFoundException {
        logoutBtn.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        readDiagBtn.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        backBtn.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        deleteBtn.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        gyBtn.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));

        logoutBtn.setMinSize(250, 45);
        readDiagBtn.setMaxSize(250, 45);
        backBtn.setMinSize(250, 45);
        deleteBtn.setMinSize(250, 45);
        gyBtn.setMinSize(250, 45);

        logoutBtn.setAlignment(Pos.CENTER);
        readDiagBtn.setAlignment(Pos.CENTER);
        backBtn.setAlignment(Pos.CENTER);
        deleteBtn.setAlignment(Pos.CENTER);
        gyBtn.setAlignment(Pos.CENTER);

        
        logoutBtn.setStyle("-fx-background-color:rgb(235, 9, 21) ; -fx-border-color: black;");
        readDiagBtn.setStyle("-fx-background-color:rgb(157, 181, 237) ; -fx-border-color: black;"); // 157, 181, 237
        backBtn.setStyle("-fx-background-color:rgb(250, 144, 5) ; -fx-border-color: black;");  //ส้ม
        deleteBtn.setStyle("-fx-background-color:rgb(219, 33, 45) ; -fx-border-color: black;"); // แดง 
        gyBtn.setStyle("-fx-background-color:rgb(147, 216, 237) ; -fx-border-color: black;"); //147, 216, 237
        
         ImageView imglf = new ImageView(new Image(new FileInputStream(new File("src/Medicine/FrontEnd/Images/BG_PAGE.png"))));       
         ImageView bgUs = new ImageView(new Image(new FileInputStream(new File("src/Medicine/FrontEnd/Images/BG_PAGE.png"))));
           UserStackPane.getChildren().add(imglf);
            BgUser.getChildren().add(bgUs);
        
        //INSERT TOP LEFT BOTTON RIGHT
//        logoutBtn.setBorder(new Insets(10));
        Symptom sym = new Symptom(userStage);

        userStage.setResizable(false);
        cb1.getItems().clear();
        third = new Comment(userStage);
        ReadDATA2(); // Call Function
        userStage.setTitle("Pharmacy Information System");
//          cb1.getItems().clear();
//          cb1.getItems().addAll(cbtype());
        Button button = new Button();
        button.setText("Ctegory1");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Click! 1");
            }
        });

        Button button2 = new Button("ดูข้อมูลของยา");  // 142 143 232
        Button button4 = new Button("สอบถามอาการเบื้องต้น");  //

        button2.setMinSize(250, 45);
        button2.setAlignment(Pos.CENTER); //
        
         button2.setStyle("-fx-background-color:rgb(217, 43, 191) ; -fx-border-color: black;");
        button4.setStyle("-fx-background-color:rgb(145, 147, 235) ; -fx-border-color: black;");
        
        button4.setMinSize(250, 45);
       
        button4.setAlignment(Pos.CENTER);

        button2.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        button4.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));


        cb1.setMinSize(250, 45);
        cb2.setMinSize(250, 45);

        cb1.setPromptText("เลือกประเภทยา");
        cb2.setPromptText("เลือกยา");

        cb1.setStyle("-fx-background-color:rgb(217, 43, 191) ; -fx-border-color: black;");
        cb2.setStyle("-fx-background-color:rgb(217, 43, 191) ; -fx-border-color: black;");
        
        cb1.setStyle("-fx-font: 18px \"Serithai-Regular.ttf\";");
        cb2.setStyle("-fx-font: 18px \"Serithai-Regular.ttf\";");

        cb1.getItems().addAll(cbtype());

        Set1.getChildren().clear();
        Set1.getChildren().addAll(cb1, cb2, button2);
        Set1.setAlignment(Pos.CENTER);

        Set2.getChildren().clear();
        Set2.getChildren().addAll(button4, readDiagBtn, gyBtn);
        Set2.setAlignment(Pos.CENTER);

        SSet1.getChildren().clear();
        SSet1.getChildren().addAll(Set1, Set2);
        SSet1.setAlignment(Pos.CENTER);

        logoutBtn.setAlignment(Pos.CENTER);
        SSet2.getChildren().clear();
        SSet2.getChildren().add(logoutBtn);
        SSet2.setAlignment(Pos.CENTER);


        Set3.getChildren().clear();
        Set3.getChildren().addAll(SSet1, SSet2);
        Set3.setAlignment(Pos.TOP_CENTER);

        BorderPane layout = new BorderPane();
        

        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(Set3);

        //INSERT TOP LEFT BOTTON RIGHT
//        VBox.setMargin(cb1, new Insets(10, 10, 5, 0)); // set Margin btn1
//        VBox.setMargin(cb2, new Insets(10, 10, 5, 0)); // set Margin btn2

        vbox.setAlignment(Pos.CENTER);
        
        UserStackPane.getChildren().add(vbox);
        layout.setCenter(UserStackPane);
        layout.setTop(GLOBALBAR(userStage));
        

        Scene scene = new Scene(layout, 700, 650);
        userStage.setScene(scene);
        //userStage.show();

        //Event zone
        cb1.setOnAction(new EventHandler<ActionEvent>() { // if cb1 change value = change value in cb 2 ...
            @Override
            public void handle(ActionEvent e) {
                cb2.getItems().clear(); // Clear old member
                int index = type.indexOf(cb1.getValue()); // Find index of (A,B,C) in type

                cb2.getItems().addAll(cbname().get(index)); // it mean name[i] -> but use .get(i)
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (cb1.getValue() != null && cb2.getValue() != null) {
                    System.out.println(String.format("Select %s -> %s", cb1.getValue(), cb2.getValue()));
                    // API.InitDrugInform();
                    String s = String.format("%s", cb2.getValue());
                    System.out.println(API.getCustom("Drugs"));
                    System.out.println(s);
                    int index = Drug.getIdxDrug(s);
                    Drug dg = Database.getDrug().get(index);
                    System.out.println(dg);
                    System.out.print("price = " + dg.getPrice());

                
                    final Stage dialog = new Stage();

                    dialog.initModality(Modality.APPLICATION_MODAL);
                    dialog.initOwner(userStage);
                    VBox dialogVbox = new VBox(20);

                      Label lL = new Label();
                    lL.setText(String.format("\n\n\n      Kind : %s\n\n      Name : %s\n\n      Description : %s\n\n      Price : %s\n", dg.getKind(), dg.getName(), dg.getDescription(), dg.getPrice()));
                    lL.setWrapText(true);
                    lL.setMaxWidth(750);
                    lL.setAlignment(Pos.CENTER_LEFT);
                    try {
                        lL.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(USER.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    dialogVbox.getChildren().add(lL);
                    // dialogVbox.getChildren().add(textshow);
                    
                    U2Pane.setCenter(dialogVbox);
                    U2Pane.setTop(GLOBALBAR(dialog));
                    Scene dialogScene = new Scene(U2Pane, 650, 250);
                    
                    dialog.setScene(dialogScene);
                    dialog.show();
                } else {
                    System.out.println("Error!");
                }
            }
        });

        button4.setOnAction((ActionEvent ex) -> {
            sym.show();
            userStage.hide();
        });

        deleteBtn.setOnAction((ActionEvent ex) -> { /// admin
            try {
                User us = User.getById(Register.usrname);
                String l = Register.usrname;
                Text a = new Text();
                Database db = new Database();
                db.setFile("Suggestions");
                ArrayList<Suggestion> arr = API.getAllSug();
                System.out.println("arr>>");
                System.out.println(arr);
                System.out.println("<<");
                db.write(null);
                suggestionBox.getChildren().clear();
                accountBox.getChildren().clear();
                gaiyangBox.getChildren().clear();
                int t = arr.size();
                for (int i = arr.size() - 1; i >= 0; i--) {
                    //System.out.println("Name="+name);
                    if (arr.get(i).getReceiver().equals(l)) {
                        System.out.println("First");
                        arr.remove(i);
                    }
                }
                db.write(arr);
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i).getReceiver().equals(l)) {

                        a.setText(arr.get(i).getMessage());
                        // suggestionBox.getChildren().addAll(new Text(arr.get(i).getMessage()));
                    }
                }
                System.out.println(arr);
                Text t1 = new Text(String.format("ชื่อ : %s\nนามสกุล : %s\nอายุ : %s\nเพศ : %s", us.getFirstName(), us.getLastName(), us.getAge(), us.getGender()));
                t1.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));

                accountBox.getChildren().add(t1);

                Text t2 = new Text("คำแนะนำจากเภสัชกร : ");
                t2.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));

                DEL_BACK.getChildren().clear();
                DEL_BACK.getChildren().addAll(deleteBtn, backBtn);
                gaiyangBox.getChildren().clear();
                gaiyangBox.getChildren().addAll(accountBox, t2, a, DEL_BACK);
                gaiyangBox.setAlignment(Pos.CENTER);
                suggestionBox.getChildren().clear();
                suggestionBox.getChildren().addAll(gaiyangBox);
                suggestionBox.setAlignment(Pos.CENTER);

            } catch (FileNotFoundException ex1) {
                Logger.getLogger(USER.class.getName()).log(Level.SEVERE, null, ex1);
            }
        });

        backBtn.setOnAction((ActionEvent ex) -> {
            userStage.setScene(scene);
        });

        
        
        
        
        
        
        readDiagBtn.setOnAction((ActionEvent ex) -> {
            try {
                User us = User.getById(Register.usrname);

                String name = Register.getusrname();
                String ms = new String();
                for (int i = 0; i < API.getAllSug().size(); i++) {
                    if (API.getAllSug().get(i).getReceiver().equals(name)) {
                        ms = API.getAllSug().get(i).getMessage();
                    }
                }
                System.out.println(ms);
                suggestionBox.getChildren().clear();
                accountBox.getChildren().clear();
                gaiyangBox.getChildren().clear();
                DEL_BACK.getChildren().clear();
                
                
                Text t1 = new Text(String.format("ชื่อ : %s\nนามสกุล : %s\nอายุ : %s\nเพศ : %s", us.getFirstName(), us.getLastName(), us.getAge(), us.getGender()));
                
                t1.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));

                try {
                    t1.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
                } catch (FileNotFoundException ex1) {

                }

                accountBox.getChildren().add(t1);

                Text t2 = new Text("คำแนะนำจากเภสัชกร : "+ms);
                t2.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));

                
                DEL_BACK.getChildren().addAll(deleteBtn, backBtn);
                
                gaiyangBox.getChildren().addAll(accountBox, t2, DEL_BACK);
                gaiyangBox.setAlignment(Pos.CENTER);

              
                suggestionBox.getChildren().addAll(gaiyangBox);
                suggestionBox.setAlignment(Pos.CENTER);

                
                U3Pane.setCenter(suggestionBox);
                U3Pane.setTop(GLOBALBAR(userStage));
                

                userStage.setScene(sugges);

            } catch (FileNotFoundException ex1) {
                Logger.getLogger(USER.class.getName()).log(Level.SEVERE, null, ex1);

            }

        });

        return scene;

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
