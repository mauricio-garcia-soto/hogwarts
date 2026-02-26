package com.example.howgarts.service;

import com.example.howgarts.dto.MascotaDto;
import com.example.howgarts.mapper.MascotaMapper;
import com.example.howgarts.model.Mascota;
import com.example.howgarts.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;
    private final MascotaMapper mascotaMapper;

    public MascotaService(MascotaRepository mascotaRepository, MascotaMapper mascotaMapper) {
        this.mascotaRepository = mascotaRepository;
        this.mascotaMapper = mascotaMapper;
    }

    public List<MascotaDto> getAll() {
        return mascotaRepository.findAll().stream()
                .map(mascotaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<MascotaDto> getById(Long id) {
        return mascotaRepository.findById(id).map(mascotaMapper::toDTO);
    }

    public Mascota create(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public Mascota update(Long id, Mascota mascota) {
        mascota.setId(id);
        return mascotaRepository.save(mascota);
    }

    public void delete(Long id) {
        mascotaRepository.deleteById(id);
    }
}