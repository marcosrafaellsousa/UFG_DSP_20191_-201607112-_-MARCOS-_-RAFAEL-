package br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.deletar;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Lotacao;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.consultar.ConsultarLotacao;

import java.sql.PreparedStatement;

public class DeletarLotacao extends PersistenciaJdbc{

    public boolean deletarLotacaoPorId(Long id){
        boolean result = false;
        try {
            Lotacao lotacao = new ConsultarLotacao().consultarPorId(id);
            if (lotacao.getId() != 0){
                preparaPersistencia();

                String sql = "DELETE FROM LOTACAO WHERE id = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1,id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("A Lotacao foi excluido do banco de dados");
                pstmt.close();
            }else{
                System.out.println("Não foi encontrada Lotacao com id = " + id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
