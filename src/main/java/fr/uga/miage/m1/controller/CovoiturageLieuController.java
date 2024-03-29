package fr.uga.miage.m1.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.miage.m1.dto.CovoiturageLieuDto;
import fr.uga.miage.m1.requests.CreateCovoiturageLieuRequest;
import fr.uga.miage.m1.requests.OffreCovoiturageFilterRequest;
import fr.uga.miage.m1.services.CovoiturageLieuService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CovoiturageLieuController {
    private final CovoiturageLieuService covoiturageLieuService;

    @PostMapping("covoiturageLieu/")
    public CovoiturageLieuDto create(@RequestBody final CreateCovoiturageLieuRequest createCovoiturageLieuRequest){
        return covoiturageLieuService.create(createCovoiturageLieuRequest);
    }

    @GetMapping("covoiturageLieu/")
    public Page<CovoiturageLieuDto> getAll(Pageable pageable){
        return covoiturageLieuService.getAll(pageable);
    }

    @GetMapping("covoiturageLieu/byid/{idCovoiturageLieu}")
    public CovoiturageLieuDto getById(@PathVariable final Long idCovoiturageLieu){
        return covoiturageLieuService.getById(idCovoiturageLieu);
    }

    @GetMapping("festival/{nomManifestation}/covoituragelieu")
    public Page<CovoiturageLieuDto> getByIdFestival(Pageable pageable, @PathVariable final String nomManifestation){
        return covoiturageLieuService.getByIdFestival(pageable, nomManifestation);
    }

    @PostMapping("festival/{nomManifestation}/covoituragelieu/filter")
    public Page<CovoiturageLieuDto> getByIdFestivalAndFilter(Pageable pageable, @PathVariable final String nomManifestation, @RequestBody final OffreCovoiturageFilterRequest filterRequest){
        return covoiturageLieuService.getByIdFestivalAndFilter(pageable, nomManifestation, filterRequest);
    }


    @GetMapping("covoiturageLieu/{idOffreCovoiturage}")
    public List<CovoiturageLieuDto> getCovoituragesLieusByOffreCovoiturage(@PathVariable final Long idOffreCovoiturage){
        return covoiturageLieuService.getCovoituragesLieusByOffreCovoiturage(idOffreCovoiturage);
    }

    // @PostMapping("covoiturageLieu/filter")
    // public Page<CovoiturageLieuDto> filter(@RequestBody final CovoiturageLieuFilterRequest filterRequest, Pageable pageable) {
    //     return covoiturageLieuService.filter(filterRequest, pageable);
    // }
}
