package br.com.marcosrafaellsousa.dsp20191.aulas0104.ap;

public class Testes {
    public static void main (String args[]) {

        // Nome do arquivo
        String fileSeparator = System.getProperty("file.separator");
        String relativePath = "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator
                + "arquivo.txt";

        Escritor escritor = new Escritor();

        escritor.CriaArquivo(relativePath);
        escritor.AdicionaLinha(relativePath, "bom dia, esta deve ser a segunda linha");
        escritor.AdicionaLinha(relativePath, "boa tarde, tenho q escrever esta e mais 3 linhas");
        escritor.AdicionaLinha(relativePath, "boa noite, faltam 2 linhas");
        escritor.AdicionaLinha(relativePath, "boa madrugada, so mais uma");
        escritor.AdicionaLinha(relativePath, "boa manha, essa e a ultima linha");

        Leitor leitor = new Leitor();

        leitor.ImprimeArquivo(relativePath);
    }
}
