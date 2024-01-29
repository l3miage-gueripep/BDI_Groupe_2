package fr.uga.miage.m1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.miage.m1.dto.LieuCovoiturageDto;
import fr.uga.miage.m1.services.LieuCovoiturageService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LieuCovoiturageController {
    private final LieuCovoiturageService lieuCovoiturageService;

    @GetMapping("lieuCovoiturage/")
    public List<LieuCovoiturageDto> getAll(){
        return lieuCovoiturageService.getAll();
    }


}
