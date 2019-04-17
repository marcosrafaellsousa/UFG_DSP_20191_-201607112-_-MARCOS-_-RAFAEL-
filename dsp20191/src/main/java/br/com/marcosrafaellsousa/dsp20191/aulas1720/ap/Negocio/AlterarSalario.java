package br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.Negocio;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Cargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Departamento;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Funcionario;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Lotacao;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.alterar.AlterarCargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.consultar.ConsultarLotacao;
import java.util.ArrayList;

public class AlterarSalario {

    public ArrayList<Funcionario> aumentarSalario (Cargo cargo, Departamento departamento, double percentual) {
        ArrayList<Lotacao> listaLotacoes;
        ArrayList<Funcionario> funcionariosModificados = new ArrayList<Funcionario>();
        try {
            listaLotacoes = new ConsultarLotacao().consultarPorCargoEDep(cargo, departamento);
            if (listaLotacoes.size() > 0)
                alterarSalario(cargo, percentual);
            for (int i = 0; i < listaLotacoes.size(); i++) {
                funcionariosModificados.add(listaLotacoes.get(i).getFuncionario());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return funcionariosModificados;
    }

    private void alterarSalario (Cargo cargo, double percentual) throws Exception {
        cargo.setSalario(cargo.getSalario() + (cargo.getSalario() * (percentual / 100.0)));
        new AlterarCargo().alterarCargo(cargo);
    }
}
