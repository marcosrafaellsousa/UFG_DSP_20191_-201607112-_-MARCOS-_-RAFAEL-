package br.com.marcosrafaellsousa.dsp20191.aulas0104.as;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeitorCSV {
    public List<UF> ListarUFs (String fileName) {
        List<UF> listaUFs= new ArrayList<UF>();

        String line;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                UF uf = new UF();
                uf.setLinha(line);
                listaUFs.add(uf);
            }
        }

        catch(IOException ex) {
            System.out.println(
                    "Erro ao ler o arquivo");
        }

        return listaUFs;
    }

    public void ImprimirLista (List<UF> listaUFs) {
        for(int i=0; i< listaUFs.size(); i++){
            System.out.println(listaUFs.get(i).getLinha());
        }
    }
}
