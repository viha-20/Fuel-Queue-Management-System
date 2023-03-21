//I declare that my work contains no examples of misconduct, such as
//plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898902
//7/8/2022
package com.example.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class allDataController implements Initializable {
    public static Passenger[][] tempar = new Passenger[6][7];

    public static cDataAr Queue1 = new cDataAr();
    public static cDataAr Queue2 = new cDataAr();
    public static cDataAr Queue3 = new cDataAr();
    public static cDataAr Queue4 = new cDataAr();
    public static cDataAr Queue5 = new cDataAr();


    @FXML
    private TableColumn<cData,String> fname;

    @FXML
    private TableView<cData> myTable;

    @FXML
    private TableColumn<cData,Integer> pos;

    @FXML
    private TableColumn<cData,String> pump;

    @FXML
    private TableColumn<cData,Integer> rfuel;

    @FXML
    private TextField searchtxt;

    @FXML
    private TableColumn<cData,String> sname;

    @FXML
    private TableColumn<cData,String> vnum;

    @FXML
    void searchOnClick() {
        list.clear();
        cDataAr[] QueueAll = {Queue1,Queue2,Queue3,Queue4,Queue5};
        for (cDataAr Q:QueueAll) {
            for (cData D:Q.c) {
                Boolean fCheck = D.getF().equalsIgnoreCase(searchtxt.getText());
                Boolean sCheck = D.getS().equalsIgnoreCase(searchtxt.getText());
                if (fCheck || sCheck){
                    list.add(D);
                }
            }
        }
        myTable.setItems(list);
    }

    ObservableList<cData> list = FXCollections.observableArrayList();
    void setData(){
        tempar = Main.getData();
        cDataAr[] QueueAll = {Queue1,Queue2,Queue3,Queue4,Queue5};
        for (int j=1;j<6;j++){
            for (int i=1;i<7;i++){
                if(tempar[j][i] == null){
                    cData Customer = new cData(Integer.toString(j),i,"No","No","No",0);
                    QueueAll[j-1].c[i-1] = Customer;
                }else{
                    String fname = tempar[j][i].getFName();
                    fname = fname.substring(0,1).toUpperCase() + fname.substring(1).toLowerCase();
                    String sname = tempar[j][i].getLName();
                    sname = sname.substring(0,1).toUpperCase() + sname.substring(1).toLowerCase();
                    String vname = tempar[j][i].getVehicle_No();
                    int rfuel = tempar[j][i].getNoOfLiters();
                    cData Customer = new cData(Integer.toString(j),i,fname,sname,vname,rfuel);
                    QueueAll[j-1].c[i-1] = Customer;
                }
            }
        }
        for (cDataAr Q:QueueAll) {
            list.addAll(Q.c);
        }
        myTable.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pump.setCellValueFactory(new PropertyValueFactory<>("pump"));
        pos.setCellValueFactory(new PropertyValueFactory<>("pos"));
        fname.setCellValueFactory(new PropertyValueFactory<>("f"));
        sname.setCellValueFactory(new PropertyValueFactory<>("s"));
        vnum.setCellValueFactory(new PropertyValueFactory<>("v"));
        rfuel.setCellValueFactory(new PropertyValueFactory<>("rf"));
        setData();
    }

}
