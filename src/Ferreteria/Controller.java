package Ferreteria;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import View.Menu;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements ActionListener {

    public Menu menu;
    public Metodos metodos;
    
        public Controller() {
        this.menu = new Menu();
        this.metodos = new Metodos();
            }
    public void asignarOyentes() {
	    menu.getBotonOpcion1().addActionListener(this);
		//vista.getPdatos().getLista_nombre().addActionListener(this);
	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("OPCION1")) {
            try {
                menu.getPanelresultados().setText(metodos.listarProductos());
                menu.getBotonOpcion1().addActionListener(this);
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
    }
    
    
}
