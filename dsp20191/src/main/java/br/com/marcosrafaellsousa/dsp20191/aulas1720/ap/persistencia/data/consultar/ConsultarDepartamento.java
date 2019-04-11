package br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.consultar;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Departamento;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultarDepartamento extends PersistenciaJdbc{
    private Departamento departamento;

    public ConsultarDepartamento() {
        departamento = new Departamento();
    }

    public Departamento consultarPorId(Long id) throws Exception{

        preparaPersistencia();

        String sql = "SELECT * FROM DEPARTAMENTO WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,id);

        ResultSet rs = pstmt.executeQuery(  );
        while(rs.next()){
            departamento.setId(rs.getLong("id"));
            departamento.setNome(rs.getString("nome"));
        }

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return departamento;
    }
}
