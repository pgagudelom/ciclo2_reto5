package jar.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jar.model.vo.AsesorPorCiudadVo;
import jar.util.JDBCUtilities;

public class AsesorPorCiudadDao {

    public ArrayList<AsesorPorCiudadVo> listar() throws SQLException{

        ArrayList<AsesorPorCiudadVo> resultado = new ArrayList<AsesorPorCiudadVo>();

        Connection conn = JDBCUtilities.gConnection();

        try{
            String sql = "SELECT l.ID_Lider, l.nombre, l.Primer_Apellido, l.Ciudad_Residencia " +
                         " FROM Lider l " + 
                         " ORDER BY l.Ciudad_Residencia";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                AsesorPorCiudadVo asesor = new AsesorPorCiudadVo(
                rs.getInt("ID_Lider"),
                rs.getString("Nombre"),
                rs.getString("Primer_Apellido"),
                rs.getString("Ciudad_Residencia")
                );

                resultado.add(asesor);
            }

            rs.close();
            stmt.close();

        }finally{
            if(conn != null){
                conn.close();
            }
        }

        return resultado; 
    }

}
