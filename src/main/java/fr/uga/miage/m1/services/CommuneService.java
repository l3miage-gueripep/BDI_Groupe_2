package fr.uga.miage.m1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.dto.CommuneDto;
import fr.uga.miage.m1.entities.Commune;
import fr.uga.miage.m1.mapper.CommuneMapper;
import fr.uga.miage.m1.repos.CommuneRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommuneService {

    private final CommuneRepository repo;
    private final CommuneMapper mapper;

    public Commune create(Commune commune) {
        return repo.save(commune);
    }

    public List<CommuneDto> getAll() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    public List<CommuneDto> getAllByNomCommune(String nomCommune) {
        return repo.findByNomCommuneContainingIgnoreCase(nomCommune).stream().map(mapper::toDto).toList();
    }
}
