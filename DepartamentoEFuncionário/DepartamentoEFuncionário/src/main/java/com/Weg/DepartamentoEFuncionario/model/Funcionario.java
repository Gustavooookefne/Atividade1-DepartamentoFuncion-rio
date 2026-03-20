package com.Weg.DepartamentoEFuncionario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome_funcionario" , nullable = false)
    private String nome;

    @Column(name = "salario",nullable = false)
    private double salario;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Departamento departamento;

    public Funcionario(String nome, double salario, String cargo) {
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
    }


}
