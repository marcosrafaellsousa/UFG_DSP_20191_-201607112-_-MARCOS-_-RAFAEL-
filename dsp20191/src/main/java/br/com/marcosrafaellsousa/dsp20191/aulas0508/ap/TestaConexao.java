package br.com.marcosrafaellsousa.dsp20191.aulas0508.ap;

import java.io.IOException;

public class TestaConexao {
    final String OS = System.getProperty("os.name").toLowerCase();
    private Usuario usuario;
    private Conexao conexao;

    public void ImprimeUsuarioConexao () {
        ObtemUsuarioConexao();
        System.out.printf(usuario.getNome() + "%n" + usuario.getLogin() + "%n" + usuario.getSenha() + "%n" +
                conexao.getSgbd() + "%n" + conexao.getTipoConexao() + "%n" + conexao.getBancoDados() + "%n" +
                conexao.getUrlBd() + "%n" + conexao.getSistemaOperacional());
    }

    public void ObtemUsuarioConexao() {

        LeitorProperties leitor = new LeitorProperties();
        leitor.LerConexaoProperties();
        try {
            usuario = leitor.CriarUsuario();
            conexao = leitor.CriaConexao();
            conexao.setSistemaOperacional(OS);
        }
        catch (IOException ex) {
            System.out.println("Erro ao ler o arquivo");
        }
    }
}
