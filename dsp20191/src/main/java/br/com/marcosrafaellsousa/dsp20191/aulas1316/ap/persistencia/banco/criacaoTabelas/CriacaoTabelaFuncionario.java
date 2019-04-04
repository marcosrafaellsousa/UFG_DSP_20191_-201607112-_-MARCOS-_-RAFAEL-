package br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.banco.criacaoTabelas;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class CriacaoTabelaFuncionario extends PersistenciaJdbc {

    public boolean criaTabela() throws Exception{

        preparaPersistencia();

        System.out.println("Criando a tabela Funcionario");

        String sql = " CREATE TABLE IF NOT EXISTS FUNCIONARIO (\n" +
                " id LONG NOT NULL,\n" +
                " nome VARCHAR(255) NOT NULL,\n" +
                " matricula LONG NOT NULL,\n" +
                " PRIMARY KEY (id));";

        stmt.executeUpdate(sql);

        System.out.println("A tabela Funcionario foi criada!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }
}
