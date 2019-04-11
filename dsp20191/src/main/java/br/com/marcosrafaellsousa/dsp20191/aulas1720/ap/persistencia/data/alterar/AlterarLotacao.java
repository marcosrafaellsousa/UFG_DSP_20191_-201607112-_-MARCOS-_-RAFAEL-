package br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.alterar;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Lotacao;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class AlterarLotacao extends PersistenciaJdbc {
    public boolean persisteAluno(Lotacao lotacao) throws Exception{

        preparaPersistencia();

        String sql = "UPDATE CARGO " +
                "SET id = '" + lotacao.getId() +
                "', dataInicial = " + lotacao.getDataInicial() +
                ", dataFinal = " + lotacao.getDataFinal() +
                ", idCargo = '" + lotacao.getCargo().getId() +
                "', idDepartamento = '" + lotacao.getDepartamento().getId() +
                "', idFuncionario = '" + lotacao.getFuncionario().getId() +
                "' WHERE id = '" + lotacao.getId() +  "';" ;

        stmt.executeUpdate(sql);
        System.out.println("A Lotacao foi atualizado no banco de dados");

        stmt.close();
        connection.close();

        return true;
    }
}
