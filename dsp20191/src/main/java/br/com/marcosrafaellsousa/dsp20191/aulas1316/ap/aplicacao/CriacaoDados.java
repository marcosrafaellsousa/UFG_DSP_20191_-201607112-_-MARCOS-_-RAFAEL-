package br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.aplicacao;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Cargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Departamento;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Funcionario;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Lotacao;
import java.util.ArrayList;
import java.util.Random;

public class CriacaoDados {
    public ArrayList<Funcionario> criarFuncionarios (int quantidade) {
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
        for (int i = 0;i < quantidade; i++) {
            Funcionario funcionario = new Funcionario();
            funcionario.setId((long)(i + 1));
            funcionario.setNome("func" + (i + 1));
            funcionario.setMatricula(i + 1);
            listaFuncionarios.add(funcionario);
        }
        return listaFuncionarios;
    }

    public ArrayList<Cargo> criarCargos (int quantidade) {
        ArrayList<Cargo> listaCargos = new ArrayList<Cargo>();
        for (int i = 0;i < quantidade; i++) {
            Cargo cargo = new Cargo();
            cargo.setId((long)(i + 1));
            cargo.setNome("car" + (i + 1));
            cargo.setSalario((i * 1000.0));
            listaCargos.add(cargo);
        }
        return listaCargos;
    }

    public ArrayList<Departamento> criarDepartamentos (int quantidade) {
        ArrayList<Departamento> listaDepartamentos = new ArrayList<Departamento>();
        for (int i = 0; i < quantidade; i++) {
            Departamento departamento = new Departamento();
            departamento.setId((long)(i + 1));
            departamento.setNome("dep" + (i + 1));
            listaDepartamentos.add(departamento);
        }
        return listaDepartamentos;
    }

    public ArrayList<Lotacao> criarLotacoes (ArrayList<Cargo> listaCargos, ArrayList<Departamento> listaDepartamento,
                                             ArrayList<Funcionario> listaFuncionarios) {
        ArrayList<Lotacao> listaLotacoes = new ArrayList<Lotacao>();
        int i = 0;
        for (Funcionario funcionario : listaFuncionarios) {
            Lotacao lotacao = new Lotacao();
            lotacao.setId((long)(i + 1));
            lotacao.setDataInicial("10/04/2019");
            lotacao.setDataFinal("10/04/2020");
            Random random = new Random();
            lotacao.setCargo(listaCargos.get(random.nextInt((listaCargos.size()-1))));
            lotacao.setDepartamento(listaDepartamento.get(random.nextInt((listaDepartamento.size()-1))));
            lotacao.setFuncionario(funcionario);
            listaLotacoes.add(lotacao);
            i++;
        }
        return listaLotacoes;
    }
}
