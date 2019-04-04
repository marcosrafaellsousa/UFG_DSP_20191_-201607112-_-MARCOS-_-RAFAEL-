package br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.data.insercao;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Funcionario;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class InsereFuncionario extends PersistenciaJdbc{

    public boolean persisteAluno(Funcionario funcionario) throws Exception{

        preparaPersistencia();

        String sql = "INSERT INTO FUNCIONARIO " +
                "VALUES('" + funcionario.getId() +
                "','" + funcionario.getNome() +
                "','" + funcionario.getMatricula() +
                "')";

        stmt.executeUpdate(sql);
        System.out.println("O Funcionario foi inserido na tabela corretamente.");

        stmt.close();
        connection.close();

        return true;
    }
}
