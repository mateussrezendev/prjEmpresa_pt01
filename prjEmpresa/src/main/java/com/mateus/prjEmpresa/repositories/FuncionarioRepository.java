package com.mateus.prjEmpresa.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.prjEmpresa.entities.Funcionario;
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
}
