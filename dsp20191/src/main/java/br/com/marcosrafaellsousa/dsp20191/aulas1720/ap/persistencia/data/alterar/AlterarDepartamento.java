package br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.alterar;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Departamento;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class AlterarDepartamento extends PersistenciaJdbc {
    public boolean persisteAluno(Departamento departamento) throws Exception{

        preparaPersistencia();

        String sql = "UPDATE DEPARTAMENTO " +
                "SET id = '" + departamento.getId() +
                "', nome = '" + departamento.getNome() +
                "' WHERE id = '" + departamento.getId() +  "';" ;

        stmt.executeUpdate(sql);
        System.out.println("O Departamento foi atualizado no banco de dados");

        stmt.close();
        connection.close();

        return true;
    }
}
