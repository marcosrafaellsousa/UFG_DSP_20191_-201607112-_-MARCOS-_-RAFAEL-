package br.com.marcosrafaellsousa.dsp20191.aulas2124.ead.aplicacao;

import br.com.marcosrafaellsousa.dsp20191.aulas2124.ead.entidades.Aluno;
import br.com.marcosrafaellsousa.dsp20191.aulas2124.ead.serializacao.Empacotamento;

import java.util.ArrayList;

public class Programa {

    public static void main (String args[]) {

        //criando objeto aluno
        Aluno aluno = new Aluno();
        aluno.setNome("Zézinho");
        aluno.setMatricula("201900000");
        aluno.setDisciplina("Matematica");
        aluno.setFrequencia(89.00);
        aluno.setNota1(9.0);
        aluno.setNota2(7.0);

        String fileSeparator = System.getProperty("file.separator");
        String fileName = "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator
                + "aluno.dat";

        Empacotamento.gravarArquivoBinario(aluno, fileName);

        Aluno alunoLido = Empacotamento.lerArquivoBinario(fileName);

        System.out.print(alunoLido);
        System.out.println(alunoLido.avaliar());
    }

}
