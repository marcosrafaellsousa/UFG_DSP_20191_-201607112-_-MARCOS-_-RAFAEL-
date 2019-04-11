package br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.data.insercao;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Cargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class InsereCargo extends PersistenciaJdbc{

    public boolean persisteCargo(Cargo cargo) throws Exception{

        preparaPersistencia();

        String sql = "INSERT INTO CARGO " +
                "VALUES('" + cargo.getId() +
                "','" + cargo.getNome() +
                "','" + cargo.getSalario() +
                "')";

        stmt.executeUpdate(sql);
        System.out.println("O Cargo foi inserido na tabela corretamente.");

        stmt.close();
        connection.close();

        return true;
    }
}
