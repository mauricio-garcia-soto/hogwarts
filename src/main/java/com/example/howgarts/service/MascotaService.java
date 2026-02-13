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

    public MascotaService(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    public List<MascotaDto> getAll() {
        return mascotaRepository.findAll().stream()
                .map(MascotaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<MascotaDto> getById(Integer id) {
        return mascotaRepository.findById(id).map(MascotaMapper::toDTO);
    }

    public Mascota create(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public Mascota update(Long id, Mascota mascota) {
        mascota.setId(id);
        return mascotaRepository.save(mascota);
    }

    public void delete(Integer id) {
        mascotaRepository.deleteById(id);
    }
}