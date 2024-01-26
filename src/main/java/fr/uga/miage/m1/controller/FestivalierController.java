package fr.uga.miage.m1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.miage.m1.dto.FestivalierDto;
import fr.uga.miage.m1.services.FestivalierService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FestivalierController {
    private final FestivalierService festivalierService;
    @GetMapping("festivalier/")
    List<FestivalierDto> getAll(){
        return festivalierService.getAll();
    }
}
