package br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.banco.criacaoTabelas;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class CriacaoTabelaCargo extends PersistenciaJdbc{

    public boolean criaTabela() throws Exception{

        preparaPersistencia();

        System.out.println("Criando a tabela Cargo");

        String sql = "CREATE TABLE IF NOT EXISTS CARGO (\n" +
                " id LONG NOT NULL,\n" +
                " nome VARCHAR(255) NOT NULL,\n" +
                " salario DOUBLE NOT NULL,\n" +
                " PRIMARY KEY (id));";

        stmt.executeUpdate(sql);

        System.out.println("A tabela Cargo foi criada!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }
}
