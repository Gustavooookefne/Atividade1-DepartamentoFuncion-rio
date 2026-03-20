package com.Weg.DepartamentoEFuncionario.repository;

import com.Weg.DepartamentoEFuncionario.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento , Long> {
}
