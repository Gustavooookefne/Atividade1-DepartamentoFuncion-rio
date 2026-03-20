package com.Weg.DepartamentoEFuncionario.dto.FuncionarioDto;

import java.util.UUID;

public record FuncionarioResponseDto(
        UUID id,
        String nome,
        double salario,
        String departamento
){
}
