package com.example.calcgui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    private mathAction ma;
    private double m_firstNum = 0;
    private double m_secondNum = 0;
    private int m_numCounter = 0;
    private String m_textMessage;
    private StringBuilder m_textBuilder = new StringBuilder();

    @FXML
    private Button m_addButton;
    @FXML
    private Button m_dotButton;
    @FXML
    private Button m_eightButton;
    @FXML
    private Button m_equalsButton;
    @FXML
    private Button m_fiveButton;
    @FXML
    private Button m_fourButton;
    @FXML
    private Button m_nineButton;
    @FXML
    private Button m_oneButton;
    @FXML
    private Label m_resLabel;
    @FXML
    private Button m_sevenButton;
    @FXML
    private Button m_sixButton;
    @FXML
    private Button m_subsButton;
    @FXML
    private Button m_threeButton;
    @FXML
    private Button m_twoButton;
    @FXML
    private Button m_zeroButton;
    @FXML
    private Button m_allClearButton;

    @FXML
    void initialize() {
        m_equalsButton.setOnAction(event -> {
            double num = 0;
            try{
                num = Double.parseDouble(m_resLabel.getText());

                if(ma == null)
                {
                    System.out.println("No action selected!");
                }
                else {
                    ma.m_secondNum = num;
                    m_resLabel.setText(String.valueOf(ma.run()));
                    ma = null;
                }
            } catch (NullPointerException  e) {
                System.out.println("No Data entered!");
            }
        });

        m_oneButton.setOnAction(event -> {
            m_textBuilder.append(1);
            m_resLabel.setText(m_textBuilder.toString());
        });

        m_twoButton.setOnAction(event -> {
            m_textBuilder.append(2);
            m_resLabel.setText(m_textBuilder.toString());
        });

        m_threeButton.setOnAction(event -> {
            m_textBuilder.append(3);
            m_resLabel.setText(m_textBuilder.toString());
        });

        m_fourButton.setOnAction(event -> {
            m_textBuilder.append(4);
            m_resLabel.setText(m_textBuilder.toString());
        });

        m_fiveButton.setOnAction(event -> {
            m_textBuilder.append(5);
            m_resLabel.setText(m_textBuilder.toString());
        });

        m_sixButton.setOnAction(event -> {
            m_textBuilder.append(6);
            m_resLabel.setText(m_textBuilder.toString());
        });

        m_sevenButton.setOnAction(event -> {
            m_textBuilder.append(7);
            m_resLabel.setText(m_textBuilder.toString());
        });

        m_eightButton.setOnAction(event -> {
            m_textBuilder.append(8);
            m_resLabel.setText(m_textBuilder.toString());
        });

        m_nineButton.setOnAction(event -> {
            m_textBuilder.append(9);
            m_resLabel.setText(m_textBuilder.toString());
        });

        m_zeroButton.setOnAction(event -> {
            m_textBuilder.append(0);
            m_resLabel.setText(m_textBuilder.toString());
        });

        m_dotButton.setOnAction(event -> {
            m_textBuilder.append('.');
            m_resLabel.setText(m_textBuilder.toString());
        });

        m_allClearButton.setOnAction(event -> {
            m_textBuilder.delete(0, m_textBuilder.capacity() - 1);
            m_resLabel.setText(m_textBuilder.toString());
        });
    }

    @FXML
    public void btnCell(ActionEvent actionEvent) {
        String source = actionEvent.getSource().toString();
        int bInd = source.indexOf("id=") + 3;
        int eInd = source.indexOf(",", bInd);
        String id = source.substring(bInd, eInd);
        System.out.println(id);
        double num = 0;

        try{
            num = Double.parseDouble(m_resLabel.getText());

            if(ma == null) {
                switch (id){
                    case "m_addButton":
                        ma = new addition();
                        break;
                    case "m_subsButton":
                        ma = new subtraction();
                        break;
                    case "m_multButton":
                        ma = new multiplication();
                        break;
                    case "m_divButton":
                        ma = new division();
                        break;
                    default:
                        System.out.println("Unknown source");
                        break;
                }

                ma.m_firstNum = num;
                m_textBuilder.delete(0, m_textBuilder.capacity() - 1);
                m_resLabel.setText(m_textBuilder.toString());
            }
            else {
                ma.m_secondNum = num;
                m_resLabel.setText(String.valueOf(ma.run()));
                ma = null;
            }
        } catch (NullPointerException  e) {
            System.out.println("No Data entered!");
        }
    }
}



