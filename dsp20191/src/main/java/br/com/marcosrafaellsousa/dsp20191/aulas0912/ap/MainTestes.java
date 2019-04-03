package br.com.marcosrafaellsousa.dsp20191.aulas0912.ap;

import br.com.marcosrafaellsousa.dsp20191.aulas0912.ap.Json.JsonParser;

import java.io.FileNotFoundException;

public class MainTestes {
    public static void main (String args[]) {
        JsonParser jsonParser = new JsonParser();
        try {
            jsonParser.parseJson();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
