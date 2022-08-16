package cl.funciones;

import javax.swing.JOptionPane;

/**
 * @author Daniel Gómez
 * Contacto: dgomez.informatica@gmail.com
 */

public class Funciones {
    
    private final String TITULO_JOPTION = "Conversor de Monedas/Temperaturas";
   
    
    public void MessageBox(String message, int icon) 
    {
        JOptionPane.showMessageDialog(null, message, TITULO_JOPTION, icon);
    }
    
    
    public String ComboBoxDialog(String message, int button, String[] data) 
    {
        return (String) JOptionPane.showInputDialog(null, // Parametro incial por defecto
            message,                // Mensaje de la Ventana
            TITULO_JOPTION,         // Titulo de la Ventana
            button,                 // Botones por defecto
            null,                   // Icono (En este caso como no tenemos, la definimos como nulo)
            data,                   // Accediendo al array de objetos (de donde sacara la informacion)
            data[0]                 // Dejamos como predeterminado la primera opcion marcada
        );  
    }
    
    
    public String InputBoxDialog(String message, int icon)
    {
        return JOptionPane.showInputDialog(null, message, TITULO_JOPTION, icon);
    }
    
    
    public boolean fieldEmpty(String... campos) 
    {
        for (String campo : campos) {
            if (campo.equals("")) {
                return true;
            }
        }
        
        return false;
    }
    
}
