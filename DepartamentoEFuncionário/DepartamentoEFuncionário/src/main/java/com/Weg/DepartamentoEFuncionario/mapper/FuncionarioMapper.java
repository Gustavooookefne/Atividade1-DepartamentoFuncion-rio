package com.Weg.DepartamentoEFuncionario.mapper;

import com.Weg.DepartamentoEFuncionario.dto.FuncionarioDto.FuncionarioRequestDto;
import com.Weg.DepartamentoEFuncionario.dto.FuncionarioDto.FuncionarioResponseDto;
import com.Weg.DepartamentoEFuncionario.model.Funcionario;

public class FuncionarioMapper {

    public Funcionario paraEntidade(FuncionarioRequestDto requestDto){

        return new Funcionario(

                requestDto.nome(),
                requestDto.salario(),
                requestDto.departamento()

        );
    }

    public FuncionarioResponseDto paraDto(Funcionario funcionario){

        return new FuncionarioResponseDto(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getSalario(),
                funcionario.getCargo()
        );
    }


}
