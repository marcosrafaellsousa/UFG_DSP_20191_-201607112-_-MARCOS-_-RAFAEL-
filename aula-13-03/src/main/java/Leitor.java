import java.io.*;

public class Leitor {
    public void lerArquivo() {

        //vai referenciar uma linha por vez



        String fileSeparator = System.getProperty("file.separator");
        String fileName = "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator
                + "arquivo.txt";

        String line = null;

        try {
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Nao foi possivel abrir o arquivo");
        }
        catch(IOException ex) {
            System.out.println(
                    "Erro ao ler o arquivo");
        }
    }
}
