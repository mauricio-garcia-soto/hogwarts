package com.example.howgarts.service;

import com.example.howgarts.model.Mascota;
import com.example.howgarts.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaService(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    public List<Mascota> getAll() {
        return mascotaRepository.findAll();
    }

    public Optional<Mascota> getById(Integer id) {
        return mascotaRepository.findById(id);
    }

    public Mascota create(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public Mascota update(Integer id, Mascota mascota) {
        mascota.setIdMascota(id);
        return mascotaRepository.save(mascota);
    }

    public void delete(Integer id) {
        mascotaRepository.deleteById(id);
    }
}