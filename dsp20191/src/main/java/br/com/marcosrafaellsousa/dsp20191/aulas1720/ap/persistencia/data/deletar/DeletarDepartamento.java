package br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.deletar;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Departamento;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.consultar.ConsultarDepartamento;

import java.sql.PreparedStatement;

public class DeletarDepartamento extends PersistenciaJdbc{

    public boolean deletarDepartamentoPorId(Long id){
        boolean result = false;
        try {
            Departamento departamento = new ConsultarDepartamento().consultarPorId(id);
            if (departamento.getId() != 0){
                preparaPersistencia();

                String sql = "DELETE FROM DEPARTAMENTO WHERE id = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1,id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("O Departamento foi excluido do banco de dados");
                pstmt.close();
            }else{
                System.out.println("Não foi encontrado Departamento com id = " + id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
