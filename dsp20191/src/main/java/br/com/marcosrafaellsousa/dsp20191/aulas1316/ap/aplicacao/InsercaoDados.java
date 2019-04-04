package br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.aplicacao;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Funcionario;
import java.util.ArrayList;

public class InsercaoDados {
    public ArrayList<Funcionario> CriarFuncionarios () {
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        for (int i = 0;i <10; i++) {
            Funcionario funcionario = new Funcionario();
        }
        return funcionarios;
    }
}
