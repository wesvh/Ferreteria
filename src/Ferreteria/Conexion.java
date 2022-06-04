package Ferreteria;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
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
          if (conexion!=null) {
            System.out.println("Conectado");  //Si no es null nos devuelve el mensaje
        }
    }
    
    public void agregarProductos() throws SQLException{
        String insert = "INSERT INTO  productos (nombre,referencia,valor_compra,valor_venta,cantidad,categoria) VALUES (?,?,?,?,?,?)";
        PreparedStatement INSERT = conexion.prepareStatement(insert);
        //Se reemplaza cada ? , en orden siendo (x,valor) x el numero del ? a reemplazar por "valor"
        INSERT.setString(1 , "PRUEBA DE CONEXION"); 
        INSERT.setString(2 , "R0003");
        INSERT.setInt(3 , 1000);
        INSERT.setInt(4 , 2500);
        INSERT.setInt(5 , 50);
        INSERT.setString(6 , "PVC");
        int rowsInserted = INSERT.executeUpdate(); //ejecuta el script de SQL
        if ( rowsInserted > 0) {
        System.out.println (" Insercion exitosa !"); //Devuelve esto si se logro hacer la insercion
        }
    }
    
        public void modificarProductos() throws SQLException{        
        String update = "UPDATE productos SET valor_compra =? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
        PreparedStatement UPDATE = conexion.prepareStatement(update);
        UPDATE.setInt(1, 50000); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
        UPDATE.setString(2,"R0003");
        int rowsUpdated = UPDATE.executeUpdate(); //Se enumera la cantidad de actualizaciones
        if (rowsUpdated > 0) {
            System.out.println("EL REGISTRO SE ACTUALIZO CORRECTAMENTE"); //Se imprime si hay mas de 1 actualizacion.
    }}
    
        public void consultarProductos() throws SQLException{
                String select = "SELECT * FROM productos" ; //Script de la consulta a listar
        Statement SELECT = conexion.createStatement();
        ResultSet result =SELECT.executeQuery(select); //Se le otorga la variable de select
        while (result.next()){
        String nombre = result.getString(1); //Se establece en el GET el numero correspondiente al valor dentro de la lista a desear obtener
        int cantidad = result.getInt(5);
            System.out.println("Nombre del producto: " + nombre + " Cantidad de ese producto: " + cantidad);} }
        
        public void borrarProductos() throws SQLException{
         String update = "UPDATE productos SET valor_compra =? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
        PreparedStatement UPDATE = conexion.prepareStatement(update);
        UPDATE.setInt(1, 50000); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
        UPDATE.setString(2,"R0003");
        int rowsUpdated = UPDATE.executeUpdate(); //Se enumera la cantidad de actualizaciones
        if (rowsUpdated > 0) {
            System.out.println("EL REGISTRO SE ACTUALIZO CORRECTAMENTE"); //Se imprime si hay mas de 1 actualizacion.
        //SCRIPT DE BORRADO
        String delete = "DELETE FROM productos WHERE referencia=?";  //Un ejemplo de borrar un dato en funcion de la referencia
        PreparedStatement DELETE = conexion.prepareStatement(delete);
        DELETE.setString(1,"R0003"); // Mismo caso de reemplazo
        int rowsDeleted = DELETE.executeUpdate(); //FUNCION DE ELIMINAR
        if (rowsDeleted>0) {
            System.out.println("BORRADO EXITOSO");            
        }}}
        
    public void cerrandoConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}