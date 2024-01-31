package fr.uga.miage.m1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.miage.m1.dto.PanierDto;
import fr.uga.miage.m1.requests.CreatePanierRequest;
import fr.uga.miage.m1.services.PanierService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PanierController {
    private final PanierService panierService;

    @GetMapping("panier/")
    List<PanierDto> getAll() {
        return panierService.getAll();
    }

    @PostMapping("panier/")
    PanierDto create(@RequestBody final CreatePanierRequest createPanierRequest) {
        return panierService.create(createPanierRequest);
    }

    @PostMapping("panier/{idPanier}/add/{idLieu}")
    PanierDto addLieu(@PathVariable final Long idPanier, @PathVariable final Long idLieu) {
        return panierService.addLieu(idPanier, idLieu);
    }
}
