package com.mateus.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mateus.prjEmpresa.entities.Funcionario;
import com.mateus.prjEmpresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;

	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
    	this.funcionarioRepository = funcionarioRepository;
    }

	public Funcionario getFuncionarioById(Long id) {
		return funcionarioRepository.findById(id).orElse(null);
	}

	public Funcionario saveFuncionario(Funcionario Funcionario) {
		return funcionarioRepository.save(Funcionario);
	}

	public List<Funcionario> getAllFuncionarios() {
		return funcionarioRepository.findAll();
	}

	public void deleteFuncionario(Long id) {
		funcionarioRepository.deleteById(id);

	}
	public Funcionario updateFuncionario(Long id, Funcionario novoFuncionario) {
		Optional<Funcionario> FuncionarioOptional = funcionarioRepository.findById(id);
		if (FuncionarioOptional.isPresent()) {
			Funcionario FuncionarioExistente = FuncionarioOptional.get();
			FuncionarioExistente.setfunnome(novoFuncionario.getfunnome());
			FuncionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());
			FuncionarioExistente.setFunsalario(novoFuncionario.getFunsalario());
			return funcionarioRepository.save(FuncionarioExistente);
		} else {
			return null;
		}
	}
}