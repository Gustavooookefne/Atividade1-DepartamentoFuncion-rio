package com.Weg.DepartamentoEFuncionario.controller;

import com.Weg.DepartamentoEFuncionario.dto.FuncionarioDto.FuncionarioRequestDto;
import com.Weg.DepartamentoEFuncionario.dto.FuncionarioDto.FuncionarioResponseDto;
import com.Weg.DepartamentoEFuncionario.model.Funcionario;
import com.Weg.DepartamentoEFuncionario.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService service;

    @PutMapping
    public ResponseEntity<FuncionarioResponseDto> salvar (@RequestBody FuncionarioRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvar(requestDto));
    }
    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDto>> listarTodos(){
           List<FuncionarioResponseDto> responseDtos = service.listarTodos();

           return ResponseEntity.ok().body(responseDtos);

    }
    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDto> listarPorId (@PathVariable UUID id){
            FuncionarioResponseDto responseDto = service.listarPorId(id);

            return ResponseEntity.ok().body(responseDto);
    }
    @PostMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDto> atulizar (@RequestBody FuncionarioRequestDto requestDto,@PathVariable UUID id){
            FuncionarioResponseDto responseDto = service.atualizar(requestDto , id);

        return ResponseEntity.ok().body(responseDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable UUID id){
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }

}
