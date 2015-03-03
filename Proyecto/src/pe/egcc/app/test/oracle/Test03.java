package pe.egcc.app.test.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 */
public class Test03 {

  public static void main(String[] args) {
    Connection cn = null;
    try {
      // Datos Oracle
      String driver = "oracle.jdbc.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:XE";
      String user = "eureka";
      String pass = "admin";
      // Conexión
      Class.forName(driver).newInstance();
      cn = DriverManager.getConnection(url, user, pass);
      // Consulta
      String sql = "select tm.vch_tipodescripcion tipo, "
              + "sum(m.dec_moviimporte) importe "
              + "from tipomovimiento tm join movimiento m "
              + "on tm.chr_tipocodigo = m.chr_tipocodigo "
              + "group by tm.vch_tipodescripcion";
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      // Obtener metadata
      ResultSetMetaData md = rs.getMetaData();
      int columns = md.getColumnCount();
      System.out.println("getColumnName\tgetColumnLabel");
      for (int i = 1; i <= columns; i++) {
        System.out.println(md.getColumnName(i) + "\t" + md.getColumnLabel(i));
			}
      rs.close();
      pstm.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (cn != null) {
          cn.close();
        }
      } catch (Exception e) {
      }
    }
  }

}
