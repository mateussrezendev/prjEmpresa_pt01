package com.mateus.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mateus.prjEmpresa.entities.Departamento;
import com.mateus.prjEmpresa.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

	private final DepartamentoRepository departamentoRepository;

	public DepartamentoService(DepartamentoRepository departamentoRepository) {
    	this.departamentoRepository = departamentoRepository;
    }

	public Departamento getDepartamentoById(Long id) {
		return departamentoRepository.findById(id).orElse(null);
	}

	public Departamento saveDepartamento(Departamento Departamento) {
		return departamentoRepository.save(Departamento);
	}

	public List<Departamento> getAllDepartamentos() {
		return departamentoRepository.findAll();
	}

	public void deleteDepartamento(Long id) {
		departamentoRepository.deleteById(id);

	}
	public Departamento updateDepartamento(Long id, Departamento novoDepartamento) {
		Optional<Departamento> DepartamentoOptional = departamentoRepository.findById(id);
		if (DepartamentoOptional.isPresent()) {
			Departamento DepartamentoExistente = DepartamentoOptional.get();
			DepartamentoExistente.setdepnome(novoDepartamento.getdepnome());
			return departamentoRepository.save(DepartamentoExistente);
		} else {
			return null;
		}
	}
}