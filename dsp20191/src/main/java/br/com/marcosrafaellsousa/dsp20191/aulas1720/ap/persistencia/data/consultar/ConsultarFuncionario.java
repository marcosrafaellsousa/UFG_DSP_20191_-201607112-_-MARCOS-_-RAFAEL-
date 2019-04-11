package br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.consultar;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Funcionario;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultarFuncionario extends PersistenciaJdbc{
    private Funcionario funcionario;

    public ConsultarFuncionario() {
        funcionario = new Funcionario();
    }

    public Funcionario consultarPorId(Long id) throws Exception{

        preparaPersistencia();

        String sql = "SELECT * FROM DEPARTAMENTO WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,id);

        ResultSet rs = pstmt.executeQuery(  );
        while(rs.next()){
            funcionario.setId(rs.getLong("id"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setMatricula(rs.getLong("matricula"));
        }

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return funcionario;
    }
}
