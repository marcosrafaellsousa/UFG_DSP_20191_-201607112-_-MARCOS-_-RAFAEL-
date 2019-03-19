package br.com.marcosrafaellsousa.dsp20191.aulas0104.ap;

import java.io.*;

public class Leitor {

    public void ImprimeArquivo(String fileName) {

        //vai referenciar uma linha por vez

        String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Arquivo não encontrado");
        }
        catch(IOException ex) {
            System.out.println(
                    "Erro ao ler o arquivo");
        }
    }
}
