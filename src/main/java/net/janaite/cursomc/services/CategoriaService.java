package net.janaite.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.janaite.cursomc.domain.Categoria;
import net.janaite.cursomc.repositories.CategoriaRepository;
import net.janaite.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				String.format("Object not found! Id: %d, type: %s", id, Categoria.class.getName())));
	}

}
