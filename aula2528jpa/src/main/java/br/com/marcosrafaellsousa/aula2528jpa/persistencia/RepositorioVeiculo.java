package br.com.marcosrafaellsousa.aula2528jpa.persistencia;

import br.com.marcosrafaellsousa.aula2528jpa.entidades.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RepositorioVeiculo implements IRepositorioVeiculo{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.com.marcosrafaellsousa.aula2528jpa");
    private EntityManager em;

    public RepositorioVeiculo() {
        em = emf.createEntityManager();
    }

    @Override
    public Veiculo create (Veiculo veiculo) {
        em.getTransaction().begin();
        em.persist(veiculo);
        em.getTransaction().commit();
        return veiculo;
    }

    @Override
    public Veiculo read (Long id) {
        //em.getTransaction().begin();
        Veiculo veiculo = em.find(Veiculo.class, id);
        //em.getTransaction().commit();
        return veiculo;
    }

    @Override
    public Veiculo update(Veiculo veiculo) {
        em.getTransaction().begin();
        veiculo = em.merge(veiculo);
        em.getTransaction().commit();
        return veiculo;
    }

    @Override
    public void delete(Veiculo veiculo) {
        em.getTransaction().begin();
        em.remove(veiculo);
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        emf.close();
    }

}
