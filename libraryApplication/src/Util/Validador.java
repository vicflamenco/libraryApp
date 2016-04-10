package Util;

import javax.swing.JTextField;

public class Validador {
    
    public static String validarTexto(JTextField txtField){
        String valor = txtField.getText();
        return (valor.isEmpty()) ? null : valor;
    }
    
    public static int validarEntero(JTextField txtField){
        String valor = txtField.getText();
        return (!valor.isEmpty() && valor.matches("[0-9]+")) ? Integer.parseInt(valor) : null;
    }
    
    public static String validarFecha(JTextField txtField){
        String valor = txtField.getText();
        return (!valor.isEmpty() && valor.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) ? valor : null;
    }
    
    public static String validarCorreo(JTextField txtField){
        String valor = txtField.getText();
        return (!valor.isEmpty() && valor.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9+_.-]+")) ? valor : null;
    }
}