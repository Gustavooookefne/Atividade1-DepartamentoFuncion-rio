package com.Weg.DepartamentoEFuncionario.service;

import com.Weg.DepartamentoEFuncionario.dto.DepartamentoDto.DepartamentoRequestDto;
import com.Weg.DepartamentoEFuncionario.dto.DepartamentoDto.DepartamentoResponseDto;
import com.Weg.DepartamentoEFuncionario.mapper.DepartamentoMapper;
import com.Weg.DepartamentoEFuncionario.model.Departamento;
import com.Weg.DepartamentoEFuncionario.repository.DepartamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository repository;
    private final DepartamentoMapper mapper;

    public DepartamentoResponseDto salvar (DepartamentoRequestDto requestDto) {

        Departamento departamento = new Departamento();

        return mapper.paraDto(repository.save(departamento));
    }

    public List<DepartamentoResponseDto> listarTodos () {
        return repository.findAll()
                .stream()
                .map(mapper::paraDto)
                .toList();
    }

    public DepartamentoResponseDto listarPorID (Long id){
        Departamento departamento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada"));

        return mapper.paraDto(departamento);
    }

    public DepartamentoResponseDto atulizar (DepartamentoRequestDto requestDto, Long id){
        Departamento departamento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));

        departamento.setNomeDoDepartamento(requestDto.nomeDoDepartamento());

        return mapper.paraDto(departamento);
    }

    public void deletar (Long id){
        repository.deleteById(id);
    }

}
