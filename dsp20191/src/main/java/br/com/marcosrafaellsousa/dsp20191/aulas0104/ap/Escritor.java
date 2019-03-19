package br.com.marcosrafaellsousa.dsp20191.aulas0104.ap;

import java.io.*;

public class Escritor {

    public void CriaArquivo (String fileName){

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("ola, estou testando escrever um texto");
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Erro ao criar o arquivo");
        }
    }

    public void AdicionaLinha (String fileName, String linha) {

        try {
            FileWriter fileWriter = new FileWriter(fileName,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(linha);
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Erro ao adicionar linhas ao arquivo");
        }
    }
}
