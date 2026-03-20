package com.Weg.DepartamentoEFuncionario.controller;

import com.Weg.DepartamentoEFuncionario.dto.DepartamentoDto.DepartamentoRequestDto;
import com.Weg.DepartamentoEFuncionario.dto.DepartamentoDto.DepartamentoResponseDto;
import com.Weg.DepartamentoEFuncionario.service.DepartamentoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    private final DepartamentoService service;

    public DepartamentoResponseDto salvar (DepartamentoRequestDto requestDto) {

        return service.salvar(requestDto);
    }

    public List<DepartamentoResponseDto> listarTodos () {

        return service.listarTOdos();
    }

    public DepartamentoResponseDto listarPorId (Long id) {

        return service.listarPorID(id);
    }

    public DepartamentoResponseDto atualizar (DepartamentoRequestDto requestDto , Long id){

        return service.atulizar(requestDto , id);
    }

    public void deletar (Long id){
        service.deletar(id);
    }
}
