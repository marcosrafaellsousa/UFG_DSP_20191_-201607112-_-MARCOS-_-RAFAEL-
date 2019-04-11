package br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.consultar;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Cargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Departamento;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Funcionario;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Lotacao;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultarLotacao extends PersistenciaJdbc{
    private Lotacao lotacao;

    public ConsultarLotacao() {
        lotacao = new Lotacao();
    }

    public Lotacao consultarPorId(Long id) throws Exception{

        preparaPersistencia();

        String sql = "SELECT * FROM DEPARTAMENTO WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,id);

        Departamento departamento = new Departamento();
        Cargo cargo = new Cargo();
        Funcionario funcionario = new Funcionario();
        ResultSet rs = pstmt.executeQuery(  );
        while(rs.next()){
            lotacao.setId(rs.getLong("id"));
            lotacao.setDataInicial(rs.getString("dataInicial"));
            lotacao.setDataFinal(rs.getString("dataFinal"));
            cargo.setId(rs.getLong("idCargo"));
            departamento.setId(rs.getLong("idDepartamento"));
            funcionario.setId(rs.getLong("idFuncionario"));
            lotacao.setCargo(cargo);
            lotacao.setDepartamento(departamento);
            lotacao.setFuncionario(funcionario);
        }

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return lotacao;
    }
}
