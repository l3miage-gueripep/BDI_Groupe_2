package fr.uga.miage.m1.services;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.entities.Region;
import fr.uga.miage.m1.repos.RegionRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepo repo;

    public Region create(Region region) {
        // Region newRegionEntity = new Region();
        // newRegionEntity.setNomRegion(nomRegion);
        // System.out.println("nomRegion: " + newRegionEntity.getNomRegion());
        return repo.save(region);
    }
}
