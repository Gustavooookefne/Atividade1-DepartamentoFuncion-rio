package com.Weg.DepartamentoEFuncionario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_departamento", nullable = false)
    private String nomeDoDepartamento;

    @OneToMany(mappedBy = "departamento")
    private List<Funcionario> funcionarios;

    public Departamento(String s) {
    }
}
