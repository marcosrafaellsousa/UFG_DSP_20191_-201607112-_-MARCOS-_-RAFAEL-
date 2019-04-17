package br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.aplicacao;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Cargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Departamento;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Funcionario;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades.Lotacao;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.data.insercao.InsereCargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.data.insercao.InsereDepartamento;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.data.insercao.InsereFuncionario;
import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.data.insercao.InsereLotacao;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.Negocio.AlterarSalario;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.alterar.AlterarCargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.alterar.AlterarDepartamento;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.alterar.AlterarFuncionario;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.alterar.AlterarLotacao;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.consultar.ConsultarCargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.consultar.ConsultarDepartamento;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.consultar.ConsultarFuncionario;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.consultar.ConsultarLotacao;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.deletar.DeletarCargo;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.deletar.DeletarDepartamento;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.deletar.DeletarFuncionario;
import br.com.marcosrafaellsousa.dsp20191.aulas1720.ap.persistencia.data.deletar.DeletarLotacao;
import java.util.ArrayList;

public class Programa {

    public static void main (String args[]) {

        try {
        //Criando dados
            Cargo cargo = new Cargo();
            cargo.setId(99);
            cargo.setNome("cargo99");
            cargo.setSalario(3600);

            Departamento departamento = new Departamento();
            departamento.setId(99);
            departamento.setNome("Departamento99");

            Funcionario funcionario = new Funcionario();
            funcionario.setId(99);
            funcionario.setMatricula(99);
            funcionario.setNome("funcionario99");

            Funcionario funcionario98 = new Funcionario();
            funcionario98.setId(98);
            funcionario98.setMatricula(98);
            funcionario98.setNome("funcionario98");

            Lotacao lotacao = new Lotacao();
            lotacao.setDepartamento(departamento);
            lotacao.setCargo(cargo);
            lotacao.setFuncionario(funcionario);
            lotacao.setId((long)99);
            lotacao.setDataInicial("17/04/2019");
            lotacao.setDataFinal("17/04/2020");

            Lotacao lotacao98 = new Lotacao();
            lotacao98.setDepartamento(departamento);
            lotacao98.setCargo(cargo);
            lotacao98.setFuncionario(funcionario98);
            lotacao98.setId((long)98);
            lotacao98.setDataInicial("17/04/2019");
            lotacao98.setDataFinal("17/04/2020");

            new InsereCargo().persisteCargo(cargo);
            new InsereDepartamento().persisteDepartamento(departamento);
            new InsereFuncionario().persisteFuncionario(funcionario);
            new InsereFuncionario().persisteFuncionario(funcionario98);
            new InsereLotacao().persisteLotacao(lotacao);
            new InsereLotacao().persisteLotacao(lotacao98);

        //Consultando dados
            System.out.println();
            System.out.println("Consultando dados criados:");
            consultaDados(cargo, departamento, funcionario, funcionario98, lotacao, lotacao98);

        //Alterando dados
            cargo.setNome("CARGO 99 ALTERADO");
            departamento.setNome("DEPARTAMENTO 99 ALTERADO");
            funcionario.setNome("FUNCIONARIO 99 ALTERADO");
            lotacao.setDataInicial("10/04/2019");

            System.out.println();
            new AlterarCargo().alterarCargo(cargo);
            new AlterarDepartamento().alterarDepartamento(departamento);
            new AlterarFuncionario().alterarFuncionario(funcionario);
            new AlterarLotacao().alterarLotacao(lotacao);

        //Consultando os dados alterados
            System.out.println();
            System.out.println("Consultando dados alteados:");
            consultaDados(cargo, departamento, funcionario, funcionario98, lotacao, lotacao98);

        //Alterando salario
            System.out.println();
            System.out.println("Aumentando salário dos funcionarios do cargo: "+ cargo.getNome() +" em 20%");
            double percentual = 20.0;
            AlterarSalario alterarSalario = new AlterarSalario();
            ArrayList<Funcionario> listaFuncionarios = alterarSalario.aumentarSalario(cargo, departamento, percentual);

            System.out.println();
            System.out.println("Funcionarios com salário alterado:");
            for (int i = 0; i < listaFuncionarios.size(); i++)
                System.out.println(listaFuncionarios.get(i));

        //Deletando os dados criados
            System.out.println();
            new DeletarCargo().deletarCargoPorId(cargo.getId());
            new DeletarDepartamento().deletarDepartamentoPorId(departamento.getId());
            new DeletarFuncionario().deletarFuncionarioPorId(funcionario.getId());
            new DeletarFuncionario().deletarFuncionarioPorId(funcionario98.getId());
            new DeletarLotacao().deletarLotacaoPorId(lotacao.getId());
            new DeletarLotacao().deletarLotacaoPorId(lotacao98.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void consultaDados(Cargo cargo, Departamento departamento, Funcionario funcionario,
                                      Funcionario funcionario98, Lotacao lotacao, Lotacao lotacao98) throws Exception {
        System.out.println(new ConsultarCargo().consultarPorId(cargo.getId()));
        System.out.println(new ConsultarDepartamento().consultarPorId(departamento.getId()));
        System.out.println(new ConsultarFuncionario().consultarPorId(funcionario.getId()));
        System.out.println(new ConsultarFuncionario().consultarPorId(funcionario98.getId()));
        System.out.println(new ConsultarLotacao().consultarPorId(lotacao.getId()));
        System.out.println(new ConsultarLotacao().consultarPorId(lotacao98.getId()));
    }


}
