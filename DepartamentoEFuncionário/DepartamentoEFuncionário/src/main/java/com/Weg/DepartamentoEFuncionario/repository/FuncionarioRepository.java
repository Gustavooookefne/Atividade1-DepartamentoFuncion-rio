package com.Weg.DepartamentoEFuncionario.repository;

import com.Weg.DepartamentoEFuncionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {
}
