package br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.aplicacao;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Cargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Departamento;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Funcionario;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Lotacao;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.banco.criacaoTabelas.CriacaoTabelaCargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.banco.criacaoTabelas.CriacaoTabelaDepartamento;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.banco.criacaoTabelas.CriacaoTabelaFuncionario;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.banco.criacaoTabelas.CriacaoTabelaLotacao;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.data.insercao.InsereCargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.data.insercao.InsereDepartamento;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.data.insercao.InsereFuncionario;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.data.insercao.InsereLotacao;

import java.util.ArrayList;

public class Programa {
    public static void main (String args[]) {

        //Instanciando dados
        ArrayList<Cargo> listaCargos = new CriacaoDados().criarCargos(3);
        ArrayList<Departamento> listaDepartamentos = new CriacaoDados().criarDepartamentos(4);
        ArrayList<Funcionario> listaFuncionario = new CriacaoDados().criarFuncionarios(10);
        ArrayList<Lotacao> listaLotacoes = new CriacaoDados().criarLotacoes(listaCargos, listaDepartamentos,
                listaFuncionario);


        //Criando as tabelas
        try {
            CriacaoTabelaCargo criacaoTabelaCargo = new CriacaoTabelaCargo();
            criacaoTabelaCargo.criaTabela();

            CriacaoTabelaDepartamento criacaoTabelaDepartamento = new CriacaoTabelaDepartamento();
            criacaoTabelaDepartamento.criaTabela();

            CriacaoTabelaFuncionario criacaoTabelaFuncionario = new CriacaoTabelaFuncionario();
            criacaoTabelaFuncionario.criaTabela();

            CriacaoTabelaLotacao criacaoTabelaLotacao = new CriacaoTabelaLotacao();
            criacaoTabelaLotacao.criaTabela();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Inserindo os dados

        try {
            InsereCargo insereCargo = new InsereCargo();
            for (Cargo cargo : listaCargos)
                insereCargo.persisteCargo(cargo);

            InsereDepartamento insereDepartamento = new InsereDepartamento();
            for (Departamento departamento : listaDepartamentos)
                insereDepartamento.persisteDepartamento(departamento);

            InsereFuncionario insereFuncionario = new InsereFuncionario();
            for (Funcionario funcionario : listaFuncionario)
                insereFuncionario.persisteFuncionario(funcionario);

            InsereLotacao insereLotacao = new InsereLotacao();
            for (Lotacao lotacao : listaLotacoes)
                insereLotacao.persisteLotacao(lotacao);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
