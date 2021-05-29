/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.FrontEnd;

import Medicine.BackEnd.*;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public final class Register extends Application {

    boolean check, np;
    int i = 0, p = 0, o;
    VBox LogInpage = new VBox(15);

    BorderPane loginPane = new BorderPane();
    StackPane LoginStackPane = new StackPane();
    StackPane BgRegi = new StackPane();

    VBox Registerpage = new VBox(5);
    HBox Registerpage2 = new HBox(5);

    BorderPane REGIS_P = new BorderPane();

    HBox NameBox = new HBox(200);
    HBox PWBox = new HBox(200);

    HBox TextBox = new HBox(70);

    VBox Na = new VBox(14);

    DropShadow ds = new DropShadow();
    
    HBox Hchat = new HBox();

    String ka, kb = "---------------- รักษาสุขภาพกันด้วยนะทุกคน ---------------- \n"
            +              "                                        Medicine Center                                \n";
    public static String usrname = new String();

    VBox Error_Page = new VBox(200);
    VBox NameBox2 = new VBox(200);
    HBox BackBox = new HBox(20);

    Button next = new Button("OK");

    HBox B1 = new HBox(30);

    Text filllogin = new Text(" ~ LOGIN ~");
    Text fillregister = new Text(" ~ REGISTER ~");

    TextField fillName = new TextField();
    TextField fillPW = new PasswordField();

    Button back = new Button("back");

    ScrollPane sp = new ScrollPane();

    private Text[] alltext;
    private Button[] allbutton;
    Scene[] scene;
    VBox[] Row;
    TextField[] allfill;
    HBox[] Column;

    ObservableList<String> options = FXCollections.observableArrayList("Admin", "User");
    ObservableList<String> Registorr = FXCollections.observableArrayList("Admin", "User");
    ObservableList<String> gender = FXCollections.observableArrayList("MALE", "FEMALE");

    ComboBox comboBox = new ComboBox(options);
    ComboBox comboBox2 = new ComboBox(Registorr);
    ComboBox genderBox = new ComboBox(gender);

    //set all scene//   
    Scene s1 = new Scene(loginPane, 700, 650);
    Scene s2 = new Scene(Error_Page, 700, 650);
    Scene s3 = new Scene(REGIS_P, 700, 670);

    /////////////////////////////////////////////////////////////
    /////////////setting for scene///////////////////////////////
    //Create starting page//
    Register(Stage a) throws FileNotFoundException {

        /*-------------------------------------------------------*/
        // HBox.setMargin(fillName, new Insets(5));
        fillName.setMinSize(220, 10);
//        fillName.setPadding(new Insets(10, 0, 5, 0));
        fillName.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));

        fillPW.setMinSize(200, 10);

        fillPW.setFont(new Font("Serithai-Regular", 18));
        fillPW.setStyle("-fx-echo-char: *;");

        next.setMinWidth(150);
            next.setStyle("-fx-background-color:rgb(196, 95, 232) ; -fx-border-color: black;");
                    buttonEffect(next);
        //        fillPW.setPadding(new Insets(10, 0, 5, 0));
        // fillPW.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")),18));
        //    fillName.setPromptText("asd");
        //  LogInpage.setStyle("-fx-background-image:url(\"src/Medicine/FrontEnd/Images/bg.png\");");
        //LogInpage.setStyle("-fx-background-color:rgb(51,51,51) ");
        // LogInpage.setPrefSize(600, 800);
        //     next.setMaxSize(120, 60); // linear-gradient(#042A5A, #0B509B)
        // next.setStyle("-fx-background-color :linear-gradient(#042A5A,#0B509B); -fx-text-fill: red;-fx-border-color: black;");
        try {
            next.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 15));
            next.setAlignment(Pos.CENTER);
            //  fillName.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Anantason-Regular.ttf")), 10));
            //   ImageView imgv = new ImageView(new Image(new FileInputStream(new File("src/Medicine/FrontEnd/Images/GIF1.gif"))));
//             ImageView imgv = new ImageView(new Image(new FileInputStream(new File("src/Medicine/FrontEnd/Images/GIF1.gif"))));
            ImageView imglf = new ImageView(new Image(new FileInputStream(new File("src/Medicine/FrontEnd/Images/BG_LOGG.png"))));
            // LogInpage.getChildren().add(imgv);

            ImageView bgRg = new ImageView(new Image(new FileInputStream(new File("src/Medicine/FrontEnd/Images/BG_LOGG.png"))));
            LoginStackPane.getChildren().add(imglf);
            BgRegi.getChildren().add(bgRg);

            //loginPane.setLeft(imglf);
        } catch (Exception e) {
            e.printStackTrace();
        }

        settext();
        setVbox();
        settingscene();
        setbut();
        setHbox();
        setTextbox();
        SetErrpage();
        SetRegis(a);
        Admin1 Adminpage = new Admin1();
        TableViewSample table = new TableViewSample();
//<<<<<<< HEAD

        USER Userpage = new USER();
        np = false;
        fillName.setPromptText("YOUR ID");
        fillName.setStyle("-fx-background-color:white;");
        fillName.setAlignment(Pos.CENTER);

        fillPW.setPromptText("YOUR PASSWORD");
        fillPW.setAlignment(Pos.CENTER);
        fillPW.setStyle("-fx-background-color:white;");

        LogInpage.setAlignment(Pos.CENTER);

        NameBox.setAlignment(Pos.CENTER);
        PWBox.setAlignment(Pos.CENTER);

        TextBox.setAlignment(Pos.CENTER);

        allbutton[3].setText("สมัครสมาชิก");
       allbutton[3].setStyle("-fx-background-color:rgb(196, 95, 232) ; -fx-border-color: black;");
         buttonEffect(allbutton[3]);
        allbutton[3].setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 15));
        allbutton[3].setAlignment(Pos.CENTER);
        allbutton[3].setMinWidth(150);
      

// 
//Text t = new Text();
//t.setEffect(ds);
//t.setCache(true);
//t.setX(10.0f);
//t.setY(270.0f);
//t.setFill(Color.RED);
//t.setText("JavaFX drop shadow...");
//t.setFont(Font.font(null, FontWeight.BOLD, 32));
        ds.setOffsetY(7.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
        alltext[1].setEffect(ds);
        alltext[1].setCache(true);
        alltext[1].setText("ยินดีต้อนรับเข้าสู่ระบบ");
        alltext[1].setStrokeWidth(5);
        alltext[1].setFill(Color.rgb(158, 74, 232));
        alltext[1].setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 28));

        alltext[13].setText("");

        alltext[13].setFill(Color.RED);

      
        
        
        NameBox.getChildren().add(fillName);

        PWBox.getChildren().add(fillPW);

        BorderPane LoginBorderPane = new BorderPane();
        TextBox.getChildren().add(alltext[1]);

        B1.getChildren().addAll(next, allbutton[3]);
        B1.setAlignment(Pos.CENTER);
        LogInpage.getChildren().addAll(TextBox, NameBox, PWBox, B1, alltext[13]);
//        LogInpage.setPadding(new Insets(10, 80, 10, 10));
        LogInpage.setMinWidth(385);
        LogInpage.setMinHeight(250);
        LoginBorderPane.setRight(LogInpage);
        LoginStackPane.getChildren().add(LoginBorderPane);

        loginPane.setCenter(LoginStackPane);
        loginPane.setTop(GLOBALBAR(a));

        next.setOnAction((ActionEvent t) -> {
            Person user = (Person) idcheckers();
            // Userpage.cb1.getItems().clear();
            //Userpage.cb1.getItems().addAll(Adminpage.cbtype());
            if (user != null) {
//<<<<<<< HEAD
//                System.out.println(user.getUserName() + " LOGIN ");
////                if (user.getRole().equals("Staff")) {
////                    alltext[13].setText("User welcome");
////                } else {
//=======
                System.out.println(user.getUserName() + " LOGIN " + user.getRole());
                if (user.getRole().equals("User")) {
                    try {
                        usrname = user.getUserName();
                        //      alltext[13].setText("User welcome");
                        a.setScene(Userpage.Setscene(a));
                        System.out.println("Userpage show");
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("error : " + Register.class.getName());
                    }
                } else {
//                    Adminpage.page1.setPrefWidth(300);
                    usrname = user.getUserName();
//>>>>>>> origin/BlxSheep
                    Adminpage.aa.getChildren().clear();
                    Adminpage.aa.getChildren().addAll(Adminpage.page1, Adminpage.ppane);
                    Adminpage.page1.setStyle("-fx-background-color :linear-gradient(#540770,#540770);-fx-border-color: black");
                    Adminpage.ppane.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF);");
                    Adminpage.ppane.setAlignment(Pos.CENTER);
                    a.setScene(Adminpage.admain);
//<<<<<<< HEAD
                }
            } else {
                alltext[13].setText("กรุณาตรวจสอบ ID หรือ PASSWORD อีกครั้ง");
                alltext[13].setEffect(ds);
                alltext[13].setCache(true);
//                alltext[13].setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 26));
                alltext[13].setFont(new Font("Serithai-Regular.", 16));

//=======
//
//                }
//
//            } else {
//                alltext[13].setText("เกิดข้อผิดพลาด กรุณาเช็ค id หรือ password อีกครั้ง");
//>>>>>>> origin/BlxSheep
                Setbacktostartingpage();
            }
        });
        allbutton[3].setOnAction((ActionEvent t) -> {
            a.setScene(scene[3]);
            a.setTitle("Registor_PAGE");
        });
        ///////////////ErrorPage//////////////////
        back.setOnAction((ActionEvent t) -> {
            Setbacktostartingpage();
            a.setScene(scene[1]);
            alltext[13].setText("");
            a.setTitle("LOGIN_PAGE");
        });
        ///////////Registor Page///////////////////
        ////// Back to Loginpage From RegistorPage
        allbutton[5].setOnAction((ActionEvent t) -> {
            Setbacktostartingpage();
            registerclear();
            alltext[12].setText("");
            alltext[13].setText("");
            a.setScene(scene[1]);
            a.setTitle("LOGIN_PAGE");
        });

        allbutton[4].setOnAction((ActionEvent t) -> {
            if (checkpassWord()) {
                for (int i = 1; i < 8; i++) {
                    System.out.println(allfill[i].getText());
                      alltext[12].setText(" Login Success Press Back To Continues ");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("asdasdasd");
                alert.setTitle("TITLE");
                alert.setHeaderText("Header");
                alert.showAndWait();

                }
              
                if (comboBox2.getValue().equals("Admin")) {
                    // Admin st = new Admin(allfill[1].getText(), allfill[2].getText());
                    Admin st = new Admin(allfill[1].getText(), allfill[2].getText(), allfill[4].getText(), allfill[5].getText(), allfill[6].getText(), allfill[7].getText());
                    String s = String.format("%s", genderBox.getValue());
                    st.setGender(s);
                    Authority.registor(st);
                }// get role
                else if (comboBox2.getValue().equals("User")) {
                    //User st = new User(allfill[1].getText(), allfill[2].getText());
                    User st = new User(allfill[1].getText(), allfill[2].getText(), allfill[4].getText(), allfill[5].getText(), allfill[6].getText(), allfill[7].getText());
                    String s = String.format("%s", genderBox.getValue());
                    st.setGender(s);
                    Authority.registor(st);
                }
                System.out.println(comboBox2.getValue());
                registerclear();
            } else {
                alltext[12].setText("เกิดข้อผิดพลาดกรุณาเช็คข้อมูลอีกครั้ง");
                 alltext[12].setEffect(ds);
                alltext[12].setCache(true);
                
            }
//                 << << << < HEAD
//            
// == == == =
            /**
             * ******************************************************************************
             */
        });
        Adminpage.allbutton[1].setOnAction((ActionEvent t) -> {
            // Queue Patient
            String ss = new String();
            ArrayList<String> userName = new ArrayList<>();
            for (int j = 0; j < API.getAllUser().size(); j++) {
                ss = API.getAllUser().get(j).getUserName();
                userName.add(ss);

            }
            Adminpage.refreshshowpatient();
            Adminpage.mednameBox3.getItems().clear();
            Adminpage.mednameBox3.getItems().addAll(userName);
            Adminpage.showpatient();
            Adminpage.l.getChildren().clear();
            Adminpage.l.getChildren().addAll(Adminpage.popo, Adminpage.addq);
            Adminpage.addq.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF);");
            Adminpage.l.setAlignment(Pos.BOTTOM_CENTER);

//                 >>> >>> > origin / BlxSheep
        });
        Adminpage.allbutton[2].setOnAction((ActionEvent t) -> {
            Adminpage.l.getChildren().clear();
            Adminpage.l.getChildren().addAll(Adminpage.popo, Adminpage.updatepage);
            Adminpage.updatepage.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF);");
            Adminpage.l.setAlignment(Pos.BOTTOM_CENTER);
        });
        Adminpage.allbutton[3].setOnAction((ActionEvent t) -> {
//            Adminpage.l.getChildren().clear();
//            Adminpage.l.getChildren().addAll();
//            Adminpage.addpage.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF);");
//            Adminpage.l.setAlignment(Pos.BOTTOM_CENTER);
            a.setScene(table.setScene(a));
            a.setWidth(900);
            a.setHeight(520);
        });
          Adminpage.popo.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 28));
        Adminpage.chatBtn.setOnAction((ActionEvent t) -> {
            Adminpage.l.getChildren().clear();
            Adminpage.l.getChildren().addAll(Adminpage.lineBox, Adminpage.popo);
            Adminpage.addpage.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF);");
            Adminpage.l.setAlignment(Pos.TOP_CENTER);
        });
        Adminpage.allbutton[5].setOnAction((ActionEvent t) -> {
            a.setScene(Adminpage.admain);
        });
        /**
         * *****************************************************************************
         */
//             << << << < HEAD
//        
//    
        //   }
//                == == ==
        //Add to add drug
        Adminpage.allbutton[4].setOnAction((ActionEvent t) -> {
            String name = Adminpage.allfill[1].getText();
            String des = Adminpage.allfill[2].getText();
            String stock = Adminpage.allfill[3].getText();
            String price = Adminpage.allfill[4].getText();
            String kind = Adminpage.allfill[7].getText();
            String exp = Adminpage.allfill[5].getText();
            API.addDrug(new Drug(kind, name, exp, des, price, stock));
            System.out.println(API.getCustom("Drugs"));
            ArrayList<String> arr = Adminpage.cbtype();
            List<List<String>> arr2 = Adminpage.cbname();
            System.out.print("CBTYPE ==  ");
            System.out.print(arr);
            System.out.print("CBNAME==");
            System.out.println(arr2);
            ArrayList<String> Type1 = arr;
            Adminpage.typeBox.getItems().clear();
            Adminpage.typeBox2.getItems().clear();
            Adminpage.typeBox.getItems().addAll(Type1);
            Adminpage.typeBox2.getItems().addAll(Type1);
//                     >>> >>> > origin / BlxSheep
//                            << << << < HEAD

//                    Register() {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////                         == == == =
        });

        Adminpage.allbutton[7].setOnAction((ActionEvent t) -> {
            //clear

            Database db = new Database();
            db.setFile("BSymptoms");
            db.write(null);
            System.out.println(API.getAllAdmin());
            Adminpage.VshowPatient.getChildren().clear();
            Adminpage.VshowPatient.getChildren().add(new Text(String.format("No Older Patient")));
            Adminpage.mednameBox3.setVisibleRowCount(3);
            Adminpage.allbutton[7].setText("Read ALL");
            Adminpage.allbutton[8].setText("Back");
          Adminpage.showpatient();

        });
        //Remove drug
        Adminpage.removeBtn.setOnAction((ActionEvent t) -> {
            String newname = String.format("%s", Adminpage.mednameBox2.getValue());
            // Remove button 
            int index = Drug.getIdxDrug(newname);
            System.out.println(" index >>" + index);
            API.removeDrug(newname);

            ArrayList<String> arx = Adminpage.cbtype();
            List<List<String>> arr2 = Adminpage.cbname();
            System.out.print("CBTYPE ==  ");
            System.out.print(arx);
            System.out.print("CBNAME==");
            System.out.println(arr2);
            ArrayList<String> Type1 = arx;
            Adminpage.typeBox.getItems().clear();
            Adminpage.typeBox2.getItems().clear();
            Adminpage.typeBox.getItems().addAll(Type1);
            Adminpage.typeBox2.getItems().addAll(Type1);
            Userpage.cb1.getItems().clear();
            Userpage.cb1.getItems().addAll(Userpage.cbtype());
//  
  
        
            System.out.println(API.getAllDrug());
        });
        Adminpage.informBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (Adminpage.typeBox2.getValue() != null && Adminpage.mednameBox2.getValue() != null) {
                    System.out.println(String.format("Select %s -> %s", Adminpage.typeBox2.getValue(), Adminpage.mednameBox2.getValue()));
                    //API.InitDrugInform();
                    String s = String.format("%s", Adminpage.mednameBox2.getValue());
                    System.out.println(API.getCustom("Drugs"));
                    System.out.println(s);
                    int index = Drug.getIdxDrug(s);
                    Drug dg = Database.getDrug().get(index);
                    System.out.println(dg);
                    System.out.print("price = " + dg.getPrice());

                    //System.out.println(indx);
                    final Stage dialog = new Stage();
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    dialog.initOwner(a);
                    VBox dialogVbox = new VBox(20);
                    // dialogVbox.getChildren().add(new Text(String.format("Select %s -> %s", cb1.getValue(),cb2.getValue())));
                    dialogVbox.getChildren().add(new Text(String.format("\n      Kind : %s\n\n      Name : %s\n\n      Description : %s\n\n      Price : %s\n\n      Stock : %s\n\n      Expiration Date : %s", dg.getKind(), dg.getName(), dg.getDescription(), dg.getPrice(), dg.getStock(), dg.getExpire())));
                    Scene dialogScene = new Scene(dialogVbox, 700, 200);
                    dialog.setScene(dialogScene);
                    dialog.show();
                } else {
                    System.out.println("Error!");
                }
            }
        });
        Adminpage.allbutton[8].setOnAction((ActionEvent t) -> {
            a.setScene(Adminpage.admain);
        });
        Adminpage.upbackBtn.setOnAction((ActionEvent t) -> {
            a.setScene(Adminpage.admain);
        });

        table.backButton.setOnAction((ActionEvent t) -> {
            a.setScene(Adminpage.admain);
            table.hb.getChildren().clear();
            table.vbox.getChildren().clear();
           a.setWidth(780);
           a.setHeight(700);
             loginPane.setPrefSize(700, 650);
        });
//
        Adminpage.typeBox.setOnAction(new EventHandler<ActionEvent>() { // if cb1 change value = change value in cb 2 ...
            @Override
            public void handle(ActionEvent e) {

                Adminpage.mednameBox.getItems().clear(); // Clear old member
                int index = Adminpage.Type.indexOf(Adminpage.typeBox.getValue()); // Find index of (A,B,C) in type
                // Adminpage.Medname= FXCollections.observableArrayList(Adminpage.cbname());
                System.out.println(Adminpage.cbname());
                Adminpage.mednameBox.getItems().addAll(Adminpage.cbname().get(index)); // it mean name[i] -> but use .get(i)
            }
        });

        Adminpage.typeBox2.setOnAction(new EventHandler<ActionEvent>() { // if cb1 change value = change value in cb 2 ...
            @Override
            public void handle(ActionEvent e) {
                Adminpage.mednameBox2.getItems().clear(); // Clear old member
                int index = Adminpage.Type1.indexOf(Adminpage.typeBox2.getValue()); // Find index of (A,B,C) in type               
                // Adminpage.Medname= FXCollections.observableArrayList(Adminpage.cbname());
                System.out.println(Adminpage.cbname());
                Adminpage.mednameBox2.getItems().addAll(Adminpage.cbname().get(index)); // it mean name[i] -> but use .get(i)
            }
        });

        Adminpage.updateBtn.setOnAction((ActionEvent t) -> {
            String xprice = Adminpage.price.getText();
            String xstock = Adminpage.stock.getText();
            String newname = String.format("%s", Adminpage.mednameBox.getValue());
            String ntype = String.format("%s", Adminpage.typeBox.getValue());

            // Update button 
            int index = Drug.getIdxDrug(newname);
            System.out.println(" index >>" + index);
            ArrayList<Drug> arr = API.getAllDrug();
            String exp = arr.get(index).getExpire();
            String Des = arr.get(index).getDescription();
            API.editDrug(newname, new Drug(ntype, newname, Des, exp, xprice, xstock));

            System.out.println(API.getAllDrug());

        });
        Adminpage.logoutBtn.setOnAction((ActionEvent t) -> {
            a.setScene(s1);
         loginPane.setPrefSize(700, 650);
            Setbacktostartingpage();
            a.setWidth(700);
            a.setHeight(650);
        });
        Userpage.logoutBtn.setOnAction((ActionEvent t) -> {
            a.setScene(s1);
            Setbacktostartingpage();
        });
        Adminpage.chatBtn.setOnAction((ActionEvent t) -> {
            Adminpage.l.getChildren().clear();
            Adminpage.lineBox.getChildren().clear();
            Adminpage.lineBox.getChildren().addAll(Adminpage.chat);
            Adminpage.l.getChildren().addAll(Adminpage.lineBox);
            Adminpage.lineBox.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF);");
//            Adminpage.l.setAlignment(Pos.BOTTOM_CENTER);
        });

        Adminpage.ansbut.setOnAction((ActionEvent t) -> {
            try {
                //              ArrayList<String > arr = new  ArrayList<>();
//              ArrayList<String> temp = new ArrayList<>();
ka = "";

Adminpage.popo1.setText(ka);

String addas = "Name  : " + Adminpage.fname.getText() + "          Text : " + Adminpage.fillchat.getText() + " \n";
ka = kb + addas;

Adminpage.popo1.setStyle("-fx-background-color :linear-gradient(#042A5A,#0B509B); -fx-text-fill: red;-fx-border-color: black;");
Adminpage.popo1.setText(ka);
Adminpage.popo1.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
kb = ka;
Adminpage.fillchat.setText("");
Adminpage.fname.setText("");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

////////////////
        Userpage.gyBtn.setOnAction((ActionEvent t) -> {
       
            a.setScene(Adminpage.admain);
            Adminpage.aa.getChildren().clear(); 
            Adminpage.aa.getChildren().addAll(Hchat,Adminpage.lineBox);
            Adminpage.lineBox.getChildren().clear();
            //Adminpage.page1.getChildren().clear();
            Hchat.setPrefSize(150,700);
            Hchat.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF)");
            Adminpage.lineBox.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF)");
            Adminpage.page1.setStyle("-fx-background-color :linear-gradient(#540770,#540770);-fx-border-color: black");
            
            Adminpage.replychat.getChildren().clear();    // 
            Adminpage.replychat.getChildren().addAll(Adminpage.fname, Adminpage.fillchat, Adminpage.ansbut);
            Adminpage.lineBox.getChildren().addAll(Adminpage.chat, Adminpage.backuser);
            
            Setbacktostartingpage();
        });
        Adminpage.backuser.setOnAction((ActionEvent t) -> {
            try {
                a.setScene(Userpage.Setscene(a));
                Adminpage.fillchat.setText("");
                Adminpage.fillchat.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
                Adminpage.fname.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
                Adminpage.fname.setText("");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Adminpage.clearchat.setOnAction((ActionEvent t) -> {
            try {
                kb = "---------------- รักษาสุขภาพกันด้วยนะทุกคน ---------------- \n"
            +              "                                        Medicine Center                                \n";
                Adminpage.popo1.setText(kb);
                Adminpage.popo1.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        /**
         * *********************************************************************
         */

        Adminpage.diagnoseBtn.setOnAction((ActionEvent t) -> {
            String sk = String.format("%s", Adminpage.mednameBox3.getValue());
            String di = Adminpage.diagnoseField.getText();
            User uss = User.getById(sk);
//        uss.setSuggestion(di);
            //   Database  db = new Database();
            //db.setFile("Suggestions");
            Suggestion sg = new Suggestion(di, sk);
            Suggestion.addSug(sg);
            System.out.println(API.getCustom("Suggestions"));
            Adminpage.mednameBox3.setValue("");
            Adminpage.diagnoseField.setText("");
            //     System.out.println(uss.getSuggestion());
        });

    }
    ///// set position error page ////

    void SetErrpage() {
        Error_Page.setAlignment(Pos.CENTER);
        NameBox2.setAlignment(Pos.CENTER);
        BackBox.setAlignment(Pos.BOTTOM_RIGHT);
        getAlltext()[3].setText("Plesae check YOUR ID or PASSWORD");
        getAlltext()[3].setFill(Color.RED);
        getAlltext()[2].setText("Error");
        getAlltext()[2].setFont(Font.font(20));
        BackBox.getChildren().add(back);
        NameBox2.getChildren().addAll(getAlltext()[2], getAlltext()[3]);
        Error_Page.getChildren().addAll(NameBox2, BackBox);
    }

    // next.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Anantason-Regular.ttf")), 10));
    void SetRegis(Stage a) throws FileNotFoundException {

        Font f1 = new Font(28);
        getAlltext()[0].setText("สถานะ ");
        getAlltext()[4].setText("ID :");
        getAlltext()[5].setText("PASSWORD :");
        getAlltext()[6].setText("CONFIRM PASSWORD :");
        getAlltext()[7].setText("ชื่อ :");
        getAlltext()[8].setText("นามสกุล :");
        getAlltext()[9].setText("อายุ :");
        getAlltext()[10].setText("อีเมล :");
        getAlltext()[11].setText("เพศ ");

        getAlltext()[12].setText("");
        getAlltext()[12].setFill(Color.RED);

        Na.setAlignment(Pos.BOTTOM_RIGHT);
        Row[6].setAlignment(Pos.CENTER);
        for (int j = 1; j <= 7; j++) {
            Na.getChildren().addAll(getAlltext()[j + 3]);
            allfill[j].setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 14));
            Na.setSpacing(20);
            Row[6].getChildren().addAll(allfill[j]);
            Row[6].setSpacing(16);
        }

        for (int j = 0; j < 13; j++) {
            if (j != 2 && j != 3) {
                FileInputStream font1 = new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf"));
                getAlltext()[j].setFont(Font.loadFont(font1, 18));
                getAlltext()[j].setFill(Color.BLACK);
                getAlltext()[j].setEffect(ds);
                getAlltext()[j].setCache(true);
            }
        }
        /**
         * ***********************************************************************************
         */  // Insets ซ้าย บน ล่าง ขวา
        genderBox.setMinSize(175, 35);
//        genderBox.setStyle("-fx-font: 13px \"src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf\"-fx- alignment: CENTER");
        comboBox2.setMinSize(175, 35);
//        comboBox2.setc
//        comboBox2.getEditor().setFont(Font.font("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf", FontWeight.EXTRA_BOLD, 14));
//        comboBox2.setStyle("-fx-font: 13px \"src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf\";");

//        Column[0].setAlignment(Pos.CENTER);
//        Column[0].setAlignment(Pos.CENTER); // สถานะ
//        Column[0].getChildren().addAll(getAlltext()[0], comboBox2);
//         Column[0].setPadding(new Insets(10, 10, 10, 10));

        GridPane comboGrad = new GridPane();
        comboGrad.setPadding(new Insets(10, 5, 5, 30));
        comboGrad.add(getAlltext()[0], 0, 0);
        comboGrad.add(comboBox2, 1, 0);
        comboGrad.add(getAlltext()[11], 0, 1);
        comboGrad.add(genderBox, 1, 1);
        comboGrad.setAlignment(Pos.CENTER_RIGHT);
        comboGrad.setVgap(2);
        comboGrad.setHgap(5);

        getAllbutton()[4].setText("Register");
        getAllbutton()[5].setText("Back");
        allbutton[4].setMinSize(150, 20);
        allbutton[4].setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        allbutton[5].setMinSize(150, 20);
        allbutton[5].setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));

//          Column[8].setAlignment(Pos.CENTER); // เพศ
//        Column[8].getChildren().addAll(getAlltext()[11], genderBox);
//        Column[8].setPadding(new Insets(10, 10, 10, 10));

        Registerpage2.setAlignment(Pos.CENTER);
        Registerpage2.getChildren().addAll(Na, Row[6]);
        Registerpage2.setPadding(new Insets(10, 10, 5, 10));

        getAllbutton()[4].setAlignment(Pos.CENTER);
        getAllbutton()[5].setAlignment(Pos.CENTER);

        Column[11].getChildren().addAll(getAllbutton()[4], getAllbutton()[5]);
        Column[11].setAlignment(Pos.CENTER);
        getAllbutton()[4].setAlignment(Pos.CENTER);
        getAllbutton()[5].setAlignment(Pos.CENTER);
        Column[11].setPadding(new Insets(1, 10, 20, 10));

        fillregister.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 30));
        fillregister.setFill(Color.BLACK);
       fillregister.setEffect(ds);
        fillregister.setCache(true);
        
        Registerpage.setAlignment(Pos.CENTER);
        Registerpage.getChildren().addAll(fillregister, Registerpage2, comboGrad, getAlltext()[12], Column[11]);

        BorderPane RegiBorderPane = new BorderPane();
        RegiBorderPane.setRight(Registerpage);
        BgRegi.getChildren().addAll(RegiBorderPane);

        REGIS_P.setCenter(BgRegi);
        REGIS_P.setTop(GLOBALBAR(a));
    }

    /**
     * **************************************************************************************
     */
    //////////////////////////////////////////////////////
    ///////////////another function///////////////////////
    //////////////////////////////////////////////////////
    boolean checkpassWord() {
        if (allfill[2].getText().equals(allfill[3].getText()) && allfill[2].getText() != " ") {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    void Setbacktostartingpage() {
        fillName.setPromptText("YOUR ID");
        fillPW.setText("");
        comboBox.setValue("");
        scene[1] = s1;
    }

    void registerclear() {
        for (int j = 1; j < 8; j++) {
            allfill[j].setText("");
        }
        comboBox2.setValue("");
        genderBox.setValue("");
    }

    Object idcheckers() {
        System.out.println("test " + fillName.getText());
        return Authority.login(fillName.getText(), fillPW.getText());

    }

    public void settingscene() {
        scene = new Scene[5];
        scene[1] = s1;
        scene[2] = s2;
        scene[3] = s3;
    }

    public void settext() {
        setAlltext(new Text[20]);
        for (int i = 0; i < 20; i++) {
            getAlltext()[i] = new Text("");
        }
    }

    public void setbut() {
        setAllbutton(new Button[20]);
        for (int i = 1; i < 20; i++) {
            getAllbutton()[i] = new Button("");
            getAllbutton()[i].setAlignment(Pos.CENTER);
        }
    }

    public void setVbox() {
        Row = new VBox[20];
        for (int i = 1; i < 20; i++) {
            Row[i] = new VBox(4);
            Row[i].setAlignment(Pos.CENTER);
        }
    }

    public void setTextbox() {
        allfill = new TextField[20];
        for (int i = 1; i < 20; i++) {
            allfill[i] = new TextField("");
            allfill[i].setAlignment(Pos.CENTER);
        }

    }

    public void setHbox() {
        Column = new HBox[20];
        for (int i = 0; i < 20; i++) {
            Column[i] = new HBox(60);
            Column[i].setAlignment(Pos.CENTER);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//    <<<<<<< HEAD
//
//    =======

    public static String getusrname() {

        return usrname;
    }

//    >>>>>>> origin
//    /BlxSheep
    /**
     * @return the alltext
     */
    public Text[] getAlltext() {
        return alltext;
    }

    /**
     * @param alltext the alltext to set
     */
    public void setAlltext(Text[] alltext) {
        this.alltext = alltext;
    }

    /**
     * @return the allbutton
     */
    public Button[] getAllbutton() {
        return allbutton;
    }

    /**
     * @param allbutton the allbutton to set
     */
    public void setAllbutton(Button[] allbutton) {
        this.allbutton = allbutton;
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

    private void buttonEffect(Button button) {
        button.addEventHandler(MouseEvent.MOUSE_MOVED, (MouseEvent t) -> {
            button.setStyle("-fx-backGround-color: #6a819e;-fx-text-fill: #FFFFFF;");
            //button.setTextFill(Color.web("#333138"));
        });
        button.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent t) -> {
            button.setStyle("-fx-backGround-color: #B924EF;-fx-text-fill:5 #FFFFFF;");
            //button.setTextFill(Color.web("#fcfeff"));
        });
    }

    private void MC_Effect(Button button) {
        button.addEventHandler(MouseEvent.MOUSE_MOVED, (MouseEvent t) -> {
            button.setStyle("-fx-backGround-color: #6a819e;-fx-text-fill: #FFFFFF;");
            //button.setTextFill(Color.web("#333138"));
        });
        button.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent t) -> {
            button.setStyle("-fx-backGround-color: #778DA9;-fx-text-fill:5 #FFFFFF;");
            //button.setTextFill(Color.web("#fcfeff"));
        });
    }
}
