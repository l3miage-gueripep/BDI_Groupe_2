package fr.uga.miage.m1.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.miage.m1.dto.FestivalDto;
import fr.uga.miage.m1.dto.PanierOffreDto;
import fr.uga.miage.m1.entities.PanierOffre;
import fr.uga.miage.m1.services.PanierOffreService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PanierOffreController {
    private final PanierOffreService panierOffreService;

    @GetMapping("panierOffre/{idPanierOffre}")
    public PanierOffreDto getById(@PathVariable final Long idPanierOffre) {
        return panierOffreService.getById(idPanierOffre);
    }

    @DeleteMapping("panierOffre/")
    public void deleteAll() {
        panierOffreService.deleteAll();
    }

    @DeleteMapping("panierOffre/{idPanierOffre}")
    public void deleteById(@PathVariable final Long idPanierOffre){
        panierOffreService.deleteById(idPanierOffre);
    }

    @PatchMapping("panierOffre/{idPanierOffre}")
    public PanierOffre updateById(@PathVariable Long idPanierOffre, @RequestBody int quantite) {
       return panierOffreService.updateQuantite(idPanierOffre, quantite);
    }

}
