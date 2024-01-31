package fr.uga.miage.m1.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.miage.m1.services.PanierOffreService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PanierOffreController {
    private final PanierOffreService panierOffreService;

    @DeleteMapping("panierOffre/")
    void deleteAll() {
        panierOffreService.deleteAll();
    }
}
