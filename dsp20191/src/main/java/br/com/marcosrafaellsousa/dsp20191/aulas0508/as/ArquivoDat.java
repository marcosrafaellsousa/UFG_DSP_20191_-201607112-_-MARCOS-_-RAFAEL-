package br.com.marcosrafaellsousa.dsp20191.aulas0508.as;

import java.io.*;

public class ArquivoDat {

    private String fileSeparator = System.getProperty("file.separator");
    private String fileName = "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator
            + "avaliacao.dat";

    public void GravaAluno () {
        Aluno aluno = new Aluno();
        aluno.setNome("Jonathan Joestar");
        aluno.setMatricula(11037);
        aluno.setNota1(5.5);
        aluno.setNota2(1.2);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            dataOutputStream.writeUTF(aluno.getNome());
            dataOutputStream.writeLong(aluno.getMatricula());
            dataOutputStream.writeDouble(aluno.getNota1());
            dataOutputStream.writeDouble(aluno.getNota2());
        }
        catch(IOException ex) {
            System.out.println("Erro ao escrever o arquivo avaliacao.dat");
        }
    }

    public void ImprimeAluno () {
        Aluno aluno = new Aluno();

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            aluno.setNome(dataInputStream.readUTF());
            aluno.setMatricula(dataInputStream.readLong());
            aluno.setNota1(dataInputStream.readDouble());
            aluno.setNota2(dataInputStream.readDouble());
        }
        catch(IOException ex) {
            System.out.println("Erro ao tentar ler o arquivo avaliacao.dat");
        } finally {
            System.out.println("Aluno: " + aluno.getNome());
            System.out.println("Matricula: " + aluno.getMatricula());
            System.out.println("Nota 1: " + aluno.getNota1());
            System.out.println("Nota 2: " + aluno.getNota2());

            double media = aluno.getNota1() * aluno.getNota2() / 2;
            if (media >= 5)
                System.out.println("O Aluno esta aprovado");
            else System.out.println("O Aluno esta REPROVADO");
        }
    }
}
