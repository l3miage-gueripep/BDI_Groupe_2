package fr.uga.miage.m1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.miage.m1.dto.AdherentDto;
import fr.uga.miage.m1.services.AdherentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AdherentController {
    private final AdherentService adherentService;
    
    @GetMapping("adherent/")
    public List<AdherentDto> getAll(){
        return adherentService.getAll();
    }

    @PostMapping("adherent/")
    public AdherentDto create(@RequestBody final AdherentDto adherentDto){
        return adherentService.create(adherentDto);
    }

}
