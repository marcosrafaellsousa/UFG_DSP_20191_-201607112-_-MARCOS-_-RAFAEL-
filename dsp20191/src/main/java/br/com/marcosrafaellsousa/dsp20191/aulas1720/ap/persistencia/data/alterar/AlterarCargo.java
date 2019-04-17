package br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.alterar;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Cargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class AlterarCargo extends PersistenciaJdbc {
    public boolean alterarCargo(Cargo cargo) throws Exception{

        preparaPersistencia();

        String sql = "UPDATE CARGO " +
                "SET id = '" + cargo.getId() +
                "', nome = '" + cargo.getNome() +
                "', salario = '" + cargo.getSalario() +
                "' WHERE id = '" + cargo.getId() +  "';" ;

        stmt.executeUpdate(sql);
        System.out.println("O Cargo foi atualizado no banco de dados");

        stmt.close();
        connection.close();

        return true;
    }
}
