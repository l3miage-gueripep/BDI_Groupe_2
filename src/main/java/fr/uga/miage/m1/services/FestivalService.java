package fr.uga.miage.m1.services;

import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import fr.uga.miage.m1.entities.Festival;
import fr.uga.miage.m1.entities.SousDomaine;
import fr.uga.miage.m1.mapper.FestivalMapper;
import fr.uga.miage.m1.repos.FestivalRepo;
import fr.uga.miage.m1.requests.FestivalFilterRequest;
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

        return repo.save(festival);
    }

    public Page<FestivalDto> getAll(Pageable pageable) {
        Page<Festival> festivals = repo.findAll(pageable);
        return festivals.map(mapper::toDto);
    }

    public FestivalDto getById(String nomManifestation) {
        Festival festival = repo.findById(nomManifestation).orElseThrow();
        return mapper.toDto(festival);
    }

    public Page<FestivalDto> getByFilter(FestivalFilterRequest filtre, Pageable pageable) {
        Festival festivalExample = new Festival();
        festivalExample.setLieuPrincipal(filtre.getLieuPrincipal());
        festivalExample.setTarifPass(null);
        if (filtre.getSousDomaine() != null) {
            festivalExample.setSousDomaine(SousDomaine.builder().nomSousDomaine(filtre.getSousDomaine()).build());
        }
        festivalExample.setDateDebut(filtre.getDateDebut());
        festivalExample.setDateFin(filtre.getDateFin());

        Example<Festival> example = Example.of(festivalExample);
        Page<Festival> festivals = repo.findAll(example, pageable);

        return festivals.map(mapper::toDto);
    }

    public List<String> getAllLieuPrincipal() {
        return  repo.findAll()
            .stream().map(mapper::toDto).toList()
            .stream().map(FestivalDto::getLieuPrincipal)
            .distinct()  
            .toList();  
    }

    public List<String> getAllDomaine() {
        return  repo.findAll()
            .stream().map(mapper::toDto).toList()
            .stream().map(FestivalDto::getSousDomaine)
            .map(SousDomaineDto::getNomDomaine)
            .distinct()  
            .toList();  
    }
}
