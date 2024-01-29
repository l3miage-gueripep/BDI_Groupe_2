package fr.uga.miage.m1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.miage.m1.dto.CovoiturageLieuDto;
import fr.uga.miage.m1.requests.CreateCovoiturageLieuRequest;
import fr.uga.miage.m1.services.CovoiturageLieuService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CovoiturageLieuController {
    private final CovoiturageLieuService covoiturageLieuService;

    @PostMapping("covoiturageLieu/")
    CovoiturageLieuDto create(@RequestBody final CreateCovoiturageLieuRequest createCovoiturageLieuRequest){
        return covoiturageLieuService.create(createCovoiturageLieuRequest);
    }

    @GetMapping("covoiturageLieu/")
    List<CovoiturageLieuDto> getAll(){
        return covoiturageLieuService.getAll();
    }
}
