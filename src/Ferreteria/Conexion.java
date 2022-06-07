package Ferreteria;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//AUTORES : Esteban Villada Henao, Cristian Camilo Roa Rojas y Giovany Andrés Molina
public class Conexion {
    String pass = "";
    String user = "";
    Scanner leer =  new Scanner(System.in);
    private Connection conexion;
    private Properties mispropiedades = new Properties();
    
    public Conexion(){
        conexion = null;
        try {
          mispropiedades.load(new FileReader("src/pswd.properties"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
              }

    public void EstableciendoConexion() throws FileNotFoundException, IOException {
        conexion = null;
        mispropiedades.load(new FileReader("src/pswd.properties"));
        String db = mispropiedades.getProperty("database");
        String iploc = mispropiedades.getProperty("IPLocal");
        user = mispropiedades.getProperty("usuario");
        pass =  mispropiedades.getProperty("pass");
        String url = "jdbc:mysql://"+iploc+":3306/"+db+"";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void conectarPrimerVez() throws IOException {
        
        String db = mispropiedades.getProperty("database");
        String iploc = mispropiedades.getProperty("IPLocal");
        user = leerDato("Ingrese el nombre de usuario de la Base de Datos");
        mispropiedades.setProperty("usuario",user);        
        pass =  leerDato("Ingrese su contraseña de la Base de Datos");
        mispropiedades.setProperty("pass",pass);        
        mispropiedades.store(new FileWriter("src/pswd.properties"),"Ingreso de credenciales");
        String url = "jdbc:mysql://"+iploc+":3306/"+db+"";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (Exception x) {
            x.printStackTrace();
        }
        
    }
    public Connection getConexion() {
        return conexion;
    }
        
        public String leerDato(String mensaje) {
        String aux = JOptionPane.showInputDialog(mensaje);
        return aux;
    }
    public void cerrandoConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}
