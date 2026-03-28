package com.Weg.DepartamentoEFuncionario.controller;

import com.Weg.DepartamentoEFuncionario.dto.DepartamentoDto.DepartamentoRequestDto;
import com.Weg.DepartamentoEFuncionario.dto.DepartamentoDto.DepartamentoResponseDto;
import com.Weg.DepartamentoEFuncionario.model.Departamento;
import com.Weg.DepartamentoEFuncionario.service.DepartamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    private final DepartamentoService service;

    @PutMapping
    public ResponseEntity<DepartamentoResponseDto> salvar (@RequestBody DepartamentoRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvar(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoResponseDto>> listarTodos () {
        List<DepartamentoResponseDto> departamentos = service.listarTodos();

        return ResponseEntity.ok().body(departamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDto> listarPorId (@PathVariable Long id) {
        DepartamentoResponseDto responseDto = service.listarPorID(id);

        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDto> atualizar (@RequestBody DepartamentoRequestDto requestDto ,@PathVariable Long id){
        DepartamentoResponseDto responseDto = service.atulizar(requestDto , id);

        return ResponseEntity.ok().body(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id){
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
