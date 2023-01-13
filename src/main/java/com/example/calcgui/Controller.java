package com.example.calcgui;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.effect.MotionBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {
    private mathAction ma;
    private double m_firstNum = 0;
    private double m_secondNum = 0;
    private int m_numCounter = 0;
    private String m_textMessage;
    private StringBuilder m_textBuilder = new StringBuilder();
    private HashMap<String, Button> m_buttonMap = new HashMap<String, Button>();
    String m_style = new String();

    DropShadow m_dropShadow = new DropShadow();
    Shadow m_shadow = new Shadow();

    @FXML
    private Button m_addButton;
    @FXML
    private Button m_subsButton;
    @FXML
    private Button m_multButton;
    @FXML
    private Button m_divButton;
    @FXML
    private Button m_dotButton;
    @FXML
    private Label m_resLabel;
    @FXML
    private Button m_allClearButton;
    @FXML
    private Button m_equalsButton;
    @FXML
    private Button m_oneButton;
    @FXML
    private Button m_twoButton;
    @FXML
    private Button m_threeButton;
    @FXML
    private Button m_fourButton;
    @FXML
    private Button m_fiveButton;
    @FXML
    private Button m_sixButton;
    @FXML
    private Button m_sevenButton;
    @FXML
    private Button m_eightButton;
    @FXML
    private Button m_nineButton;
    @FXML
    private Button m_zeroButton;
    @FXML
    private Button m_percent;
    @FXML
    private Button m_changeSign;

    @FXML
    void initialize() {
        m_buttonMap.put("m_zeroButton", m_zeroButton);
        m_buttonMap.put("m_oneButton", m_oneButton);
        m_buttonMap.put("m_twoButton", m_twoButton);
        m_buttonMap.put("m_threeButton", m_threeButton);
        m_buttonMap.put("m_fourButton", m_fourButton);
        m_buttonMap.put("m_fiveButton", m_fiveButton);
        m_buttonMap.put("m_sixButton", m_sixButton);
        m_buttonMap.put("m_sevenButton", m_sevenButton);
        m_buttonMap.put("m_eightButton", m_eightButton);
        m_buttonMap.put("m_nineButton", m_nineButton);
        m_buttonMap.put("m_allClearButton", m_allClearButton);
        m_buttonMap.put("m_dotButton", m_dotButton);
        m_buttonMap.put("m_addButton", m_addButton);
        m_buttonMap.put("m_subsButton", m_subsButton);
        m_buttonMap.put("m_multButton", m_multButton);
        m_buttonMap.put("m_divButton", m_divButton);
        m_buttonMap.put("m_equalsButton", m_equalsButton);
        m_buttonMap.put("m_percent", m_percent);
        m_buttonMap.put("m_changeSign", m_changeSign);

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

    @FXML
    void onMouseEntered(MouseEvent event) {
        String source = event.toString();
        int bInd = source.indexOf("id=") + 3;
        int eInd = source.indexOf(",", bInd);
        String id = source.substring(bInd, eInd);
        //System.out.println(id);

        m_buttonMap.get(id).setEffect(m_dropShadow);
    }

    @FXML
    void onMouseExited(MouseEvent event) {
        String source = event.toString();
        int bInd = source.indexOf("id=") + 3;
        int eInd = source.indexOf(",", bInd);
        String id = source.substring(bInd, eInd);
        //System.out.println(id);

        m_buttonMap.get(id).setEffect(null);
    }

    @FXML
    void onMousePressed(MouseEvent event) {
        String source = event.toString();
        int bInd = source.indexOf("id=") + 3;
        int eInd = source.indexOf(",", bInd);
        String id = source.substring(bInd, eInd);
        m_style = m_buttonMap.get(id).getStyle();
        String[] string = m_style.split(";");
        string = string[0].split(":");
        string = string[1].split("#");
        Long num = Long.parseLong(string[1], 16);
        num = 16777215 - num;

        //m_buttonMap.get(id).setStyle("fx-background-color: #2F2F2F; -fx-background-radius: 45");
        m_buttonMap.get(id).setStyle("fx-background-color: #" + Long.toHexString(num) + "; -fx-background-radius: 45");
        m_buttonMap.get(id).setTextFill(Color.BLACK);
    }

    @FXML
    void onMouseReleased(MouseEvent event) {
        String source = event.toString();
        int bInd = source.indexOf("id=") + 3;
        int eInd = source.indexOf(",", bInd);
        String id = source.substring(bInd, eInd);

        m_buttonMap.get(id).setStyle(m_style);
        m_buttonMap.get(id).setTextFill(Color.WHITE);
    }
}



