package com.Weg.DepartamentoEFuncionario.controller;

import com.Weg.DepartamentoEFuncionario.dto.FuncionarioDto.FuncionarioRequestDto;
import com.Weg.DepartamentoEFuncionario.dto.FuncionarioDto.FuncionarioResponseDto;
import com.Weg.DepartamentoEFuncionario.model.Funcionario;
import com.Weg.DepartamentoEFuncionario.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService service;

    @PutMapping
    public FuncionarioResponseDto salvar (@RequestBody FuncionarioRequestDto requestDto){

        return service.salvar(requestDto);
    }
    @GetMapping
    public List<FuncionarioResponseDto> listarTodos(){

        return service.listarTodos();
    }
    @GetMapping("/{id}")
    public FuncionarioResponseDto listarPorId (@PathVariable UUID id){

        return service.listarPorId(id);
    }
    @PostMapping("/{id}")
    public FuncionarioResponseDto atulizar (@RequestBody FuncionarioRequestDto requestDto,@PathVariable UUID id){

        return service.atualizar(requestDto , id);
    }
    @DeleteMapping("/{id}")
    public void deletar (@PathVariable UUID id){

        service.deletar(id);
    }

}
