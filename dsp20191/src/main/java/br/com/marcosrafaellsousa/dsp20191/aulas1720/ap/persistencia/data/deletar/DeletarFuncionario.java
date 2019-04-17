package br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.deletar;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Funcionario;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.consultar.ConsultarFuncionario;

import java.sql.PreparedStatement;

public class DeletarFuncionario extends PersistenciaJdbc{

    public boolean deletarFuncionarioPorId(Long id){
        boolean result = false;
        try {
            Funcionario funcionario = new ConsultarFuncionario().consultarPorId(id);
            if (funcionario.getId() != 0){
                preparaPersistencia();

                String sql = "DELETE FROM FUNCIONARIO WHERE id = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1,id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("O Funcionario foi excluido do banco de dados");
                pstmt.close();
            }else{
                System.out.println("Não foi encontrado Funcionario com id = " + id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
