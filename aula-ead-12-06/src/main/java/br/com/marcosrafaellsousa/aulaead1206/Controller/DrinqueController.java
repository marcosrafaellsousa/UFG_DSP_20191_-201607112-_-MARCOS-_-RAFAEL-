package br.com.marcosrafaellsousa.aulaead1206.Controller;

import br.com.marcosrafaellsousa.aulaead1206.modelo.Drinque;
import br.com.marcosrafaellsousa.aulaead1206.repositorio.DrinqueRepositorio;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class DrinqueController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final DrinqueRepositorio drinqueRepositorio;

    public DrinqueController(DrinqueRepositorio drinqueRepositorio) {
        this.drinqueRepositorio = drinqueRepositorio;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Drinque> buscarTodosDrinques() {
        LOG.info("Buscando todos os drinques.");
        return drinqueRepositorio.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Drinque buscarDrinque(@PathVariable String id) {
        LOG.info("Buscando um drinque pelo ID: {}.", id);
        ObjectId objectId;
        try {
            objectId = new ObjectId(id);
        } catch (IllegalArgumentException e) {
            return null;
        }
        return drinqueRepositorio.findById(objectId).get();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Drinque addNovoDrinque(@RequestBody Drinque drinque) {
        LOG.info("Salvando um drinque.");
        return drinqueRepositorio.save(drinque);
    }

    //Adicionar um novo ingrediente no drinque
    @RequestMapping(value = "/ingrediente/{id}/{ingrediente}", method = RequestMethod.PUT)
    public String addIngredienteDrinque(@PathVariable String id, @PathVariable String ingrediente) {
        LOG.info("Adicionando um ingrediente a um drinque.");
        ObjectId objectId;
        try {
            objectId = new ObjectId(id);
        } catch (IllegalArgumentException e) {
            return "Drinque não encontrado";
        }
        Drinque drinque = drinqueRepositorio.findById(objectId).get();
        if (drinque != null) {
            drinque.getIngredientes().add(ingrediente);
            drinqueRepositorio.save(drinque);
            return "Ingrediente adicionado";
        } else {
            return "Drinque não encontrado";
        }
    }
}
