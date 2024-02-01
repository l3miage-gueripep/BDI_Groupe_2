package fr.uga.miage.m1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.uga.miage.m1.entities.Region;
import fr.uga.miage.m1.repos.RegionRepo;
import fr.uga.miage.m1.services.RegionService;

@ExtendWith(MockitoExtension.class)
class RegionServiceTest {

    @Mock
    private RegionRepo repo;

    @InjectMocks
    private RegionService service;

    @Test
    void testCreate() {
        Region region = new Region();
        when(repo.save(any(Region.class))).thenReturn(region);

        Region result = service.create(region);

        assertEquals(region, result);
        verify(repo, times(1)).save(region);
    }
}