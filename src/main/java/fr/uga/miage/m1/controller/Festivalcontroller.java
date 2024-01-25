package fr.uga.miage.m1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.uga.miage.m1.dto.FestivalDto;
import fr.uga.miage.m1.services.FestivalService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class Festivalcontroller {
    private final FestivalService festivalService;

    @GetMapping("festival/")
    List<FestivalDto> getAll(Pageable pageable){
        return festivalService.getAll(pageable);
    }
    @GetMapping("festival/{nomManifestation}")
    FestivalDto getById(@PathVariable final String nomManifestation){
        return festivalService.getById(nomManifestation);
    }

}
