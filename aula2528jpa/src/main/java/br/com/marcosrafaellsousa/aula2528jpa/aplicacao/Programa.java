package br.com.marcosrafaellsousa.aula2528jpa.aplicacao;

import br.com.marcosrafaellsousa.aula2528jpa.entidades.Veiculo;
import br.com.marcosrafaellsousa.aula2528jpa.persistencia.IRepositorioVeiculo;
import br.com.marcosrafaellsousa.aula2528jpa.persistencia.RepositorioVeiculo;

public class Programa {

    public static void main (String args[]){
        IRepositorioVeiculo iRepositorioVeiculo = new RepositorioVeiculo();
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setMarca("Mazda");
        veiculo1.setModelo("RX-7");
        System.out.println("Criando o veiculo");
        iRepositorioVeiculo.create(veiculo1);

        System.out.println(veiculo1.getId());

        veiculo1.setAnoFabricacao(2009);

        System.out.println("Atualizando o veiculo");
        iRepositorioVeiculo.update(veiculo1);

        System.out.println(iRepositorioVeiculo.read((long)1));

        System.out.println("Deletando o veiculo");
        iRepositorioVeiculo.delete(veiculo1);

        System.out.println("Fechando conexao");
        iRepositorioVeiculo.close();

    }
}
