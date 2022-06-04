import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTemporal {
    
    public static void main(String[] args) throws SQLException {
        //Se agregan las credenciales y link de acceso a la base de datos
        String dbURL= "jdbc:mysql://localhost:3306/ferreteria"; //luego de localhost:3306/  se agrega el nombre del schema 
        String username = "root"; //credenciales
        String password = "root";
        Connection conn= null; //se inicializa la variable que comprueba conexion
        try{
        conn= DriverManager.getConnection(dbURL,username,password); //conecta
        if (conn!=null) {
            System.out.println("Conectado");  //Si no es null nos devuelve el mensaje
        }
    } catch(SQLException ex){
        ex.printStackTrace();}
        
        //Se inicializa la variable que contendra el script de INSERT   
        String sql = "INSERT INTO  productos (nombre,referencia,valor_compra,valor_venta,cantidad,categoria) VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        //Se reemplaza cada ? , en orden siendo (x,valor) x el numero del ? a reemplazar por "valor"
        statement.setString(1 , "PRUEBA DE CONEXION"); 
        statement.setString(2 , "R0003");
        statement.setInt(3 , 1000);
        statement.setInt(4 , 2500);
        statement.setInt(5 , 50);
        statement.setString(6 , "PVC");
        int rowsInserted = statement.executeUpdate(); //ejecuta el script de SQL
        if ( rowsInserted > 0) {
        System.out.println (" Insercion exitosa !"); //Devuelve esto si se logro hacer la insercion
        }
        // CONSULTAS
        String select = "SELECT * FROM productos" ; //Script de la consulta a listar
        Statement statement = conn.createStatement();
        ResultSet result =statement.executeQuery(select); //Se le otorga la variable de select
        while (result.next()){
        String nombre = result.getString(1); //Se establece en el GET el numero correspondiente al valor dentro de la lista a desear obtener
        int cantidad = result.getInt(5);
            System.out.println("Nombre del producto: " + nombre + " Cantidad de ese producto: " + cantidad);} 
        
        //SCRIPT DE UPDATE
        
        String update = "UPDATE productos SET valor_compra =? WHERE referencia=?"; //Un ejemplo de actualizacion de precio en funcion del numero de referencia
        PreparedStatement UPDATE = conn.prepareStatement(update);
        UPDATE.setInt(1, 50000); //SE REEMPLAZA IGUAL QUE EN LO ANTERIOR, PRIMERO EL NUMERO DEL '?' y luego el valor a poner sobre èl.
        UPDATE.setString(2,"R0003");
        int rowsUpdated = UPDATE.executeUpdate(); //Se enumera la cantidad de actualizaciones
        if (rowsUpdated > 0) {
            System.out.println("EL REGISTRO SE ACTUALIZO CORRECTAMENTE"); //Se imprime si hay mas de 1 actualizacion
        }}
