package fr.uga.miage.m1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.dto.AdherentDto;
import fr.uga.miage.m1.entities.Adherent;
import fr.uga.miage.m1.mapper.AdherentMapper;
import fr.uga.miage.m1.repos.AdherentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AdherentService {
    private final AdherentRepo repo;
    private final AdherentMapper mapper;

    public AdherentDto create(AdherentDto adherentDto) {
        Adherent adh = mapper.toEntity(adherentDto);
        adh.setIdAdherent(null);
        return mapper.toDto(repo.save(adh));
    }

    public List<AdherentDto> getAll() {
        return repo.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }
}