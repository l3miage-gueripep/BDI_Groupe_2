package fr.uga.miage.m1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import fr.uga.miage.m1.dto.FestivalDto;
import fr.uga.miage.m1.requests.FestivalFilterRequest;
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
    @GetMapping("festival/filter")
    List<FestivalDto> getByFilter(@RequestBody final FestivalFilterRequest request){
        return festivalService.getByFilter(request);
    }

}
