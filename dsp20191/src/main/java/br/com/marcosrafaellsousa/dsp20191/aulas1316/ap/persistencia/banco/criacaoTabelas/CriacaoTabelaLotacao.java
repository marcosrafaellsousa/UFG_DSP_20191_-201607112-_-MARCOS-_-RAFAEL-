package br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.banco.criacaoTabelas;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class CriacaoTabelaLotacao extends PersistenciaJdbc {

    public boolean criaTabela() throws Exception{

        preparaPersistencia();

        System.out.println("Criando a tabela Lotacao");

        String sql = " CREATE TABLE IF NOT EXISTS LOTACAO (\n" +
                " id LONG NOT NULL,\n" +
                " dataInicial VARCHAR(10) NOT NULL,\n" +
                " dataFinal VARCHAR(10),\n" +
                " idCargo VARCHAR(20) NOT NULL,\n" +
                " idDepartamento VARCHAR(20) NOT NULL,\n" +
                " idFuncionario VARCHAR(20) NOT NULL,\n" +
                " PRIMARY KEY (id))\n";

        stmt.executeUpdate(sql);

        System.out.println("A tabela Lotacao foi criada!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }
}
