package br.com.marcosrafaellsousa.aulaead1206.repositorio;

import br.com.marcosrafaellsousa.aulaead1206.modelo.Drinque;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinqueRepositorio extends MongoRepository<Drinque, ObjectId> {

}
