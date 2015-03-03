package pe.egcc.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 */
public class AccesoDB {

  private AccesoDB() {
  }

  public static Connection getConnection() throws SQLException {
    Connection cn = null;
    try {
      // Datos Oracle
      String driver = "oracle.jdbc.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:XE";
      String user = "eureka";
      String pass = "admin";
      // Datos SQL Server
      /*String driver = "net.sourceforge.jtds.jdbc.Driver";
      String url = "jdbc:jtds:sqlserver://localhost:1433/EUREKABANK";
      String user = "sa";
      String pass = "sql";*/
      // Datos MySQL
      /*String driver = "com.mysql.jdbc.Driver";
      String url = "jdbc:mysql://localhost:3306/EUREKABANK";
      String user = "eureka";
      String pass = "admin";*/
      // Cargar el driver a memoria
      Class.forName(driver).newInstance();
      // Obtener el objeto Connection
      cn = DriverManager.getConnection(url, user, pass);
    } catch (SQLException e) {
      throw e;
    } catch(ClassNotFoundException e){
      throw new SQLException("ERROR, no se encuentra el driver.");
    } catch(Exception e){
      throw new SQLException("ERROR, no se tiene acceso al servidor.");
    }
    return cn;
  }
}
