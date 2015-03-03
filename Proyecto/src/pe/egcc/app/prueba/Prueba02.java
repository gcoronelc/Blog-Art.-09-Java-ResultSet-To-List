package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import pe.egcc.app.db.AccesoDB;
import pe.egcc.app.util.JdbcUtil;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 */
public class Prueba02 {
  
  public static void main(String[] args) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_cliecodigo cod, vch_cliepaterno pat, "
              + "vch_cliematerno mat, vch_clienombre nom "
              + "from cliente";
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      List<Map<String,?>> lista = JdbcUtil.rsToList(rs);
      rs.close();
      pstm.close();
      for (Map<String, ?> map : lista) {
        System.out.println(map.get("cod") + " " + 
                map.get("pat") + " " + 
                map.get("mat") + " " + 
                map.get("nom") );
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    } finally {
      try {
        if(cn != null) cn.close();
      } catch (Exception e) {
      }
    }
  }

}
