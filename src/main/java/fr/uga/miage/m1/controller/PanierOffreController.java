package fr.uga.miage.m1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.model.processor.PhaseIndicator;
import fr.uga.miage.m1.dto.PanierDto;
import fr.uga.miage.m1.requests.CreatePanierRequest;
import fr.uga.miage.m1.services.PanierOffreService;
import fr.uga.miage.m1.services.PanierService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PanierOffreController {
    private final PanierOffreService panierOffreService;

    @DeleteMapping("panierOffre/")
    void deleteAll(){
        panierOffreService.deleteAll();
    }
}
