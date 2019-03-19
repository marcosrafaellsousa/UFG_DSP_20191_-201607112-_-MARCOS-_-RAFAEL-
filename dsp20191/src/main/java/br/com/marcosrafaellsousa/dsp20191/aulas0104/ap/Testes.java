package br.com.marcosrafaellsousa.dsp20191.aulas0104.ap;

public class Testes {
    public static void main (String args[]) {

        // Nome do arquivo
        String fileSeparator = System.getProperty("file.separator");
        String relativePath = "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator
                + "arquivo.txt";

        Escritor escritor = new Escritor();

        Leitor leitor = new Leitor();

        leitor.ImprimeArquivo(relativePath);
    }
}
