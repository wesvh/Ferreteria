package Ferreteria;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//AUTORES : Esteban Villada Henao, Cristian Camilo Roa Rojas y Giovany Andrés Molina
public class Metodos {

    Conexion start = new Conexion();
    String referenciaComprobar;    
    String advertenciaError="Caracter Invalido, Intente Nuevamente. Recuerde Ingresar SOLO NUMEROS";
    String upName="\nIngrese el Nombre:";
    String upRef="\nIngrese la Referencia del Producto";
    String upPrice="\nIngrese Valor de Compra:";
    String upSell="\nIngrese Valor de Venta :";
    String upAmount ="\nIngrese Cantidad :";
    String upType ="\nIngrese la Descripcion de Categoria:";

    public void agregarProductos() throws SQLException, IOException {
        start.EstableciendoConexion();
        String insert = "INSERT INTO  productos (nombre,referencia,valor_compra,valor_venta,cantidad,categoria) VALUES (?,?,?,?,?,?)";
        String nombre, referencia, categoria, valor_compra, valor_venta, cantidad;
        nombre = leerDato(upName);
        boolean continuar = false;
        do {
            referencia = leerDato(upRef);
            char[] contador = referencia.toCharArray();
            if (contador.length > 5) {
                mostrarInformacion("REFERENCIA INVALIDA, LOS CARACTERES MAXIMOS SON 5");
            } else {
                continuar = true;
            }
        } while (continuar == false);
        valor_compra=evaluadorNumerico(1);
        valor_venta=evaluadorNumerico(2);
        cantidad=evaluadorNumerico(3);
        categoria = leerDato(upType);
        PreparedStatement INSERT = start.getConexion().prepareStatement(insert);
        //Se reemplaza cada ? , en orden siendo (x,valor) x el numero del ? a reemplazar por "valor"
        INSERT.setString(1, nombre);
        INSERT.setString(2, referencia);
        INSERT.setInt(3, Integer.parseInt(valor_compra));
        INSERT.setInt(4, Integer.parseInt(valor_venta));
        INSERT.setInt(5, Integer.parseInt(cantidad));
        INSERT.setString(6, categoria);
        int rowsInserted = INSERT.executeUpdate(); //ejecuta el script de SQL
        if (rowsInserted > 0) {
            mostrarInformacion("Insercion Exitosa"); //Devuelve esto si se logro hacer la insercion
        }
    }

    public void modificarProductos() throws SQLException, IOException {
        start.EstableciendoConexion();
        String opcion = "";
        do {
            opcion = leerDato("\nEscoja que desea modificar \n" + "1.Nombre\n" + "2.Precio de compra\n" + "3.Precio de venta \n" + "4.Cantidad del producto\n"
                    + "5.Descripcion de categoria\n" + "6.Todas las anteriores\n");
            if (isNumeric(opcion) == false) {
                mostrarInformacion(advertenciaError);
            }
        } while (isNumeric(opcion) == false);

        switch (Integer.parseInt(opcion)) {
            case 1:
                String update = "UPDATE productos SET nombre=? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
                PreparedStatement UPDATE = start.getConexion().prepareStatement(update);
                String nombre = leerDato(upName);
                UPDATE.setString(1, nombre); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
                UPDATE.setString(2, referenciaComprobar);
                int rowsUpdated = UPDATE.executeUpdate();
                break;
            case 2:
                update = "UPDATE productos SET valor_compra =? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
                UPDATE = start.getConexion().prepareStatement(update);
                String valor_compra;                
                valor_compra=evaluadorNumerico(1);
                UPDATE.setInt(1, Integer.parseInt(valor_compra)); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
                UPDATE.setString(2, referenciaComprobar);
                rowsUpdated = UPDATE.executeUpdate();
                break;
            case 3:
                update = "UPDATE productos SET valor_venta =? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
                UPDATE = start.getConexion().prepareStatement(update);
                String valor_venta;
                valor_venta=evaluadorNumerico(2);
                UPDATE.setInt(1, Integer.parseInt(valor_venta)); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
                UPDATE.setString(2, referenciaComprobar);
                rowsUpdated = UPDATE.executeUpdate();
                break;
            case 4:
                update = "UPDATE productos SET cantidad =? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
                UPDATE = start.getConexion().prepareStatement(update);
                String cantidad;
                cantidad = evaluadorNumerico(3);
                UPDATE.setInt(1, Integer.parseInt(cantidad)); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
                UPDATE.setString(2, referenciaComprobar);
                rowsUpdated = UPDATE.executeUpdate();
                break;
            case 5:
                update = "UPDATE productos SET categoria=? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
                UPDATE = start.getConexion().prepareStatement(update);
                String categoria = leerDato(upType);
                UPDATE.setString(1, categoria); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
                UPDATE.setString(2, referenciaComprobar);
                rowsUpdated = UPDATE.executeUpdate();
                break;
            case 6:
                update = "UPDATE productos SET nombre=?, valor_compra =?, valor_venta=?, cantidad=?, categoria=? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
                UPDATE = start.getConexion().prepareStatement(update);
                nombre = leerDato(upName);
                valor_compra=evaluadorNumerico(1);
                valor_venta=evaluadorNumerico(2);
                cantidad=evaluadorNumerico(3);
                categoria = leerDato(upType);
                UPDATE.setString(1, nombre);
                UPDATE.setInt(2, Integer.parseInt(valor_venta));//SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
                UPDATE.setInt(3, Integer.parseInt(valor_compra));
                UPDATE.setInt(4, Integer.parseInt(cantidad));
                UPDATE.setString(5, categoria);
                UPDATE.setString(6, referenciaComprobar);
                rowsUpdated = UPDATE.executeUpdate();
                break;

            default:
                mostrarInformacion("Ocurrio un error, intentelo nuevamente");
        }
    }

    public ArrayList<String> consultarReferencia() throws SQLException, IOException {
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

    public String listarProductos() throws SQLException, IOException {
        ArrayList<String> temporal = new ArrayList<String>();
        start.EstableciendoConexion();
        String select = "SELECT * FROM productos ORDER BY cantidad ASC"; //Script de la consulta a listar
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
        String rta = "";
        for (int j = 0; j < temporal.size(); j++) {
            rta += "\n" + temporal.get(j);
        }
        return rta;
    }

    public String consultarProductos() throws SQLException {
        PreparedStatement SELECT;
        ResultSet result;
        String select = "SELECT * FROM productos WHERE referencia = ?"; //Script de la consulta a listar
        String rta = new String();
        try {
            start.EstableciendoConexion();
            SELECT = start.getConexion().prepareStatement(select);
            SELECT.setString(1, referenciaComprobar);
            result = SELECT.executeQuery(); //Se le otorga la variable de select
            if (result.next()) {
                String nombre = result.getString(1);
                String ref = result.getString(2); //Se establece en el GET el numero correspondiente al valor dentro de la lista a desear obtener
                int valor_compra = result.getInt(3);
                int valor_venta = result.getInt(4);
                int cantidad = result.getInt(5);
                String categoria = result.getString(6);
                rta = "\n" + "Nombre del producto: " + nombre
                        + "\n Codigo de producto: " + ref
                        + "\n Valor de compra: " + valor_compra
                        + "\n Valor de venta: " + valor_venta
                        + "\n Cantidad: " + cantidad
                        + "\n Categoria: " + categoria + "\n";
                System.out.println(rta);
            }
            start.cerrandoConexion();
        } catch (Exception e) {
            System.out.println("invalida");
        }
        return rta;
    }

    public void borrarProductos() throws SQLException, IOException {
        //SCRIPT DE BORRADO
        start.EstableciendoConexion();
        String delete = "DELETE FROM productos WHERE referencia=?";  //Un ejemplo de borrar un dato en funcion de la referencia
        PreparedStatement DELETE = start.getConexion().prepareStatement(delete);
        if (permitirConsultar()) {
            DELETE.setString(1, referenciaComprobar); // Mismo caso de reemplazo
            int rowsDeleted = DELETE.executeUpdate(); //FUNCION DE ELIMINAR
            if (rowsDeleted > 0) {
                System.out.println("BORRADO EXITOSO\n");
            }

        }
    }

    private static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.]+");
    }

    public int leerNumero(String mensaje) {
        String aux = JOptionPane.showInputDialog(mensaje);
        int dato = Integer.parseInt(aux);
        return dato;
    }

    public String leerDato(String mensaje) {
        String aux = JOptionPane.showInputDialog(mensaje);
        return aux;
    }

    public void mostrarInformacion(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public boolean permitirConsultar() throws SQLException, IOException {
        boolean permitir = false;
        do {
            referenciaComprobar = leerDato(upRef);
            ArrayList<String> determinantes = new ArrayList<String>();
            determinantes = consultarReferencia();
            for (int i = 0; i < determinantes.size(); i++) {
                if (determinantes.get(i).equals(referenciaComprobar)) {
                    permitir = true;
                }
            }
            if (permitir == false) {
                mostrarInformacion("REFERENCIA INEXISTENTE, intentelo nuevamente");
                break;
            }
        } while (permitir == false);
        return permitir;
    }
    public String evaluadorNumerico(int i){
        String valor ="";
        switch (i){
            case 1:do{
            valor = leerDato(upPrice);
            if (isNumeric(valor) == false) {
                mostrarInformacion(advertenciaError);
            }
        } while (isNumeric(valor) == false);
            break;
            case 2:do{
            valor = leerDato(upSell);
            if (isNumeric(valor) == false) {
                mostrarInformacion(advertenciaError);
            }
        } while (isNumeric(valor) == false);
            break;
            case 3:do{
            valor = leerDato(upAmount);
            if (isNumeric(valor) == false) {
                mostrarInformacion(advertenciaError);
            }
        } while (isNumeric(valor) == false);
            break;
        }
    return valor;}
}
