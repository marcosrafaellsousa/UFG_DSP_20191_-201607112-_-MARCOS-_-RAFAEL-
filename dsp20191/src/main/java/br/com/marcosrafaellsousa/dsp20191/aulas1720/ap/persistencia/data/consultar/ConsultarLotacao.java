package br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.consultar;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Cargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Departamento;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Funcionario;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Lotacao;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultarLotacao extends PersistenciaJdbc{


    public Lotacao consultarPorId(Long id) throws Exception{

        preparaPersistencia();

        String sql = "SELECT * FROM LOTACAO WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,id);

        Departamento departamento = new Departamento();
        Cargo cargo = new Cargo();
        Funcionario funcionario = new Funcionario();
        Lotacao lotacao = null;
        ResultSet rs = pstmt.executeQuery(  );
        while(rs.next()){
            lotacao = new Lotacao();
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

    //O método retorna uma lista de lotações com os funcionarios e os cargps, os departamentos não são preenchidos
    public ArrayList<Lotacao> consultarPorCargoEDep (Cargo cargo, Departamento departamento) throws Exception {
        preparaPersistencia();
        ArrayList<Lotacao> listaLotacoes = new ArrayList<Lotacao>();
        String sql = "SELECT * FROM LOTACAO WHERE idCargo = ? AND idDepartamento = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, cargo.getId());
        pstmt.setLong(2, departamento.getId());

        ResultSet rs = pstmt.executeQuery(  );
        while(rs.next()) {
            Funcionario funcionario = new Funcionario();
            Lotacao lotacao = new Lotacao();
            lotacao.setId(rs.getLong("id"));
            lotacao.setDataInicial(rs.getString("dataInicial"));
            lotacao.setDataFinal(rs.getString("dataFinal"));
            long idFuncionario = (rs.getLong("idFuncionario"));
            funcionario = new ConsultarFuncionario().consultarPorId(idFuncionario);
            lotacao.setFuncionario(funcionario);
            lotacao.setCargo(cargo);
            lotacao.setDepartamento(departamento);
            listaLotacoes.add(lotacao);
        }
        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return listaLotacoes;
    }
}