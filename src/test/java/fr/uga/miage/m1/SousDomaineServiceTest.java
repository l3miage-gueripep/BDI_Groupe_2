package fr.uga.miage.m1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.uga.miage.m1.entities.SousDomaine;
import fr.uga.miage.m1.repos.SousDomaineRepo;
import fr.uga.miage.m1.services.SousDomaineService;

@ExtendWith(MockitoExtension.class)
class SousDomaineServiceTest {

    @Mock
    private SousDomaineRepo repo;

    @InjectMocks
    private SousDomaineService service;

    @Test
    void testCreate() {
        SousDomaine sousDomaine = new SousDomaine();
        when(repo.save(any(SousDomaine.class))).thenReturn(sousDomaine);

        SousDomaine result = service.create(sousDomaine);

        assertEquals(sousDomaine, result);
        verify(repo, times(1)).save(sousDomaine);
    }
}