package br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.banco.criacaoTabelas;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class CriacaoTabelaLotacao extends PersistenciaJdbc {

    public boolean criaTabela() throws Exception{

        preparaPersistencia();

        System.out.println("Criando a tabela Lotacao");

        String sql = " CREATE TABLE IF NOT EXISTS LOTACAO (\n" +
                " id LONG NOT NULL,\n" +
                " nome VARCHAR(255) NOT NULL,\n" +
                " dataInicial DATE NOT NULL,\n" +
                " dataFinal DATE,\n" +
                " idCargo VARCHAR(20) NOT NULL,\n" +
                " idDepartamento VARCHAR(20) NOT NULL,\n" +
                " PRIMARY KEY (id),\n" +
                " FOREIGN KEY (`idCargo`)\n" +
                " REFERENCES `AULAS1316`.`CARGO` (`id`),\n" +
                " FOREIGN KEY (`idDepartamento`)\n" +
                " REFERENCES `AULAS1316`.`DEPARTAMENTO` (`id`));";

        stmt.executeUpdate(sql);

        System.out.println("A tabela Lotacao foi criada!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }
}
