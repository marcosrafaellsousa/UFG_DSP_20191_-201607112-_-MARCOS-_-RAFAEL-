package br.com.marcosrafaellsousa.dsp20191.aulas2124.ead.serializacao;

import br.com.marcosrafaellsousa.dsp20191.aulas2124.ead.entidades.Aluno;

import java.io.*;
import java.util.ArrayList;

public class Empacotamento {

    public static void gravarArquivoBinario(Aluno aluno, String nomeArq) {
        File arq = new File(nomeArq);
        try {
            arq.delete();
            arq.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(aluno);
            objOutput.close();

        } catch(IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }

    public static Aluno lerArquivoBinario(String nomeArq) {
        Aluno aluno = new Aluno();
        try {
            File arq = new File(nomeArq);
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                aluno = (Aluno)objInput.readObject();
                objInput.close();
            }
        } catch(IOException erro1) {
            System.out.printf("Erro: %s", erro1.getMessage());
        } catch(ClassNotFoundException erro2) {
            System.out.printf("Erro: %s", erro2.getMessage());
        }

        return(aluno);
    }
}
