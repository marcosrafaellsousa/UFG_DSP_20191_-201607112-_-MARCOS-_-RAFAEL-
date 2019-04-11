package br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.consultar;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Cargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultarCargo extends PersistenciaJdbc{
    private Cargo cargo;

    public ConsultarCargo() {
        cargo = new Cargo();
    }

    public Cargo consultarPorId(Long id) throws Exception{

        preparaPersistencia();

        String sql = "SELECT * FROM CARGO WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,id);

        ResultSet rs = pstmt.executeQuery(  );
        while(rs.next()){
            cargo.setId(rs.getLong("id"));
            cargo.setNome(rs.getString("nome"));
            cargo.setSalario(rs.getDouble("salario"));
        }

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return cargo;
    }
}
