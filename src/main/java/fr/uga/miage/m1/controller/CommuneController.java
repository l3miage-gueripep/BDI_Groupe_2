package fr.uga.miage.m1.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.miage.m1.dto.CommuneDto;
import fr.uga.miage.m1.dto.FestivalDto;
import fr.uga.miage.m1.services.CommuneService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommuneController {
    private final CommuneService communeService;

    @GetMapping("commune/")
    List<CommuneDto> getAll(){
        return communeService.getAll();
    }

    //give all communes starting with the given string
    @GetMapping("commune/{nomCommune}")
    List<CommuneDto> getAllByNomCommune(@PathVariable final String nomCommune){
        return communeService.getAllByNomCommune(nomCommune);
    }

    
}
