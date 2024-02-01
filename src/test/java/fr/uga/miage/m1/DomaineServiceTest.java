package fr.uga.miage.m1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.uga.miage.m1.entities.Domaine;
import fr.uga.miage.m1.repos.DomaineRepo;
import fr.uga.miage.m1.services.DomaineService;

@ExtendWith(MockitoExtension.class)
class DomaineServiceTest {

    @Mock
    private DomaineRepo repo;

    @InjectMocks
    private DomaineService service;

    @Test
    void testCreate() {
        Domaine domaine = new Domaine();
        when(repo.save(any(Domaine.class))).thenReturn(domaine);

        Domaine result = service.create(domaine);

        assertEquals(domaine, result);
        verify(repo, times(1)).save(domaine);
    }
}