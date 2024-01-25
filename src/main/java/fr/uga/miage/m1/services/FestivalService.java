package fr.uga.miage.m1.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.uga.miage.m1.entities.Festival;
import fr.uga.miage.m1.mapper.FestivalMapper;
import fr.uga.miage.m1.repos.FestivalRepo;
import fr.uga.miage.m1.dto.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class FestivalService {

    private final FestivalRepo repo;
    private final FestivalMapper mapper;

    public Festival create(Festival festival) {
        // Festival newFestivalEntity = new Festival();
        // newFestivalEntity.setNomManifestation(nomManifestation);
        // System.out.println("nomManifestation: " +
        // newFestivalEntity.getNomManifestation());
        return repo.save(festival);
    }

    public List<FestivalDto> getAll(Pageable pageable) {
        Page<Festival> festivals = repo.findAll(pageable);
        return festivals.stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }

    public FestivalDto getById(String nomManifestation) {
        Festival festival = repo.findById(nomManifestation).orElseThrow();
        return mapper.toDto(festival);
    }
}
