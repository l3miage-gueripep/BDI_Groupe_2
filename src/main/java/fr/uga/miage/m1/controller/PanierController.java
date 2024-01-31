package fr.uga.miage.m1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ch.qos.logback.core.model.processor.PhaseIndicator;
import fr.uga.miage.m1.dto.PanierDto;
import fr.uga.miage.m1.entities.Panier;
import fr.uga.miage.m1.requests.AddPanierOffreRequest;
import fr.uga.miage.m1.requests.CreatePanierRequest;
import fr.uga.miage.m1.services.PanierService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PanierController {
    private final PanierService panierService;

    @GetMapping("panier/")
    List<PanierDto> getAll(){
        return panierService.getAll();
    }

    @PostMapping("panier/")
    PanierDto create(@RequestBody final CreatePanierRequest createPanierRequest){
        return panierService.create(createPanierRequest);
    }

    @GetMapping("panier/{userMail}")
    PanierDto getCurrentPanierByUserMail(@PathVariable final String userMail){
        return panierService.getCurrentPanierByUserMail(userMail)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Panier not found for user " + userMail));
    }

    @PostMapping("panier/add/")
    PanierDto addLieu(@RequestBody final AddPanierOffreRequest addPanierOffreRequest){
        return panierService.addLieu(addPanierOffreRequest.getUserMail(), addPanierOffreRequest.getIdCovoiturageLieu(), addPanierOffreRequest.getQuantite());
    }

    @PatchMapping("panier/pay/{idPanier}")
    PanierDto setEtatToPaye(@PathVariable final Long idPanier){
        return panierService.setEtatToPaye(idPanier);
    }
}
