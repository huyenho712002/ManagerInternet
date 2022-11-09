/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poly.helper;

import java.awt.Color;
import java.awt.TextField;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class DataValidator {
    public static void validateEmpty(TextField field, StringBuilder sb, String errorMessage) {
        if(field.getText().equals("")){
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
            field.setBackground(Color.GREEN);
        }
        
    }
    public static void validateEmpty(JPasswordField field, StringBuilder sb, String errorMessage) {
        String passWord = new String(field.getPassword());
        if(field.getText().equals("")){
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
            field.setBackground(Color.GREEN);
        }

}
}