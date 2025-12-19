package com.example.howgarts.service;

import com.example.howgarts.model.Casa;
import com.example.howgarts.repository.CasaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasaService {

    private final CasaRepository casaRepository;

    public CasaService(CasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }

    public List<Casa> getAll() {
        return casaRepository.findAll();
    }

    public Optional<Casa> getById(Integer id) {
        return casaRepository.findById(id);
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
