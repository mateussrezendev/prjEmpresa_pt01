package com.mateus.prjEmpresa.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.prjEmpresa.entities.Departamento;
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
	
}
