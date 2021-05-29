/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.FrontEnd;

import Medicine.BackEnd.BSymptom;
import Medicine.BackEnd.Drug;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Medicine.BackEnd.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import static javafx.scene.text.Font.font;

/**
 *
 * @author ASUS
 */
public class Admin1 extends Application {

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

    }
    
    ArrayList<BSymptom> arr = new ArrayList<BSymptom>();
    
    ScrollPane SP1 = new ScrollPane();
    
    Text[] alltext;
    Button[] allbutton;
    Button[] pnameuser;
    Button ansbut = new Button();
    Button removeBtn = new Button();
    Button chatBtn = new Button();
    Button nameuser = new Button();
    Button nameuser2 = new Button();
    Button upbackBtn = new Button();
    Button updateBtn = new Button();
    Button informBtn = new Button();
    Button logoutBtn = new Button();
    Button diagnoseBtn = new Button();

    Button backuser = new Button("กลับ");
    Button clearchat = new Button("ล้างแชท");
    Scene[] scene;

    VBox[] Row;

    VBox VshowPatient = new VBox(1);
    VBox queuePatient = new VBox(10);
    HBox QP = new HBox(20);

    HBox lineBox = new HBox(10);
    VBox linename = new VBox(5);
    HBox linename1 = new HBox();
    VBox chat = new VBox(20);
//    VBox  = new VBox(1);

    HBox pVbox = new HBox(20);
    HBox Hfname = new HBox(20);
    HBox sVbox = new HBox(20);
    HBox diagH = new HBox(20);
    HBox replychat = new HBox(20);
    HBox patientPane = new HBox();

    TextField[] allfill;
    TextField diagnoseField = new TextField();
    TextField price = new TextField();
    TextField stock = new TextField();

    HBox[] Column;
    VBox addpage = new VBox(10);
    VBox addq = new VBox(4);
    HBox addpage2 = new HBox(10);
    VBox Na = new VBox(20);

    TextField fillchat = new TextField();
    
    TextField fname = new TextField();
    
    Text Tpage1 = new Text("                                                         ");
    ////////////////////////////////

    VBox page1 = new VBox(200); // ระยะห่าง ปุ่ม logout กับ 3 ปุ่ม บน

    VBox l = new VBox();
    HBox aa = new HBox();
    BorderPane AD1 = new BorderPane();
    
    Scene admain = new Scene(aa, 780, 700);

    VBox ppane = new VBox(100); // <<<<<<<<<<<<
    //Button popo = new Button("                                                                                                                                                           ");
    Text popo = new Text  ("                                                                                                                                           ");
    Text popo1 = new Text("---------------- รักษาสุขภาพกันด้วยนะทุกคน ---------------- \n"
            +              "                                        Medicine Center                                \n");
    VBox popo2 = new VBox();

//^^^^^^^^^^^^^^^^^^^////
    /////////////////////////////////////
    VBox page2 = new VBox(6);
    VBox ppm = new VBox(6);
    VBox page2s = new VBox(70);

    VBox updatepage = new VBox(100);

    Scene adupdate = new Scene(updatepage, 700, 780);
    Scene adadd = new Scene(addpage, 700, 780);
    Scene adshowpatient = new Scene(addq, 700, 650);

    // ArrayList arr = API.getAllDrug()
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

    public void reset() {
        ObservableList<String> Type = FXCollections.observableArrayList(cbtype());
        ObservableList<String> Type1 = FXCollections.observableArrayList(cbtype());
        ObservableList<List<String>> Medname = FXCollections.observableArrayList();
        ObservableList<List<String>> Medname1 = FXCollections.observableArrayList();
        //  ObservableList<String> count = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "---------------");

        ComboBox typeBox = new ComboBox(Type); //Updatepage Lower cb
        ComboBox typeBox2 = new ComboBox(Type1);
        ComboBox typeBox3 = new ComboBox(Type);
        ComboBox mednameBox = new ComboBox(Medname);
        ComboBox mednameBox2 = new ComboBox(Medname1);
    }
    //  ComboBox CountBox = new ComboBox(count);

    /*
           but1 => goto check 
           but2 => goto updateMed
           but3 => goto view
           but4 => goto addMed
     */
    Admin1() throws FileNotFoundException {

        setHbox();
        setTextbox();
        setbut();
        settext();
        setVbox();
        Updatepage();
        Setadd();
        showpatient();
        setlinebut();
        CHATLINE();
        //////////////////////////////

          
        
        
       
        
        aa.getChildren().addAll(page1, ppane);
        page1.setStyle("-fx-background-color :linear-gradient(#540770,#540770);-fx-border-color: black");
//         page1.setPrefWidth(300);
        
        ppane.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF);");

        l.getChildren().addAll(popo);
        ppane.getChildren().add(l);
        ppane.setAlignment(Pos.CENTER);
        l.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF);");

        allbutton[4].setText("เพิ่มยา");
        try {
            allbutton[4].setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin1.class.getName()).log(Level.SEVERE, null, ex);
        }

        allbutton[4].setPrefWidth(100);
        allbutton[4].setAlignment(Pos.CENTER);

        chatBtn.setText("Chat");
        try {
            chatBtn.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin1.class.getName()).log(Level.SEVERE, null, ex);
        }

        chatBtn.setPrefWidth(200);
        chatBtn.setAlignment(Pos.CENTER);

        allbutton[3].setText("ยาทั้งหมด");
        try {
            allbutton[3].setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin1.class.getName()).log(Level.SEVERE, null, ex);
        }

        allbutton[3].setPrefWidth(200);
        allbutton[3].setAlignment(Pos.CENTER);

//        allbutton[2].setText("        อัพเดท/ดูข้อมูล        ");
        allbutton[1].setText("อาการผู้ป่วย");
        try {
            allbutton[1].setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin1.class.getName()).log(Level.SEVERE, null, ex);
        }
        allbutton[1].setPrefWidth(200);
        allbutton[1].setAlignment(Pos.CENTER);

        logoutBtn.setText("LOGOUT");
        logoutBtn.setPrefWidth(200);
        logoutBtn.setAlignment(Pos.CENTER);

        try {
            logoutBtn.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin1.class.getName()).log(Level.SEVERE, null, ex);
        }

//
//        allbutton[4].setFont(font(20));
        chatBtn.setStyle("-fx-background-color :linear-gradient(#A233F7,#A233F7)");
        logoutBtn.setStyle("-fx-background-color :linear-gradient(#A233F7,#A233F7)");
        allbutton[1].setStyle("-fx-background-color :linear-gradient(#A233F7,#A233F7)");
//        allbutton[2].setStyle("-fx-background-color :linear-gradient(#A233F7,#A233F7)");
        allbutton[3].setStyle("-fx-background-color :linear-gradient(#A233F7,#A233F7)");
        Row[1].setAlignment(Pos.CENTER);

        for (int i = 1; i < 4; i++) {
            if (i != 2) {
                Row[1].getChildren().add(allbutton[i]);
            }
        }
        Row[1].getChildren().addAll(chatBtn);

        page1.setAlignment(Pos.BOTTOM_LEFT);
        page1.getChildren().addAll(Tpage1,Row[1], logoutBtn);

    }

    void CHATLINE() { try {
        //
        
        backuser.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { 
            clearchat.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin1.class.getName()).log(Level.SEVERE, null, ex);
        }

        linename1.getChildren().addAll(linename);
        for (int i = 0; i < 15; i++) {
            try {
                pnameuser[i].setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Admin1.class.getName()).log(Level.SEVERE, null, ex);
            }
            pnameuser[i].setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF)");
            linename.getChildren().add(pnameuser[i]);
            
        }
        try {
            popo.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin1.class.getName()).log(Level.SEVERE, null, ex);
        }
        linename.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF)");
        linename1.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF)");
//        linename.setAlignment(Pos.TOP_LEFT);

        ansbut.setText("ส่ง");
        try {
            ansbut.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin1.class.getName()).log(Level.SEVERE, null, ex);
        }

        ansbut.setPrefWidth(100);
        backuser.setPrefWidth(100);
        clearchat.setPrefWidth(100);
        
        try {
            fname.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fillchat.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin1.class.getName()).log(Level.SEVERE, null, ex);
        }

       fname.setAlignment(Pos.CENTER);
       fillchat.setAlignment(Pos.CENTER);
        
        popo2.getChildren().addAll(popo1);
        popo2.setAlignment(Pos.BOTTOM_CENTER);
        
         SP1.setContent(popo2);
         SP1.fitToHeightProperty().set(true);
         
         SP1.setPrefHeight(500);
        
       
        replychat.getChildren().addAll(fname, fillchat, ansbut, clearchat);
        replychat.setAlignment(Pos.BOTTOM_CENTER);
       
        chat.getChildren().addAll(SP1, replychat);
        chat.setAlignment(Pos.BOTTOM_CENTER);
        
        chat.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF)");
        lineBox.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF)");
        
        lineBox.setAlignment(Pos.BOTTOM_CENTER);
        lineBox.getChildren().addAll(chat);
    }

    void Updatepage() {
        mednameBox2.setVisibleRowCount(3);
        mednameBox.setVisibleRowCount(3);
        //CountBox.setVisibleRowCount(3);
        informBtn.setText("ดูข้อมูล");
        updateBtn.setText("อัพเดท");
        upbackBtn.setText("ย้อนกลับ");
        removeBtn.setText("Remove");
        alltext[1].setText("_______________________________________________________________________________________________________________");
        pVbox.getChildren().addAll(price);
        sVbox.getChildren().addAll(stock);
        pVbox.setAlignment(Pos.CENTER);
        sVbox.setAlignment(Pos.CENTER);
        Row[2].getChildren().addAll(typeBox2, mednameBox2, informBtn, removeBtn);
        page2.getChildren().addAll(typeBox, mednameBox, pVbox, sVbox, updateBtn);
        page2.setAlignment(Pos.BOTTOM_CENTER);
        page2s.setAlignment(Pos.TOP_CENTER);
        page2s.getChildren().add(Row[2]);
        updatepage.getChildren().addAll(page2s, page2);
        updatepage.setAlignment(Pos.CENTER);
    }

    void Setadd() {

        alltext[0].setText("หมวดหมู่ :");
        alltext[4].setText("ชื่อยา :");
        alltext[5].setText("สรรพคุณ :");
        alltext[6].setText("จำนวน :");
        alltext[7].setText("ราคา :");
        alltext[8].setText("วันหมดอายุ:");
        allbutton[5].setText("back");

        Na.setAlignment(Pos.TOP_RIGHT);
        Row[6].setAlignment(Pos.TOP_RIGHT);
        for (int j = 1; j <= 5; j++) {
            Na.getChildren().addAll(alltext[j + 3]);
            Row[6].getChildren().addAll(allfill[j]);
        }
        Column[0].setAlignment(Pos.TOP_CENTER);
        Column[0].setAlignment(Pos.TOP_CENTER);
        Na.getChildren().addAll(alltext[0]);
        Row[6].getChildren().addAll(allfill[7]);
        addpage2.setAlignment(Pos.CENTER);
        addpage2.getChildren().addAll(Na, Row[6]);
        allbutton[4].setAlignment(Pos.CENTER_RIGHT);
        allbutton[5].setAlignment(Pos.CENTER_RIGHT);
        allbutton[4].setStyle("-fx-background-color :linear-gradient(#F4A460,#F4A460)");
        ppm.setStyle("-fx-background-color :linear-gradient(#F4A460,#F4A460)");
        ppm.getChildren().addAll(allbutton[4]);
        ppm.setAlignment(Pos.CENTER);
        addpage.setAlignment(Pos.BOTTOM_CENTER);
        addpage.getChildren().addAll(addpage2, ppm);
    }

   

    void refreshshowpatient() {
        arr = API.getAllSymptom();

        System.out.println(arr);
        if (arr == null) {
            VshowPatient.getChildren().clear();
            VshowPatient.getChildren().add(new Text(String.format("No Older Patient\n")));
        } else {
            VshowPatient.getChildren().clear();
            for (int i = 0; i < arr.size(); i++) {
                addq.getChildren().clear();

                VshowPatient.getChildren().add(new Text(String.format("Symptom  : %s   Writer : %s\n", arr.get(i).getCymtomp(), arr.get(i).getPatient())));

            }
        }

    }

    void showpatient() {
        mednameBox3.setVisibleRowCount(5);
        
        allbutton[7].setText("อ่านทั้งหมด");
        allbutton[7].setAlignment(Pos.BASELINE_RIGHT);
        //allbutton.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf")), 18));

//        allbutton[8].setText("ย้อนกลับ");
        diagnoseBtn.setText("ส่งคำตอบรับ");
        
        diagH.getChildren().clear();
        diagH.getChildren().add(diagnoseField); 
        diagH.setAlignment(Pos.BOTTOM_CENTER);
        
        mednameBox3.setPromptText("กรุณาเลือกชื่อ");
        QP.getChildren().clear();
        QP.getChildren().addAll(mednameBox3, diagH, diagnoseBtn);
                
        queuePatient.getChildren().clear();
        queuePatient.getChildren().addAll(allbutton[7],QP);
        queuePatient.setAlignment(Pos.BOTTOM_CENTER);
        
        patientPane.getChildren().clear();
        patientPane.getChildren().addAll(queuePatient);
        patientPane.setAlignment(Pos.BOTTOM_CENTER);
        
        addq.getChildren().clear(); ///
        addq.getChildren().addAll(VshowPatient, patientPane);
         addq.setAlignment(Pos.CENTER);
         
        VshowPatient.setAlignment(Pos.CENTER);
       

    }

    public void settext() {
        alltext = new Text[20];
        for (int i = 0; i < 20; i++) {
            alltext[i] = new Text("");
        }
    }

    public void setbut() {
        allbutton = new Button[20];
        for (int i = 1; i < 20; i++) {
            allbutton[i] = new Button("");
            allbutton[i].setAlignment(Pos.CENTER);
        }
    }

    public void setlinebut() {
        pnameuser = new Button[20];
        for (int i = 0; i < 20; i++) {
            pnameuser[i] = new Button();
            pnameuser[i].setText("");
            pnameuser[i].setAlignment(Pos.CENTER);
        }
    }

    public void setVbox() {
        Row = new VBox[20];
        for (int i = 1; i < 20; i++) {
            Row[i] = new VBox(10);
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
            Column[i] = new HBox(10);
            Column[i].setAlignment(Pos.CENTER);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
 public HBox GLOBALBAR(Stage a) {
        HBox loginBar = new HBox();
        loginBar.setStyle("-fx-background-color:rgb(187,88,35) ");
        try {

            ImageView minImage = new ImageView(new Image(new FileInputStream("src/Medicine/FrontEnd/Images/min1.png")));
            loginBar.getChildren().add(minImage);
            minImage.setOnMouseClicked((t) -> {
                a.setIconified(true);
            });
            loginBar.setAlignment(Pos.CENTER_RIGHT);

            ImageView closeImage = new ImageView(new Image(new FileInputStream("src/Medicine/FrontEnd/Images/cancle1.png")));
            loginBar.getChildren().add(closeImage);
            closeImage.setOnMouseClicked((t) -> {
                System.exit(0);
            });
            loginBar.setAlignment(Pos.CENTER_RIGHT);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return loginBar;
    }
}
