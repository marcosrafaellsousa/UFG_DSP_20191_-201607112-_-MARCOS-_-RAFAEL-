package br.com.marcosrafaellsousa.dsp20191.aulas0104.ap;

import java.io.*;

public class Escritor {

    public void CriaArquivo (){
        // Nome do arquivo

        String fileSeparator = System.getProperty("file.separator");

        String relativePath = "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator
                + "arquivo.txt";

        try {
            FileWriter fileWriter =
                    new FileWriter(relativePath);

            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            bufferedWriter.write("ola, estou testando escrever um texto");
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Erro ao criar o arquivo");
        }
    }
}
