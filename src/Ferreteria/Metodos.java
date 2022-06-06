package Ferreteria;
import View.Vista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

//AUTORES : Esteban Villada Henao, Cristian Camilo Roa Rojas y Giovany Andrés Molina
public class Metodos {

    private Vista vista;
    Conexion start = new Conexion();
    Scanner leer = new Scanner(System.in);
    Scanner numerar = new Scanner(System.in);

    public Metodos() {
        this.vista = new Vista();
    }

    public void agregarProductos() throws SQLException {
        start.EstableciendoConexion();
        String insert = "INSERT INTO  productos (nombre,referencia,valor_compra,valor_venta,cantidad,categoria) VALUES (?,?,?,?,?,?)";
<<<<<<< HEAD
        String nombre,referencia,categoria,valor_compra,valor_venta,cantidad;      
=======
        String nombre,referencia,categoria,valor_compra,valor_venta,cantidad;
>>>>>>> 9de71fdf7b2046c68faa7d5dde7eb9c8a931fe70
        nombre = vista.leerDatoString("\nIngrese nombre :");        
        boolean continuar = false;
        do {
            /*
            System.out.println("\nIngrese referencia :");
            referencia = leer.nextLine();
            */
            referencia = vista.leerDatoString("\nIngrese referencia:");
            char[] contador = referencia.toCharArray();
            if (contador.length > 5) {
                System.out.println("Cantidad de caracteres invalida, la referencia tiene 5 caracteres maximo.");}
          else {continuar=true;}
        }while(continuar == false);
        do{
        System.out.println("\nIngrese valor de compra:");
        valor_compra = numerar.nextLine();
            if (isNumeric(valor_compra) == false) {
                System.out.println("Caracter invalido, intente nuevamente. Recuerde ingresar SOLO NUMEROS");
            } 
        }while(isNumeric(valor_compra) == false);
        do{
        System.out.println("\nIngrese valor de venta :");
        valor_venta=numerar.nextLine();
            if (isNumeric(valor_venta) == false) {
                System.out.println("Caracter invalido, intente nuevamente. Recuerde ingresar SOLO NUMEROS");
            } 
        }while(isNumeric(valor_venta) == false);
        do{
        System.out.println("\nIngrese cantidad :");
        cantidad =  numerar.nextLine();
            if (isNumeric(cantidad) == false) {
                System.out.println("Caracter invalido, intente nuevamente. Recuerde ingresar SOLO NUMEROS");
            } 
        }while(isNumeric(cantidad) == false);
        System.out.println("\nIngrese una aproximacion a la categoria :");
        categoria = leer.nextLine(); 
        PreparedStatement INSERT = start.getConexion().prepareStatement(insert);
        //Se reemplaza cada ? , en orden siendo (x,valor) x el numero del ? a reemplazar por "valor"
        INSERT.setString(1 , nombre); 
        INSERT.setString(2 , referencia);
        INSERT.setInt(3 , Integer.parseInt(valor_compra));
        INSERT.setInt(4 , Integer.parseInt(valor_venta));
        INSERT.setInt(5 , Integer.parseInt(cantidad));
        INSERT.setString(6 , categoria);
        int rowsInserted = INSERT.executeUpdate(); //ejecuta el script de SQL
        if (rowsInserted > 0) {
            System.out.println(" Insercion exitosa !\n"); //Devuelve esto si se logro hacer la insercion
        }
    }

    public void modificarProductos(int opcion, String referencia) throws SQLException {
        start.EstableciendoConexion();
        switch (opcion) {
            case 1:
                String update = "UPDATE productos SET nombre=? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
                PreparedStatement UPDATE = start.getConexion().prepareStatement(update);
                System.out.println("\nINGRESE EL NOMBRE:");
                String nombre = leer.nextLine();
                UPDATE.setString(1, nombre); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
                UPDATE.setString(2, referencia);
                int rowsUpdated = UPDATE.executeUpdate();
                break;
            case 2:
        update = "UPDATE productos SET valor_compra =? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
        UPDATE = start.getConexion().prepareStatement(update);
        String valor_compra;
        do{
        System.out.println("\nIngrese valor de compra:");
        valor_compra = numerar.nextLine();
            if (isNumeric(valor_compra) == false) {
                System.out.println("Caracter invalido, intente nuevamente. Recuerde ingresar SOLO NUMEROS");
            } 
        }while(isNumeric(valor_compra) == false);
        UPDATE.setInt(1, Integer.parseInt(valor_compra)); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
        UPDATE.setString(2,referencia);
        rowsUpdated = UPDATE.executeUpdate();
        break;
             case 3:
        update = "UPDATE productos SET valor_venta =? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
        UPDATE = start.getConexion().prepareStatement(update);
        String valor_venta;
        do{
        System.out.println("\nIngrese valor de venta :");
        valor_venta=numerar.nextLine();
            if (isNumeric(valor_venta) == false) {
                System.out.println("Caracter invalido, intente nuevamente. Recuerde ingresar SOLO NUMEROS");
            } 
        }while(isNumeric(valor_venta) == false);
        UPDATE.setInt(1, Integer.parseInt(valor_venta)); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
        UPDATE.setString(2,referencia);
        rowsUpdated = UPDATE.executeUpdate();
        break;
             case 4:
        update = "UPDATE productos SET cantidad =? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
        UPDATE = start.getConexion().prepareStatement(update);
        String cantidad;
        do{
        System.out.println("\nIngrese cantidad :");
        cantidad =  numerar.nextLine();
            if (isNumeric(cantidad) == false) {
                System.out.println("Caracter invalido, intente nuevamente. Recuerde ingresar SOLO NUMEROS");
            } 
        }while(isNumeric(cantidad) == false);
        UPDATE.setInt(1, Integer.parseInt(cantidad)); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
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
        nombre = leer.nextLine();
        do{
        System.out.println("\nIngrese valor de compra:");
        valor_compra = numerar.nextLine();
            if (isNumeric(valor_compra) == false) {
                System.out.println("Caracter invalido, intente nuevamente. Recuerde ingresar SOLO NUMEROS");
            } 
        }while(isNumeric(valor_compra) == false);
        do{
        System.out.println("\nIngrese valor de venta :");
        valor_venta=numerar.nextLine();
            if (isNumeric(valor_venta) == false) {
                System.out.println("Caracter invalido, intente nuevamente. Recuerde ingresar SOLO NUMEROS");
            } 
        }while(isNumeric(valor_venta) == false);
        do{
        System.out.println("\nIngrese cantidad :");
        cantidad =  numerar.nextLine();
            if (isNumeric(cantidad) == false) {
                System.out.println("Caracter invalido, intente nuevamente. Recuerde ingresar SOLO NUMEROS");
            } 
        }while(isNumeric(cantidad) == false);
        System.out.println("\nINGRESE LA DESCRIPCION DE CATEGORIA:");
        categoria = leer.nextLine();
        UPDATE.setString(1, nombre);
        UPDATE.setInt(2, Integer.parseInt(valor_venta));//SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
        UPDATE.setInt(3, Integer.parseInt(valor_compra));
        UPDATE.setInt(4, Integer.parseInt(cantidad));
        UPDATE.setString(5, categoria);
        UPDATE.setString(6,referencia);
        rowsUpdated = UPDATE.executeUpdate();
        break;}//Se enumera la cantidad de actualizaciones
       }
   public ArrayList<String> consultarReferencia() throws SQLException{
        start.EstableciendoConexion();
        ArrayList<String> referencias = new ArrayList<String>();
        String select = "SELECT referencia FROM productos"; //Script de la consulta a listar
        Statement SELECT = start.getConexion().createStatement();
        ResultSet result = SELECT.executeQuery(select); //Se le otorga la variable de select
        while (result.next()) {
            int i = 0;
            referencias.add(result.getString(1));
            i++;
            //Se establece en el GET el numero correspondiente al valor dentro de la lista a desear obtener
        }
        return referencias;
    }

    public String listarProductos() throws SQLException {
        ArrayList<String> temporal = new ArrayList<String>();
        start.EstableciendoConexion();
        String select = "SELECT * FROM productos"; //Script de la consulta a listar
        Statement SELECT = start.getConexion().createStatement();
        ResultSet result = SELECT.executeQuery(select); //Se le otorga la variable de select
        while (result.next()) {
            String nombre = result.getString(1); //Se establece en el GET el numero correspondiente al valor dentro de la lista a desear obtener
            String referencia = result.getString(2);
            int valor_compra = result.getInt(3);
            int valor_venta = result.getInt(4);
            int cantidad = result.getInt(5);
            String categoria = result.getString(6);
            System.out.println("\n Nombre del producto: " + nombre + "\n REFERENCIA: " + referencia + "\n precio de compra: " + valor_compra + "\n precio de venta: " + valor_venta + "\n CANTIDAD: " + cantidad + "\n Categoria: " + categoria + "\n");
            temporal.add("\n Nombre del producto: " + nombre + "\n REFERENCIA: " + referencia + "\n precio de compra: " + valor_compra + "\n precio de venta: " + valor_venta + "\n CANTIDAD: " + cantidad + "\n Categoria: " + categoria + "\n");
            
        }
        String rta= "";
        for (int j = 0; j < temporal.size(); j++) {
           rta += "\n"+temporal.get(j);
        }
    return rta;
    }

    public void consultarProductos() throws SQLException {
        PreparedStatement SELECT;
        ResultSet result;
        String select = "SELECT * FROM productos WHERE referencia = ?"; //Script de la consulta a listar
        try {
            start.EstableciendoConexion();
            SELECT = start.getConexion().prepareStatement(select);
            /*
            System.out.println("\nIngrese referencia :");
            String referencia;          
            referencia = leer.nextLine();
             */
            String referencia = vista.leerDatoString("\nIngrese referencia:");
            SELECT.setString(1, referencia);
            result = SELECT.executeQuery(); //Se le otorga la variable de select
            if (result.next()) {
                String nombre = result.getString(1);
                String ref = result.getString(2); //Se establece en el GET el numero correspondiente al valor dentro de la lista a desear obtener
                int valor_compra = result.getInt(3);
                int valor_venta = result.getInt(4);
                int cantidad = result.getInt(5);
                String categoria = result.getString(6);
                System.out.println("\n" + "Nombre del producto: " + nombre
                        + ";\n Codigo de producto: " + ref
                        + ";\n Valor de compra: " + valor_compra
                        + ";\n Valor de venta: " + valor_venta
                        + ";\n Cantidad: " + cantidad
                        + ";\n Categoria: " + categoria + "\n");
            }
            start.cerrandoConexion();
        } catch (Exception e) {
            System.out.println("invalida");
        }

    }

    public void borrarProductos() throws SQLException {
        //SCRIPT DE BORRADO
        start.EstableciendoConexion();
        String delete = "DELETE FROM productos WHERE referencia=?";  //Un ejemplo de borrar un dato en funcion de la referencia
        PreparedStatement DELETE = start.getConexion().prepareStatement(delete);
        String referencia;
        boolean continuar = false;
        do {
            System.out.println("\nIngrese la referencia del producto a eliminar");
            referencia = leer.nextLine();
            char[] contador = referencia.toCharArray();
            if (contador.length > 5) {
                System.out.println("Cantidad de caracteres invalida, la referencia tiene 5 caracteres maximo.");
            } else {
                continuar = true;
            }
        } while (continuar == false);
        DELETE.setString(1, referencia); // Mismo caso de reemplazo
        int rowsDeleted = DELETE.executeUpdate(); //FUNCION DE ELIMINAR
        if (rowsDeleted>0) {
            System.out.println("BORRADO EXITOSO\n");            
        }}
    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
}


