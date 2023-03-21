//I declare that my work contains no examples of misconduct, such as
//plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898902
//7/8/2022
package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    @FXML
    public void startOnClick(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("allData-view.fxml")));
        newStage.setScene(new Scene(root,600,400));
        newStage.show();
        newStage.setResizable(false);

        Stage previousStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        previousStage.close();
    }
}
