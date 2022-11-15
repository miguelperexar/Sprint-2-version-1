package com.marcaci.nbrigadistas.Brigada.empresarial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcaci.nbrigadistas.Brigada.empresarial.model.Brigadistas;
import com.marcaci.nbrigadistas.Brigada.empresarial.repository.BrigadistaRepository;
@Service
public class BrigadistasServiceImpl implements BrigadistasService {
	@Autowired
	private BrigadistaRepository repositorio;
		@Override
	public Brigadistas actualizarBrigadistas(Brigadistas brigadista) {
			if (brigadista == null) {
				return null;
			}
			Optional<Brigadistas> brigadistasAAtualizar = repositorio.findById(brigadista.getId());
			if (brigadistasAAtualizar.isPresent()) {
				return repositorio.save(brigadista);
			}
			return null;
	}

	@Override
	public Brigadistas crearBrigadisas(Brigadistas brigadista) {
		// TODO Auto-generated method stub
		return null;
		/*Optional<Brigadistas> brigadistasAConsultar = repositorio.findById(brigadista.getId());
		if (brigadistasAConsultar.isPresent()) {
			return brigadistasAConsultar.get();
		}
		List<Brigadistas> brigadistas = repositorio.findByDescripccion(brigadista.get));
		if (brigadistas.size() > 0) {
			return brigadistas.get(0);
		} else {

			return repositorio.insert(brigadista);
		}*/
	}

	@Override
	public void eliminarBrigadistasPorID(Long id) {
		Optional<Brigadistas> eliminarBrigadista = repositorio.findById(id);
		if (eliminarBrigadista.isPresent()) {
			repositorio.delete(eliminarBrigadista.get());
		}

	}

	@Override
	public Optional<Brigadistas> consultarBrigadistas(Long id, String descripcion) {
		if (id == null) {

			return Optional.empty();
		}
		return repositorio.findById(id);
		
		// TODO Auto-generated method stub
		//return Optional.empty();
	}

	@Override
	public List<Brigadistas> consultarBrigadistasPorId(Long Id) {
		//TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Brigadistas> consultarLista() {
		return repositorio.findAll();
	}

}
