package Ferreteria;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
//AUTORES : Esteban Villada Henao, Cristian Roa y Giovany Andrés Molina
public class Conexion {
    Scanner leer =  new Scanner(System.in);
    private Connection conexion;
    private Properties mispropiedades;
    
    public Conexion(){
        mispropiedades = new Properties();
        conexion = null;
        try {
            mispropiedades.load(new FileReader("src/pswd.properties"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
              }

    public void EstableciendoConexion() {
        String db = mispropiedades.getProperty("database");
        String iploc = mispropiedades.getProperty("IPLocal");
        String user = mispropiedades.getProperty("usuario");
        String pass = mispropiedades.getProperty("pass");
        String url = "jdbc:mysql://"+iploc+":3306/"+db+"";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public Connection getConexion() {
        return conexion;
    }
        
    public void cerrandoConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}
