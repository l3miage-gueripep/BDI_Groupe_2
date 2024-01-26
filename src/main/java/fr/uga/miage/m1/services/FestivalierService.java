package fr.uga.miage.m1.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.uga.miage.m1.dto.AdherentDto;
import fr.uga.miage.m1.dto.FestivalierDto;
import fr.uga.miage.m1.mapper.FestivalierMapper;
import fr.uga.miage.m1.repos.AdherentRepo;
import fr.uga.miage.m1.repos.FestivalierRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class FestivalierService {
    private final FestivalierRepo repo;
    private final FestivalierMapper mapper;

    public List<FestivalierDto> getAll() {
        List<FestivalierDto> festivaliers = repo.findAll().stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
        return festivaliers;
    }
}
