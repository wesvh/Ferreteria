package Ferreteria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {
   Conexion start = new Conexion();   
   Scanner leer =  new Scanner(System.in);
   Scanner leerx2 = new Scanner (System.in);
   public void agregarProductos() throws SQLException{
       start.EstableciendoConexion();
        String insert = "INSERT INTO  productos (nombre,referencia,valor_compra,valor_venta,cantidad,categoria) VALUES (?,?,?,?,?,?)";
        String nombre,referencia,categoria;
        int valor_compra,valor_venta,cantidad;
        System.out.println("\nIngrese nombre :");
        nombre=leer.nextLine();
        System.out.println("\nIngrese referencia :");
        referencia=leerx2.nextLine();
        System.out.println("\nIngrese valor de compra:");
        valor_compra = leer.nextInt();
        System.out.println("\nIngrese valor de venta :");
        valor_venta=leerx2.nextInt();
        System.out.println("\nIngrese cantidad :");
        cantidad =  leer.nextInt();
        System.out.println("\nIngrese una aproximacion a la categoria :");
        categoria = leerx2.nextLine();        
        PreparedStatement INSERT = start.getConexion().prepareStatement(insert);
        //Se reemplaza cada ? , en orden siendo (x,valor) x el numero del ? a reemplazar por "valor"
        INSERT.setString(1 , nombre); 
        INSERT.setString(2 , referencia);
        INSERT.setInt(3 , valor_compra);
        INSERT.setInt(4 , valor_venta);
        INSERT.setInt(5 , cantidad);
        INSERT.setString(6 , categoria);
        int rowsInserted = INSERT.executeUpdate(); //ejecuta el script de SQL
        if ( rowsInserted > 0) {
        System.out.println (" Insercion exitosa !"); //Devuelve esto si se logro hacer la insercion
        }
    }
   public void modificarProductos(int opcion, String referencia) throws SQLException{        
        start.EstableciendoConexion();
        switch (opcion) {
            case 1:
        String update = "UPDATE productos SET nombre=? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
        PreparedStatement UPDATE = start.getConexion().prepareStatement(update);
        System.out.println("\nINGRESE EL NOMBRE:");
        String nombre = leer.nextLine();
        UPDATE.setString(1, nombre); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
        UPDATE.setString(2,referencia);
        int rowsUpdated = UPDATE.executeUpdate();
                break;
            case 2:
        update = "UPDATE productos SET valor_compra =? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
        UPDATE = start.getConexion().prepareStatement(update);
        System.out.println("\nINGRESE EL PRECIO DE COMPRA:");
        int valor_compra = leer.nextInt();
        UPDATE.setInt(1, valor_compra); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
        UPDATE.setString(2,referencia);
        rowsUpdated = UPDATE.executeUpdate();
        break;
             case 3:
        update = "UPDATE productos SET valor_venta =? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
        UPDATE = start.getConexion().prepareStatement(update);
        System.out.println("\nINGRESE EL PRECIO DE VENTA:");
        int valor_venta = leer.nextInt();
        UPDATE.setInt(1, valor_venta); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
        UPDATE.setString(2,referencia);
        rowsUpdated = UPDATE.executeUpdate();
        break;
             case 4:
        update = "UPDATE productos SET cantidad =? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
        UPDATE = start.getConexion().prepareStatement(update);
        System.out.println("\nINGRESE LA CANTIDAD:");
        int cantidad = leer.nextInt();
        UPDATE.setInt(1, cantidad); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
        UPDATE.setString(2,referencia);
        rowsUpdated = UPDATE.executeUpdate();
        break;
              case 5:
        update = "UPDATE productos SET categoria=? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
        UPDATE = start.getConexion().prepareStatement(update);
        System.out.println("\nINGRESE LA DESCRIPCION DE CATEGORIA:");
        String categoria = leer.nextLine();
        UPDATE.setString(1, categoria); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
        UPDATE.setString(2,referencia);
        rowsUpdated = UPDATE.executeUpdate();
        break;                 
            case 6:
        update = "UPDATE productos SET nombre=?, valor_compra =?, valor_venta=?, cantidad=?, categoria=? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
        UPDATE = start.getConexion().prepareStatement(update);
        System.out.println("\nINGRESE EL NOMBRE:");
        nombre = leerx2.nextLine();
        System.out.println("\nINGRESE EL PRECIO DE COMPRA:");
        valor_venta = leer.nextInt();
        System.out.println("\nINGRESE EL PRECIO DE VENTA:");
        valor_compra = leerx2.nextInt();
        System.out.println("\nINGRESE LA CANTIDAD:");
        cantidad = leer.nextInt();
        System.out.println("\nINGRESE LA DESCRIPCION DE CATEGORIA:");
        categoria = leerx2.nextLine();
        UPDATE.setString(1, nombre);
        UPDATE.setInt(2, valor_venta);//SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
        UPDATE.setInt(3, valor_compra);
        UPDATE.setInt(4, cantidad);
        UPDATE.setString(5, categoria);
        UPDATE.setString(6,referencia);
        rowsUpdated = UPDATE.executeUpdate();
        break;}//Se enumera la cantidad de actualizaciones
       }
   public ArrayList<String> consultarReferencia() throws SQLException{
        start.EstableciendoConexion();
        ArrayList<String> referencias = new ArrayList<String>();
        String select = "SELECT referencia FROM productos" ; //Script de la consulta a listar
        Statement SELECT = start.getConexion().createStatement();
        ResultSet result =SELECT.executeQuery(select); //Se le otorga la variable de select
        while (result.next()){
        int i =0;
        referencias.add(result.getString(1));
        i++;
       //Se establece en el GET el numero correspondiente al valor dentro de la lista a desear obtener
        }return referencias;}
   public void listarProductos() throws SQLException{
        start.EstableciendoConexion();
        String select = "SELECT * FROM productos" ; //Script de la consulta a listar
        Statement SELECT = start.getConexion().createStatement();
        ResultSet result =SELECT.executeQuery(select); //Se le otorga la variable de select
        while (result.next()){
        String nombre = result.getString(1); //Se establece en el GET el numero correspondiente al valor dentro de la lista a desear obtener
        String referencia = result.getString(2);
        int valor_compra = result.getInt(3);
        int valor_venta= result.getInt(4);
        int cantidad = result.getInt(5);
        String categoria = result.getString(6);
        System.out.println("Nombre del producto: " + nombre + " REFERENCIA: " + referencia+" precio de compra: " +valor_compra+" precio de venta: " +valor_venta+ " CANTIDAD: "+cantidad + " Categoria: " +categoria);} }
   public void consultarProductos() throws SQLException {
        PreparedStatement SELECT;
        ResultSet result;
        String select = "SELECT * FROM productos WHERE referencia = ?"; //Script de la consulta a listar
        try {
            start.EstableciendoConexion();
            SELECT = start.getConexion().prepareStatement(select);
            System.out.println("\nIngrese referencia :");
            String referencia;          
            referencia = leer.nextLine();
            SELECT.setString(1, referencia);
            result = SELECT.executeQuery(); //Se le otorga la variable de select
            if (result.next()) {
                String nombre = result.getString(1);
                String ref = result.getString(2); //Se establece en el GET el numero correspondiente al valor dentro de la lista a desear obtener
                int valor_compra = result.getInt(3);
                int valor_venta = result.getInt(4);
                int cantidad = result.getInt(5);
                String categoria = result.getString(6);
                System.out.println("\n" + "Nombre del producto: " + nombre + "; Codigo de producto: " + ref
                        + "; Valor de compra: " + valor_compra + "; Valor de venta: " + valor_venta
                        + "; Cantidad: " + cantidad + "; Categoria" + categoria + "\n");
            }
            start.cerrandoConexion();
        } catch (Exception e) {
            System.out.println("invalida");
        }

    }
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
