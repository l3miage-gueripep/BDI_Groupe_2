package fr.uga.miage.m1.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.miage.m1.dto.OffreCovoiturageDto;
import fr.uga.miage.m1.services.OffreCovoiturageService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OffreCovoiturageController {
    private final OffreCovoiturageService covoiturageService;

    @PostMapping("covoiturage")
    OffreCovoiturageDto create(@RequestBody final OffreCovoiturageDto offreCovoiturageDto){
        return covoiturageService.create(offreCovoiturageDto);
    }

    @GetMapping("covoiturage")
    List<OffreCovoiturageDto> getAll(Pageable pageable){
        return covoiturageService.getAll(pageable);
    }

    @GetMapping("covoiturage/{idOffre}")
    OffreCovoiturageDto getById(@PathVariable final Long idOffre){
        return covoiturageService.getById(idOffre);
    }

    @GetMapping("covoiturage/festival/{idFestival}")
    List<OffreCovoiturageDto> getAllByFestival(Pageable pageable, String nomManifestation){
        return covoiturageService.getAllByFestival(pageable, nomManifestation);
    }

    @PatchMapping("covoiturage/{idOffre}/buy/{nbPlaces}")
    OffreCovoiturageDto prendrePlaces(@PathVariable final Long idOffre, @PathVariable final int nbPlaces){
        return covoiturageService.prendrePlaces(idOffre, nbPlaces);
    }


}
