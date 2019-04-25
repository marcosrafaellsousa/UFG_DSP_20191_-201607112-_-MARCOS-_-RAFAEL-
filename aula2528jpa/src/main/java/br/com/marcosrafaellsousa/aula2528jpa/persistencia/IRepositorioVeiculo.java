package br.com.marcosrafaellsousa.aula2528jpa.persistencia;

import br.com.marcosrafaellsousa.aula2528jpa.entidades.Veiculo;

public interface IRepositorioVeiculo {

    Veiculo create(Veiculo veiculo);


    Veiculo read(Long id);

    Veiculo update(Veiculo veiculo);


    void delete(Veiculo veiculo);

    /**
     * close the model manager factory
     */
    void close();
}
