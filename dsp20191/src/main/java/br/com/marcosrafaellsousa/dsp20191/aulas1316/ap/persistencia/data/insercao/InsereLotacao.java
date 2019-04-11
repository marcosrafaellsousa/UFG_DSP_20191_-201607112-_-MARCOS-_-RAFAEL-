package br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.data.insercao;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Lotacao;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class InsereLotacao extends PersistenciaJdbc{

    public boolean persisteLotacao(Lotacao lotacao) throws Exception{

        preparaPersistencia();

        String sql = "INSERT INTO LOTACAO " +
                "VALUES('" + lotacao.getId() +
                "','" + lotacao.getDataInicial() +
                "','" + lotacao.getDataFinal() +
                "','" + lotacao.getCargo().getId() +
                "','" + lotacao.getDepartamento().getId() +
                "','" + lotacao.getFuncionario().getId() +
                "')";

        stmt.executeUpdate(sql);
        System.out.println("A Lotacao foi inserido na tabela corretamente.");

        stmt.close();
        connection.close();

        return true;
    }
}
