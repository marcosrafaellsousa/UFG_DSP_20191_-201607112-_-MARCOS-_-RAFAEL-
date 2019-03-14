package br.com.marcosrafaellsousa.dsp20191.aulas0104.ap;

/**
 * Created by Alunoinf_2 on 13/03/2019.
 */
public class Testes {
    public static void main (String args[]) {

        Escritor escritor = new Escritor();
        escritor.CriaArquivo();

        Leitor leitor = new Leitor();
        leitor.lerArquivo();
    }
}
