package com.example.howgarts.service;

import com.example.howgarts.dto.CasaDto;
import com.example.howgarts.mapper.CasaMapper;
import com.example.howgarts.model.Casa;
import com.example.howgarts.repository.CasaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CasaService {

    private final CasaRepository casaRepository;

    public CasaService(CasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }

    public List<CasaDto> getAll() {
        return casaRepository.findAll().stream().map(CasaMapper::toDTO).collect(Collectors.toList());

    }

    public Optional<CasaDto> getById(Integer id) {
        return casaRepository.findById(id).map(CasaMapper::toDTO);
    }

    public Casa create(Casa casa) {
        return casaRepository.save(casa);
    }

    public Casa update(Integer id, Casa casa) {
        casa.setId(Long.valueOf(id));
        return casaRepository.save(casa);
    }

    public void delete(Integer id) {
        casaRepository.deleteById(id);
    }
}
