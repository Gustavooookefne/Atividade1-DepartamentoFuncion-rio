package com.Weg.DepartamentoEFuncionario.controller;

import com.Weg.DepartamentoEFuncionario.dto.DepartamentoDto.DepartamentoRequestDto;
import com.Weg.DepartamentoEFuncionario.dto.DepartamentoDto.DepartamentoResponseDto;
import com.Weg.DepartamentoEFuncionario.service.DepartamentoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    private final DepartamentoService service;

    @PutMapping
    public DepartamentoResponseDto salvar (@RequestBody DepartamentoRequestDto requestDto) {
        return service.salvar(requestDto);
    }

    @GetMapping
    public List<DepartamentoResponseDto> listarTodos () {
        return service.listarTOdos();
    }

    @GetMapping("/{id}")
    public DepartamentoResponseDto listarPorId (@PathVariable Long id) {
        return service.listarPorID(id);
    }

    @PostMapping("/{id}")
    public DepartamentoResponseDto atualizar (@RequestBody DepartamentoRequestDto requestDto ,@PathVariable Long id){
        return service.atulizar(requestDto , id);
    }

    @DeleteMapping("/{id}")
    public void deletar (@PathVariable Long id){
        service.deletar(id);
    }
}
