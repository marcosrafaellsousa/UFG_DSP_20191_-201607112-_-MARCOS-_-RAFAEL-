package br.com.marcosrafaellsousa.dsp20191.aulas1316.ap;

import br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.persistencia.banco.criacaoTabelas.CriacaoTabelaCargo;

public class MainTestes {
    public static void main (String args[]) {
        CriacaoTabelaCargo criacaoTabelaCargo = new CriacaoTabelaCargo();
        try {
            criacaoTabelaCargo.criaTabela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
