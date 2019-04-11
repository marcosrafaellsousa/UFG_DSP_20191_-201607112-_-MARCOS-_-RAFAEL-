package br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.alterar;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Funcionario;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class AlterarFuncionario extends PersistenciaJdbc {
    public boolean persisteAluno(Funcionario funcionario) throws Exception{

        preparaPersistencia();

        String sql = "UPDATE CARGO " +
                "SET id = '" + funcionario.getId() +
                "', nome = '" + funcionario.getNome() +
                "', matricula = '" + funcionario.getMatricula() +
                "' WHERE id = '" + funcionario.getId() +  "';" ;

        stmt.executeUpdate(sql);
        System.out.println("O Funcionario foi atualizado no banco de dados");

        stmt.close();
        connection.close();

        return true;
    }
}
