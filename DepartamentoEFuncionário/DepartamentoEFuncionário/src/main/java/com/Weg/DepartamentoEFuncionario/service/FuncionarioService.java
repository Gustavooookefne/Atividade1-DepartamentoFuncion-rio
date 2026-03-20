package com.Weg.DepartamentoEFuncionario.service;

import com.Weg.DepartamentoEFuncionario.dto.FuncionarioDto.FuncionarioRequestDto;
import com.Weg.DepartamentoEFuncionario.dto.FuncionarioDto.FuncionarioResponseDto;
import com.Weg.DepartamentoEFuncionario.mapper.FuncionarioMapper;
import com.Weg.DepartamentoEFuncionario.model.Funcionario;
import com.Weg.DepartamentoEFuncionario.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;

    public FuncionarioResponseDto salvar(FuncionarioRequestDto requestDto){

        Funcionario funcionario = new Funcionario();

        return mapper.paraDto(repository.save(funcionario));
    }

    public List<FuncionarioResponseDto> listarTodos(){

        return repository.findAll()
                .stream()
                .map(mapper::paraDto)
                .toList();
    }

    public FuncionarioResponseDto listarPorId (UUID id){
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada"));

        return mapper.paraDto(funcionario);
    }

    public FuncionarioResponseDto atualizar(FuncionarioRequestDto requestDto, UUID id){
            Funcionario funcionario = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

            funcionario.setNome(requestDto.nome());
            funcionario.setSalario(requestDto.salario());
            funcionario.setCargo(requestDto.cargo());

        return mapper.paraDto(funcionario);
    }

    public void deletar (UUID id){
        repository.deleteById(id);
    }
}
