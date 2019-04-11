package br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.deletar;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Cargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.consultar.ConsultarCargo;
import java.sql.PreparedStatement;

public class DeletarCargo extends PersistenciaJdbc{

    public boolean deletarCargo(Long id){
        boolean result = false;
        try {
            Cargo cargo = new ConsultarCargo().consultarPorId(id);
            if (cargo.getId() != 0){
                preparaPersistencia();

                String sql = "DELETE FROM CARGO WHERE id = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1,id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("O Cargo foi excluido do banco de dados");
                pstmt.close();
            }else{
                System.out.println("Não foi encontrado cargo com id = " + id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
