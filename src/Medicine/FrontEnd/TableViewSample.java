package Medicine.FrontEnd;

import Medicine.BackEnd.*;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;


public class TableViewSample extends Application {

    public int editstate = 0;
    TableView<Drug> table = new TableView<>();

    ObservableList<Drug> data = FXCollections.observableArrayList(
            new Drug("ยาเเก้ปวดท้อง", "ยาธาตุน้ำขาวกระต่ายบิน", "ทำลายเชื้อโรคในลำไส้ รักษาอาการอักเสบของลำไส้ แก้ปวดท้อง", "20/12/20", "200", "100"),
            new Drug("ยาฆ่าเชื้อ", "Amoxicillin", "ยาปฏิชีวนะกลุ่มเพนิซิลลิน (Penicillins) \nซึ่งจะใช้ในการรักษาโรคที่มีสาเหตุการติดเชื้อมาจากแบคทีเรีย ", "16/2/24", "200", "45"),
            new Drug("ยาดมเเละยาทา", "ยาดมโป้ยเซียน", "ใช้ดม ใช้ทา ในหลอดเดียวกัน", "20/2/30", "15", "45"),
            new Drug("ยาดมเเละยาทา", "ยามหาทันใจนิยม", "ใช้แก้อาการ มึนเวียนศีรษะ หน้ามืด", "10/11/55", "700", "68")); //<< เพิ่มมาใหม่ 
    ObservableList<Drug> data2 = FXCollections.observableArrayList(API.getAllDrug());

    final HBox hb = new HBox();
    final VBox vbox = new VBox();

    final Button addButton = new Button("ADD");
    final Button editButton = new Button("EDIT");
    final Button deleteButton = new Button("DELETE");
    final Button backButton = new Button("BACK");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(setScene(stage));
        stage.show();
    }

    public Scene setScene(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Drugs Information");

        stage.setWidth(700);
        stage.setHeight(650);

        final Label label = new Label("Drugs Information");
//        label.setFont(new Font("Serithai-Regular", Font.BOLD, 20));
        Font font = new Font("Serithai-Regular", 20);

        //set font for JLabel
        label.setFont(font);

        //add label to applet
      

        //able.setEditable(true);
        Callback<TableColumn, TableCell> cellFactory
                = new Callback<TableColumn, TableCell>() {
            public TableCell call(TableColumn p) {
                return new EditingCell();
            }
        };

        TableColumn KindCol = new TableColumn("Kind");
        KindCol.setMinWidth(150);
        KindCol.setCellValueFactory(
                new PropertyValueFactory<Drug, String>("Kind"));
        KindCol.setCellFactory(cellFactory);
        KindCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Drug) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setKind(t.getNewValue());
            }
        }
        );

        TableColumn NameCol = new TableColumn("Name");
        NameCol.setMinWidth(150);
        NameCol.setCellValueFactory(
                new PropertyValueFactory<Drug, String>("Name"));
        NameCol.setCellFactory(cellFactory);
        NameCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Drug) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setName(t.getNewValue());
            }
        }
        );

        TableColumn DesCol = new TableColumn("Description");
        DesCol.setMinWidth(300);
        DesCol.setCellValueFactory(
                new PropertyValueFactory<Drug, String>("Description"));
        DesCol.setCellFactory(cellFactory);
        DesCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Drug) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setDescription(t.getNewValue());
            }
        }
        );

        TableColumn ExpCol = new TableColumn("Expire");
        ExpCol.setMinWidth(100);
        ExpCol.setCellValueFactory(
                new PropertyValueFactory<Drug, String>("Expire"));
        ExpCol.setCellFactory(cellFactory);
        ExpCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Drug) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setExpire(t.getNewValue());
            }
        }
        );

        TableColumn StockCol = new TableColumn("Stock");
        StockCol.setMinWidth(100);
        StockCol.setCellValueFactory(
                new PropertyValueFactory<Drug, String>("Stock"));
        StockCol.setCellFactory(cellFactory);
        StockCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Drug) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setStock(t.getNewValue());
            }
        }
        );

        TableColumn PriceCol = new TableColumn("Price");
        PriceCol.setMinWidth(100);
        PriceCol.setCellValueFactory(
                new PropertyValueFactory<Drug, String>("Price"));
        PriceCol.setCellFactory(cellFactory);
        PriceCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Drug) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setPrice(t.getNewValue());
            }
        }
        );

        table.setItems(data2);
        table.getColumns().addAll(KindCol, NameCol, DesCol, ExpCol, StockCol, PriceCol);

        final TextField addKind = new TextField();
        addKind.setPromptText("Kind");
        addKind.setMaxWidth(KindCol.getPrefWidth());
        final TextField addName = new TextField();
        addName.setMaxWidth(NameCol.getPrefWidth());
        addName.setPromptText("Name");
        final TextField addDes = new TextField();
        addDes.setMaxWidth(DesCol.getPrefWidth());
        addDes.setPromptText("Description");
        final TextField addExp = new TextField();
        addExp.setMaxWidth(ExpCol.getPrefWidth());
        addExp.setPromptText("Expire");
        final TextField addPrice = new TextField();
        addPrice.setMaxWidth(PriceCol.getPrefWidth());
        addPrice.setPromptText("Price");
        final TextField addStock = new TextField();
        addStock.setMaxWidth(StockCol.getPrefWidth());
        addStock.setPromptText("Stock");

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                API.addDrug(new Drug(addKind.getText(), addName.getText(), addDes.getText(), addExp.getText(), addStock.getText(), addPrice.getText()));
                data2.clear();
                data2.addAll(API.getAllDrug());
                //data2.add(new Drug(addKind.getText(), addName.getText(), addDes.getText(), addExp.getText(), addStock.getText(), addPrice.getText()));
                System.out.println(API.getAllDrug());
                addKind.clear();
                addName.clear();
                addDes.clear();
                addExp.clear();
                addPrice.clear();
                addStock.clear();

//                vbox.getChildren().clear();
//                vbox.getChildren().addAll(label, table, hb);
//                table.setItems(data2);
            }
        });

        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String selectInform = table.getSelectionModel().getSelectedItem().getName();
                if (editstate == 0) {
                    editstate = 1;
                    int a = Drug.getIdxDrug(selectInform);
                    Drug dg = API.getAllDrug().get(a);

                    addKind.setText(dg.getKind());
                    addName.setText(dg.getName());
                    addPrice.setText(dg.getPrice());
                    addStock.setText(dg.getStock());
                    addDes.setText(dg.getDescription());
                    addExp.setText(dg.getExpire());

                } else {
                    editstate = 0;
                    API.editDrug(selectInform, new Drug(addKind.getText(), addName.getText(), addDes.getText(), addExp.getText(), addPrice.getText(), addStock.getText()));
                    data2.clear();
                    data2.addAll(API.getAllDrug());
                    addKind.clear();
                    addName.clear();
                    addDes.clear();
                    addExp.clear();
                    addPrice.clear();
                    addStock.clear();
                }
            }
        });

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //data2.removeAll(data2);
                String selectInform = table.getSelectionModel().getSelectedItem().getName();
                API.removeDrug(selectInform);
                System.out.println(API.getAllDrug());
                data2.clear();
                data2.addAll(API.getAllDrug());
            }
        });

        hb.getChildren().addAll(addKind, addName, addDes, addExp, addStock, addPrice, addButton, editButton, deleteButton, backButton);
        hb.setSpacing(10);

        vbox.setSpacing(5);
        vbox.setPadding(new Insets(0,0,0,0));

        vbox.getChildren().addAll(label, table, hb);
        vbox.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF);");
        hb.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF);");
        label.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF);");
        table.setStyle("-fx-background-color :linear-gradient(#B924EF,#B924EF);");
        ((Group) scene.getRoot()).getChildren().addAll(vbox);

//        stage.setScene(scene);
//        stage.show();
        return scene;
    }



    class EditingCell extends TableCell<Drug, String> {

        private TextField textField;

        public EditingCell() {
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                        System.out.println("Edit ");
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());

                    setGraphic(null);
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0,
                        Boolean arg1, Boolean arg2) {
                    if (!arg2) {
                        commitEdit(textField.getText());
                    }
                }
            });
        }

        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
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

    public ArrayList<Drug> drugdata() {
        ArrayList<Drug> drugdata = API.getAllDrug();
        return drugdata;
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

            System.out.println("name= " + name);
        }
        return name;
    }
}
