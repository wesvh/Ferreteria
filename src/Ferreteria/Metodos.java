package Ferreteria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Metodos {
   Conexion start = new Conexion();   
   Scanner leer =  new Scanner(System.in);
   public void agregarProductos() throws SQLException{
       start.EstableciendoConexion();
        String insert = "INSERT INTO  productos (nombre,referencia,valor_compra,valor_venta,cantidad,categoria) VALUES (?,?,?,?,?,?)";
        String nombre,referencia,categoria;
        int valor_compra,valor_venta,cantidad;
        System.out.println("");
        PreparedStatement INSERT = start.getConexion().prepareStatement(insert);
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
         start.EstableciendoConexion();
        String update = "UPDATE productos SET valor_compra =? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
        PreparedStatement UPDATE = start.getConexion().prepareStatement(update);
        UPDATE.setInt(1, 50000); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
        UPDATE.setString(2,"R0003");
        int rowsUpdated = UPDATE.executeUpdate(); //Se enumera la cantidad de actualizaciones
        if (rowsUpdated > 0) {
            System.out.println("EL REGISTRO SE ACTUALIZO CORRECTAMENTE"); //Se imprime si hay mas de 1 actualizacion.
    }}
    
        public void consultarProductos() throws SQLException{
            start.EstableciendoConexion();
                String select = "SELECT * FROM productos" ; //Script de la consulta a listar
        Statement SELECT = start.getConexion().createStatement();
        ResultSet result =SELECT.executeQuery(select); //Se le otorga la variable de select
        while (result.next()){
        String nombre = result.getString(1); //Se establece en el GET el numero correspondiente al valor dentro de la lista a desear obtener
        int cantidad = result.getInt(5);
            System.out.println("Nombre del producto: " + nombre + " Cantidad de ese producto: " + cantidad);} }
        
        public void borrarProductos() throws SQLException{
            start.EstableciendoConexion();
         String update = "UPDATE productos SET valor_compra =? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
        PreparedStatement UPDATE = start.getConexion().prepareStatement(update);
        UPDATE.setInt(1, 50000); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
        UPDATE.setString(2,"R0003");
        int rowsUpdated = UPDATE.executeUpdate(); //Se enumera la cantidad de actualizaciones
        if (rowsUpdated > 0) {
            System.out.println("EL REGISTRO SE ACTUALIZO CORRECTAMENTE"); //Se imprime si hay mas de 1 actualizacion.
        //SCRIPT DE BORRADO
        String delete = "DELETE FROM productos WHERE referencia=?";  //Un ejemplo de borrar un dato en funcion de la referencia
        PreparedStatement DELETE = start.getConexion().prepareStatement(delete);
        DELETE.setString(1,"R0003"); // Mismo caso de reemplazo
        int rowsDeleted = DELETE.executeUpdate(); //FUNCION DE ELIMINAR
        if (rowsDeleted>0) {
            System.out.println("BORRADO EXITOSO");            
        }}}
}
