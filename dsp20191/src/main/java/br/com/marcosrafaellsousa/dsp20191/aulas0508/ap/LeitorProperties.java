package br.com.marcosrafaellsousa.dsp20191.aulas0508.ap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeitorProperties {

    private String fileSeparator = System.getProperty("file.separator");
    private String fileName = "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator
            + "conexao.properties";
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public void LerConexaoProperties() {
        try {
            fileReader = new FileReader(fileName);

            bufferedReader = new BufferedReader(fileReader);
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Arquivo não encontrado");
        }
    }

    public Usuario CriarUsuario () throws IOException{
        Usuario usuario = new Usuario();
        usuario = PreencheUsuario(bufferedReader, usuario);

        return usuario;
    }

    public Conexao CriaConexao() throws IOException {
        Conexao conexao = new Conexao();
        conexao = PreencheConexao(bufferedReader, conexao);

        return conexao;
    }

    private Usuario PreencheUsuario (BufferedReader bufferedReader, Usuario usuario) throws IOException {
        String line = null;

        if ((line = bufferedReader.readLine()) != null)
            usuario.setNome(line);

        if ((line = bufferedReader.readLine()) != null)
            usuario.setLogin(line);

        if ((line = bufferedReader.readLine()) != null)
            usuario.setSenha(line);

        return usuario;
    }

    private Conexao PreencheConexao (BufferedReader bufferedReader, Conexao conexao) throws IOException {
        String line = null;

        if ((line = bufferedReader.readLine()) != null)
            conexao.setSgbd(line);

        if ((line = bufferedReader.readLine()) != null)
            conexao.setTipoConexao(line);

        if ((line = bufferedReader.readLine()) != null)
            conexao.setBancoDados(line);

        if ((line = bufferedReader.readLine()) != null)
            conexao.setUrlBd(line);

        bufferedReader.close();
        return conexao;
    }

}
