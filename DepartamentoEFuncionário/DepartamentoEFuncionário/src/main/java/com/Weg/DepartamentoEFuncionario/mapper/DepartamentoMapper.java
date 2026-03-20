package com.Weg.DepartamentoEFuncionario.mapper;

import com.Weg.DepartamentoEFuncionario.dto.DepartamentoDto.DepartamentoRequestDto;
import com.Weg.DepartamentoEFuncionario.dto.DepartamentoDto.DepartamentoResponseDto;
import com.Weg.DepartamentoEFuncionario.model.Departamento;

public class DepartamentoMapper {

    public Departamento paraEntidades (DepartamentoRequestDto requestDto){
        return new Departamento(
                requestDto.nomeDoDepartamento()
        );
    }

    public DepartamentoResponseDto paraDto (Departamento departamento){
        return new DepartamentoResponseDto(
                departamento.getId(),
                departamento.getNomeDoDepartamento()
        );
    }
}
