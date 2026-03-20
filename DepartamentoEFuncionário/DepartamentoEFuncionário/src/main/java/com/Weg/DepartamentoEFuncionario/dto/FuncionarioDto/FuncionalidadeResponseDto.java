package com.Weg.DepartamentoEFuncionario.dto.FuncionarioDto;

public record FuncionalidadeResponseDto (
        Long id,
        String nome,
        double salario,
        String departamento
){
}
