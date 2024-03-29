package fr.uga.miage.m1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.uga.miage.m1.dto.FestivalDto;
import fr.uga.miage.m1.requests.FestivalFilterRequest;
import fr.uga.miage.m1.services.FestivalService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FestivalControllers {
    private final FestivalService festivalService;

    @GetMapping("festival/")
    public Page<FestivalDto> getAll(Pageable pageable) {
        return festivalService.getAll(pageable);
    }

    @GetMapping("festival/{nomManifestation}")
    public FestivalDto getById(@PathVariable final String nomManifestation) {
        return festivalService.getById(nomManifestation);
    }

    @PostMapping("festival/filter")
    public Page<FestivalDto> getByFilter(@RequestBody final FestivalFilterRequest filtre, Pageable pageable) {
        return festivalService.getByFilter(filtre, pageable);
    }

    @GetMapping("festival/allCity")
    public List<String> getAllCity() {
        return festivalService.getAllLieuPrincipal();
    }

    @GetMapping("festival/allDomaine")
    public List<String> getAllDomaine() {
        return festivalService.getAllDomaine();
    }
}
