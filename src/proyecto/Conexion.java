
package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection conectar = null;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/bd_tallervideojuegos", "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conectar;
    }
}