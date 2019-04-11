package br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.data.insercao;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Departamento;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class InsereDepartamento extends PersistenciaJdbc{

    public boolean persisteDepartamento(Departamento departamento) throws Exception{

        preparaPersistencia();

        String sql = "INSERT INTO DEPARTAMENTO " +
                "VALUES('" + departamento.getId() +
                "','" + departamento.getNome() +
                "')";

        stmt.executeUpdate(sql);
        System.out.println("O Departamento foi inserido na tabela corretamente.");

        stmt.close();
        connection.close();

        return true;
    }
}
