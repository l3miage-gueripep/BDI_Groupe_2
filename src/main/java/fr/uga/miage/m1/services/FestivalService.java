package fr.uga.miage.m1.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import fr.uga.miage.m1.entities.Festival;
import fr.uga.miage.m1.mapper.FestivalMapper;
import fr.uga.miage.m1.repos.FestivalRepo;
import fr.uga.miage.m1.requests.FestivalFilterRequest;
import fr.uga.miage.m1.dto.*;
import jakarta.persistence.criteria.Predicate;
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
        Specification<Festival> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filtre.getNomManifestation() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nomManifestation")), "%" + filtre.getNomManifestation().toLowerCase() + "%"));
            }
            if (filtre.getLieuPrincipal() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("lieuPrincipal")), "%" + filtre.getLieuPrincipal().toLowerCase() + "%"));
            }
            if (filtre.getSousDomaine() != null) {
                predicates.add(criteriaBuilder.equal(root.get("sousDomaine").get("nomSousDomaine"), filtre.getSousDomaine()));
            }
            if (filtre.getDateDebut() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dateDebut"), filtre.getDateDebut()));
            }
            if (filtre.getDateFin() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dateFin"), filtre.getDateFin()));
            }

            

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        Page<Festival> festivals = repo.findAll(spec, pageable);

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
