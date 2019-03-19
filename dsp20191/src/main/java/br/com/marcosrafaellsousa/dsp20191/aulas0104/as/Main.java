package br.com.marcosrafaellsousa.dsp20191.aulas0104.as;

import br.com.marcosrafaellsousa.dsp20191.aulas0104.ap.Escritor;
import java.util.List;

public class Main {
    public static void main (String args[]) {


        // Exercício 3
        String fileSeparator = System.getProperty("file.separator");
        String relativePathTxt = "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator
                + "arquivo.txt";

        Escritor escritor = new Escritor();

        escritor.CriaArquivo(relativePathTxt);
        escritor.AdicionaLinha(relativePathTxt, "bom dia, esta deve ser a segunda linha");
        escritor.AdicionaLinha(relativePathTxt, "boa tarde, tenho q escrever esta e mais 3 linhas");
        escritor.AdicionaLinha(relativePathTxt, "boa noite, faltam 2 linhas");
        escritor.AdicionaLinha(relativePathTxt, "boa madrugada, so mais uma");
        escritor.AdicionaLinha(relativePathTxt, "boa manha, essa e a ultima linha");


        //Exercício 4

        String relativePathUF = "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator
                + "UF.csv";

        LeitorCSV leitorCSV = new LeitorCSV();
        List<UF> listaUFs = leitorCSV.ListarUFs(relativePathUF);
        leitorCSV.ImprimirLista(listaUFs);
    }
}
